package edu.galileo.android.photofeed;

import android.app.Application;

import com.firebase.client.Firebase;

import edu.galileo.android.photofeed.domain.di.DomainModule;

/**
 * Created by Roberto Hdez. on 27/06/16.
 * <roberto.htamayo@gmail.com>
 */

public class PhotoFeedApp extends Application {
    private final static String EMAIL_KEY = "email";
    private final static String SHARED_PREFERENCES_NAME = "UserPrefs";
    private final static String FIREBASE_URL = "https://galileophoto-52d83.firebaseio.com/";

    private DomainModule domainModule;
    private PhotoFeedAppModule photoFeedAppModule;

    @Override
    public void onCreate() {
        super.onCreate();
        initFirebase();
        initModules();
    }

    private void initModules() {
        photoFeedAppModule = new PhotoFeedAppModule(this);
        domainModule = new DomainModule(FIREBASE_URL);
    }

    private void initFirebase() {
        Firebase.setAndroidContext(this);
    }

    public String getEmailKey() {
        return EMAIL_KEY;
    }

    public String getSharedPreferencesName() {
        return SHARED_PREFERENCES_NAME;
    }

    public static String getFirebaseUrl() {
        return FIREBASE_URL;
    }
}
