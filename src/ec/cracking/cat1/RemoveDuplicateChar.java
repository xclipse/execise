package ec.cracking.cat1;

public class RemoveDuplicateChar {

  public static void main(String[] args) {

    char[] cs = "abcd".toCharArray();
    removeDupChar(cs);
    System.out.println(cs);
  }

  public static void removeDupChar(char[] cs){
    int [] bitVec = new int[8];
    if(cs == null || cs.length < 2) return ;
    int tail = 0; // exclusive tail index
    for (int i = tail; i < cs.length; i++) {
      int idx = cs[i]/ Integer.SIZE;
      int mask = 1 << cs[i] % Integer.SIZE;
      if((bitVec[idx] & mask) != 0){
        cs[i]=0;
        continue;
      }
      bitVec[idx] |= mask;
      cs[tail++] = cs[i];
      if(tail - i != 1){
        cs[i] = 0;
      }
    }
    
  }
}
