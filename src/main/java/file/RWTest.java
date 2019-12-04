package file;

import java.io.*;
import java.util.Scanner;

/**
 * @author Chanpyo Hong
 */
public class RWTest {
    public static void main(String[] args) {
//        copyFile();
        copyChar();
    }

    private static void copyChar() {
        FileReader fileReader = null;
        File destFile = new File("/Users/hongchanpyo/IdeaProjects/junk/src/main/java/file/data_dest.txt");
        if (destFile.exists()) {
            destFile.delete();
        }

        int c;
        try {
            fileReader = new FileReader("/Users/hongchanpyo/IdeaProjects/junk/src/main/java/file/data.txt");

            BufferedOutputStream outputStream = null;
            try {
                byte[] buffer = new byte[1];
                outputStream = new BufferedOutputStream(new FileOutputStream(destFile), 5);
                while ((c = fileReader.read()) != -1) {
                    buffer[0] = (byte) c;
                    outputStream.write(buffer);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
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
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private static void copyFile() {

        FileInputStream fileReader = null;
        FileOutputStream fileWriter = null;
        byte[] buffer = new byte[1024];

        File destFile = new File("/Users/hongchanpyo/IdeaProjects/junk/src/main/java/file/image_dest.jpg");
        if (destFile.exists()) {
            destFile.delete();
        }

        try {
            fileReader = new FileInputStream("/Users/hongchanpyo/IdeaProjects/junk/src/main/java/file/image.jpg");
            fileWriter = new FileOutputStream(destFile);

            int size;
            while ((size = fileReader.read(buffer)) != -1) {
                fileWriter.write(buffer, 0, size);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

