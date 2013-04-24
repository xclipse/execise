package ec.cracking.cat3;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinTrackStack {

  private Deque<Integer> datas = new ArrayDeque<Integer>();
  private Deque<Integer> min = new ArrayDeque<Integer>();
  public static void main(String[] args) {

  }

  public int pop(){
    int r = datas.pop();
    if(min.peek() == r){
      min.removeFirst();
    }
    return r;
  }
  
  public void push(int i){
    datas.push(i);
    if(i == min.peekFirst()){
      min.push(i);
    }
  }
  
  public int min(){
    return min.peek();
  }
}
