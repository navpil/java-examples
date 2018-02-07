package ua.lviv.navpil.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;

public class StreamTokenizerDemo {

    public static void main(String[] args) throws IOException {

        Reader reader = new InputStreamReader(new ByteArrayInputStream("val name=\"Jim H\";\nalert('Hello dear' + name +'!');".getBytes()));

        StreamTokenizer tokenizer = new StreamTokenizer(reader);

        boolean eof = false;
        while (!eof) {
            int i = tokenizer.nextToken();

            switch (i) {
                case StreamTokenizer.TT_EOF:
                    eof = true;
                    break;
                case StreamTokenizer.TT_EOL:
                    System.out.println();
                    break;
                case StreamTokenizer.TT_NUMBER:
                    System.out.print(tokenizer.nval);
                    break;
                case StreamTokenizer.TT_WORD:
                    System.out.print(tokenizer.sval);
                    break;

                default:
                    System.out.printf(" %n%s ", tokenizer.toString());
//                    System.out.println("--error--");
            }
        }


    }
}
