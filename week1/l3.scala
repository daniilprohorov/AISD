import scala.io._
import java.io._
import scala.math.BigInt
import scala.Array
import scala.collection.Map

object l3 {
  /** Сортировка вставками */
  // def sortIn(lst : List[Int]):List[Int] = {
  //     def _sortIn(unsorted : List[Int], tmp : List[Int], sorted : List[Int]) : List[Int] = {
  //         if(unsorted != List()){
  //             /** unsorted head элемент для вставки */
  //             if(tmp == List()){
  //                 val newSorted : List[Int] = sorted :+ (unsorted head)
  //                 _sortIn(unsorted tail, newSorted, newSorted)
  //             }
  //             else if((unsorted head) < (tmp head)){
  //                 _sortIn(unsorted, tmp tail, sorted)
  //             }
  //             else {
  //                 /** Получаем сортированный список */
  //                 /** sorted 5 3 2 1 - tmp 3 2 1 + 4 :: tmp = sorted 5 4 3 2 1 */
  //                 val newSorted : List[Int]= (sorted diff tmp) ::: ( (unsorted head) :: tmp )
  //                 _sortIn(unsorted tail, newSorted, newSorted)
  //             }
  //         }
  //         else{
  //           sorted reverse
  //         }
  //     }
  //     _sortIn(lst tail, List(lst head), List(lst head))
  // }
  //
  def sortIn(lst : List[Int]):List[Tuple2[Int, Int]] = {
      def _sortIn(unsorted : List[Int], tmp : List[Tuple2[Int, Int]], sorted : List[Tuple2[Int, Int]]) : List[Tuple2[Int, Int]] = {
          if(unsorted != List()){
              /** unsorted head элемент для вставки */
              if(tmp == List()){
                  val newSorted : List[Tuple2[Int, Int]] = sorted :+ (unsorted head, 1)
                  _sortIn(unsorted tail, newSorted, newSorted)  
              }
              else if((unsorted head) < (tmp head)._1){
                  _sortIn(unsorted, tmp tail, sorted)
              }
              else {
                  /** Получаем сортированный список */
                  /** sorted 5 3 2 1 - tmp 3 2 1 + 4 :: tmp = sorted 5 4 3 2 1 */
                  val newSorted : List[Tuple2[Int, Int]] = (sorted diff tmp) ::: ( (unsorted head, tmp.length + 1) :: tmp )
                  _sortIn(unsorted tail, newSorted, newSorted)  
              }
          }    
          else{
            sorted reverse
          }
      }
      _sortIn(lst tail, List((lst head, 1)), List((lst head, 1)))
  }
  def main(args: Array[String]): Unit = {
    val inpFname = "input.txt"
    val outFname = "output.txt"
    val outFile = new File(outFname)
    val bw = new BufferedWriter(new FileWriter(outFile))
    val lines  = Source.fromFile(inpFname).getLines.toArray
    val count = lines(0).toInt
    var listElements : List[Int]= lines(1).split(' ').map(_.toInt).toList
    val listWithIndex = sortIn(listElements)
    val elIndex = listWithIndex.toMap
    val outFirstLine = listElements.map(elIndex(_)) mkString " " 
    val outSecondLine = listWithIndex.map(_._1) mkString " "
    bw.write(outFirstLine + "\n")
    bw.write(outSecondLine + "\n")
    bw.close()
  }
}

