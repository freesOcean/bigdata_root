package com.atguigu.chapter11

object FlatMapDemo01 {
  def main(args: Array[String]): Unit = {

    val names = List("Alice", "Bob", "Nick")
    val names2 = names.flatMap(s=>s)
    println("names2=" + names2)

    println("======================")
    //需求是将List集合中的所有元素，进行扁平化操作，即把所有元素打散
    val list = List(List(1,3),List(990,45),List(2,5))
    list.flatMap(a=>a).foreach(println)

    println("======================")
    val list2 = List("Hello World","Hello Hive","Hello HBase","Hello XiAoMao JM ZX")

    //利用groupBy进行wordCount
    println(list2.flatMap(_.split(" ")))
  }
  def upper( s : String ) : String = {
    s. toUpperCase
  }
}
