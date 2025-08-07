package tree

import model.TreeNode

object PreOrderTraversal extends App {

  def preOrderTraversal(root: TreeNode): List[Int] = {
    def helper(root: TreeNode, stack: List[TreeNode], result: List[Int]): List[Int] = {
      if (root != null) {
        helper(root.left, root.right :: stack, root.value :: result)
      } else if (stack.nonEmpty) {
        helper(stack.head, stack.tail, result)
      } else result
    }

    helper(root, List.empty, List.empty)
  }

  val root = TreeNode(10, TreeNode(1, TreeNode(3), TreeNode(4, TreeNode(8))), TreeNode(2, TreeNode(5), TreeNode(6, null, TreeNode(7, right = TreeNode(9)))))

  println(preOrderTraversal(root))
}
