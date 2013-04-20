package ec.cracking.cat1;


public class Ana {

  public static void main(String[] args) {
    System.out.println(isAna("abccc", "cacbc"));
  }

  public static boolean isAna(String s, String t){
    int [] charBalance = new int [256];
    if(s == null || t == null || s.length() != t.length()){
      return false;
    }
    for(int i=0; i < s.length(); i ++){
      charBalance[s.charAt(i)] ++;
      charBalance[t.charAt(i)] --;
    }
    for (int i = 0; i < charBalance.length; i++) {
      if(charBalance[i] != 0){
        return false;
      }
    }
    return true;
  }
}
