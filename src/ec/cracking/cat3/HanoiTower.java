package ec.cracking.cat3;

import java.util.ArrayDeque;
import java.util.Deque;

public class HanoiTower {

  public static void main(String[] args) {
    new HanoiTower().hanoi(3);

  }
  
  public void hanoi(int disks){
    @SuppressWarnings("unchecked")
    Deque<Integer>[] robs = new Deque[] {new ArrayDeque<Integer>(), new ArrayDeque<Integer>(), new ArrayDeque<Integer>()};
    for (int i = disks; i > 0; i--) {
      robs[0].push(i);
    }
    mv(robs,disks,0,1,2);
  }

  private void mv(Deque<Integer>[] robs, int disks, int src, int buf, int tar) {
    
    if(disks > 0){
      mv(robs,disks-1,src,tar,buf);
      int d = robs[src].pop();
      robs[tar].push(d);
      logAction(d, src, tar);
      mv(robs, disks -1 , buf, src, tar);
    }
  }

  private void logAction(int d, int src, int tar) {
    System.out.println("move " + d + " from tower " + src + " to tower " + tar);
  }

}
