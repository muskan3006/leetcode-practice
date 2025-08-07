package tree

import model.TreeNode

import scala.annotation.tailrec

object LevelOrderTraversal extends App {

  def levelOrderTraversal(root: TreeNode): List[List[Int]] ={
    @tailrec
    def helper(queue: List[TreeNode], result: List[List[Int]]): List[List[Int]] ={
      if(queue.isEmpty) result.filter(_.nonEmpty)
      else {
        val next = queue.flatMap(node => List(node.left, node.right)).filter(_ != null)
        val levelValues = queue.map(_.value)
        helper(next, levelValues :: result)
      }
    }

    helper(List(root), List.empty)
  }
  val root = TreeNode(10, TreeNode(1, TreeNode(3), TreeNode(4, TreeNode(8))), TreeNode(2, TreeNode(5), TreeNode(6, null, TreeNode(7, right = TreeNode(9)))))
  val r1 = TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))
  println(levelOrderTraversal(root))

}
