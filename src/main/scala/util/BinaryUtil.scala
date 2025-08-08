package util

import scala.annotation.tailrec

object BinaryUtil {

  def binaryToInt(list: List[Int]): Int = {
    @tailrec
    def helper(l: List[Int], index: Int, res: Int): Int = {
      l match {
        case ::(head, next) if head == 1 => helper(next, index + 1, math.pow(2, index).toInt + res)
        case ::(_, next) => helper(next, index + 1, res)
        case Nil => res
      }
    }

    helper(list, 0, 0)
  }

}
