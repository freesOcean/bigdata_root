package com.root.bigdata

/**
  * CreateBy zxmao on  2020/10/23 0023 11:42
  */
object functionTest {
  def main(args: Array[String]): Unit = {
    goldenHeap(8)
    println
    multiTable

    /**
      * 1.参数类型是可以推断的
      * 2.当传入的参数是单个参数时，可以省略括号
      * 3.如果变量只在=>右边出现一次，可以用_ 代替
      */
    val list = List(1,23,4,5,5)

    println(list.map({(x:Int)=> x+1}))
    println(list.map((x:Int)=> x+1))
    println(list.map((x)=> x+1))
    println(list.map(x=> x+1))
    println(list.map(_+1))


    println(list.reduce((n1:Int,n2:Int)=>{n1+n2}))
    println(list.reduce((n1,n2)=>n1+n2))
    println(list.reduce((_+_)))
    println(list.reduce(_+_))


    list map{_*2} filter{_>3} foreach(println)
    println("==============")
    list.map(_*2).filter(_>3).foreach(println)
    println("===================")
    list.map{_*2}.filter{_>3}.foreach{println}

  }

  /**
    * 金字塔
    * @param n
    */
  def goldenHeap(n:Int){
    for(i<-1 to n ){
      for(j<- 1 to (n+i-1)){
        if(j<=n-i){
          print(" ")
        }else{
          print("*")
        }
      }
      println
    }
  }

  /**
    * 乘法表打印
    */
  def multiTable(): Unit ={
    for(i<- 1 to 9){
      for(j<-1 to i){
        print(j+"x"+i+"="+(j*i)+"   ")
      }
      println
    }
  }

}
