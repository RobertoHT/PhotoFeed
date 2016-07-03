package edu.galileo.android.photofeed.photolist.di;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Provides;
import edu.galileo.android.photofeed.domain.FirebaseAPI;
import edu.galileo.android.photofeed.domain.Util;
import edu.galileo.android.photofeed.entities.Photo;
import edu.galileo.android.photofeed.libs.base.EventBus;
import edu.galileo.android.photofeed.libs.base.ImageLoader;
import edu.galileo.android.photofeed.photolist.PhotoListInteractor;
import edu.galileo.android.photofeed.photolist.PhotoListInteractorImpl;
import edu.galileo.android.photofeed.photolist.PhotoListPresenter;
import edu.galileo.android.photofeed.photolist.PhotoListPresenterImpl;
import edu.galileo.android.photofeed.photolist.PhotoListRepository;
import edu.galileo.android.photofeed.photolist.PhotoListRepositoryImpl;
import edu.galileo.android.photofeed.photolist.ui.PhotoListView;
import edu.galileo.android.photofeed.photolist.ui.adapters.OnItemClickListener;
import edu.galileo.android.photofeed.photolist.ui.adapters.PhotoListAdapter;

/**
 * Created by Roberto Hdez. on 03/07/16.
 * <roberto.htamayo@gmail.com>
 */

public class PhotoListModule {
    PhotoListView view;
    OnItemClickListener onItemClickListener;

    public PhotoListModule(PhotoListView view, OnItemClickListener onItemClickListener) {
        this.view = view;
        this.onItemClickListener = onItemClickListener;
    }

    @Provides
    @Singleton
    PhotoListView providesPhotoListView() {
        return this.view;
    }

    @Provides
    @Singleton
    PhotoListPresenter providesPhotoListPresenter(EventBus eventBus, PhotoListView view, PhotoListInteractor listInteractor) {
        return new PhotoListPresenterImpl(eventBus, view, listInteractor);
    }

    @Provides
    @Singleton
    PhotoListInteractor providesPhotoListInteractor(PhotoListRepository repository) {
        return new PhotoListInteractorImpl(repository);
    }

    @Provides
    @Singleton
    PhotoListRepository providesPhotoListRepository(EventBus eventBus, FirebaseAPI firebase) {
        return new PhotoListRepositoryImpl(eventBus, firebase);
    }

    @Provides @Singleton
    PhotoListAdapter providesPhotosAdapter(Util utils, List<Photo> photoList, ImageLoader imageLoader, OnItemClickListener onItemClickListener) {
        return new PhotoListAdapter(utils, photoList, imageLoader, onItemClickListener);
    }

    @Provides
    @Singleton
    OnItemClickListener providesOnItemClickListener() {
        return this.onItemClickListener;
    }

    @Provides
    @Singleton
    List<Photo> providesPhotosList() {
        return new ArrayList<Photo>();
    }
}
