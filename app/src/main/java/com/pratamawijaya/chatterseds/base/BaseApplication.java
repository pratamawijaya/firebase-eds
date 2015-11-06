package com.pratamawijaya.chatterseds.base;

import android.app.Application;
import android.content.ContextWrapper;
import com.firebase.client.Firebase;
import com.pratamawijaya.chatterseds.BuildConfig;
import com.pratamawijaya.chatterseds.Config;
import com.pratamawijaya.chatterseds.helper.Prefs;
import timber.log.Timber;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 11/1/15
 * Project : ChattersEDS
 */
public class BaseApplication extends Application {

  private static final String FIREBASE_URL = "" + Config.FIREBASE_ROOT;
  private static final String CHILD_MESSAGE = "message";
  private static Firebase firebase;

  @Override public void onCreate() {
    super.onCreate();

    // initialize firebase
    Firebase.setAndroidContext(this);
    Firebase.getDefaultConfig().setPersistenceEnabled(true);

    firebase = new Firebase(FIREBASE_URL).child(CHILD_MESSAGE);

    if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());

    new Prefs.Builder().setContext(this)
        .setMode(ContextWrapper.MODE_PRIVATE)
        .setPrefsName(getPackageName())
        .setUseDefaultSharedPreference(true)
        .build();
  }

  public static Firebase getFirebase() {
    return firebase;
  }
}
