package edu.galileo.android.photofeed.main;

import android.location.Location;

/**
 * Created by praxis on 29/06/16.
 */
public interface MainRepository {
    void logout();
    void uploadPhoto(Location location, String path);
}
