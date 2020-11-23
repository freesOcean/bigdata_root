package com.xm.rdd

import org.apache.spark.{SparkConf, SparkContext}

/**
  * CreateBy zxmao on  2020/11/3 0003 08:15
  */
object ActionRDDDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("XiAoMao")
    val sc = new SparkContext(sparkConf)



    // aggregateByKey : 初始值只会参与分区内计算
    // aggregate : 初始值会参与分区内计算,并且和参与分区间计算
    val rdd = sc.makeRDD(List(1,2,3,4),8)
    val res = rdd.aggregate(10)(_+_,_+_)
    println(res)



    sc.stop()
  }

}
