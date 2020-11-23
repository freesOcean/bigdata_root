package com.root.bigdata

/**
  * CreateBy zxmao on  2020/10/29 0029 07:53
  */
object PartialFunDemo {
  def main(args: Array[String]): Unit = {

    val list = List(2,3,4,"hello")

    //将所有的Int类型元素*2,并返回全部Int集合
    println(list.filter(item => item.isInstanceOf[Int]))
    println(list.filter(item => item.isInstanceOf[Int]).map(_.asInstanceOf[Int]).map(_ * 2))

    println("======================")
    //偏函数写法1
    val partialFun = new PartialFunction[Any,Int] {
      override def isDefinedAt(x: Any): Boolean = {
        x.isInstanceOf[Int]
      }

      override def apply(v1: Any): Int = {
        v1.asInstanceOf[Int]
      }
    }

    println(list.collect(partialFun).map(_*2))

    println("======================")

    //偏函数写法2
    println(list.collect({
      case i: Int => i * 2
    }))

  }

}
