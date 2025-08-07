package tree

import model.TreeNode

object InOrderTraversal extends App {
  def inorderTraversal(root: TreeNode): List[Int] = {

    def helper(root: TreeNode, stack: List[TreeNode], result: List[Int]): List[Int] = {
      if(root != null) {
        if(root.left != null){
          helper(root.left, TreeNode(root.value, null, root.right) :: stack, result)
        } else if(root.right == null && stack.nonEmpty){
          helper(stack.head, stack.tail, root.value :: result)
        } else helper(root.right, stack, root.value :: result)
      } else result
    }

    helper(root, List.empty, List.empty)
  }

  val root = TreeNode(10, TreeNode(1, TreeNode(3), TreeNode(4, TreeNode(8))), TreeNode(2, TreeNode(5), TreeNode(6, null, TreeNode(7, right = TreeNode(9)))))

  println(inorderTraversal(root))
}
