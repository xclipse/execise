package ec.cracking.cat4;

public class CommonAncestor {

  public static void main(String[] args) {
    TreeNode<Integer> root = new TreeNode<>(1, new TreeNode<>(2,new TreeNode<>(4,null,null),new TreeNode<>(5,null,null)), new TreeNode<>(3,new TreeNode<>(6,null,null),new TreeNode<>(7,null,null)));
    System.out.println(commAncestor(root, root.left, root.right).value);
    System.out.println(commAncestor(root, root.left, root.right.right).value);
    System.out.println(commAncestor(root, root.right, root.right.right).value);
    System.out.println(commAncestor(root, root.right.left, root.right.right).value);
    System.out.println(commAncestor(root, root.left, root.left.right).value);
    System.out.println(commAncestor(root, root.left.left, root.left.right).value);
    System.out.println(commAncestor(root, root.left, root.left.right).value);
    System.out.println(" -------------- LCA --------------------- ");
    System.out.println(LCA(root, root.left, root.right).value);
    System.out.println(LCA(root, root.left, root.right.right).value);
    System.out.println(LCA(root, root.right, root.right.right).value);
    System.out.println(LCA(root, root.right.left, root.right.right).value);
    System.out.println(LCA(root, root.left, root.left.right).value);
    System.out.println(LCA(root, root.left.left, root.left.right).value);
    System.out.println(LCA(root, root.left, root.left.right).value);
  }

  public static <E> TreeNode<E> commAncestor(TreeNode<E> root, TreeNode<E> a, TreeNode<E> b){
    if(root == null || root == a || root == b){
      return root;
    }
    boolean al = cover(root.left, a);
    boolean ar = cover(root.right, a);
    boolean bl = cover(root.left, b);
    boolean br = cover(root.right, b);
    if(al && br || ar && bl){
      return root;
    } else if(al && bl){
      return commAncestor(root.left, a, b);
    } else if(ar && br){
      return commAncestor(root.right, a, b);
    }
    return null;
  }
  
  public static <E> boolean cover(TreeNode<E> r, TreeNode<E> a){
    if(r == null || a == null){
      return false;
    } else if(r == a){
      return true;
    }
    return cover(r.left, a) || cover(r.right, a);
    
  }
  
  public static <E> TreeNode<E> LCA(TreeNode<E> root, TreeNode<E> a, TreeNode<E> b){
    if(root == null){
      return null;
    }
    if(root == a || root == b){
      return root;
    }
    TreeNode<E> l = LCA(root.left, a, b);
    TreeNode<E> r = LCA(root.right, a, b);
    if(l != null && r != null){
      return root;
    }
    return l != null? l:r; 
  }
}
