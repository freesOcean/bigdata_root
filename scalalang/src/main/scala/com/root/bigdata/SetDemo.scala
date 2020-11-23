package com.root.bigdata

import scala.collection.mutable

/**
  * CreateBy zxmao on  2020/10/26 0026 16:46
  */
object SetDemo {
  def main(args: Array[String]): Unit = {


    //不可变集合
    val set = Set(12,34,"a")
    println(set)

    //可变集合
    val setM = mutable.Set(2,3,4)
    setM+=8
    setM-=2
    setM.remove(3)

    for(item<-setM){
      println(item)
    }

  }

}
