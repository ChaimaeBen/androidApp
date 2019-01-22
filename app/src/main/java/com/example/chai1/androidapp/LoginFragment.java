package com.example.chai1.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chai1.androidapp.Database.Repository.userRepository;
import com.example.chai1.androidapp.Database.UserDao;
import com.example.chai1.androidapp.Models.User;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 */
public class LoginFragment extends Fragment {
    private UserDao dao;
    private EditText em, pass;
    private Button btn;

private userRepository mrep;
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        em = v.findViewById(R.id.email_id);
        pass = v.findViewById(R.id.password_id);
        btn = v.findViewById(R.id.log_btn);
        mrep = new userRepository(this.getActivity().getApplication());

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                User u = new User();
                String email = em.getText().toString();
                String pa = pass.getText().toString();

                if (!isEmail(email)) {
                    em.setError("You must enter valid email");
                }else{
                    u.setEmail(email);
                }
                if (TextUtils.isEmpty(pa)) {
                    pass.setError("You must enter password");

                }else{u.setPassword(pa);}


                if (mrep.verify(email, pa)!=null) {
                    SessionLogin session = new SessionLogin(getContext().getApplicationContext());
                    session.setLogin(true);

                    Intent myIntent = new Intent(getActivity(), bookListActivity.class);
                    getActivity().startActivity(myIntent);
                } else {
                    Toast.makeText(getContext(), "email or password incorrect", Toast.LENGTH_SHORT).show();

                }
                em.setText("");
                pass.setText("");
            }



//https://stackoverflow.com/questions/21228721/how-to-replace-a-fragment-on-button-click-of-that-fragm
        });

        return v;


    }
        boolean isEmail(String t) {
            return (!TextUtils.isEmpty(t) && Patterns.EMAIL_ADDRESS.matcher(t).matches());
        }
}



