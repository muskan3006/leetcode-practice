package array.oneD

import scala.annotation.tailrec

object IsStringPrefixOfArray extends App {
  /**
   * 1961. Check If String Is a Prefix of Array
   * Given a string s and an array of strings words, determine whether s is a prefix string of words.
   *
   * A string s is a prefix string of words if s can be made by concatenating the first k strings in words for some positive k no larger than words.length.
   *
   * Return true if s is a prefix string of words, or false otherwise.
   *
   *
   *
   * Example 1:
   *
   * Input: s = "iloveleetcode", words = ["i","love","leetcode","apples"]
   * Output: true
   * Explanation:
   * s can be made by concatenating "i", "love", and "leetcode" together.
   * Example 2:
   *
   * Input: s = "iloveleetcode", words = ["apples","i","love","leetcode"]
   * Output: false
   * Explanation:
   * It is impossible to make s using a prefix of arr.
   *
   *
   * Constraints:
   *
   * 1 <= words.length <= 100
   * 1 <= words[i].length <= 20
   * 1 <= s.length <= 1000
   * words[i] and s consist of only lowercase English letters.
   */

  def isPrefixString(s: String, words: Array[String]): Boolean = {
    @tailrec
    def helper(list: List[String], remainingString: String): Boolean = {
      if (remainingString.isEmpty) {
        true
      } else {
        list match {
          case ::(head, next) => {
            val headSize = head.length
            if (headSize > remainingString.length) false
            else {
              if (remainingString.take(headSize) == head)
                helper(next, remainingString.drop(headSize))
              else
                false
            }
          }
          case Nil => false
        }
      }
    }

    helper(words.toList, s)
  }

  println(isPrefixString("a", Array("aa","aaaa","banana")))
}
