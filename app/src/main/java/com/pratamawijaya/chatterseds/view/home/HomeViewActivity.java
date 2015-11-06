package com.pratamawijaya.chatterseds.view.home;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.pratamawijaya.chatterseds.R;
import com.pratamawijaya.chatterseds.helper.Prefs;
import com.pratamawijaya.chatterseds.model.KeyPref;
import com.pratamawijaya.chatterseds.view.login.LoginViewFragment;

public class HomeViewActivity extends AppCompatActivity {

  @Bind(R.id.fragment_container) FrameLayout fragmentContainer;
  @Bind(R.id.toolbar) Toolbar toolbar;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home_view);
    ButterKnife.bind(this);

    setSupportActionBar(toolbar);
    getSupportActionBar().setTitle("Home");

    if (fragmentContainer != null) {
      if (savedInstanceState != null) return;

      if (Prefs.getBoolean(KeyPref.IS_LOGIN, false)) {
        setActionBarTitle("Home");

        getFragmentManager().beginTransaction()
            .add(R.id.fragment_container, HomeViewActivityFragment.newInstance())
            .commit();
      } else {
        setActionBarTitle("Login");

        getFragmentManager().beginTransaction()
            .add(R.id.fragment_container, LoginViewFragment.newInstance())
            .commit();
      }
    }
  }

  private void setActionBarTitle(String title) {
    getSupportActionBar().setTitle(title);
  }

  private void changeFragment(Fragment fragment) {
    getFragmentManager().beginTransaction()
        .replace(R.id.fragment_container, fragment)
        .addToBackStack("fragment")
        .commit();
  }
}
