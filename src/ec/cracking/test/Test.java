package ec.cracking.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Test {

  public static void main(String[] args) {
    int head=0, tail = 0;
    int max = 16;
    System.out.println((head - 1) & (max - 1));
    
    int initialCapacity = 8;
    int numElements = 16;
    // Find the best power of two to hold elements.
    // Tests "<=" because arrays aren't kept full.
    if (numElements >= initialCapacity) {
        initialCapacity = numElements;
        System.out.println(initialCapacity + " = " + Integer.toBinaryString(initialCapacity));
        initialCapacity |= (initialCapacity >>>  1);
        System.out.println(initialCapacity + " = " + Integer.toBinaryString(initialCapacity));
        initialCapacity |= (initialCapacity >>>  2);
        System.out.println(initialCapacity + " = " + Integer.toBinaryString(initialCapacity));
        initialCapacity |= (initialCapacity >>>  4);
        System.out.println(initialCapacity + " = " + Integer.toBinaryString(initialCapacity));
        initialCapacity |= (initialCapacity >>>  8);
        System.out.println(initialCapacity + " = " + Integer.toBinaryString(initialCapacity));
        initialCapacity |= (initialCapacity >>> 16);
        System.out.println(initialCapacity + " = " + Integer.toBinaryString(initialCapacity));
        initialCapacity++;

        
        if (initialCapacity < 0)   // Too many elements, must back off
            initialCapacity >>>= 1;// Good luck allocating 2 ^ 30 elements
    }
    System.out.println((1<<31)-1);
    System.out.println(Integer.toBinaryString(((1<<31)-1)));
    System.out.print(countOnebit(0b110000));
    
    
    System.out.println("");
    System.out.println(Character.isDigit('1'));
    System.out.println(Character.isAlphabetic('a'));
    System.out.println(Character.isDigit((int)'1'));
    System.out.println(Character.forDigit(15, 16));
    System.out.println(Integer.toBinaryString(-1));
  }

  public static int countOnebit(int b){
    int count = 0;
    while(b > 0){
      count ++;
      b &= (b - 1);
    }
    return count;
  }
}
