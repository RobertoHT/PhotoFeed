package edu.galileo.android.photofeed;

import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.firebase.client.Firebase;

import edu.galileo.android.photofeed.domain.di.DomainModule;
import edu.galileo.android.photofeed.libs.di.LibsModule;
import edu.galileo.android.photofeed.login.di.DaggerLoginComponent;
import edu.galileo.android.photofeed.login.di.LoginComponent;
import edu.galileo.android.photofeed.login.di.LoginModule;
import edu.galileo.android.photofeed.login.ui.LoginView;
import edu.galileo.android.photofeed.main.di.MainComponent;
import edu.galileo.android.photofeed.main.di.MainModule;
import edu.galileo.android.photofeed.main.ui.MainView;
import edu.galileo.android.photofeed.photolist.di.PhotoListComponent;
import edu.galileo.android.photofeed.photolist.di.PhotoListModule;
import edu.galileo.android.photofeed.photolist.ui.PhotoListView;
import edu.galileo.android.photofeed.photolist.ui.adapters.OnItemClickListener;

/**
 * Created by Roberto Hdez. on 27/06/16.
 * <roberto.htamayo@gmail.com>
 */

public class PhotoFeedApp extends Application {
    private final static String EMAIL_KEY = "email";
    private final static String SHARED_PREFERENCES_NAME = "UserPrefs";
    private final static String FIREBASE_URL = "http://galileophoto-52d83.firebaseio.com/";

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

    public LoginComponent getLoginComponent(LoginView view) {
        return DaggerLoginComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(new LibsModule(null))
                .loginModule(new LoginModule(view))
                .build();
    }

    public MainComponent getMainComponent(MainView view, FragmentManager manager, Fragment[] fragments, String[] titles){
        return DaggerMainComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(new LibsModule(null))
                .mainModule(new MainModule(view, titles, fragments, manager))
                .build();
    }

    public PhotoListComponent getPhotoListComponent(Fragment fragment, PhotoListView view, OnItemClickListener onItemClickListener) {
        return DaggerPhotoListComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(new LibsModule(null)
                .photoListModule(new PhotoListModule(view, onItemClickListener))
                .build();
    }
}
