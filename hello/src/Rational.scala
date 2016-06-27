
//example to illustrate functional object
class Rational (n:Int, d:Int) {
  //the denominator cannot be 0
  require(d != 0)
  println("Create a rational " + n + "/" + d)
  //find the maximum common divisor
  private val g = gcd(n.abs, d.abs)
  //divide the input by the common divisor
  val numerator = n/g
  val denom = d/g
  
  def this(n:Int) = this(n, 1)
  
  //override toString(), return some useful string rather than the address
  override def toString():String = {
    return this.numerator + "/" + this.denom    
  }
  //recursive function gcd()
  def gcd(a:Int, b:Int):Int= {
    if(b==0) {
      return a
    }
    else {
      return gcd(b, a % b)
    }
  }
  
  def *(that:Rational):Rational= {
    return new Rational(this.numerator*that.numerator, this.denom*that.denom)
  }
  //use operator + instead of add, it is more simple!
  def +(that:Rational):Rational= {
    return this.add(that)
  }
  def add(that:Rational):Rational= {
    return new Rational(this.numerator*that.denom+this.denom*that.numerator, 
        this.denom*that.denom)
  }
  //overload the add with Int, rational + 1 no problem, but 1 + rational, problem!
  def +(i:Int):Rational= {
    return new Rational(this.numerator+i*this.denom, this.denom)
  }
  //implicit type conversion, 1 + rational, make this possible
  //implicit def intToRational(x:Int) = new Rational(x)
}

object TestRational {
  def main(args:Array[String]) {
    var two = new Rational(2)
    var x = new Rational(5, 3)
    var y = new Rational(3, 8)
    println(new Rational(66, 22))
    println(two+x)
    println("2*(3/8) = " + y*two)
    println(y + 1)
    //implicit def should be in main
    implicit def intToRational(x:Int) = new Rational(x)
    println(1+y)
  }
}