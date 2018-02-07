package ua.lviv.navpil.path;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SeekableByteChannelTry {
    public static void main(String[] args) throws IOException {
        Path file = Paths.get("xanadu.txt");
        try (SeekableByteChannel sbc = Files.newByteChannel(file)) {
            ByteBuffer buf = ByteBuffer.allocate(10);

            // Read the bytes with the proper encoding for this platform.  If
            // you skip this step, you might see something that looks like
            // Chinese characters when you expect Latin-style characters.
            String encoding = System.getProperty("file.encoding");
            while (sbc.read(buf) > 0) {
                buf.flip();
                System.out.print(Charset.forName(encoding).decode(buf));
                buf.clear();
            }
        }
    }
}
