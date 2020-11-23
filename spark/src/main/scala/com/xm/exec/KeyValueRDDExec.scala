package com.xm.exec

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * CreateBy zxmao on  2020/10/30 0030 15:27
  */
object KeyValueRDDExec {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("XiAoMao")
    val sparkContext = new SparkContext(sparkConf)

    //需求：计算每个学生的平均成绩
    val rdd = sparkContext.makeRDD(List(("jiemei", 88), ("sizhe", 79), ("jiemei", 70), ("sizhe", 99), ("jiemei", 89), ("sizhe", 68)), 2)

    println("==========方案1============")
    rdd.groupBy(_._1).map {
      case (name, scores) => {
        (name, scores.map(_._2).sum / scores.size.toFloat)
      }
    }.collect().foreach(println)

    println("=========方案2=============")
    //可能存在单点压力
    rdd.groupByKey().map {
      case (key, values) => {
        (key, values.sum / values.size.toFloat)
      }
    }.collect().foreach(println)

    println("=========方案reduceByKey=============")
    rdd.map {
      case (name, score) => {
        (name, (score, 1))
      }
    }.reduceByKey {
      (t1,t2) => {
        (t1._1+t1._1,t1._2+t2._2)
      }
    }.mapValues {
      case (scores, num) => {
        scores / num
      }
    }.collect().foreach(println)

    println("=========方案3=============")

    rdd.aggregateByKey((0, 0))(
      (x, y) => {
        (x._1 + y, x._2 + 1)
      },
      (x, y) => {
        (x._1 + y._1, x._2 + y._2)
      }
      //这里mapValues 传入参数是一个元组，可以利用偏函数的匹配元组。
    ).mapValues(x => (x._1 / x._2)).collect().foreach(println)
    println("======================")

    val newRDD: RDD[(String, (Int, Int))] = rdd.aggregateByKey((0, 0))(
      (t, v) => {
        (t._1 + v, t._2 + 1)
      },
      (t1, t2) => {
        (t1._1 + t2._1, t1._2 + t2._2)
      }
    )
    val resultRDD: RDD[(String, Int)] = newRDD.mapValues {
      case (num, cnt) => {
        num / cnt
      }
    }
    resultRDD.collect().foreach(println)

    println("=========方案4=============")
    // combineByKey : 方法需要三个参数
    // 第一个参数表示：将相同key的第一个数据进行结构的转换，实现操作
    // 第二个参数表示：分区内的计算规则
    // 第三个参数表示：分区间的计算规则
    rdd.combineByKey(
      v => (v, 1),
      //需要指定泛型
      (pre: (Int, Int), nextV) => {
        (pre._1 + nextV, pre._2 + 1)
      },
      (t1: (Int, Int), t2: (Int, Int)) => {
        (t1._1 + t2._1, t1._2 + t2._2)
      }
    ).mapValues(tup => tup._1 / tup._2.toFloat).foreach(println)


    sparkContext.stop()
  }

}
