package com.pratamawijaya.chatterseds.view.home;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.pratamawijaya.chatterseds.R;
import timber.log.Timber;

/**
 * A placeholder fragment containing a simple view.
 */
public class HomeViewActivityFragment extends Fragment {

  public static HomeViewActivityFragment newInstance() {
    Timber.d("fragment home instance");
    Bundle args = new Bundle();
    HomeViewActivityFragment fragment = new HomeViewActivityFragment();
    fragment.setArguments(args);
    return fragment;
  }

  public HomeViewActivityFragment() {
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_home_view, container, false);
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);
  }
}
