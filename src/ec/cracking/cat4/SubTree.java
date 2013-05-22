package ec.cracking.cat4;

public class SubTree {

  public static void main(String[] args) {
    TreeNode<Integer> root = new TreeNode<>(1, new TreeNode<>(2,new TreeNode<>(4,null,null),new TreeNode<>(5,null,null)), new TreeNode<>(3,new TreeNode<>(6,null,null),new TreeNode<>(7,null,null)));
    TreeNode<Integer> a = new TreeNode<>(1, new TreeNode<>(2,new TreeNode<>(4,null,null),new TreeNode<>(5,null,null)), new TreeNode<>(3,new TreeNode<>(6,null,null),new TreeNode<>(7,null,null)));
    TreeNode<Integer> b = new TreeNode<>(2,new TreeNode<>(4,null,null),new TreeNode<>(5,null,null));
    TreeNode<Integer> c = new TreeNode<>(3,new TreeNode<>(6,null,null),new TreeNode<>(7,null,null));
    TreeNode<Integer> d = new TreeNode<>(7,null,null);
    System.out.println(subTree(root, a));
    System.out.println(subTree(root, b));
    System.out.println(subTree(root, c));
    System.out.println(subTree(root, d));
  }
  
  public static <E> boolean subTree(TreeNode<E> t1, TreeNode<E> t2){
    if(t1 == null) return false;
    if(t2 == null) return true;
    if(t1.value.equals(t2.value)){
      if(match(t1, t2)){
        return true;
      }
    }
    return subTree(t1.left, t2) || subTree(t1.right, t2);
  }

  public static <E> boolean match(TreeNode<E> t1, TreeNode<E> t2){
    if(t1 == null && t2 == null){
      return true;
    }
    if(t1 != null && t2 != null){
      return t1.value.equals(t2.value) && match(t1.left, t2.left) && match(t1.right, t2.right);
    }
    return false;
  }
}
