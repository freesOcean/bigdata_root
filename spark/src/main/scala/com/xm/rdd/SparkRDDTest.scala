package com.xm.rdd

import org.apache.spark.{SparkConf, SparkContext}

/**
  * CreateBy zxmao on  2020/10/21 0021 10:18
  * 内存读取：默认分区是和cpu核数相同。
  * 通过文件读取：默认分区是采用cpu核数和2的最小值
  */
object SparkRDDTest {
  def main(args: Array[String]): Unit = {
    //1.初始化
    val sparkConf = new SparkConf().setMaster("local[4]").setAppName("XiAoMao")
    //    val sparkConf = new SparkConf().setMaster("spark://master:7077").setAppName("XiAoMao")
    val sparkContext = new SparkContext(sparkConf)

    //2.创建RDD
    //    val rdd = sparkContext.makeRDD(List(1,2,4,5,2)) //采用默认分区
//    val rdd = sparkContext.makeRDD(List(1, 2, 4, 5, 2), 4) //手动指定分区数
    //    val rdd = sparkContext.textFile("./spark/input/*")


        val rdd = sparkContext.textFile("hdfs://master:9000/input/*")

    //3.转换和执行
    //    rdd.foreach(println);  本机模式，可以打印所有元素。
    //    rdd.collect().foreach(println) //集群模式，需要通过collect收集到driver节点然后输出。
    //
    rdd.take(4).foreach(println) //为了防止driver收集过多元素，导致内存溢出，可以通过take方式输出。

    //    rdd.saveAsTextFile("D:\\output")
    //    rdd.saveAsTextFile("hdfs://master:9000/spark")
    sparkContext.stop()
  }
}
