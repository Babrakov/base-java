package test.java.part3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import main.java.part3.AsciiCharSequence;

public class AsciiCharSequenceTest {

    byte[] example = {72, 101, 108, 108, 111, 33};
    AsciiCharSequence answer = new AsciiCharSequence(example);
    @Test
    public void checkToString() {
        Assertions.assertEquals(answer.toString(),"Hello!");
    }

    @Test
    public void checkLength() {
        Assertions.assertEquals(answer.length(),6);
    }

    @Test
    public void checkCharAt() {
        Assertions.assertEquals(answer.charAt(1),'e');
    }

    @Test
    public void checkSubSequence() {
        Assertions.assertEquals(answer.subSequence(1,5).toString(),"ello");
    }

}
