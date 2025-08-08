package array.oneD


object PathCrossing extends App {
  /**
   * Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east, or west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.
   *
   * Return true if the path crosses itself at any point, that is, if at any time you are on a location you have previously visited. Return false otherwise.
   *
   *
   *
   * Example 1:
   *
   *
   * Input: path = "NES"
   * Output: false
   * Explanation: Notice that the path doesn't cross any point more than once.
   * Example 2:
   *
   *
   * Input: path = "NESWW"
   * Output: true
   * Explanation: Notice that the path visits the origin twice.
   *
   *
   * Constraints:
   *
   * 1 <= path.length <= 104
   * path[i] is either 'N', 'S', 'E', or 'W'.
   */
  import scala.annotation.tailrec

  def isPathCrossing(path: String): Boolean = {
    @tailrec
    def helper(pathL: List[Char], current: (Int, Int), set: Set[(Int, Int)]): Boolean = {
      if (set.contains(current)) true else
        pathL match {
          case ::(head, next) if head == 'N' =>
            val nC = (current._1 + 1, current._2 + 1)
            helper(next, nC, set + current)
          case ::(head, next) if head == 'S' =>
            val nC = (current._1 - 1, current._2 - 1)
            helper(next, nC, set + current)
          case ::(head, next) if head == 'E' =>
            val nC = (current._1, current._2 + 1)
            helper(next, nC, set + current)
          case ::(head, next) if head == 'W' =>
            val nC = (current._1, current._2 - 1)
            helper(next, nC, set + current)
          case Nil => false
          case _ => false
        }
    }

    helper(path.toList, (0, 0), Set.empty)
  }

  println(isPathCrossing("NESSWN"))
}
