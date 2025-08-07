package twoPointer

import scala.annotation.tailrec

object ArrayConcatenationValue extends App {
  /**
   * You are given a 0-indexed integer array nums.
   *
   * The concatenation of two numbers is the number formed by concatenating their numerals.
   *
   * For example, the concatenation of 15, 49 is 1549.
   * The concatenation value of nums is initially equal to 0. Perform this operation until nums becomes empty:
   *
   * If nums has a size greater than one, add the value of the concatenation of the first and the last element to the concatenation value of nums, and remove those two elements from nums. For example, if the nums was [1, 2, 4, 5, 6], add 16 to the concatenation value.
   * If only one element exists in nums, add its value to the concatenation value of nums, then remove it.
   * Return the concatenation value of nums.
   *
   *
   *
   * Example 1:
   *
   * Input: nums = [7,52,2,4]
   * Output: 596
   * Explanation: Before performing any operation, nums is [7,52,2,4] and concatenation value is 0.
   *  - In the first operation:
   *    We pick the first element, 7, and the last element, 4.
   *    Their concatenation is 74, and we add it to the concatenation value, so it becomes equal to 74.
   *    Then we delete them from nums, so nums becomes equal to [52,2].
   *  - In the second operation:
   *    We pick the first element, 52, and the last element, 2.
   *    Their concatenation is 522, and we add it to the concatenation value, so it becomes equal to 596.
   *    Then we delete them from the nums, so nums becomes empty.
   *    Since the concatenation value is 596 so the answer is 596.
   *    Example 2:
   *
   * Input: nums = [5,14,13,8,12]
   * Output: 673
   * Explanation: Before performing any operation, nums is [5,14,13,8,12] and concatenation value is 0.
   *  - In the first operation:
   *    We pick the first element, 5, and the last element, 12.
   *    Their concatenation is 512, and we add it to the concatenation value, so it becomes equal to 512.
   *    Then we delete them from the nums, so nums becomes equal to [14,13,8].
   *  - In the second operation:
   *    We pick the first element, 14, and the last element, 8.
   *    Their concatenation is 148, and we add it to the concatenation value, so it becomes equal to 660.
   *    Then we delete them from the nums, so nums becomes equal to [13].
   *  - In the third operation:
   *    nums has only one element, so we pick 13 and add it to the concatenation value, so it becomes equal to 673.
   *    Then we delete it from nums, so nums become empty.
   *    Since the concatenation value is 673 so the answer is 673.
   *
   *
   * Constraints:
   *
   * 1 <= nums.length <= 1000
   * 1 <= nums[i] <= 104
   */

  def findTheArrayConcVal(nums: Array[Int]): Long = {
    @tailrec
    def findDigits(number: Int, multiplier: Int): Long = {
//      println(number, multiplier)
      if (number / 10 == 0) multiplier else findDigits(number / 10, multiplier * 10)
    }

    def concatValues(num1: Int, num2: Int): Long = {
      println(s"num 1 : $num1, num2: $num2")
      val a = findDigits(num2, 1)
//      println(a)
      val b = (num1 * a) + num2
      println(b)
      b
    }

    @tailrec
    def helper(first: Int, last: Int, concat: Long): Long = {
      println(nums(first), first, nums(last), last, concat)
      if (first > last) concat
      else if (first == last) nums(first) + concat
      else {
        helper(first + 1, last - 1, concat + concatValues(nums(first), nums(last)))
      }
    }

    helper(0, nums.length - 1, 0)
  }

  println(findTheArrayConcVal(Array(1,78,27,48,14,86,79,68,77,20,57,21,18,67,5,51,70,85,47,56,22,79,41,8,39,81,59,74,14,45,49,15,10,28)))
//print(findTheArrayConcVal(Array(78, 10)))
//  println(1%10, 1/10)
}
