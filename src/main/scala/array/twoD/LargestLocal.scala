package array.twoD

import scala.annotation.tailrec

object LargestLocal extends App {
  /**
   * You are given an n x n integer matrix grid.
   *
   * Generate an integer matrix maxLocal of size (n - 2) x (n - 2) such that:
   *
   * maxLocal[i][j] is equal to the largest value of the 3 x 3 matrix in grid centered around row i + 1 and column j + 1.
   * In other words, we want to find the largest value in every contiguous 3 x 3 matrix in grid.
   *
   * Return the generated matrix.
   *
   * Example 1:
   *
   *
   * Input: grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
   * Output: [[9,9],[8,6]]
   * Explanation: The diagram above shows the original matrix and the generated matrix.
   * Notice that each value in the generated matrix corresponds to the largest value of a contiguous 3 x 3 matrix in grid.
   * Example 2:
   *
   *
   * Input: grid = [[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]
   * Output: [[2,2,2],[2,2,2],[2,2,2]]
   * Explanation: Notice that the 2 is contained within every contiguous 3 x 3 matrix in grid.
   *
   *
   * Constraints:
   *
   * n == grid.length == grid[i].length
   * 3 <= n <= 100
   * 1 <= grid[i][j] <= 100
   */

  def largestLocal(grid: Array[Array[Int]]): Array[Array[Int]] = {
    val arraySize = grid.length

    @tailrec
    def helper(iLimit: Int, jLimit: Int, i: Int, j: Int, iLocal: Int, jLocal: Int, currentMax: Int, result: Array[Array[Int]]): Array[Array[Int]] = {
      if (iLimit <= arraySize) {
        if (jLimit <= arraySize) {
          if (iLocal < iLimit) {
            if (jLocal < jLimit) {
              println(s"1>>>> iLimit: $iLimit, jLimit: $jLimit, i: $i, j: $j, iLocal: $iLocal, jLocal: $jLocal, currentMax: $currentMax")
              val currentValue = grid(iLocal)(jLocal)
              helper(iLimit, jLimit, i, j, iLocal, jLocal + 1, if (currentMax > currentValue) currentMax else currentValue, result)
            } else {
              println(s"2>>>> iLimit: $iLimit, jLimit: $jLimit, i: $i, j: $j, iLocal: $iLocal, jLocal: $jLocal, currentMax: $currentMax")
              helper(iLimit, jLimit, i, j, iLocal + 1, j, currentMax, result)
            }
          } else {

            println(s"3>>>> iLimit: $iLimit, jLimit: $jLimit, i: $i, j: $j, iLocal: $iLocal, jLocal: $jLocal, currentMax: $currentMax")
            result(i)(j) = currentMax
            val updatedJ = j + 1
            helper(i + 3, updatedJ + 3, i, updatedJ, i, updatedJ, 0, result)
          }
        } else {
          println(s"4>>>> iLimit: $iLimit, jLimit: $jLimit, i: $i, j: $j, iLocal: $iLocal, jLocal: $jLocal, currentMax: $currentMax")
          val updatedI = i + 1
          helper(updatedI + 3, 3, updatedI, 0, updatedI, 0, 0, result)
        }
      } else result
    }

    helper(3, 3, 0, 0, 0, 0, 0, Array.fill(arraySize - 2, arraySize - 2)(0))
  }

  println(largestLocal(Array(Array(9, 9, 8, 1), Array(5, 6, 2, 6), Array(8, 2, 6, 4), Array(6, 2, 2, 2))).toList.map(_.toList))
}
