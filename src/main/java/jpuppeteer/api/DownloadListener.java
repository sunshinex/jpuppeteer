package jpuppeteer.api;

public interface DownloadListener {

    void onStart(DownloadObject downloadObject);

    void onProgress(DownloadObject downloadObject);

    void onComplete(DownloadObject downloadObject);

    void onCancel(DownloadObject downloadObject);

}
