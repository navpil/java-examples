package ua.lviv.navpil.jenkovnio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class ChannelToStringExample {
    public static void main(String[] args) throws IOException {
        String s;
        try (
                RandomAccessFile f = new RandomAccessFile("xanadu.txt", "r");
                FileChannel channel = f.getChannel();
                ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                WritableByteChannel out = Channels.newChannel(outStream);
        ) {
            ByteBuffer buf = ByteBuffer.allocate(48);
            while (channel.read(buf) != -1) {
                buf.flip();
                while (buf.hasRemaining()) {
                    out.write(buf);
                }
                buf.clear();
            }
            s = new String(outStream.toByteArray());
        }

        System.out.println(s);

    }
}
