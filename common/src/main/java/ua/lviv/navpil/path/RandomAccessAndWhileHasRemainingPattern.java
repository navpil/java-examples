package ua.lviv.navpil.path;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static java.nio.file.AccessMode.READ;
import static java.nio.file.AccessMode.WRITE;

public class RandomAccessAndWhileHasRemainingPattern {



    public static void main(String[] args) throws IOException {
        ByteBuffer wrap = ByteBuffer.wrap("I was here!\n".getBytes());
        ByteBuffer buf = ByteBuffer.allocate(12);

        Path path = Paths.get("xanadu3.txt");
        try(FileChannel fc = (FileChannel.open(path, StandardOpenOption.READ, StandardOpenOption.WRITE))) {
            int nread;
//            do {
                nread = fc.read(buf);
//            } while (nread != -1 && buf.hasRemaining());

            fc.position(0);
//            while (wrap.hasRemaining()) {
                fc.write(wrap);
//            }
            wrap.rewind();

            long size = fc.size();
            fc.position(size-1);

            buf.flip();
//            while(buf.hasRemaining()) {
                fc.write(buf);
//            }
//            while(wrap.hasRemaining()) {
                fc.write(wrap);
//            }

        }

    }

}
