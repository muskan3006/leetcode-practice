package util

import model.ListNode

import scala.annotation.tailrec

object LinkedListUtil {

  def traverseList(head: ListNode): List[Int] = {
    @tailrec
    def helper(node: ListNode, res: List[Int]): List[Int] = {
      if (node != null) {
        helper(node.next, node.x :: res)
      } else res
    }

    helper(head, List.empty)
  }

}
