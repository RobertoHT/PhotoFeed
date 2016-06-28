package edu.galileo.android.photofeed.login;

import com.firebase.client.FirebaseError;

import edu.galileo.android.photofeed.domain.FirebaseAPI;
import edu.galileo.android.photofeed.domain.FirebaseActionListenerCallback;
import edu.galileo.android.photofeed.libs.base.EventBus;
import edu.galileo.android.photofeed.login.events.LoginEvent;

/**
 * Created by praxis on 28/06/16.
 */
public class LoginRepositoryImpl implements LoginRepository {
    private EventBus eventBus;
    private FirebaseAPI firebase;

    public LoginRepositoryImpl(FirebaseAPI firebase, EventBus eventBus) {
        this.firebase = firebase;
        this.eventBus = eventBus;
    }

    @Override
    public void doSignUp(final String email, final String password) {
        firebase.signup(email, password, new FirebaseActionListenerCallback() {
            @Override
            public void onSuccess() {
                post(LoginEvent.onSignUpSuccess);
                doSignIn(email, password);
            }

            @Override
            public void onError(FirebaseError error) {
                post(LoginEvent.onSignUpError, error.getMessage());
            }
        });
    }

    @Override
    public void doSignIn(String email, String password) {
        if (email != null && password != null) {
            firebase.login(email, password, new FirebaseActionListenerCallback() {
                @Override
                public void onSuccess() {
                    String email = firebase.getAuthEmail();
                    post(LoginEvent.onSignInSuccess, null, email);
                }

                @Override
                public void onError(FirebaseError error) {
                    post(LoginEvent.onSignInError, error.getMessage());
                }
            });
        } else {
            firebase.checkForSession(new FirebaseActionListenerCallback() {
                @Override
                public void onSuccess() {
                    String email = firebase.getAuthEmail();
                    post(LoginEvent.onSignInSuccess, null, email);
                }

                @Override
                public void onError(FirebaseError error) {
                    post(LoginEvent.onFailedToRecoverSession);
                }
            });
        }
    }

    private void post(int type) {
        post(type, null);
    }

    private void post(int type, String errorMessage) {
        post(type, errorMessage, null);
    }

    private void post(int type, String errorMessage, String loggedUserEmail) {
        LoginEvent loginEvent = new LoginEvent();
        loginEvent.setEventType(type);
        loginEvent.setErrorMesage(errorMessage);
        loginEvent.setLoggedUserEmail(loggedUserEmail);
        eventBus.post(loginEvent);
    }

}
