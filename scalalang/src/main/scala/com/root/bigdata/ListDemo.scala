package com.root.bigdata

import scala.collection.mutable.ListBuffer

/**
  * CreateBy zxmao on  2020/10/26 0026 15:07
  */
object ListDemo {
  def main(args: Array[String]): Unit = {

    //List 的创建
    val list = List(1,2,5,"abc")

    //List的遍历
    for(item<-list){
      println(item)
    }

    //List访问
    println(list(1))//2

    //创建空List
    val list2 = Nil
    //List是不可变集合所以，每次添加元素都会返回新的元素
    val listNew = list2:+3
    println(list2)//List()
    println(listNew)//List(3)

    //List元素追加：追加会产生一个新的集合。
    var L1 = list:+ 12 // List(1,2,5,"abc",12)
    var L3 = 10+:list // List(10,1,2,5,"abc")
    println(L1)
    println(L3)


    //:: 表示向集合中，新建集合添加元素，集合放在最右边。
    var L4 = 4::5::Nil //List(4,5)
    println(L4)
    // ::: 将集合中的每一个元素添加到集合中去，左右都是集合对象
    var L5 = 99::L4:::Nil //List(99,4,5)
    println(L5)

    //===================
    val bufL0  = ListBuffer[Int](3,2,4)
    bufL0+=99 //List(3,2,4,99)
    bufL0.append(88)
    bufL0.append(88,77)

    //删除下标为1元素
    bufL0.remove(1)


    println(bufL0)
    println(bufL0(0))




  }

}
