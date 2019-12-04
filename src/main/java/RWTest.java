import java.io.*;
import java.util.Scanner;

/**
 * @author Chanpyo Hong
 */
public class RWTest {
    public static void main(String[] args) {
        FileReader fileReader = null;
        int c;
        try {
            fileReader = new FileReader("/home/hong/IdeaProjects/junk/src/main/java/data.txt");

            BufferedWriter outputStream = null;
            try {
                outputStream = new BufferedWriter(new OutputStreamWriter(System.out), 5);
                while ((c= fileReader.read()) != -1) {
                    outputStream.write(c);
                }
                new Scanner(System.in).nextLine();
                outputStream.flush();
            } catch (IOException e1) {
                e1.printStackTrace();
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
