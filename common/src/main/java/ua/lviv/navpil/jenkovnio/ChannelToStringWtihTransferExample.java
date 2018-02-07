package ua.lviv.navpil.jenkovnio;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ChannelToStringWtihTransferExample {
    public static void main(String[] args) throws IOException {
        String s;
        try (
//                RandomAccessFile f = new RandomAccessFile("xanadu.txt", "r");
//                FileChannel channel = f.getChannel();
                FileChannel channel = FileChannel.open(Paths.get("xanadu.txt"));
                ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                WritableByteChannel out = Channels.newChannel(outStream);
        ) {
            channel.transferTo(0, channel.size(), out);
            s = new String(outStream.toByteArray());
        }

        System.out.println(s);
    }
}
