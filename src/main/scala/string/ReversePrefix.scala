package string

import scala.annotation.tailrec

object ReversePrefix extends App {
  /**
   * Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and ends at the index of the first occurrence of ch (inclusive). If the character ch does not exist in word, do nothing.
   *
   * For example, if word = "abcdefd" and ch = "d", then you should reverse the segment that starts at 0 and ends at 3 (inclusive). The resulting string will be "dcbaefd".
   * Return the resulting string.
   *
   *
   *
   * Example 1:
   *
   * Input: word = "abcdefd", ch = "d"
   * Output: "dcbaefd"
   * Explanation: The first occurrence of "d" is at index 3.
   * Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".
   * Example 2:
   *
   * Input: word = "xyxzxe", ch = "z"
   * Output: "zxyxxe"
   * Explanation: The first and only occurrence of "z" is at index 3.
   * Reverse the part of word from 0 to 3 (inclusive), the resulting string is "zxyxxe".
   * Example 3:
   *
   * Input: word = "abcd", ch = "z"
   * Output: "abcd"
   * Explanation: "z" does not exist in word.
   * You should not do any reverse operation, the resulting string is "abcd".
   */

  //  def reversePrefix(word: String, ch: Char): String = {
  //    if (word.contains(ch)) {
  //      val reversePrefix = (word.takeWhile(_ != ch) + ch).reverse
  //      reversePrefix + word.drop(reversePrefix.length)
  //    } else {
  //      println("l")
  //      word
  //    }
  //  }

  def reversePrefix(word: String, ch: Char): String = {

    @tailrec
    def helper(list: List[Char], word: String, size: Int): (String, Int) = {
      list match {
        case ::(head, _) if head == ch => helper(Nil, s"$head$word", size + 1)
        case ::(head, next) => helper(next, s"$head$word", size + 1)
        case Nil => (word, size)
      }
    }

    if (word.contains(ch)) {
      val (a, s) = helper(word.toList, "", 0)
      a + word.drop(s)
    } else {
      word
    }
  }


  println(reversePrefix("abcdefd", 'd'))
}
