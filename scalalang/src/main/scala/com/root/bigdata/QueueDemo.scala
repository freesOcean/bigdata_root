package com.root.bigdata

import scala.collection.mutable

/**
  * CreateBy zxmao on  2020/10/26 0026 16:00
  */
object QueueDemo {
  def main(args: Array[String]): Unit = {
    //Queue创建
    val que = new mutable.Queue[Any]
    //增加元素
    que += 4
    //将一个集合添加到队列
    que ++=List(3,6,9)
    //将List(99) 作为一个元素加入队列
    que +=List(99)

    println(que)
    //入队
    que.enqueue(5) //(4,3,6,9,List(99),5)
    //出队：队列会变
    println(que.dequeue()) //(3,6,9,List(99),5)

    //返回一个子队列,不会改变原队列
    println(que.take(2))
    println(que)

    //返回除第一个元素之后剩余元素组成的队列
    println(que.tail)
    println(que.tail.tail)
    println(que.head)
    println(que.last)

  }

}
