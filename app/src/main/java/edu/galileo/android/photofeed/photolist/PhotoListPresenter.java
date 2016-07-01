package edu.galileo.android.photofeed.photolist;

import edu.galileo.android.photofeed.entities.Photo;
import edu.galileo.android.photofeed.photolist.events.PhotoListEvent;

/**
 * Created by praxis on 01/07/16.
 */
public interface PhotoListPresenter {
    void onCreate();
    void onDestroy();

    void subscribe();
    void unsubscribe();

    void removePhoto(Photo photo);
    void onEventMainThread(PhotoListEvent event);
}
