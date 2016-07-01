package edu.galileo.android.photofeed.main;

import android.location.Location;

/**
 * Created by praxis on 01/07/16.
 */
public class UploadInteractorImpl implements UploadInteractor {
    private MainRepository repository;

    public UploadInteractorImpl(MainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Location location, String path) {
        repository.uploadPhoto(location, path);
    }
}
