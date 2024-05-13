package array.twoD

import scala.annotation.tailrec

object ScoreAfterFlippingMatrix extends App {
  /**
   * You are given an m x n binary matrix grid.
   *
   * A move consists of choosing any row or column and toggling each value in that row or column (i.e., changing all 0's to 1's, and all 1's to 0's).
   *
   * Every row of the matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.
   *
   * Return the highest possible score after making any number of moves (including zero moves).
   *
   *
   *
   * Example 1:
   *
   *
   * Input: grid = [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
   * Output: 39
   * Explanation: 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
   * Example 2:
   *
   * Input: grid = [[0]]
   * Output: 1
   */

  def matrixScore(grid: Array[Array[Int]]): Int = {
    val rowMutation = flipRow(grid)
    //    println(rowMutation.map(_.toList).toList)
    val columnMutation = flipColumn(rowMutation, 0, 0, grid(0).length, grid.length, 0, Map.empty[(Int, Int), Int])
    //    println(columnMutation.map(_.toList).toList)
    calculateSum(columnMutation)
  }

  def flipRow(grid: Array[Array[Int]]): Array[Array[Int]] = {
    grid.map(row => if (row(0) == 0) row.map(v => if (v == 0) 1 else 0) else row)
  }

  @tailrec
  def flipColumn(grid: Array[Array[Int]], j: Int, i: Int, jLimit: Int, iLimit: Int, count: Int, currentColumn: Map[(Int, Int), Int]): Array[Array[Int]] = {
    if (j < jLimit) {
      if (i < iLimit) {
        val currentValue = grid(i)(j)
        if (currentValue == 0) flipColumn(grid, j, i + 1, jLimit, iLimit, count + 1, currentColumn + (((i, j), 0)))
        else flipColumn(grid, j, i + 1, jLimit, iLimit, count, currentColumn + (((i, j), 1)))
      } else {
        if (count > iLimit / 2) {
          currentColumn.foreach(x => if (x._2 == 0) grid(x._1._1)(x._1._2) = 1 else grid(x._1._1)(x._1._2) = 0)
          flipColumn(grid, j + 1, 0, jLimit, iLimit, 0, Map.empty[(Int, Int), Int])
        } else flipColumn(grid, j + 1, 0, jLimit, iLimit, 0, Map.empty[(Int, Int), Int])
      }
    } else grid
  }

  def calculateSum(grid: Array[Array[Int]]): Int = {
    grid.foldLeft(0)((res, row) => res + calculateBinary(row.reverse, 0, 0))
  }

  @tailrec
  def calculateBinary(row: Array[Int], index: Int, sum: Int): Int = {
    if (index < row.length) {
      if (row(index) == 1) calculateBinary(row, index + 1, sum + Math.pow(2, index).toInt)
      else calculateBinary(row, index + 1, sum)
    } else sum
  }

  println(matrixScore(Array(Array(0, 0, 1), Array(0, 0, 1), Array(0, 1, 0))))
}
