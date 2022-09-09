package main;

import javax.sound.midi.Soundbank;
import java.io.*;

public class TesteSerializacao {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String nome = "Aleph Melo";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("objeto.bin"));
        objectOutputStream.writeObject(nome);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("objeto.bin"));
        nome = (String) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(nome);
    }
}
