package ec.cracking.cat2;

public class RemoveDuplicateNode {

  static class  Node{
    public Node(int value, Node next){
      this.value = value;
      this.next = next;
    }
    public Node next;
    public int value;
  }
  public static void main(String[] args) {
    Node head = new Node(1,new Node(1, new Node(1, new Node(1, new Node(1, null)))));
    removeDup(head);
    while(head != null){
      System.out.print(head.value + " --> ");
      head = head.next;
    }
  }
  
  public static void removeDup(Node head){
    Node cur, pre, tail = head;
    while(tail!= null){
      cur = tail.next;
      pre = tail;
      while(cur != null){
        if(cur.value == tail.value){
          cur=cur.next;
          pre.next = cur;
        } else {
          pre = cur;
          cur = cur.next;
        }
      }
      tail = tail.next;
    }
  }

}
