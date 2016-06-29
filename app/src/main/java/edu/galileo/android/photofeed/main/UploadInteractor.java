package edu.galileo.android.photofeed.main;

import android.location.Location;

/**
 * Created by praxis on 29/06/16.
 */
public interface UploadInteractor {
    void execute(Location location, String path);
}
