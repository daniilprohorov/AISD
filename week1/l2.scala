import scala.io._
import java.io._
import scala.math.BigInt

object l2 {
  def main(args: Array[String]): Unit = {
    val input = "input.txt"
    val output = "output.txt"
    val outfile = new File(output)
    val bw = new BufferedWriter(new FileWriter(outfile))
    for (line <- Source.fromFile(input).getLines) {
      val arr = line.split(' ').map(_.toLong)
      val a : BigInt = arr(0)
      val b : BigInt = arr(1)
      bw.write((a+b.pow(2)).toString + "\n")
    }
    bw.close()
  }
}

