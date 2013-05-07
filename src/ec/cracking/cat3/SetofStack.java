package ec.cracking.cat3;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


public class SetofStack<E> {

  public static void main(String[] args) {
    new SetofStack<String>().test("abc");
    ArrayList<String> ll = new ArrayList<String>();
    ll.add("abc");
    ll.add(null);
    ll.add("abc");
    System.out.println(ll);
    Queue<String> q = new PriorityQueue<String>();
    q  = new LinkedBlockingQueue<String>();
  }
  public void test(E a){
  }

}
