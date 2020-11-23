package com.xm.rdd

import org.apache.spark.{SparkConf, SparkContext}

/**
  * CreateBy zxmao on  2020/10/29 0029 17:24
  * 排序 sortBy算子会根据传入的函数将数据处理后，然后按照处理结果进行排序。默认是升序排序
  * 可以设置 ascending为false实现降序排序
  */
object SortByDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("XiAoMao")
    val sparkContext = new SparkContext(sparkConf)

//    val rdd = sparkContext.makeRDD(List(4,4,3,2,1,5,6,3))
    val rdd = sparkContext.makeRDD(List((4,4),(3,2),(1,5),(6,3)))

    rdd.sortBy(a=>a,false).collect().foreach(println)



    sparkContext.stop()
  }

  def a(a:(Int,Int)):Any = {

  }
}
