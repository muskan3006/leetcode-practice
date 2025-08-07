package slidingWindow

import scala.annotation.tailrec

object MinConsecutiveCardsToPick extends App {
  /**
   * You are given an integer array cards where cards[i] represents the value of the ith card. A pair of cards are matching if the cards have the same value.
   *
   * Return the minimum number of consecutive cards you have to pick up to have a pair of matching cards among the picked cards. If it is impossible to have matching cards, return -1.
   *
   *
   *
   * Example 1:
   *
   * Input: cards = [3,4,2,3,4,7]
   * Output: 4
   * Explanation: We can pick up the cards [3,4,2,3] which contain a matching pair of cards with value 3. Note that picking up the cards [4,2,3,4] is also optimal.
   * Example 2:
   *
   * Input: cards = [1,0,5,3]
   * Output: -1
   * Explanation: There is no way to pick up a set of consecutive cards that contain a pair of matching cards.
   *
   *
   * Constraints:
   *
   * 1 <= cards.length <= 105
   * 0 <= cards[i] <= 106
   */

  def minimumCardPickup(cards: Array[Int]): Int = {
    val cardsCount = cards.length

    @tailrec
    def helper(left: Int, right: Int, map: Map[Int, Int], min: Int, found: Boolean): Int = {
      if (right < cardsCount) {
        val currentCard = cards(right)
        println(s"left: $left, right: $right, map: $map, min: $min, currentCard: $currentCard")
        map.get(currentCard) match {
          case Some(value) => helper(value + 1, right + 1, map + (currentCard -> right), math.min(min, right - value + 1), true)
          case None => helper(left, right + 1, map + (currentCard -> right), min, found)
        }
      } else {
        if (!found) -1 else min
      }
    }

    helper(0, 0, Map.empty, cardsCount, false)
  }

  println(minimumCardPickup(Array(79,99,76,57,99,76,51,80,82,73,89,77,38,98,87,59,97,36,100,71,24,19,86,54,41,72,86,87,
    48,58,83,15,64,54,17,15,57,7,62,36,25,49,27,48,2,45,13,63,94,86,67,73,9,15,7,56,97,44,12,81,53,64,77,34,79,74,12,50,52)))
}
