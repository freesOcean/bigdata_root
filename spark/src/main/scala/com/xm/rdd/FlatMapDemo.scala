package com.xm.rdd

import org.apache.spark.{SparkConf, SparkContext}

/**
  * CreateBy zxmao on  2020/10/28 0028 09:01
  */
object FlatMapDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("XiAoMao")
    val sparkContext = new SparkContext(sparkConf)

    val rdd = sparkContext.makeRDD(List(List(1,3),List(990,45),List(2,5)),2)

    val nrdd = rdd.flatMap(datas=>datas)
    nrdd.collect().foreach(println)

    sparkContext.stop()
  }



}
