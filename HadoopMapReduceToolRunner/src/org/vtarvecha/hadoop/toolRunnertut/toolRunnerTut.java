/*
 * Sample Tool Runner based MapReduce program to find movies based on Genre 
 * Input file contains Movie Id, Movie Name and Genre.
 */

package org.vtarvecha.hadoop.toolRunnertut;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.util.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;



public class toolRunnerTut extends Configured implements Tool {

		 
		    @SuppressWarnings("deprecation")
			@Override
		    public int run(String[] args) throws Exception {
		 
		        // When implementing tool
		        Configuration conf = this.getConf();
 
		        // Create job
		        Job job = new Job(conf, "Tool Job");
		        job.setJarByClass(toolRunnerTut.class);
		 
		        // Setup MapReduce job
		        // Do not specify the number of Reducer
		        job.setMapperClass(Mapper.class);
		        job.setReducerClass(Reducer.class);
		 
		        // Specify key / value
		        job.setOutputKeyClass(LongWritable.class);
		        job.setOutputValueClass(Text.class);
		 
		        // Input
		        FileInputFormat.addInputPath(job, new Path(args[0]));
		        //job.setInputFormatClass(Text.class);
		 
		        // Output
		        FileOutputFormat.setOutputPath(job, new Path(args[1]));
		       // job.setOutputFormatClass(TextOutputFormat.class);
		 
		        // Execute job and return status
		        return job.waitForCompletion(true) ? 0 : 1;
		    }
		    
		public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
					 
			int res = ToolRunner.run(new Configuration(), new toolRunnerTut(), args);
			System.exit(res);
			}


	}


