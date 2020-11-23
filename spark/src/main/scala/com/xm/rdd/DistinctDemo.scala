package com.xm.rdd

import org.apache.spark.{SparkConf, SparkContext}

/**
  * CreateBy zxmao on  2020/10/29 0029 16:12
  */
object DistinctDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("XiAoMao")
    val sparkContext = new SparkContext(sparkConf)

    val rdd = sparkContext.makeRDD(List(1,2,3,4,5,5,6,6,7),3)


    rdd.distinct().collect().foreach(println)
    println("=========distinct底层是通过reduceByKey和map算子，涉及到shuffle过程=============")
    rdd.distinct(2).collect().foreach(println)

    sparkContext.stop()
  }

}
