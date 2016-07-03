package edu.galileo.android.photofeed.photomap;

import edu.galileo.android.photofeed.photomap.events.PhotoMapEvent;

/**
 * Created by Roberto Hdez. on 03/07/16.
 * <roberto.htamayo@gmail.com>
 */

public interface PhotoMapPresenter {
    void onCreate();
    void onDestroy();

    void subscribe();
    void unsubscribe();

    void onEventMainThread(PhotoMapEvent event);
}
