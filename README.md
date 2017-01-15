# Spark Streaming Kinesis Example
A really simple example of running self-contained spark streaming application for Kinesis

The project aims to get you started really quickly on Spark Streaming and Kinesis. I faced a lot of gotchas when I first started so I'm hoping this would be a quick and painless example for people who just started Spark Streaming.

I assume that you have already setup Amazon Kinesis.

# What you need?
1. [Spark](http://spark.apache.org/downloads.html)
2. [sbt](http://www.scala-sbt.org/) `brew install sbt` if you haven't already.

Don't forget to add Spark to your PATH so you can call `spark-submit` from this folder. 

# How to run the project

1. `sbt assembly`
This will package everything into a single jar so it can be submitted to Spark Streaming

2. [spark-submit](http://spark.apache.org/docs/latest/submitting-applications.html) 
```
~/opensource/spark-2.0.2-bin-hadoop2.7/bin/spark-submit --class "SparkStreamKinesis" --master local[4] target/scala-2.11/spark-streaming-kinesis-assembly-1.0.jar
```

This will run the application in your local Spark. After a few seconds, you should see the content of your Kinesis Stream.

# References
1. [Kinesis Word Count](https://docs.cloud.databricks.com/docs/latest/databricks_guide/07%20Spark%20Streaming/04%20Kinesis%20Word%20Count%20-%20Scala.html)
2. [Create scala far jar for Spark Streaming](http://queirozf.com/entries/creating-scala-fat-jars-for-spark-on-sbt-with-sbt-assembly-plugin#spark2)

# Note
This is by no means production-ready. This is just an example of how to start a simple self-contained Spark streaming application.