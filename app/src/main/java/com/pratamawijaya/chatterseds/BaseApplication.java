package com.pratamawijaya.chatterseds;

import android.app.Application;
import com.firebase.client.Firebase;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 11/1/15
 * Project : ChattersEDS
 */
public class BaseApplication extends Application {

  @Override public void onCreate() {
    super.onCreate();

    // initialize firebase
    Firebase.setAndroidContext(this);
  }
}
