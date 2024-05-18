package array.oneD

import scala.annotation.tailrec

object CountDigitsThatDivideTheNumber extends App {
  /**
   * Given an integer num, return the number of digits in num that divide num.
   *
   * An integer val divides nums if nums % val == 0.
   *
   *
   *
   * Example 1:
   *
   * Input: num = 7
   * Output: 1
   * Explanation: 7 divides itself, hence the answer is 1.
   * Example 2:
   *
   * Input: num = 121
   * Output: 2
   * Explanation: 121 is divisible by 1, but not 2. Since 1 occurs twice as a digit, we return 2.
   * Example 3:
   *
   * Input: num = 1248
   * Output: 4
   */

  def countDigits(num: Int): Int = {
    @tailrec
    def helper(remainingDigits: Int, divideBy: Int, count: Map[Int, Int]): Int = {
      if (remainingDigits == 0) {
        if (divideBy != 0 && num % divideBy == 0) {
          val mapEntry = count.get(divideBy) match {
            case Some(value) => (divideBy, value + 1)
            case None => (divideBy, 1)
          }
          val updatedCount = count + (mapEntry)
          updatedCount.values.sum
        } else {
          count.values.sum
        }

      } else {
        if (divideBy != 0 && num % divideBy == 0) {
          val mapEntry = count.get(divideBy) match {
            case Some(value) => (divideBy, value + 1)
            case None => (divideBy, 1)
          }
          helper(remainingDigits / 10, remainingDigits % 10, count + (mapEntry))
        } else {
          helper(remainingDigits / 10, remainingDigits % 10, count)
        }
      }
    }

    helper(num / 10, num % 10, Map.empty)
  }

  println(countDigits(1248))
}
