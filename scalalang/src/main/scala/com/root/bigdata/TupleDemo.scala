package com.root.bigdata

/**
  * CreateBy zxmao on  2020/10/26 0026 15:00
  */
object TupleDemo {

  def main(args: Array[String]): Unit = {
    //创建元组
    val tp = (1,2,9,"xiaomao")
    //访问元组
    val n = tp._1
    println(n)
    //遍历元组
    for(t<-tp.productIterator){
      println(t)
    }

    Tuple2
  }

}
