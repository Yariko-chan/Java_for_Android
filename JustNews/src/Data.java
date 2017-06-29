import threads.DownloaderThread;
import threads.ParserThread;

/**
 * Created by Diana on 27.06.2017.
 */
public class Data {
    private final OnDataChangesListener listener;

    public Data(OnDataChangesListener listener) {
        this.listener = listener;
        getData();
    }

    private void getData() {
        DownloaderThread downloadThread = new DownloaderThread();
        ParserThread parserThread = new ParserThread();

        downloadThread.setParserThread(parserThread);
        parserThread.setDownloaderThread(downloadThread);

        downloadThread.start();
    }


    public interface OnDataChangesListener {

        public void OnDataChanged();
    }
}
