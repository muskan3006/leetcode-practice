package array.oneD

import scala.annotation.tailrec

object TwoSum extends App {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    @tailrec
    def findIndices(start: Int, map: Map[Int, Int]): Array[Int] = {
      val currentValue = nums(start)
      map.get(target - currentValue) match {
        case Some(value) => Array(value, start)
        case None => findIndices(start + 1, map + (currentValue -> start))
      }
    }

    findIndices(0, Map.empty[Int, Int])
  }

}
