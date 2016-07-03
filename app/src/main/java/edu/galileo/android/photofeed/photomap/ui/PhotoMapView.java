package edu.galileo.android.photofeed.photomap.ui;

import edu.galileo.android.photofeed.entities.Photo;

/**
 * Created by Roberto Hdez. on 03/07/16.
 * <roberto.htamayo@gmail.com>
 */

public interface PhotoMapView {
    void addPhoto(Photo photo);
    void removePhoto(Photo photo);
    void onPhotosError(String error);
}
