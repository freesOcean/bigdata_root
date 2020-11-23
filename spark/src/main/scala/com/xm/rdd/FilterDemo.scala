package com.xm.rdd

import org.apache.spark.{SparkConf, SparkContext}

/**
  * CreateBy zxmao on  2020/10/29 0029 15:01
  */
object FilterDemo {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("XiAoMao")
    val sparkContext = new SparkContext(sparkConf)

    val rdd = sparkContext.makeRDD(List(12,3,4,5,6,9))
    rdd.filter(_%2!=0).collect().foreach(println)

    println("======================")
    sparkContext.makeRDD(List(123,23,1,32,"afa")).filter(_.isInstanceOf[Int]).collect().foreach(println)

    sparkContext.stop()
  }

}
