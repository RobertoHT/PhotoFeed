package edu.galileo.android.photofeed.photolist;

import edu.galileo.android.photofeed.entities.Photo;

/**
 * Created by praxis on 01/07/16.
 */
public interface PhotoListRepository {
    void subscribe();
    void unsubscribe();
    void remove(Photo photo);
}
