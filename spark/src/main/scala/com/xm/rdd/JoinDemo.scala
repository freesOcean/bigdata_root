package com.xm.rdd

import org.apache.spark.{SparkConf, SparkContext}

/**
  * CreateBy zxmao on  2020/11/2 0002 07:42
  */
object JoinDemo {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("XiAoMao")
    val sparkContext = new SparkContext(sparkConf)

    val rdd = sparkContext.makeRDD(List(1,2,4,5,2))


    sparkContext.stop()
  }

}
