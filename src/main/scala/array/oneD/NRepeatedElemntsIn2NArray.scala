package array.oneD

import scala.annotation.tailrec

object NRepeatedElementsIn2NArray {
  /**
   * You are given an integer array nums with the following properties:
   *
   * nums.length == 2 * n.
   * nums contains n + 1 unique elements.
   * Exactly one element of nums is repeated n times.
   * Return the element that is repeated n times.
   *
   *
   *
   * Example 1:
   *
   * Input: nums = [1,2,3,3]
   * Output: 3
   * Example 2:
   *
   * Input: nums = [2,1,2,5,3,2]
   * Output: 2
   * Example 3:
   *
   * Input: nums = [5,1,5,2,5,3,5,4]
   * Output: 5
   */

  def repeatedNTimes(nums: Array[Int]): Int = {
    @tailrec
    def helper(index: Int, set: Set[Int]): Int = {
      val currentElement = nums(index)
      if (set(currentElement)) {
        currentElement
      } else helper(index + 1, set + currentElement)
    }
    helper(0, Set.empty[Int])
  }
}
