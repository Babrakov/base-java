package main.java.part3;

/*
Напишите класс AsciiCharSequence, реализующий компактное хранение последовательности ASCII-символов
(их коды влезают в один байт) в массиве байт. По сравнению с классом String, хранящим каждый символ
как char, AsciiCharSequence будет занимать в два раза меньше памяти.

Класс AsciiCharSequence должен:

реализовывать интерфейс java.lang.CharSequence;
иметь конструктор, принимающий массив байт;
определять методы length(), charAt(), subSequence() и toString()
Сигнатуры методов и ожидания по их поведению смотрите в описании интерфейса java.lang.CharSequence
(JavaDoc или исходники).

В данном задании методам charAt() и subSequence() всегда будут подаваться корректные входные параметры,
поэтому их проверкой и обработкой ошибок заниматься не нужно. Тем более мы еще не проходили исключения.
 */

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
