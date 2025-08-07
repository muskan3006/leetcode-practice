package array.oneD

object ProductOfArrayExceptItself extends App {

  /**
   * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
   *
   * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
   *
   * You must write an algorithm that runs in O(n) time and without using the division operation.
   *
   *
   *
   * Example 1:
   *
   * Input: nums = [1,2,3,4]
   * Output: [24,12,8,6]
   * Example 2:
   *
   * Input: nums = [-1,1,0,-3,3]
   * Output: [0,0,9,0,0]
   *
   *
   * Constraints:
   *
   * 2 <= nums.length <= 105
   * -30 <= nums[i] <= 30
   * The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
   *
   *
   * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
   */

  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    val arraySize = nums.size
    val res = Array.fill(arraySize)(1)
    var index = 0
    var prefix = 1
    var postfix = 1
    while (index < arraySize) {
      res(index) = prefix
      prefix = prefix * nums(index)
      index += 1
    }

    index -= 1

    while (index >= 0) {
      res(index) = res(index) * postfix
      postfix = nums(index) * postfix
      index -= 1
    }
    res
  }

  println(productExceptSelf(Array(1, 2, 3, 4)).toList)

}
