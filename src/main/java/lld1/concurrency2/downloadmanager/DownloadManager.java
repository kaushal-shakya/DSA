package lld1.concurrency2.downloadmanager;


import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Consider a simple download manager application that needs to download multiple files concurrently.
Implement the download manager using the Java Executor Framework.

Requirements:
The download manager should be able to download multiple files simultaneously.
Each file download is an independent task that can be executed concurrently.
The download manager should use a thread pool from the Executor Framework to manage and execute the download tasks.
Implement a mechanism to track the progress of each download task and display it to the user.
*/
public class DownloadManager {

    private ExecutorService executorService;

    public DownloadManager(int threadPoolSize) {
        this.executorService = Executors.newFixedThreadPool(threadPoolSize);
    }

    public void downloadFiles(List<String> fileUrls) {
        // TODO: Implement a method to submit download tasks for each file URL.
        for (String s : fileUrls) {
            DownloadTask task = new DownloadTask(s);
            executorService.submit(task);
        }
    }

    public void shutdown() {
        // TODO: Shutdown the ExecutorService when the download manager is done.
        executorService.shutdown();
    }
}
