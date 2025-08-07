package array.oneD

object MaxSubArraySum extends App {

  /**
   * Given an integer array nums, find the subarray with the largest sum, and return its sum.
   *
   *
   *
   * Example 1:
   *
   * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
   * Output: 6
   * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
   * Example 2:
   *
   * Input: nums = [1]
   * Output: 1
   * Explanation: The subarray [1] has the largest sum 1.
   * Example 3:
   *
   * Input: nums = [5,4,-1,7,8]
   * Output: 23
   * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
   *
   *
   * Constraints:
   *
   * 1 <= nums.length <= 105
   * -104 <= nums[i] <= 104
   *
   *
   * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
   */
  import scala.annotation.tailrec
  def maxSubArray(nums: Array[Int]): Int = {
    val size = nums.length

    @tailrec
    def helper(right: Int, currentSum: Int, max: Int): Int = {
      if (right < size) {
        val cEle = nums(right)
        val s = currentSum + cEle
        if (s < 0) {
          helper(right + 1, 0, math.max(max, s))
        } else {
          helper(right + 1, s, math.max(max, s))
        }
      } else max
    }

    helper(0, 0, Integer.MIN_VALUE)
  }

  println(maxSubArray(Array(5,4,-1,7,8)))
}

