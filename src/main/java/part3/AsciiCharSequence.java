package main.java.part3;

//import java.lang.CharSequence;

public class AsciiCharSequence implements CharSequence{
    private byte[] array;
    @Override
    public String toString() {
        return new String(array);
    }

    public AsciiCharSequence(byte[] array) {
        this.array = array;
    }

    @Override
    public int length() {
        return array.length;
    }

    @Override
    public char charAt(int index) {
        return (char) array[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] subArray = java.util.Arrays.copyOfRange(array, start, end);
        return new AsciiCharSequence(subArray);
    }
}
