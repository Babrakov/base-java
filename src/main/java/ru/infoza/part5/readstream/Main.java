package ru.infoza.part5.readstream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) throws IOException {
        byte[] buf = {48, 49, 50, 51};
        ByteArrayInputStream arr = new ByteArrayInputStream(buf);
        System.out.println(readAsString(arr, Charset.forName("US-ASCII")));
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int next;
        while ( (next = inputStream.read()) != -1)
            out.write(next);
        return new String(out.toByteArray(),charset);
    }
}
