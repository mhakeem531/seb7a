package com.example.hakeem.sebha.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.hakeem.sebha.R;
import com.example.hakeem.sebha.helper.SessionManager;
import com.example.hakeem.sebha.helper.Variables;

import java.util.Objects;

import static com.example.hakeem.sebha.helper.Variables.convertToArabicNumber;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SobhanAllahFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SobhanAllahFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SobhanAllahFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Button button;
    private TextView counterTextView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private long counter = Variables.sobhanallah_count;

    public SobhanAllahFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SobhanAllahFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SobhanAllahFragment newInstance(String param1, String param2) {
        SobhanAllahFragment fragment = new SobhanAllahFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_sobhan_allah, container, false);

        counterTextView = rootView.findViewById(R.id.counter_textView);
        counterTextView.setText(convertToArabicNumber(String.valueOf(counter)));

       // applyFontToTextView(counterTextView);

        button = rootView.findViewById(R.id.sobhan_allah_button);
        Variables.applyFontToTextView(button);

        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    button.setBackground(getResources().getDrawable(R.drawable.circle_button_background_toggeld));
                    counter ++;
                    counterTextView.setText(convertToArabicNumber(String.valueOf(counter)));
                    Variables.sobhanallah_count = counter;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    button.setBackground(getResources().getDrawable(R.drawable.circle_button_background_clicked));
                }
                return true;
            }
        });

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
            Log.e("onButtonPressed", "onButtonPressed");
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        SessionManager.setSobhanAllahCount(Variables.sobhanallah_count);
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

//    private String convertToArabicNumber(String number){
//        if (number != null) {
//            return number
//                    .replaceAll("1","١")
//                    .replaceAll("2","٢")
//                    .replaceAll("3","٣")
//                    .replaceAll("4","٤")
//                    .replaceAll("5","٥")
//                    .replaceAll("6","٦")
//                    .replaceAll("7","٧")
//                    .replaceAll("8","٨")
//                    .replaceAll("9","٩")
//                    .replaceAll("0","٠");
//        }
//
//        return null;
//    }

}
