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

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    public FaqFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_faq, container, false);
        expListView = (ExpandableListView) rootView.findViewById(R.id.lvExp);
        prepareListData();
        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);
        // setting list adapter
        listAdapter.notifyDataSetChanged();
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getActivity(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getActivity(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getActivity(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
        return rootView;
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Pertanyaan 1");
        listDataHeader.add("Pertanyaan 2");
        listDataHeader.add("Pertanyaan 3");
        listDataHeader.add("Pertanyaan 4");
        listDataHeader.add("Pertanyaan 5");

        List<String> ques1 = new ArrayList<String>();
        ques1.add("Jawaban 1.1");
        ques1.add("Jawaban 1.2");
        ques1.add("Jawaban 1.3");
        ques1.add("Jawaban 1.4");
        ques1.add("Jawaban 1.5");

        List<String> ques2 = new ArrayList<String>();
        ques2.add("Jawaban 2.1");
        ques2.add("Jawaban 2.2");
        ques2.add("Jawaban 2.3");
        ques2.add("Jawaban 2.4");
        ques2.add("Jawaban 2.5");

        List<String> ques3 = new ArrayList<String>();
        ques1.add("Jawaban 3.1");
        ques1.add("Jawaban 3.2");
        ques1.add("Jawaban 3.3");
        ques1.add("Jawaban 3.4");
        ques1.add("Jawaban 3.5");

        List<String> ques4 = new ArrayList<String>();
        ques4.add("Jawaban 4.1");
        ques4.add("Jawaban 4.2");
        ques4.add("Jawaban 4.3");
        ques4.add("Jawaban 4.4");
        ques4.add("Jawaban 4.5");

        // Adding child data
        List<String> ques5 = new ArrayList<String>();
        ques5.add("Jawaban 5.1");
        ques5.add("Jawaban 5.2");
        ques5.add("Jawaban 5.3");
        ques5.add("Jawaban 5.4");
        ques5.add("Jawaban 5.5");



        listDataChild.put(listDataHeader.get(0), ques1); // Header, Child data
        listDataChild.put(listDataHeader.get(1), ques2);
        listDataChild.put(listDataHeader.get(2), ques3);
        listDataChild.put(listDataHeader.get(3), ques4);
        listDataChild.put(listDataHeader.get(4), ques5);
    }


}


