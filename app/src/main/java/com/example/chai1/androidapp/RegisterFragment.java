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
import com.example.chai1.androidapp.Models.User;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 */
public class RegisterFragment extends Fragment {
    private EditText em, first, last;
    private EditText pass, passConfirm;
    private Button btn;

    private userRepository mrep;
    private ArrayList<User> mUser;
    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        em = view.findViewById(R.id.email_id);
        first = view.findViewById(R.id.firstname);
        last = view.findViewById(R.id.lastname);
        btn = view.findViewById(R.id.log_btn);
        pass=view.findViewById(R.id.password_id);
        passConfirm=view.findViewById(R.id.password_confirm);
        mrep = new userRepository(this.getActivity().getApplication());

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String email = em.getText().toString();
                String F1 = first.getText().toString();
                String L1 = last.getText().toString();
                String password = pass.getText().toString();
                String passwordConfirm = passConfirm.getText().toString();
                User user = new User();

                if (TextUtils.isEmpty(F1)) {
                    first.setError("You must enter firstname");
                } else {
                    user.setFirstname(F1);
                }
                if (TextUtils.isEmpty(L1)) {
                    last.setError("You must enter lastname");
                } else {
                    user.setLastname(L1);
                }
                if (isEmail(email) == false) {
                    em.setError("You must enter valid email");
                } else {
                    user.setEmail(email);
                }
                if (TextUtils.isEmpty(password)) {
                    pass.setError("You must enter password");
                }

                if (TextUtils.isEmpty(passwordConfirm)) {
                    passConfirm.setError("You must confirm password");

                    if (!passwordConfirm.matches(password)) {
                        Toast.makeText(getContext(), "password do not match", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    user.setPassword(password);
                    user.setConfirmPassword(passwordConfirm);

                    SessionLogin session = new SessionLogin(getContext().getApplicationContext());
                    session.setLogin(true);

                    Intent myIntent = new Intent(getActivity(), bookListActivity.class);
                    getActivity().startActivity(myIntent);
                }

                user.setAddress("bla");
                mrep.insertUsers(user);


                first.setText("");
                last.setText("");
                pass.setText("");
                passConfirm.setText("");
                em.setText("");


            }
        });


        return view;


    }

    boolean isEmail(String t) {
        return (!TextUtils.isEmpty(t) && Patterns.EMAIL_ADDRESS.matcher(t).matches());
    }


}

