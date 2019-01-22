package com.example.chai1.androidapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 */
public class HomeLoggedFragment extends Fragment {

private Button btn_out;

    public HomeLoggedFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_home_logged, container, false);

        btn_out=v.findViewById(R.id.logout);


        btn_out.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
  logout(v);

  MainActivity.fragmentManager.beginTransaction().
          replace(R.id.frame_main, new HomeFragment()).addToBackStack(null).commit();
            }
            });

        return v;

    }

    public  void logout(View view){
        SessionLogin session = new SessionLogin(getActivity().getApplicationContext());
        session.setLogin(false);
    }

}
