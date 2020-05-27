package com.example.fragmentscommunicating;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class GreenFragment extends Fragment {

    private EditText editText;
    private OnGreenFragmentListener mCallback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_green, container, false);

        editText = v.findViewById(R.id.editText);
        Button button = v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                mCallback.messageFromGreenFragment(message);
            }
        });
        return v;
    }

    // This is the interface that the Activity will implement
    // so that this Fragment can communicate with the Activity.
    public interface OnGreenFragmentListener {
        void messageFromGreenFragment(String text);
    }

    // This method insures that the Activity has actually implemented our
    // listener and that it isn't null.
    @Override
    public void onAttach(@Nullable Context context) {
        assert context != null;
        super.onAttach(context);
        if (context instanceof OnGreenFragmentListener) {
            mCallback = (OnGreenFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnGreenFragmentListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }
}
