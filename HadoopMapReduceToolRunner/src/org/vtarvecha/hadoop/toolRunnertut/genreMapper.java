package org.vtarvecha.hadoop.toolRunnertut;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;

public class genreMapper extends Mapper<LongWritable, Text, Text, Text> {

	String input_parameter = "";
	IntWritable one = new IntWritable();

	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		Configuration conf = context.getConfiguration();
		input_parameter = conf.get("parameter");

		String file_line = value.toString();
		String[] first_split = file_line.split("\\::");

		if (first_split[2].contains(input_parameter)) {

			context.write(new Text(first_split[1]), new Text(first_split[2]));

		}

	}

}
