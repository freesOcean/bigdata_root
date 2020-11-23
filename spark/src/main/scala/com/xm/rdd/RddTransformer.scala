package com.xm.rdd

import org.apache.spark.{SparkConf, SparkContext}

/**
  * CreateBy zxmao on  2020/10/27 0027 11:36
  */
object RddTransformer {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("XiAoMao")
    val sparkContext = new SparkContext(sparkConf)

    val rdd = sparkContext.makeRDD(List(1,2,4,5,2,6,9,88),3)

    //datas代表一个分区的数据: 场景，可以减少连接次数，但是因为读取一个分区的数据，对内存要求较高。
    val nRDDA = rdd.mapPartitions(datas=>datas.map(_*2)) //这里的map是集合里的方法
    val nRDD = rdd.mapPartitionsWithIndex(
      (index,datas)=>{
        //转为二元组
        datas.map((index,_))
      }
    )
    nRDD.collect().foreach(println)
    //需求：如何让第一个分区的数据*2，别的分区数据不变
    rdd.mapPartitionsWithIndex {
      (index, datas) => {
        index match {
          case 1 => datas.map(_ * 2)
          case _ => datas
        }
      }

    }.collect().foreach(println)


    sparkContext.stop()
  }
}
