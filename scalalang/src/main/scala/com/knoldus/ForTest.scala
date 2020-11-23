package com.knoldus


/**
  * CreateBy zxmao on  2020/10/23 0023 08:25
  */
object ForTest {

  def main(args: Array[String]): Unit = {

    // <-表示限制范围 to表示 1到10 左右闭合
    for (i <- 1 to 10) {
      println(i)
    }
    println("==========================")
    //写法2 : 左闭右开
    for (i <- 1 until 10) {
      println(i)
    }
    println("==========================")

    //守卫模式：如何守卫条件为真进入循环体，如果为假则进行一个。类似加了if - continue
    for (i <- 1 to 10 if i != 6) {
      println(i)
    }

    println("==========================")
    //这个类似一个嵌套循环，内层是J
    for (i <- 1 to 4; j <- 1 to 4) {
      println(i + j)
    }

    println("==========================")
    /**
      * 对基本案例说明
      * 1) {}和()对于for表达式来说都可以
      * 2) for 推导式有一个不成文的约定：当for 推导式仅包含单一表达式时使用圆括号，
      *   当其 包含多个表达式时使用大括号
      * 3) 当使用{} 来换行写表达式时，分号就不用写了
      */
    for {
      i <- 1 to 4
      j = i * 2
    } {
      println("i=" + i + "j=" + j)
    }
    println("==========================")
    execise()
  }


  def execise():Unit = {
    for(i<- 1 to 100 if i%9 ==0){
      println(i)
    }
    println("===========================")

    for(i<- 0 until 7 ;j=6-i){
      println(i+"+" + j + "=" +(i+j))
    }
  }

  def res(a:Int,b:String) = {
    if(a==1)3 else Nil
  }
}
