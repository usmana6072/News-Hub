package com.example.newshub.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.newshub.R;
import com.example.newshub.WebViewController;

public class CNNFragment extends Fragment {

    public CNNFragment() {
        // Required empty public constructor
    }
    WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_cnn, container, false);
        webView=view.findViewById(R.id.cnnwebview);
        webView.loadUrl("https://edition.cnn.com/");
        webView.setWebViewClient(new WebViewController());
        return view;
    }
}