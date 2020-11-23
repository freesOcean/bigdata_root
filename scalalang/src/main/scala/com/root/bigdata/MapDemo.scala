package com.root.bigdata

import scala.collection.mutable.HashMap

/**
  * CreateBy zxmao on  2020/10/26 0026 16:20
  */
object MapDemo {

  def main(args: Array[String]): Unit = {

    //不可变map
    val map = Map("A"->65,"B"->66,"C"->88)
    println(map) //Map(A -> 65, B -> 66, C -> 88)
    //通过元组方式创建和上面等价，形式不同
    val map2 = Map(("A",65),("B",66),("C",88))
    println(map2("A"))
    if(map2.contains("B")){
      println(map2("B"))
    }
    val re = map2.get("A")
    println("直接get，如果不存在，会报错："+re)
    println(map2.getOrElse("C",123))


    //只有可变map，才能修改和
    //空map
    val empMap = new HashMap[String,Int]
    empMap += ("A"->65)
    empMap +=("E"->99,"F"->100)
    println("empMap:="+empMap)

    val newMap = empMap+("H"->33)
    println("newMap:="+newMap)
    println("empMap:="+empMap)

    //遍历
    for((k,v)<-newMap){
      println(k+"is "+v)
    }
    println("================")
    for(v<-newMap.values){
      println(v)
    }
    println("================")
    for(k<-newMap.keys){
      println(k+"is"+newMap(k))
    }
    println("================")
    for(tp<-newMap){
      println(tp._1+"is"+tp._2)
    }

    //删除 对应key的元素
    newMap-=("A","B")
    println(newMap)


  }

}
