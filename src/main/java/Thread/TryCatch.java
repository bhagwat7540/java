package Thread;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class TryCatch {
    public static void main(String[] args) throws Exception {
        try {
            FileReader fr = new FileReader("abc.txt");
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Custom");
        }
        finally {
            System.out.println("HI");
        }

//        try(FileReader fr = new FileReader("abc.txt")) {
//            System.out.println("REading");
//        }
    }
}
