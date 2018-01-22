package org.pindad.aftersalepindad.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.pindad.aftersalepindad.Adapter.ExpandableListAdapter;
import org.pindad.aftersalepindad.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.view.View.GONE;

public class FaqFragment extends Fragment   {

    LinearLayout ques1, ques2, ques3, ques4, ques5, ans1, ans2, ans3, ans4, ans5;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    Context context;

    public FaqFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_faq, container, false);
        context = rootView.getContext();

//        ques1 = (LinearLayout) rootView.findViewById(R.id.question1);
//        ques2 = (LinearLayout) rootView.findViewById(R.id.question2);
//        ques3 = (LinearLayout) rootView.findViewById(R.id.question3);
//        ques4 = (LinearLayout) rootView.findViewById(R.id.question4);
//        ques5 = (LinearLayout) rootView.findViewById(R.id.question5);
//        ans1 = (LinearLayout) rootView.findViewById(R.id.answer1);
//        ans2 = (LinearLayout) rootView.findViewById(R.id.answer2);
//        ans3 = (LinearLayout) rootView.findViewById(R.id.answer3);
//        ans4 = (LinearLayout) rootView.findViewById(R.id.answer4);
//        ans5 = (LinearLayout) rootView.findViewById(R.id.answer5);
//
//        ques1.setOnClickListener(this);
//        ques2.setOnClickListener(this);
//        ques3.setOnClickListener(this);
//        ques4.setOnClickListener(this);
//        ques5.setOnClickListener(this);

        return rootView;
    }



}


