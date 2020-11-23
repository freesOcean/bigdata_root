package com.xm.rdd

import org.apache.spark.{SparkConf, SparkContext}

/**
  * CreateBy zxmao on  2020/10/29 0029 17:04
  * coalesce默认不开启shuffle，所以适合缩减分区。扩大分区，需要将shuffle开启，即采用 repartition
  */
object CoalesceDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("XiAoMao")
    val sparkContext = new SparkContext(sparkConf)

    val rdd = sparkContext.makeRDD(1 to 10,3)
    rdd.mapPartitionsWithIndex {
      (index, datas) => {
        println(index + ":::" + datas.mkString(","))
        datas
      }
    }.collect()
    println("======================")
    val crdd = rdd.coalesce(2)
    crdd.mapPartitionsWithIndex {
      (index, datas) => {
        println(index + ":::" + datas.mkString(","))
        datas
      }
    }.collect()


    sparkContext.stop()
  }

}
