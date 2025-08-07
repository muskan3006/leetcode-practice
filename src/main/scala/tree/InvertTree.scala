package tree

import model.TreeNode

object InvertTree extends App {

  def invertTree(root: TreeNode): TreeNode ={
    if(root != null) TreeNode(root.value, invertTree(root.right),invertTree(root.left)) else root
  }
}
