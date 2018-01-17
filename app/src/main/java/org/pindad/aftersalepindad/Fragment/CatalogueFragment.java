package org.pindad.aftersalepindad.Fragment;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import org.pindad.aftersalepindad.Adapter.CatalogueAdapter;
import org.pindad.aftersalepindad.MenuActivity;
import org.pindad.aftersalepindad.Model.GetCatalog;
import org.pindad.aftersalepindad.Model.ListCatalogue;
import org.pindad.aftersalepindad.R;
import org.pindad.aftersalepindad.Rest.ApiClient;
import org.pindad.aftersalepindad.Rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatalogueFragment extends Fragment implements SearchView.OnQueryTextListener, View.OnClickListener {
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    HorizontalScrollView horizontalScrollView;
    ApiInterface mApiInterface;
    RelativeLayout relativeLayout;
    List<ListCatalogue> KontakList, temp;
    LinearLayout mKSteering, mKCapstan, mKCombine, mKCrane, mKTraktor, mKExcava, mKGenerator, mAll;
    public CatalogueFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_catalogue, container, false);
        horizontalScrollView = (HorizontalScrollView) view.findViewById(R.id.sHorizontal);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        mKCrane = (LinearLayout) view.findViewById(R.id.crane);
        mKTraktor = (LinearLayout) view.findViewById(R.id.traktor);
        mKGenerator = (LinearLayout) view.findViewById(R.id.generator);
        mKExcava = (LinearLayout) view.findViewById(R.id.excava);
        mKSteering = (LinearLayout) view.findViewById(R.id.steering);
        mKCapstan = (LinearLayout) view.findViewById(R.id.capstan);
        mKCombine = (LinearLayout) view.findViewById(R.id.combine);
        mAll = (LinearLayout) view.findViewById(R.id.semua);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.noInternet);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.catalogueRV);
        mRecyclerView.setHasFixedSize(true);
        setHasOptionsMenu(true);
        final SearchView searchView = (SearchView) view.findViewById(R.id.search);
        searchView.setOnQueryTextListener(this);
        EditText editText = (EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        editText.setTextColor(getResources().getColor(R.color.black));
        editText.setHintTextColor(getResources().getColor(R.color.black));
        final AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.appBar);
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    appBarLayout.setExpanded(false);
            }
        });
        mKCrane.setOnClickListener(this);
        mKTraktor.setOnClickListener(this);
        mKGenerator.setOnClickListener(this);
        mKExcava.setOnClickListener(this);
        mKSteering.setOnClickListener(this);
        mKCapstan.setOnClickListener(this);
        mKCombine.setOnClickListener(this);
        mAll.setOnClickListener(this);
        mLayoutManager  = new GridLayoutManager(getActivity(),2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        refresh();
        return view ;
    }
    public void refresh() {
        Call<List<ListCatalogue>> kontakCall = mApiInterface.getCatalogue();
        kontakCall.enqueue(new Callback<List<ListCatalogue>>() {
            @Override
            public void onResponse(Call<List<ListCatalogue>> call, Response<List<ListCatalogue>>
                    response) {
                relativeLayout.setVisibility(View.GONE);
                mRecyclerView.setVisibility(View.VISIBLE);
                KontakList = response.body();
                temp = new ArrayList<>(KontakList);
                mAdapter = new CatalogueAdapter(getContext(), KontakList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<ListCatalogue>> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
                relativeLayout.setVisibility(View.VISIBLE);
                mRecyclerView.setVisibility(View.GONE);
            }
        });
    }
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText == null || newText.trim().isEmpty()) {
            resetSearch();
            return false;
        }
        List<ListCatalogue> filteredValues = new ArrayList<>();
        try {
            for (int i=0; i<KontakList.size(); i++){
                String data = KontakList.get(i).getNama();
                if (data.toLowerCase().contains(newText.toLowerCase())) {
                    filteredValues.add(KontakList.get(i));
                }
                mAdapter = new CatalogueAdapter(getContext(), filteredValues);
                mRecyclerView.setAdapter(mAdapter);
            }
        }catch (Exception e){

        }


        return false;
    }

    public void resetSearch() {
        mAdapter = new CatalogueAdapter(getContext(), KontakList);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()!=R.id.semua) {
            String x = null;
            switch (view.getId()){
                case R.id.excava :
                    x = "excava";
                    break;
                case R.id.crane :
                    x = "crane";
                    break;
                case R.id.traktor :
                    x = "traktor";
                    break;
                case R.id.steering :
                    x = "steering";
                    break;
                case R.id.generator :
                    x = "generator";
                    break;
                case R.id.capstan :
                    x = "generator";
                    break;
                case R.id.combine :
                    x = "combine";
                    break;
            }
            List<ListCatalogue> filteredValues = new ArrayList<>();
            try {
                for (int i=0; i<temp.size(); i++){
                    String data = temp.get(i).getKategori();
                    if (data.toLowerCase().equals(x)) {
                        filteredValues.add(temp.get(i));
                    }
                    KontakList = filteredValues;
                    mAdapter = new CatalogueAdapter(getContext(), KontakList);
                    mRecyclerView.setAdapter(mAdapter);
                }
            }catch (Exception e){

            }
        }else{
            KontakList = temp;
            mAdapter = new CatalogueAdapter(getContext(), KontakList);
            mRecyclerView.setAdapter(mAdapter);
        }
    }
}
