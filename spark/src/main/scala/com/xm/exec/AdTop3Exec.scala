package com.xm.exec

import org.apache.spark.{SparkConf, SparkContext}

/**
  * CreateBy zxmao on  2020/11/2 0002 08:40
  */
object AdTop3Exec {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("XiAoMao")
    val sc = new SparkContext(sparkConf)
    //1516609143867 6 7 64 16
    // 时间戳，省份，城市，用户，广告
    val rdd = sc.textFile("./spark/input/agent.log")

    //分析：map（省份-广告,1）=> reduceByKey (省份-广告，N)=> map(省份，(广告，N))=>groupBy(省份，（）)=>mapValues(排序并返回take(3))
    rdd.map(
      line=>{
        val fields: Array[String] = line.split(" ")
        (fields(1)+"-"+fields(4),1)
      }
    ).reduceByKey(_+_).map{
      case (sf,n)=>{
        val sfArr: Array[String] = sf.split("-")
        (sfArr(0),(sfArr(1),n))
      }
    }.groupByKey().mapValues{
      //一个组的数据会进入，然后进行集合操作
      iter=>iter.toList.sortWith{
        (t1,t2)=>{
          t1._2>t2._2
        }
      }.take(3)
    }.collect().foreach(println)




    sc.stop()
  }

}
