package binaryAndBits

object SumInteger extends App {

  /**
   * Given two integers a and b, return the sum of the two integers without using the operators + and -.
   *
   *
   *
   * Example 1:
   *
   * Input: a = 1, b = 2
   * Output: 3
   * Example 2:
   *
   * Input: a = 2, b = 3
   * Output: 5
   *
   *
   * Constraints:
   *
   * -1000 <= a, b <= 1000
   */

  def getSum(a: Int, b: Int): Int = {
    var al = a
    var bl = b
    while (bl != 0) {
      val tmp = (al & bl) << 1
      al = al ^ bl
      bl = tmp
    }
    al
  }
}
