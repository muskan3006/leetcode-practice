package array.oneD


object CountPrefixAndSuffix extends App {
  /**
   * You are given a 0-indexed string array words.
   *
   * Let's define a boolean function isPrefixAndSuffix that takes two strings, str1 and str2:
   *
   * isPrefixAndSuffix(str1, str2) returns true if str1 is both a prefix and a suffix of str2, and false otherwise.
   * For example, isPrefixAndSuffix("aba", "ababa") is true because "aba" is a prefix of "ababa" and also a suffix, but isPrefixAndSuffix("abc", "abcd") is false.
   *
   * Return an integer denoting the number of index pairs (i, j) such that i < j, and isPrefixAndSuffix(words[i], words[j]) is true.
   *
   *
   *
   * Example 1:
   *
   * Input: words = ["a","aba","ababa","aa"]
   * Output: 4
   * Explanation: In this example, the counted index pairs are:
   * i = 0 and j = 1 because isPrefixAndSuffix("a", "aba") is true.
   * i = 0 and j = 2 because isPrefixAndSuffix("a", "ababa") is true.
   * i = 0 and j = 3 because isPrefixAndSuffix("a", "aa") is true.
   * i = 1 and j = 2 because isPrefixAndSuffix("aba", "ababa") is true.
   * Therefore, the answer is 4.
   * Example 2:
   *
   * Input: words = ["pa","papa","ma","mama"]
   * Output: 2
   * Explanation: In this example, the counted index pairs are:
   * i = 0 and j = 1 because isPrefixAndSuffix("pa", "papa") is true.
   * i = 2 and j = 3 because isPrefixAndSuffix("ma", "mama") is true.
   * Therefore, the answer is 2.
   * Example 3:
   *
   * Input: words = ["abab","ab"]
   * Output: 0
   * Explanation: In this example, the only valid index pair is i = 0 and j = 1, and isPrefixAndSuffix("abab", "ab") is false.
   * Therefore, the answer is 0.
   *
   *
   * Constraints:
   *
   * 1 <= words.length <= 50
   * 1 <= words[i].length <= 10
   * words[i] consists only of lowercase English letters.
   */

  def isPrefixAndSuffix(str1: String, str2: String): Boolean = {
    str2.startsWith(str1) && str2.endsWith(str1)
  }

  import scala.annotation.tailrec

  def countPrefixSuffixPairs(words: Array[String]): Int = {
    val wordsL = words.length

    @tailrec
    def helper(first: Int, second: Int, count: Int): Int = {
      if (first < wordsL - 1) {
        if (second < wordsL) {
          helper(first, second + 1, if (isPrefixAndSuffix(words(first), words(second))) count + 1 else count)
        } else {
          helper(first + 1, first + 2, count)
        }
      } else count
    }

    if (wordsL <= 1) 0 else helper(0, 1, 0)
  }

  println(countPrefixSuffixPairs(Array("a", "aba", "ababa", "abba")))

}
