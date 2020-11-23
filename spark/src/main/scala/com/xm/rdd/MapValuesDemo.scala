package com.xm.rdd

import org.apache.spark.{SparkConf, SparkContext, rdd}

/**
  * CreateBy zxmao on  2020/10/30 0030 16:07
  */
object MapValuesDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("XiAoMao")
    val sparkContext = new SparkContext(sparkConf)


    val rdd = sparkContext.makeRDD(List(("a",2),("b",2),("a",1),("c",3),("a",4),("c",2)),3)
    //只对value做转换 。map是对整体做转换。
    rdd.mapValues(_*2).collect().foreach(println)


    sparkContext.stop()
  }

}
