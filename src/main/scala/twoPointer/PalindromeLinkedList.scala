//package twoPointer
//
//import model.ListNode
//
//import scala.annotation.tailrec
//
//object PalindromeLinkedList extends App {
//  /**
//   * /**
//   * Definition for singly-linked list.
//   * class ListNode(_x: Int = 0, _next: ListNode = null) {
//   * var next: ListNode = _next
//   * var x: Int = _x
//   * }
//   * */
//   */
//
//  def isPalindrome(head: ListNode): Boolean = {
//    def reverseLinkedList(lisNode: ListNode): ListNode ={
//
//    }
//    @tailrec
//    def findMid(slow: ListNode, fast: ListNode): ListNode = {
//      if (fast.next == null || fast.next.next == null) {
//        slow
//      } else {
//        findMid(slow.next, fast.next.next)
//      }
//    }
//
//    @tailrec
//    def isIdentical(head1: ListNode, head2: ListNode, res: Boolean): Boolean = {
//      println(head1, head2)
//      if (!res) res
//      else if (head2.next == null) head1.x == head2.x
//      else isIdentical(head1.next, head2.next, head1.x == head2.x)
//    }
//
//    if (head == null || head.next == null) true else {
//      val head2 = findMid(head, head).next
//      println(head2)
//      isIdentical(head, head2, true)
//    }
//  }
//
//  println(isPalindrome(ListNode(1, ListNode(2, ListNode(2, ListNode(1, null))))))
//}
