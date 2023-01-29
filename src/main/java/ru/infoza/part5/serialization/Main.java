package ru.infoza.part5.serialization;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Animal[] animalM1 = { new Animal("Cat"), new Animal("Dog"), new Animal("Elephant"),
                new Animal("Cock"), new Animal("Bull"), new Animal("Ant"),
                new Animal("Tentecles"), new Animal("Worm")};
        ByteArrayOutputStream bai = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bai);
        oos.writeInt(animalM1.length);
        for (int i = 0; i < animalM1.length; i++) {
            oos.writeObject(animalM1[i]);
        }
        oos.flush();
        oos.close();
        Animal[] animalM2 = deserializeAnimalArray(bai.toByteArray());
        System.out.println(Arrays.toString(animalM2));
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] result = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
            Integer len = ois.readInt();
            result = new Animal[len];
            for (int i = 0; i < len; i++) {
                result[i] = (Animal) ois.readObject();
            }
        } catch (EOFException e) {
            throw new IllegalArgumentException(e);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        } catch (ClassCastException e){
            throw new IllegalArgumentException(e);
        }
        return result;
    }
}

