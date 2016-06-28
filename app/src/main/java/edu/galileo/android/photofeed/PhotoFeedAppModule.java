package edu.galileo.android.photofeed;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Roberto Hdez. on 27/06/16.
 * <roberto.htamayo@gmail.com>
 */

@Module
public class PhotoFeedAppModule {
    PhotoFeedApp app;

    public PhotoFeedAppModule(PhotoFeedApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Context provideApplicationContext(){
        return app.getApplicationContext();
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application){
        return application.getSharedPreferences(app.getSharedPreferencesName(), Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    Application providesApplication(){
        return this.app;
    }
}
