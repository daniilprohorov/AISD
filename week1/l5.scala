import scala.io._
import java.io._
import scala.Array

object l5 {
  def quickSort(inpArr : Array[Long], file : BufferedWriter): Array[Long] = {
      var buff = file 
      def _quickSort(inpArr : Array[Long], first : Int, last : Int): Array[Long] = {
          if(first >= last){ 
              /** return */
              inpArr 
          }
          else {
              var i : Int = first 
              var j : Int = last 
              var arr = inpArr
              var tmpIndexes : List[Tuple2[Int, Int]]= List()
              /** Средний элемент */
              val center = arr(((first + last)/2).toInt)
              while( i <= j ){
                  while(arr(i) < center){ i += 1 }
                  while(arr(j) > center){ j -= 1 }
                  if( i <= j ){
                      if(i != j && arr(i) != arr(j)){
                        val tmp = arr(i)        
                        arr(i) = arr(j)        
                        arr(j) = tmp        
                        tmpIndexes = (i, j)::tmpIndexes
                      }
                      i += 1
                      j -= 1
                  }

              }
               tmpIndexes.map(x => buff.write(s"Swap elements at indices ${x._1 + 1} and ${x._2 + 1}.\n"))
              _quickSort(arr, first, j)
              _quickSort(arr, i, last)
          }    
      }
      _quickSort(inpArr, 0, inpArr.length - 1)
  }
  def main(args: Array[String]): Unit = {
    val inpFname = "input.txt"
    val outFname = "output.txt"
    val outFile = new File(outFname)
    val bw = new BufferedWriter(new FileWriter(outFile))
    val lines  = Source.fromFile(inpFname).getLines.toArray
    val count = lines(0).toInt
    var listElements = lines(1).split(' ').map(_.toLong).toArray
    val listWithIndex = quickSort(listElements, bw)
    val outText : String = "No more swaps needed.\n" + (listWithIndex mkString " " ) 
    bw.write(outText) 
    bw.close()
  }
}

