import scala.io._
import java.io._

object l1 {
  def main(args: Array[String]): Unit = {
    val input = "input.txt"
    val output = "output.txt" 
    val outfile = new File(output)
    val bw = new BufferedWriter(new FileWriter(outfile))
    for (line <- Source.fromFile(input).getLines) {
      bw.write(line.split(' ').map(_.toInt).sum.toString + "\n")
    }
    bw.close()
  }
}

