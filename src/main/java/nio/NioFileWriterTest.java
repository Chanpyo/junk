package nio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author Chanpyo Hong
 */
public class NioFileWriterTest {
    public static void main(String[] args) {
        long timeUnit = 1000;
        long lineLimit = 100000;

        long startTimeMillis = System.currentTimeMillis();
        File logFile = new File("data.log");
        System.out.println(logFile.getAbsolutePath());
        if (logFile.exists()) {
            logFile.delete();
        }
        FileChannel writeChannel = null;

        try {
            writeChannel = new FileOutputStream(logFile).getChannel();

            long snapshotTimeMillis = System.currentTimeMillis();
            int lines = 0;
            while (snapshotTimeMillis - startTimeMillis < 10 * timeUnit) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - snapshotTimeMillis < timeUnit) {
                    if (lines < lineLimit) {
                        String logRecord = (currentTimeMillis-startTimeMillis) + " : " + "Hello world ! " + Math.random() + "\n";
                        Charset charset = Charset.defaultCharset();
                        ByteBuffer byteBuffer = charset.encode(logRecord);
                        int byteCount = writeChannel.write(byteBuffer);
                        lines++;
                    } else {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    snapshotTimeMillis = currentTimeMillis;
                    lines = 0;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writeChannel != null) {
                try {
                    writeChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
