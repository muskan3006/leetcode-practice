package tree

import model.TreeNode

import scala.annotation.tailrec

object SymmetricTree extends App {
  def symmetricTree(root: TreeNode): Boolean = {

    @tailrec
    def helper(left: TreeNode, right: TreeNode, queue: List[(TreeNode, TreeNode)]): Boolean = {
      (left, right) match {
        case (null, null) => if (queue.nonEmpty) {
          helper(queue.head._1, queue.head._2, queue.tail)
        } else true
        case (null, _) => false
        case (_, null) => false
        case (_, _) => if (left.value == right.value) {
          helper(left.left, right.right, (left.right, right.left) :: queue)
        } else false
      }
    }

    if (root == null) false else helper(root.left, root.right, List.empty[(TreeNode, TreeNode)])
  }
}
