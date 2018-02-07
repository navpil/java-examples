package ua.lviv.navpil.jenkovnio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

public class ScatteringReadsAndWrongAssumptionAboutArray {
    public static void main(String[] args) throws IOException{
        try(
                FileChannel c = new RandomAccessFile("xanadu.txt", "r").getChannel();
                ) {
            ByteBuffer b1 = ByteBuffer.allocate(32);
            ByteBuffer b2 = ByteBuffer.allocate(32);

            while (c.read(new ByteBuffer[] {b1
                    , b2
            }) != -1) {
                b1.flip();
                b2.flip();

                //This one is wrong. array() will give every byte away, not caring about limit()
                System.out.print(new String(b1.array()));
                //This one is correct. However we need to know much about how bytebuffer works
                System.out.print(new String(b2.array(), 0, b2.limit()));

                b1.clear();
                b2.clear();
            }

        }
    }
}
