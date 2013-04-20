package cn.eclair.kmp;

import java.util.Arrays;

public class KMPMatcher {

  private int[] pi;
  private char[] pattern;

  /**
   * @param args
   */
  public static void main(String[] args) {
    KMPMatcher kmp = new KMPMatcher();
    kmp.setPattern("abab");
    kmp.computePerfixFunction();
    System.out.println(Arrays.toString(kmp.getPi()));
    kmp.match("abababaaababa");
  }
  
  public void computePerfixFunction(){
    if(pattern == null) return;
    pi = new int[pattern.length + 1];
    int k = 0;
    pi[1] = 0;
    for (int q = 2; q < pi.length; q++) {
      while(k > 0 && pattern[k] != pattern[q - 1]){
        k = pi[k];
      }
      if(pattern[k] == pattern [q - 1]){
        k++;
      }
      pi[q] = k;
    }
  }

  public void match(String target){
    
    char[] tar = target.toCharArray();

    int q = 0;
    for (int i = 0; i < tar.length; i++) {
      while( q > 0 &&  tar[i] != pattern[q]){
        q = pi[q];
      }
      if(pattern[q] == tar[i]){
        q++;
      }
      if(q == pattern.length){
        System.out.println("Find match start at index : " + (i - pattern.length + 1));
        q = pi[q];
      }
    }
  }
  
  public int[] getPi() {
    return pi;
  }

  public char[] getPattern() {
    return pattern;
  }

  public void setPattern(char[] pattern) {
    this.pattern = pattern;
  }
  
  public void setPattern(String pattern) {
    this.pattern = pattern.toCharArray();
  }

}
