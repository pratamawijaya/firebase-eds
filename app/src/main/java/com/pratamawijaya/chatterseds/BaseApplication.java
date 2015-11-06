package com.pratamawijaya.chatterseds;

import android.app.Application;
import com.firebase.client.Firebase;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 11/1/15
 * Project : ChattersEDS
 */
public class BaseApplication extends Application {

  private static final String FIREBASE_URL = "https://pratamalabs.firebaseio.com/";
  private static final String CHILD_MESSAGE = "message";
  private static Firebase firebase;

  @Override public void onCreate() {
    super.onCreate();

    // initialize firebase
    Firebase.setAndroidContext(this);
    Firebase.getDefaultConfig().setPersistenceEnabled(true);

    firebase = new Firebase(FIREBASE_URL).child(CHILD_MESSAGE);
  }

  public static Firebase getFirebase() {
    return firebase;
  }
}
