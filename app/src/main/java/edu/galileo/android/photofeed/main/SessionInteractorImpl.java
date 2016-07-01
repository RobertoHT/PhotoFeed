package edu.galileo.android.photofeed.main;

/**
 * Created by praxis on 01/07/16.
 */
public class SessionInteractorImpl implements SessionInteractor {
    private MainRepository repository;

    public SessionInteractorImpl(MainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void logout() {
        repository.logout();
    }
}
