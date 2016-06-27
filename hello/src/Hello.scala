import scala.io.Source

object Hello {
  def main(args: Array[String]) {
    println(1+2)
    val msg2:String = "hello world again"
    
    println(msg2)
    println(max(6,4))
    println(max(2,3))
    Hello.greeting()
    Hello.while_ex()
    val msgs = Array("Hello1","world2","courage3")
    Hello.foreach_ex(msgs)
    //Array is mutable, List is immutable
    //Tuple can contain elements of different types unlike List
    Hello.tuple_ex()
    Hello.map_set_ex()
    Hello.read_file_ex(args)
  }
  
  //example of function return Int
  def max(x:Int, y:Int):Int = {
    if(x > y) x
    else
      y
  }  
  //example of function having no return
  def greeting() = {
    println("greetings !")
  }
  //example of while
  def while_ex() = {
    var i=0
    while(i<5) {
      println(i)
      i+=1
    }
  }
  //example of "foreach", "for", try not to use while but use functional
  def foreach_ex(args:Array[String])= {
    //arg represents an element of args
    args.foreach { arg => println(arg) }
    //use for
    for(arg <- args){
      println(arg)
    }
    
    //not to use var and while
    var i=0
    while(i<args.length){
      println(args(i))
      i+=1
    }
  }
  //example of Tuple
  def tuple_ex()= {
    val pair = (99, "Luftballon")
    println(pair._1)
    println(pair._2)
  }
  //example of Map, Set
  def map_set_ex()= {
    var romanNum = scala.collection.mutable.HashMap(1 -> "I", 2 -> "II", 3 -> "III")
    romanNum.put(4, "IV")
    println(romanNum)
    var Alpha = scala.collection.mutable.HashSet("a","b","c","d","e")
    println(Alpha.contains("e"))
  } 
  def read_file_ex(args:Array[String])= {
    if(args.length > 0){
      for(line <- Source.fromFile(args(0)).getLines()){
        println(line.length + " :" + line)
      }
    }
    else{
      Console.err.println("Please enter filename")
    }
  }
}

