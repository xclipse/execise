package ec.cracking.cat4;

public class InorderSuccessor {

  public static void main(String[] args) {

    TreeNode<Integer> root = new TreeNode<>(1, new TreeNode<>(2,new TreeNode<>(4,null,null),new TreeNode<>(5,null,null)), new TreeNode<>(3,new TreeNode<>(6,null,null),new TreeNode<>(7,null,null)));
    System.out.println(successor(root.left).value);
    System.out.println(successor(root.left.left).value);
    System.out.println(successor(root.left.right).value);
    System.out.println(successor(root.right.left).value);
    
  }
  
  public static <E> TreeNode<E> successor(TreeNode<E> root){
    if(root == null){
      return null;
    }
    if(root.right == null){
      while(root.parent != null && root.parent.right == root){
        root = root.parent;
      }
      return root.parent;
    } else {
      root = root.right;
      while(true){
        if(root.left == null){
          return root;
        } else {
          root = root.left;
        }
      }
    }
  }
  
}
