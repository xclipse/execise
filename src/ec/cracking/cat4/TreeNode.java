package ec.cracking.cat4;

public class TreeNode<E>{
  public TreeNode<E> parent;
  public TreeNode<E> left;
  public TreeNode<E> right;
  public E value;
  public TreeNode(E v, TreeNode<E> left, TreeNode<E> right) {
    value = v;
    this.left = left;
    this.right = right;
    if(left != null){
      left.parent = this;
    }
    if(right != null){
      right.parent = this;
    }
  }
  public TreeNode() {
    
  }
}