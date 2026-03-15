package lld1.concurrency2.downloadmanager;

public class DownloadTask implements Runnable {

    private String fileUrl;

    DownloadTask(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public void run() {
        System.out.println("Downloading file from url : " + fileUrl);

        for (int progress = 0; progress <= 100; progress+= 10) {
            System.out.println("Progress for " + fileUrl + ": " + progress + "%");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Download complete for : " + fileUrl);
    }
}
