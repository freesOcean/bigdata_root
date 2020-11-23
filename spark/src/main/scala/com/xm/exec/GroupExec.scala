package com.xm.exec

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * CreateBy zxmao on  2020/10/29 0029 08:40
  */
object GroupExec {


  def main(args: Array[String]): Unit = {
    wordcount()
    wordCountRDD()
  }

  //集合版wordCount
  def wordcount() = {
    val list = List("Hello World", "Hello Hive", "Hello HBase", "Hello XiAoMao JM ZX")

    //利用groupBy进行wordCount
    println(list.flatMap(_.split(" ")).map(s => (s, 1)).groupBy(_._1))
    println("======================")
    val list2 = list.flatMap(_.split(" ")).map(s => (s, 1)).groupBy(_._1).map {
      case (world, list) => (world, list.size)
    }

    list2.foreach(println)
    println("======================")

  }

  //RDD版worldCount
  def wordCountRDD(): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("XiAoMao")
    val sparkContext = new SparkContext(sparkConf)
    val list = List("Hello World", "Hello Hive", "Hello HBase", "Hello XiAoMao JM ZX")
    val rdd = sparkContext.makeRDD(list, 3)

    //wordCount基础版
    rdd.flatMap(_.split(" ")).map(world => (world, 1)).groupBy(_._1).map {
      case (word, list) => (word, list.size)
    }.collect().foreach(println)

    rdd.flatMap(_.split(" ")).map(w => (w, 1)).groupBy(_._1).map {
      case (word, datas) => {
        (word, datas.map(_._2).sum)
      }
    }

    println("======================")

    //wordCount优化版本
    rdd.flatMap(_.split(" ")).groupBy(a => a).map {
      case (word, list) => (word, list.size)
    }.collect().foreach(println)

    println("=========reduce=============")
    //通过reduce和mapValues求
    rdd.flatMap(_.split(" ")).map(w => (w, 1)).reduceByKey(_ + _).foreach(println)

    println("=========复杂版本 方案1=============")
    //wordCount复杂版
    val names = List(("Hello World",2),("Hello Hive",4),("Hello HBase",3),("Hello Kafka",3))
    //方案1
    val RDDM = sparkContext.makeRDD(names,3)
    RDDM.map(tup=>{
      (tup._1+" ")*tup._2
    }).flatMap(_.split(" ")).map(a=>(a,1)).reduceByKey(_+_).foreach(println)

    println("==========方案2============")
    val flatMapRDD: RDD[(String, Int)] = RDDM.flatMap {
      case (words, count) => {
        words.split(" ").map((_, count))
      }
    }
    println("==========group写法============")
    flatMapRDD.groupBy(_._1).map{
      case (word,list)=>(word,list.map(_._2).sum)
    }.collect().foreach(println)

    println("=========reduce写法=============")
    //reduceByKey可以指定分区数
    flatMapRDD.reduceByKey(_+_,2).mapPartitionsWithIndex({
      (index,datas)=>{
        println(index+":::"+datas.mkString(","))
        datas
      }
    }).foreach(println)

    sparkContext.stop()

  }
}
