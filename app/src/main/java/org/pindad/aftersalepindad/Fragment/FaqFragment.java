package org.pindad.aftersalepindad.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

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

//        MediaController mc = new MediaController(getActivity());
//
//        String path="http://www.ted.com/talks/download/video/8584/talk/761";
//        String path1="http://api.pindad.com/as/files/video/video2.MP4";
//
//        Uri uri=Uri.parse(path1);
//
//        VideoView video=(VideoView) rootView.findViewById(R.id.faqVideo);
//        video.setVideoURI(uri);
//        video.setMediaController(mc);
//        video.start();


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
//                 Toast.makeText(getActivity(),
//                 "Group Clicked " + listDataHeader.get(groupPosition),
//                 Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
//        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                Toast.makeText(getActivity(),
//                        listDataHeader.get(groupPosition) + " Expanded",
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        // Listview Group collasped listener
//        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
//
//            @Override
//            public void onGroupCollapse(int groupPosition) {
//                Toast.makeText(getActivity(),
//                        listDataHeader.get(groupPosition) + " Collapsed",
//                        Toast.LENGTH_SHORT).show();
//            }
//        });

        // Listview on child click listener
//        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v,
//                                        int groupPosition, int childPosition, long id) {
//                // TODO Auto-generated method stub
//                Toast.makeText(
//                        getActivity(),
//                        listDataHeader.get(groupPosition)
//                                + " : "
//                                + listDataChild.get(
//                                listDataHeader.get(groupPosition)).get(
//                                childPosition), Toast.LENGTH_SHORT)
//                        .show();
//                return false;
//            }
//        });
        return rootView;
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Engine Doesn't Start");



        listDataHeader.add("Engine Doesn't Start");
        listDataHeader.add("Engine Power Low");
        listDataHeader.add("Engine Doesn't Stop");
        listDataHeader.add("Engine Black Smoke");
        listDataHeader.add("Engine White Smoke");
        listDataHeader.add("Engine Can't High Idle");
        listDataHeader.add("Engine Knocking");
        listDataHeader.add("Oil Consumption is Excessive");
        listDataHeader.add("Oil is Mixed in Coolant");
        listDataHeader.add("Oil Level Rises");
        listDataHeader.add("Coolant Temperature Rises to High");
        listDataHeader.add("Hydraulic Low Power");

        List<String> ques1 = new ArrayList<String>();
        ques1.add("Terdapat udara yang terjebak didalam fuel system");
        ques1.add("Keabnormalan pada supply pump, shut-off valve");
        ques1.add("Cranking RPM tidak tercapai");
        ques1.add("Fuel tercampur air, dsb");

        List<String> ques2 = new ArrayList<String>();
        ques2.add("Terjadi kebuntuan pada air cleaner atau fuel filter");
        ques2.add("Injection timing tidak tepat");
        ques2.add("Keabnormalan pada supply pump, shut-off valve");
        ques2.add("Lingkage thottle atau current throttle drive kurang maksimal");
        ques2.add("Kualitas fuel jelek: bercampur minya, minyak tanah(kerosin) atau kotoran lainnya");

        List<String> ques3 = new ArrayList<String>();
        ques3.add("Shut-off solenoid valve putus");
        ques3.add("O-ring injector fuel return bocor, sehngga masuk ke port metering");

        List<String> ques4 = new ArrayList<String>();
        ques4.add("Pada dasarnya disebabkan perbandngan udara masuk lebih sedikir dari fuel yang diinjeksikan, sehingga ada");
        ques4.add("Air cleaner buntu");
        ques4.add("Turbocharger abnormal");
        ques4.add("Over fuelling karena keabnormalan pada control fuel system");
        ques4.add("Unit beroperasi pada daerah ketinggian, sehingga kerapatan udara luar relatif lebih kecil");

        // Adding child data
        List<String> ques5 = new ArrayList<String>();
        ques5.add("Ujung injector pecah, sehingga tidak terjadi injection spray");
        ques5.add("Injection timing tidak tepat");

        List<String> ques6 = new ArrayList<String>();
        ques6.add("Fuel control dial (potentiometer) abnormal");
        ques6.add("Keabnormalan pada ECM");
        ques6.add("Misadjustment engine speed sensor, dsb");

        List<String> ques7 = new ArrayList<String>();
        ques7.add("Timing injection terlalu cepat atau lambat");
        ques7.add("Terjadi keausan berlebihan pada main bearing");
        ques7.add("Adjustment valve clearance tidak tepat, dsb");

        List<String> ques8 = new ArrayList<String>();
        ques8.add("Keausan pada liner atau ring piston terlalu besar (oil up)");
        ques8.add("Keausan pada valve guide terlalu besar (oil down)");
        ques8.add("Kerusakan turbocharger, keausan pada bushing atau seal, sehingga oli bocor ke sisi blower atau impeller");

        List<String> ques9 = new ArrayList<String>();
        ques9.add("Terjadi keretakan pada cylinder head atau engine block pada sisi jalur air");
        ques9.add("O-ring liner bocor");
        ques9.add("O-ring gasket cylinder head bocor");
        ques9.add("Oil cooler bocor, dsb");

        List<String> ques10 = new ArrayList<String>();
        ques10.add("Oli level engine dapat naik disebabkan adanya fuel atau air radiator yang bocor dan masuk ke dalam crack case");
        ques10.add("Keausan Plunger FIP teralalu besar, sehingga fuel bocor ke dalam case FIP");
        ques10.add("Nozzle atau injector pecah, sehingga fuel langsung bocor ke ruang bacar dan turun melalui ring piston masuk");
        ques10.add("O-ring return port nozzle atau plunger bocor, dsb");
        ques10.add("Jika level bertambah tinggi karena bercampur dengan air maka, penyebabnya sama dengan oil engine bercampur");

        List<String> ques11 = new ArrayList<String>();
        ques11.add("Core & Fin rediator buntu");
        ques11.add("Air radiator kurang");
        ques11.add("Thermostat jammed");
        ques11.add("Vaccum valve (cap radiator) tidak berfungsi, dsb");
        ques11.add("Impeller water pump slip, atau internal leakage terlalu besar, dsb");

        List<String> ques12 = new ArrayList<String>();
        ques12.add("Setting primary valve terlalu rendah");


        listDataChild.put(listDataHeader.get(1), ques1); // Header, Child data
        listDataChild.put(listDataHeader.get(2), ques2);
        listDataChild.put(listDataHeader.get(3), ques3);
        listDataChild.put(listDataHeader.get(4), ques4);
        listDataChild.put(listDataHeader.get(5), ques5);
        listDataChild.put(listDataHeader.get(6), ques6);
        listDataChild.put(listDataHeader.get(7), ques7);
        listDataChild.put(listDataHeader.get(8), ques8);
        listDataChild.put(listDataHeader.get(9), ques9);
        listDataChild.put(listDataHeader.get(10), ques10);
        listDataChild.put(listDataHeader.get(11), ques11);
        listDataChild.put(listDataHeader.get(12), ques12);
    }


}


