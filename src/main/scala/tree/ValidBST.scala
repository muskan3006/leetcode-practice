package tree

import model.TreeNode

import scala.annotation.tailrec

object ValidBST extends App {
  def validBST(root: TreeNode): Boolean = {

    @tailrec
    def helper(root: TreeNode, stack: List[TreeNode], inorder: List[Int]): Boolean = {
      if (root != null) {
        if (root.left != null) {
          helper(root.left, TreeNode(root.value, right = root.right) :: stack, inorder)
        } else if (root.right == null && stack.nonEmpty) {
          helper(stack.head, stack.tail, root.value :: inorder)
        } else {
          helper(root.right, stack, root.value :: inorder)
        }
      } else {
        inorder.reverse == inorder.sorted
      }
    }

    helper(root, List.empty, List.empty)
  }

  println(validBST(TreeNode(10, TreeNode(8, right = TreeNode(9)), TreeNode(12, TreeNode(11)))))

}
