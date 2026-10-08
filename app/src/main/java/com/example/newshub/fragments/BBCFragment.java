package com.example.newshub.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.newshub.R;
import com.example.newshub.WebViewController;

public class BBCFragment extends Fragment {

    public BBCFragment() {
        // Required empty public constructor
    }
    WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_bbc, container, false);
        webView=view.findViewById(R.id.bbcwebview);
        webView.loadUrl("https://www.bbc.com/news/");
        webView.setWebViewClient(new WebViewController());
        return view;
    }
}