package com.xm.rdd

import org.apache.spark.{SparkConf, SparkContext}

/**
  * CreateBy zxmao on  2020/10/28 0028 09:24
  */
object GroupBy {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("XiAoMao")
    val sparkContext = new SparkContext(sparkConf)

    val rdd = sparkContext.makeRDD(List(1,2,3,4,5,6,7,8,9,10),3)
    //查看分组前，各个分区数据分布情况
    rdd.mapPartitionsWithIndex(
      (index,datas)=>{
        println("分区号："+index + "===========" +datas.mkString(","))
        datas
      }
    ).collect()

    println("======================")
    //进行分组：按照和3的余数
    val grdd = rdd.groupBy(_%3)
    grdd.mapPartitionsWithIndex(
      (index,datas)=>{
        println("分区号："+index +"=========="+datas.mkString(","))
        datas
      }
    ).collect()


    sparkContext.stop()
    println("======================")

    execise()

  }

  def execise()={
    /**
      * ❖ 小功能：将 List("Hello", "hive", "hbase", "Hadoop")根据单词首写字母进行分组。
      * ❖ 小功能：从服务器日志数据 apache.log 中获取每个时间段访问量。
      * ❖ 小功能：WordCount。
      *
      *
      * 分区号：1=====(k,CompactBuffer(kafka))
      * 分区号：0=====(h,CompactBuffer(hive)),(H,CompactBuffer(Hello, HBase, Hadoop))
      */


    val names = List("Hello","hive","HBase","kafka","Hadoop")
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("XiAoMao")
    val sparkContext = new SparkContext(sparkConf)

    val rdd = sparkContext.parallelize(names,2)
    rdd.groupBy(_.charAt(0)).mapPartitionsWithIndex(
      (index,datas)=>{
        println("分区号："+index+"====="+datas.mkString(","))
        datas
      }
    ).collect()

    sparkContext.stop()


  }


}
