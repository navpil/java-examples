package ua.lviv.navpil.jenkovnio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class PipeNio {
    public static void main(String[] args) throws IOException {

        //Connecting two channels
        Pipe open = Pipe.open();
        Pipe.SinkChannel sink = open.sink();
        Pipe.SourceChannel source = open.source();

        ByteBuffer buf1 = ByteBuffer.allocate(48);
        buf1.put("Hello World!".getBytes());
        buf1.flip();
        sink.write(buf1);

        ByteBuffer buf2 = ByteBuffer.allocate(48);
        source.read(buf2);

        System.out.println(new String(buf2.array(), 0, buf2.limit()));

    }
}
