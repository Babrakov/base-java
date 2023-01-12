package ru.infoza.part5.checksum;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStream stream;
        int result;
        stream = getStream( new byte[] { 0x33, 0x45, 0x01});
//        stream = getStream( new byte[] { });

        result = checkSumOfStream(stream);
        System.out.print(result);
    }

    public static InputStream getStream(byte [] data)  {
        return new ByteArrayInputStream(data);
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int result = 0;
        int currentByte =  inputStream.read();
        while (currentByte != -1) {
            result = (Integer.rotateLeft(result,1) ^ (currentByte&0xFF));
            currentByte =  inputStream.read();
        }
        return result;
    }


}
