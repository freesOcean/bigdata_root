package com.root.bigdata

import scala.collection.mutable.ArrayBuffer

/**
  * CreateBy zxmao on  2020/10/26 0026 14:26
  */
object ArrayDemo {

  def main(args: Array[String]): Unit = {
    //不可变数组
    val arr = new Array[Any](4)
    arr(0) = 1
    arr(1) = 2
    arr(2) = 0
    arr(3) = "a"
    for(a<- arr){
      println(a)
    }

    val arr2 = Array(1,3,5,9)

    for(a<- arr2) println(a)

    for(i <- 0 until arr2.length){
      printf("arr2[%d]=%s",i,arr2(i))
    }

    println("=========================")
    //不可变数组
    val arrBuf = new ArrayBuffer[Int]()
    //通过append增加元素
    arrBuf.append(2)
    arrBuf.append(2,3,4)
    //修改元素值
    arrBuf(0) = 1
    for(a<- arrBuf){
      println(a)
    }

    arrBuf.remove(0)

    for(a<-arrBuf){
      println(a)
    }

    val arrBuf2 = ArrayBuffer(2,4)
    for(a<-arrBuf2){
      println(a)
    }

  }

}
