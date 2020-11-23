package com.root.bigdata

/**
  * CreateBy zxmao on  2020/10/26 0026 08:48
  */
object MapDemo01 {

  def startA(str:String):Boolean = {
    str.startsWith("A")
  }

  def main(args: Array[String]): Unit = {
    val names = List("Bob","Jack","Alice")

    val re = names.map(s=>s.toUpperCase())

    println(re)

    val fre = names.flatMap(s=>s.toLowerCase)
    println(fre)

    val nameFilter = names.filter(startA)
    println(nameFilter)

    val vals = List(3,4,2,7,5)
    val minV = vals.reduce(findMin)
    println(minV)
  }

  def findMin(a:Int,b:Int):Int={
    if(a<b)a
    else b
  }
}
