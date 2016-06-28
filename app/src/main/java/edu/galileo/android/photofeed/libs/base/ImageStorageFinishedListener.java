package edu.galileo.android.photofeed.libs.base;

/**
 * Created by Roberto Hdez. on 27/06/16.
 * <roberto.htamayo@gmail.com>
 */
public interface ImageStorageFinishedListener {
    void onSuccess();
    void onError(String error);
}
