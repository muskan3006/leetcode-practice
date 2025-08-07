package twoPointer

import scala.annotation.tailrec

object IntersectionOf2Arrays extends App {
  /**
   * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
   *
   *
   *
   * Example 1:
   *
   * Input: nums1 = [1,2,2,1], nums2 = [2,2]
   * Output: [2]
   * Example 2:
   *
   * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
   * Output: [9,4]
   * Explanation: [4,9] is also accepted.
   *
   *
   * Constraints:
   *
   * 1 <= nums1.length, nums2.length <= 1000
   * 0 <= nums1[i], nums2[i] <= 1000
   */

  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val (smallArray, bigArray) = if (nums1.length > nums2.length) (nums1, nums2) else (nums2, nums1)

    @tailrec
    def helper(smallPtr: Int, bigPtr: Int, traversedNumbers: Set[Int], res: Set[Int]): Array[Int] = {
      if (smallPtr == smallArray.length) res.toArray
      else if (bigPtr == bigArray.length) {
        val smallNumber = smallArray(smallPtr)
        if (traversedNumbers.contains(smallNumber)) helper(smallPtr + 1, bigPtr, traversedNumbers, res + smallNumber)
        else helper(smallPtr + 1, bigPtr, traversedNumbers, res)
      }
      else {
        val smallNumber = smallArray(smallPtr)
        val bigNumber = bigArray(bigPtr)
        if ((smallNumber == bigNumber) || traversedNumbers.contains(smallNumber)) {
          helper(smallPtr + 1, bigPtr + 1, traversedNumbers + bigNumber, res + smallNumber)
        } else {
          helper(smallPtr, bigPtr + 1, traversedNumbers + bigNumber, res)
        }
      }
    }

    helper(0, 0, Set.empty[Int], Set.empty[Int])
  }

  println(intersection(Array(1, 2, 5), Array(9, 4, 5, 2)).toList)

}
