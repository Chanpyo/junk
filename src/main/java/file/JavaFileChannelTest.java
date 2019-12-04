package file;

import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Chanpyo Hong
 */
public class JavaFileChannelTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try {
            FileChannel writeChannel = (new FileOutputStream("/Users/hongchanpyo/IdeaProjects/junk/src/main/java/file/log.txt")).getChannel();
            AtomicBoolean cont = new AtomicBoolean(true);

            Runnable runnable1 = new FileChannelWriter(writeChannel, "aaaaaaaaaaaaaaaaaaaaaaaaaaaa\n", cont);
            Runnable runnable2 = new FileChannelWriter(writeChannel, "bbbbbbbbbbbbbbbbbbbbbbbbbbbb\n", cont);

            executorService.submit(runnable1);
            executorService.submit(runnable2);

            Thread.sleep(100);
            cont.set(false);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
