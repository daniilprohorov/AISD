import scala.io._
import java.io._
import scala.math.BigInt
import scala.Array

object l4 {
  def quickSort(lst : List[Tuple2[Double, Int]]) : List[Tuple2[Double, Int]] = {
      if(lst != List()){
          val x = lst.head
          val xs = lst.tail
          val left = xs.filter( _._1 < x._1 )
          val right = xs.filter( _._1 >= x._1 )
          quickSort(left) ++ List(x) ++ quickSort(right)
      }
      else{
         List() 
      }
  }
  def main(args: Array[String]): Unit = {
    val inpFname = "input.txt"
    val outFname = "output.txt"
    val outFile = new File(outFname)
    val bw = new BufferedWriter(new FileWriter(outFile))
    val lines  = Source.fromFile(inpFname).getLines.toArray
    val count = lines(0).toInt
    var listElements = lines(1).split(' ').map(_.toDouble).toList.zip(1 to count)
    val listWithIndex = quickSort(listElements)
    val outFirstLine = 
      listWithIndex(0)._2.toString + " " + 
      listWithIndex((count / 2).toInt)._2.toString + " " + 
      listWithIndex(count - 1)._2.toString
    bw.write(outFirstLine)
    bw.close()
  }
}

