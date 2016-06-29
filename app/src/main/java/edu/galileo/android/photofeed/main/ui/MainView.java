package edu.galileo.android.photofeed.main.ui;

/**
 * Created by praxis on 29/06/16.
 */
public interface MainView {
    void onUploadInit();
    void onUploadComplete();
    void onUploadError(String error);
}
