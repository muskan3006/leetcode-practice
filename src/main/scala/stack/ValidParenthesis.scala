package stack

import scala.collection.mutable

object ValidParenthesis extends App {
  /**
   * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
   *
   * An input string is valid if:
   *
   * Open brackets must be closed by the same type of brackets.
   * Open brackets must be closed in the correct order.
   * Every close bracket has a corresponding open bracket of the same type.
   *
   *
   * Example 1:
   *
   * Input: s = "()"
   *
   * Output: true
   *
   * Example 2:
   *
   * Input: s = "()[]{}"
   *
   * Output: true
   *
   * Example 3:
   *
   * Input: s = "(]"
   *
   * Output: false
   *
   * Example 4:
   *
   * Input: s = "([])"
   *
   * Output: true
   *
   * Example 5:
   *
   * Input: s = "([)]"
   *
   * Output: false
   *
   *
   *
   * Constraints:
   *
   * 1 <= s.length <= 104
   * s consists of parentheses only '()[]{}'.
   *
   */


  def isValid(s: String): Boolean = {
    val sSize = s.length
    val openingBrackets = Set('[', '{', '(')
    val closingBrackets = Set(']', '}', ')')
    val relation = Map(']' -> '[', '}' -> '{', ')' -> '(')

    def helper(index: Int, traversedItems: List[Char]): Boolean = {
      if (index < sSize) {
        val char = s(index)
        if (openingBrackets.contains(char))
          helper(index + 1, char :: traversedItems)
        else {
          val isMatch = for {
            r <- relation.get(char)
            t <- traversedItems.headOption
          } yield r == t

          isMatch match {
            case Some(value) if value => helper(index + 1, traversedItems.tail)
            case _ => false
          }
        }

      } else if (traversedItems.isEmpty) true
      else false
    }

    helper(0, List.empty)
  }
}
