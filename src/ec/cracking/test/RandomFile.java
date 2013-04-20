package ec.cracking.test;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class RandomFile {

  public static void main(String[] args) throws IOException {

    RandomAccessFile f = new RandomAccessFile("c:/test.txt", "rw");
    FileChannel c = f.getChannel();
    ByteBuffer bb = ByteBuffer.allocate(10);
    //bb.put("hello".getBytes());
    c.read(bb);
    bb.flip();
    System.out.println(bb);
    bb.rewind();
    System.out.println((char)bb.get());
    System.out.println((char)bb.get());
    System.out.println((char)bb.get());

    bb.clear();
    c.read(bb);
    bb.flip();

    if(bb.limit() == 0){
      // completed reading the file.
    }

    //bb.get(b);
    //System.out.println((char)bb.get());
    //c.write(bb);
    c.close();
  }

}
