package com.example.fragmentscommunicating;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class BlueFragment extends Fragment {

    private TextView mTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_blue, container, false);
        mTextView = v.findViewById(R.id.textview);
        return v;
    }

    // This is a public method that the Activity can use to communicate
    // directly with this Fragment
     void youveGotMail(String message) {
        mTextView.setText(message);
    }
}