package com.example.newshub.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.newshub.R;
import com.example.newshub.WebViewController;

public class NewYorkTimes_Fragment extends Fragment {


    public NewYorkTimes_Fragment() {
        // Required empty public constructor
    }

    WebView webView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_new_york_times, container, false);
        webView=view.findViewById(R.id.newyorkweview);
        webView.loadUrl("https://www.nytimes.com/international/");
        webView.setWebViewClient(new WebViewController());
        return view;
    }
}