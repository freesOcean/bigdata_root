package com.xm.rdd

import org.apache.spark.{SparkConf, SparkContext}

/**
  * CreateBy zxmao on  2020/10/28 0028 09:15
  * 将RDD每个分区变为一个数组，并放在心的RDD中。
  */
object GlomDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("XiAoMao")
    val sparkContext = new SparkContext(sparkConf)

    val rdd = sparkContext.makeRDD(List(1,2,4,5,2,67,776,23),3)

    val nrdd = rdd.glom()
    nrdd.collect().foreach((a:Array[Int])=>{
      println("数组长度========="+a.length)
      a.foreach(println)
    })

//    rdd.glom().collect().foreach(_.foreach(println))
    //需求，求分区最大值，并求和
    println("分区最大值求和："+rdd.glom().map(_.max).collect().sum)


    sparkContext.stop()

  }

}
