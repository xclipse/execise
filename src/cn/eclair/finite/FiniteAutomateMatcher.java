package cn.eclair.finite;

import java.util.Arrays;

public class FiniteAutomateMatcher {


  private String pattern;
  private char[] sigma;
  private int[][] delta;
  
  public String getPattern() {
    return pattern;
  }


  public void setPattern(String pattern) {
    this.pattern = pattern;
  }


  public int[][] computeTransitionFunction(){
    if(pattern == null) return null;
    if(sigma == null) return null;
    delta = new int[pattern.length() + 1][sigma.length];
    
    int k = 0;
    for (int q = 0; q < delta.length; q++) {
      for (int j = 0; j < sigma.length; j++) {
        k = Math.min (pattern.length(), q + 1);
        while(k > 0){
          boolean match = pattern.charAt(k - 1) == sigma[j];
          for (int i = 0; (i < k - 1) && match ; i ++) {
            if(pattern.charAt(k - 2 - i) != pattern.charAt(q - 1 - i)){
              match = false;
            }
          }
          if(!match){
            k--;
          } else {
            break;
          }
        }
        delta[q][j] = k;
      }
    }
    
    return delta;
  }

  public static void main(String[] args) {

    FiniteAutomateMatcher f = new FiniteAutomateMatcher();
    f.setPattern("ab");
    f.setSigma("ab");
    f.computeTransitionFunction();
    f.match("abab");    
  }


  public char[] getSigma() {
    return sigma;
  }


  public void setSigma(String sigma) {
    this.sigma = sigma.toCharArray();
  }
  
  public void match(String target){
    int q = 0; 
    for (int i = 0; i < target.length(); i++) {
      for (int j = 0; j < sigma.length; j++) {
        if(sigma[j] == target.charAt(i)){
          q = delta[q][j];
        }
      }
      if(pattern.length() == q){
        System.out.println("Find match in target from index " + (i - pattern.length() + 1 ));
      }
    }
  }
  
}
