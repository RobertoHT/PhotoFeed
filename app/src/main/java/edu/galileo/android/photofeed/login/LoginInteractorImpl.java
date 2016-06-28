package edu.galileo.android.photofeed.login;

/**
 * Created by praxis on 28/06/16.
 */
public class LoginInteractorImpl implements LoginInteractor {
    private LoginRepository loginRepository;

    public LoginInteractorImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }


    @Override
    public void doSignUp(String email, String password) {
        loginRepository.doSignUp(email, password);
    }

    @Override
    public void doSignIn(String email, String password) {
        loginRepository.doSignIn(email, password);
    }
}