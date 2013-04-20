package ec.cracking.cat1;

public class UniqueCharacter {

  public static void main(String[] args) {
    System.out.println(uniqueChar("abc"));
  }
  
  public static boolean uniqueChar(String s){
    if(s == null) return false;
    if(s.length() < 2 ) return true;
    char[] cs = s.toCharArray();
    int [] bitVec = new int [8];
    for (int i = 0; i < cs.length; i++) {
      int curBit = 1 << cs[i]% Integer.SIZE;
      if((bitVec[cs[i] / Integer.SIZE] & curBit) != 0) {
        return false;
      } else {
        bitVec [cs[i] / Integer.SIZE] |= curBit;
      }
    }
    return true;
  }
}
