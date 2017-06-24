
import java.io.BufferedInputStream;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;


import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.zookeeper.common.IOUtils;

import java.io.InputStream;

public class HAsignThreeTwoSix {

	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		//local file path
		String localsrc = args[0];
		//hdfs file path
		String dst = args[1];
		
		//input stream for the file in local file systemto be witten top hdfs
		InputStream in = new BufferedInputStream(new FileInputStream(localsrc));
		
		///get the configuration of hadoop system
		Configuration conf =new Configuration();
		FileSystem fs = FileSystem.get(URI.create(dst), conf);
		OutputStream out = fs.create(new Path(dst));
		IOUtils.copyBytes(in, out, 4096, true);
		System.out.println(dst+" copied to HDFS");
		
		
	}

}

