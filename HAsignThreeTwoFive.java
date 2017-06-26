import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HAsignThreeTwoFive {

	public static void main(String[] args) throws IOException, URISyntaxException {
		// TODO Auto-generated method stub
		 Configuration configuration = new Configuration();
		 ///FileSystem hdfs = FileSystem.get(new URI("hdfs://localhost:9000/"), configuration);
		 
		 Path path = new Path("hdfs://localhost:9000/user/acadgild/hadoop/max-temp.txt");
		 FileSystem fs = path.getFileSystem(configuration);
		 BufferedReader br = new BufferedReader(new InputStreamReader(fs.open(path)));
		 String line = br.readLine();
		 while(line !=null){
			 System.out.println(line);
			 line=br.readLine();
		 }
		
		 
		 
	}

}

