package tree

import model.TreeNode

object MaxDepthOfBinaryTree extends App {

  //for depth we just need the count of levels that have atleast one node, so visit level by level, level detected = size increase
  def maxDepthOfBinaryTree(root: TreeNode): Int ={
    def helper(queue: List[TreeNode], size: Int): Int ={
      if(queue.isEmpty) size
      else {
        val next = queue.flatMap(node => List(node.left, node.right)).filter(_ != null)
        helper(next, size + 1)
      }
    }
    if(root == null) 0 else helper(List(root), 0)
  }
  val root = TreeNode(10, TreeNode(1, TreeNode(3), TreeNode(4, TreeNode(8))), TreeNode(2, TreeNode(5), TreeNode(6, null, TreeNode(7, right = TreeNode(9)))))

  println(maxDepthOfBinaryTree(root))
}
