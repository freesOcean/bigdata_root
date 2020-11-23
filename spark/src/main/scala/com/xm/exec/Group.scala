package com.xm.exec

import org.apache.spark.{SparkConf, SparkContext}

object Group {

  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("XiAoMao")
    val sparkContext = new SparkContext(sparkConf)



  }
}
