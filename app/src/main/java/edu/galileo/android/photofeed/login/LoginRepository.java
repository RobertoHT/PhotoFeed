package edu.galileo.android.photofeed.login;

/**
 * Created by praxis on 28/06/16.
 */
public interface LoginRepository {
    void doSignUp(String email, String password);
    void doSignIn(String email, String password);
}
