package lld1.concurrency2.downloadmanager;

import java.util.List;

public class DownloadManagerApp {
    public static void main(String[] args) {
        DownloadManager downloadManager = new DownloadManager(3);
        List<String> urls = List.of("file1", "file2", "file3", "file4", "file5", "file6");

        downloadManager.downloadFiles(urls);

        downloadManager.shutdown();
    }
}
