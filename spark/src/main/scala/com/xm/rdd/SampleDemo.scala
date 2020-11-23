package com.xm.rdd

import org.apache.spark.{SparkConf, SparkContext}

/**
  * CreateBy zxmao on  2020/10/29 0029 15:40
  */
object SampleDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("XiAoMao")
    val sparkContext = new SparkContext(sparkConf)

    val rdd = sparkContext.makeRDD(1 to 10)

    rdd.sample(true,0.8).collect().foreach(println)
    println("======================")
    rdd.sample(false,0.9).collect().foreach(println)
    println("======================")
    rdd.takeSample(false,2).foreach(println)


    sparkContext.stop()
  }

}
