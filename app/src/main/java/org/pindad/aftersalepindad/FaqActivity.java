package org.pindad.aftersalepindad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import org.pindad.aftersalepindad.Adapter.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FaqActivity extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
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
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
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
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }

    /*
     * Preparing the list data
     */
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
        listDataChild.put(listDataHeader.get(1), ques3);
        listDataChild.put(listDataHeader.get(1), ques4);
        listDataChild.put(listDataHeader.get(1), ques5);
    }
}
