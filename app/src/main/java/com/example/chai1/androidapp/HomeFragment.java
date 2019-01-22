package com.example.chai1.androidapp;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chai1.androidapp.Database.BookDao;
import com.example.chai1.androidapp.Database.Repository.bookRepository;
import com.example.chai1.androidapp.Models.Book;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private Button reg_id;

    private Button log_id;
    RecyclerView MyRecyclerView;
    private SearchView search;
    String url = "https://www.googleapis.com/books/v1/volumes?q=" + "fantasy\"";
    ArrayList<Book> bookItem = new ArrayList<>();
    BookDao dao;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        reg_id = view.findViewById(R.id.reg_id);
        log_id = view.findViewById(R.id.log_id);

        log_id.setOnClickListener(this);
        reg_id.setOnClickListener(this);


        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.reg_id:
//https://stackoverflow.com/questions/21228721/how-to-replace-a-fragment-on-button-click-of-that-fragment
                MainActivity.fragmentManager.beginTransaction().
                        replace(R.id.frame_main,new RegisterFragment()).addToBackStack(null).commit();
                break;

            case R.id.log_id:
                MainActivity.fragmentManager.beginTransaction().
                        replace(R.id.frame_main,new LoginFragment()).addToBackStack(null).commit();
                break; }
    }


}
