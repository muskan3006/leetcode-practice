package tree

import model.TreeNode

object PostOrderTraversal extends App {

  def postOrderTraversal(root: TreeNode): List[Int] = {
    def helper(root: TreeNode, stack: List[TreeNode], result: List[Int]): List[Int] = {
      if (root != null) {
        if (root.left != null)
          helper(root.left, root.right :: TreeNode(root.value) :: stack, result)
        else if (root.right != null)
          helper(root.right, TreeNode(root.value) :: stack, result)
        else if (stack.nonEmpty) helper(stack.head, stack.tail, root.value :: result)
        else root.value :: result
      } else if (stack.nonEmpty) {
        helper(stack.head, stack.tail, result)
      } else
        result
    }

    helper(root, List.empty, List.empty)

  }

  val root = TreeNode(10, TreeNode(1, TreeNode(3), TreeNode(4, TreeNode(8))), TreeNode(2, TreeNode(5), TreeNode(6, null, TreeNode(7, right = TreeNode(9)))))
  //  val root = TreeNode(1, TreeNode(2), TreeNode(3))
  println(postOrderTraversal(root))
}
