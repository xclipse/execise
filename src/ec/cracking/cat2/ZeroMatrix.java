package ec.cracking.cat2;

public class ZeroMatrix {

  public static void main(String[] args) {

    
  }
  
  public static void setZero(int[][] m){
    if(m == null || m.length == 0){
      return;
    }
    int l =m.length;
    int [] row = new int[l];
    int [] col = new int[l];
    for (int i = 0; i < l; i++) {
      for (int j = 0; j < l; j++) {
        if(m[i][j] == 0){
          row[i] = 1;
          col[j] = 1;
        }
      }
    }
    for (int i = 0; i < l; i++) {
      for (int j = 0; j < l; j++) {
        if(row[i] == 1 || col[j] == 1){
          m[i][j] = 0;
        }
      }
    }
  }

}
