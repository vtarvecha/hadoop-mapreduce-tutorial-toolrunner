hadoop-mapreduce-tutorial-toolrunner
====================================

Tutorial - MapReduce ToolRunner Usage

Most of the time, Map-Reduce job is created using a driver class that contains static main method. But such method is not suitable for changing specific configuration on the fly. i.e. changing number of reducer through command line input is not possible. If you need to change your specific configurations, you have to go back to driver class, modify changes, and build jar file again. 

This hassle can be avoided by implementing Tool interface. Implement Tool interface and extend it to Configured class, and your hadoop configuration is right there in Map-Reduce Job via GenricOptionParser through command line interface. 

Following is the list of Supported Generic Options

-conf: specify an application configuration file
-D:    value of a given property
-fs:   specify a namenode
-jt:   specify a job tracker
-flies: provide comma separated files that is to be copied to map-reduce
-libjars: provide list of jar files (comma seperated) to be included in classpath
-archivers: provide list of archives (comma separated) to be 

Example Configuration:

1. Specify Number of Reducer if Tool Runner is used:

hadoop jar /user/local/Ex/Tool.jar com.vtarvecha.hadoop.ToolRunTut -D mapred.reduce.tasks=1 /user/inpath /user/outpath

2. Specify Remote hadoop server (Hadoop Cluster and Job tracker)

hadoop jar tool.jar com.vtarvecha.hadoop.ToolRunTut -fs hdfs://vtarvecha.com:50070 -jt vtarvecha.com:50030
