package ec.cracking.cat3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class StackinArray<E> {

  public static void main(String[] args) {
    StackinArray<String> sa = new StackinArray<String>(30, 3, String.class);
    sa.push(1, "a");
    sa.push(1, "b");
    sa.push(1, "c");
    sa.push(1, "d");
    sa.push(1, "e");
    sa.push(1, "f");
    sa.push(2, "a");
    sa.push(2, "b");
    sa.push(2, "c");
    sa.push(2, "d");
    sa.push(3, "e");
    sa.push(2, "e");
    sa.push(2, "a");
    sa.push(2, "b");
    sa.push(3, "e");
    sa.push(3, "f");
    sa.push(3, "e");
    sa.push(3, "f");
    sa.push(3, "e");
    sa.push(3, "f");
    sa.push(3, "e");
    sa.push(3, "f");
    sa.push(3, "e");
    sa.push(2, "c");
    sa.push(2, "d");
    sa.push(2, "e");
    System.out.println(Arrays.toString(sa.datas));
    System.out.println(Arrays.toString(sa.datas));
    System.out.println(sa.pop(2));
    System.out.println(Arrays.toString(sa.datas));
    System.out.println(sa.pop(2));
    System.out.println(Arrays.toString(sa.datas));
    System.out.println(sa.pop(2));
    System.out.println(sa.pop(3));
    System.out.println(Arrays.toString(sa.datas));
    System.out.println(sa.pop(3));
    System.out.println(Arrays.toString(sa.datas));
    System.out.println(sa.pop(3));
  }
  
  private E[] datas;
  private int aLen;
  private int num;
  private int[] topIdx;
  @SuppressWarnings("unchecked")
  public StackinArray(int size, int num, Class<E> clazz) {
    this.num = num;
    aLen = size;
    if(size < ((num + 1) * 2) ){
      throw new IllegalArgumentException("Array size is too small");
    }
    topIdx = new int[num];
    for (int i = 0; i < num; i++) {
      topIdx[i] = aLen * i / num;
    }
    datas = (E[]) Array.newInstance(clazz, size);
  }

  
  public boolean check(int id){
    if(id > num || id <= 0){
      throw new IllegalArgumentException("invalid stack id " + id);
    }
    return true;
  }
  public E pop(int id){
    check(id);
    int lower = (id - 1) * aLen / num;
    if(lower == topIdx[id - 1]){
      throw new NoSuchElementException();
    }
    topIdx[id - 1]--;
    return datas[topIdx[id - 1]];
  }
  
  public void push(int id, E e){
    check(id);
    int upper = id * aLen / num;
    if(upper == topIdx[id - 1]){
      throw new IndexOutOfBoundsException();
    }
    datas[topIdx[id - 1]] = e;
    topIdx[id - 1]++;
  }
  
}
