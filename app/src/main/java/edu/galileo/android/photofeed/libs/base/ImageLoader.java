package edu.galileo.android.photofeed.libs.base;

import android.widget.ImageView;

/**
 * Created by Roberto Hdez. on 27/06/16.
 * <roberto.htamayo@gmail.com>
 */

public interface ImageLoader {
    void load(ImageView imageView, String URL);
    void setOnFinishedImageLoadingListener(Object listener);
}
