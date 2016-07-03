package edu.galileo.android.photofeed.photolist.di;

import javax.inject.Singleton;

import dagger.Component;
import edu.galileo.android.photofeed.PhotoFeedAppModule;
import edu.galileo.android.photofeed.domain.di.DomainModule;
import edu.galileo.android.photofeed.libs.di.LibsModule;
import edu.galileo.android.photofeed.photolist.ui.PhotoListFragment;

/**
 * Created by Roberto Hdez. on 03/07/16.
 * <roberto.htamayo@gmail.com>
 */

@Singleton
@Component(modules = {PhotoListModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface PhotoListComponent {
    void inject(PhotoListFragment fragment);
}
