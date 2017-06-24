import java.io.IOException;
import java.net.URI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

;


//class that contain main method
public class HAsignThreeTwoFour {
	static String start_ts;
	static String end_ts;
	static long startmilli;
	static long endmilli;
public static void convertTime() throws ParseException{
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date startdate = sdf.parse(start_ts);
	Date enddate = sdf.parse(end_ts);
	startmilli=startdate.getTime();
	endmilli=enddate.getTime();
}
	//function created that will recursivly call itself if their exist a subdir. into the dir
	//then it will call itself otherwise it will print the filees contained itself
	//dir path is supplied with the parameter when called
	public static void traversingDir(String url) throws IOException, ParseException{
		//get instance of HDFS which takes path and configuration object
		FileSystem hdfs = FileSystem.get(URI.create(url),new Configuration());
		//Get meta data of he desired Dir
		FileStatus[] fileStatus = hdfs.listStatus(new Path(url));
		
		
		
		//loop till all the elements in array are traversed
		for(int i = 0;i<fileStatus.length;i++){
			if(fileStatus[i].isDirectory()){
				//recursively call the method if dir exists
				traversingDir(fileStatus[i].getPath().toString());
			}
			
			else {
				
				fileFilter(fileStatus[i]);
				
			}
		}
		
	}
	
	public static void fileFilter(FileStatus file) throws ParseException{
		
		if (startmilli <= file.getModificationTime() && endmilli >= file.getModificationTime()){
			 System.out.println(file.getPath().getName());
			
		}
		
		
	}
	
	
	//main method 
	public static void main(String[] args) throws IOException, ParseException{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Start Time Stamp in format yyyy/MM/dd HH:mm:ss");
		
		 start_ts = sc.nextLine();
		System.out.println("Enter the end Time Stamp in format yyyy/MM/dd HH:mm:ss");
		
		
		 end_ts=sc.nextLine();
		convertTime();
		// TODO Auto-generated method stub
		//calling traveringDir method first time so passed the path which is to be recursilly traversed
			traversingDir("/home/acadgild/Desktop/Test");
			
			sc.close();
	}

}

