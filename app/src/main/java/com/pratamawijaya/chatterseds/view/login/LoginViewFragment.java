package com.pratamawijaya.chatterseds.view.login;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.pratamawijaya.chatterseds.R;
import timber.log.Timber;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginViewFragment extends Fragment {
  public static LoginViewFragment newInstance() {
    Timber.d("fragment login instance");
    Bundle args = new Bundle();
    LoginViewFragment fragment = new LoginViewFragment();
    fragment.setArguments(args);
    return fragment;
  }

  public LoginViewFragment() {
    // Required empty public constructor
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);

    if (getArguments() != null) {
    }
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_login_view, container, false);
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);
  }

  @OnClick(R.id.btn_login) void loginGoogle() {
    Toast.makeText(getActivity(), "Login google", Toast.LENGTH_SHORT).show();
  }
}
