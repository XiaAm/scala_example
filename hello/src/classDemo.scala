

class ChecksumAccumulator {
  private var sum=0
  
  def add(b:Byte):Unit= {
    this.sum += b
    //b = 100
    //can not reassign the argument because they are val
  }
  
  def checksum():Int= {
    return ~(sum & 0xFF) + 1
  }
}

object ChecksumAccumulator {
  //this is the companion object of the objects of class ChecksumAccumulator
  
}