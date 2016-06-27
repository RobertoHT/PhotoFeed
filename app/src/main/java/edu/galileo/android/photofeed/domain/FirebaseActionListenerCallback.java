package edu.galileo.android.photofeed.domain;

import com.firebase.client.FirebaseError;

/**
 * Created by praxis on 27/06/16.
 */
public interface FirebaseActionListenerCallback {
    void onSuccess();
    void onError(FirebaseError error);
}
