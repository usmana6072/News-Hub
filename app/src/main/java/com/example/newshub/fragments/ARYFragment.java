package com.example.newshub.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.newshub.R;
import com.example.newshub.WebViewController;

public class ARYFragment extends Fragment {

    public ARYFragment() {
        // Required empty public constructor
    }

    WebView webView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_ary, container, false);
        webView=view.findViewById(R.id.arywebview);
        webView.loadUrl("https://arynews.tv/category/latest-blogs");
        webView.setWebViewClient(new WebViewController());
        return view;
    }
}