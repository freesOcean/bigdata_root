package com.root.bigdata

/**
  * CreateBy zxmao on  2020/10/23 0023 10:13
  */
object reverseTest {

  def main(args: Array[String]): Unit = {
    val re = feiBo(7)
    println(re)

    println("===============")
    val v = addValue(3)
    println(v)

    println("===============")
    val peach = eatMonkey(20)
    println(peach)


    println("===============")
    def f1 = "venassa"
    println(f1)


  }

  /**
    * 递归求斐波那契数
    * @param n
    * @return
    */
  def feiBo(n:Int):Int = {
    if(n==0){
      return 0;
    }else if(n==1){
      return 1;
    }

    return feiBo(n-2)+feiBo(n-1)
  }

  /**
    * 递归求函数值，f(1)= 3 ;f(n) = 2*f(n-1) +1
    * @param n
    * @return
    */
  def addValue(n:Int):Int = {
    if(n<1){
      return -1
    }else if(n==1){
      return 3
    }

    return 2*addValue(n-1)+1
  }

  /**
    * 有一堆桃子，猴子第一天吃了其中的一半，并再多吃了一个！
    * 以后每天猴子都吃 其中的一半，然后再多吃一个。
    * 当到第十天时，想再吃时（还没吃），发现只有 1个桃子了。问题：最初共多少个桃子？
    * @param n
    * @return
    */
  def eatMonkey(n:Int):Int = {
    if(n == 1){
      return 1
    }
    return 2*(eatMonkey(n-1)+1)
  }

}
