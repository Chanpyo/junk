package file;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Chanpyo Hong
 */
public class FileChannelWriter implements Runnable {
    private final FileChannel writer;
    private final String record;
    private final AtomicBoolean cont;

    FileChannelWriter(FileChannel writer, String record, AtomicBoolean cont) {
        this.writer = writer;
        this.record = record;
        this.cont = cont;
    }

    @Override
    public void run() {
        try {
            while (cont.get()) {
                ByteBuffer byteBuffer = ByteBuffer.wrap(record.getBytes());
                writer.write(byteBuffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
