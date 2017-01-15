import com.amazonaws.services.kinesis.clientlibrary.lib.worker.InitialPositionInStream.LATEST
import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel.MEMORY_AND_DISK_2
import org.apache.spark.streaming.kinesis._
import org.apache.spark.streaming.{Duration, Seconds, StreamingContext}


object SparkStreamKinesis{
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Spark Kinesis").setMaster("local[4]")
    val ssc = new StreamingContext(conf, Seconds(1))

    println("Spark Streaming")

    /**
      * Change Kinesis App Name to any application name you like and this will be used to create a DynamoDB Table as well
      * Change Kinesis Stream to the stream you created
      * Don't forget to change your region and Kinesis URL endpoint
      */

    val kinesisStream = KinesisUtils.createStream(ssc, "sparrow-ci",
      "sparrow-ci",
      "kinesis.us-east-1.amazonaws.com",
      "us-east-1",
      LATEST,
      Duration(2000),
      MEMORY_AND_DISK_2)

    kinesisStream.print()

    kinesisStream.flatMap(new String(_))
      .foreachRDD(_.collect().foreach(print))

    ssc.start()
    ssc.awaitTermination()
  }
}
