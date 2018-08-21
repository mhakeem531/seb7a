package com.example.hakeem.sebha.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.hakeem.sebha.R;
import com.example.hakeem.sebha.helper.SessionManager;
import com.example.hakeem.sebha.helper.Variables;

import static com.example.hakeem.sebha.helper.Variables.convertToArabicNumber;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EsteghfarFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EsteghfarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EsteghfarFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button button;
    private TextView counterTextView;
    private long counter = Variables.estakfar_count;

    private TasbeehFragment.OnFragmentInteractionListener mListener;

    public EsteghfarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TasbeehFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TasbeehFragment newInstance(String param1, String param2) {
        TasbeehFragment fragment = new TasbeehFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_esteghfar, container, false);

        counterTextView = rootView.findViewById(R.id.counter_textView);
        counterTextView.setText(convertToArabicNumber(String.valueOf(counter)));

        // applyFontToTextView(counterTextView);

        button = rootView.findViewById(R.id.estakfar_button);
        Variables.applyFontToTextView(button);

        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    button.setBackground(getResources().getDrawable(R.drawable.tasbeeh_toggle));
                    counter++;
                    counterTextView.setText(convertToArabicNumber(String.valueOf(counter)));
                    Variables.estakfar_count = counter;
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
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof TasbeehFragment.OnFragmentInteractionListener) {
            mListener = (TasbeehFragment.OnFragmentInteractionListener) context;
        } /*else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        SessionManager.setTasbeehCount(Variables.estakfar_count);
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
}
