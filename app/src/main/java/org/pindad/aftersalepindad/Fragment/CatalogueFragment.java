package org.pindad.aftersalepindad.Fragment;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import org.pindad.aftersalepindad.Adapter.CatalogueAdapter;
import org.pindad.aftersalepindad.Adapter.CategoryAdapter;
import org.pindad.aftersalepindad.Model.ListCatalogue;
import org.pindad.aftersalepindad.R;
import org.pindad.aftersalepindad.Rest.ApiClient;
import org.pindad.aftersalepindad.Rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatalogueFragment extends Fragment implements SearchView.OnQueryTextListener {
    RecyclerView mRecyclerView, catRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    LinearLayoutManager catLayoutManager;
    RecyclerView.Adapter mAdapter, catAdapter;
    ImageView categ1, categ2, categ3, categ4;
    HorizontalScrollView horizontalScrollView;
    ApiInterface mApiInterface;
    RelativeLayout relativeLayout;
    List<ListCatalogue> KontakList, temp, CategList;
    LinearLayout mKAMP, mKExcava, mKAPKL, mAll;
    public CatalogueFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_catalogue, container, false);
//        mKExcava = (LinearLayout) view.findViewById(R.id.excavator);
//        mKAMP = (LinearLayout) view.findViewById(R.id.amp);
//        mKAPKL = (LinearLayout) view.findViewById(R.id.apkl);
        mAll = (LinearLayout) view.findViewById(R.id.all);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.noInternet);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.catalogueRV);
        catRecyclerView = (RecyclerView) view.findViewById(R.id.catList);
//        ImageView categ1 = (ImageView) view.findViewById(R.id.category1);
//        ImageView categ2 = (ImageView) view.findViewById(R.id.category2);
//        ImageView categ3 = (ImageView) view.findViewById(R.id.category3);
//        ImageView categ4 = (ImageView) view.findViewById(R.id.category4);

//        Glide.with(getActivity())
//                .load("http://api.pindad.com/as/files/pictures/all.JPG")
//                .override(245,180)
//                .centerCrop()
//                .into(categ1);
//
//        Glide.with(getActivity())
//                .load("http://api.pindad.com/as/files/pictures/categ2.JPG")
//                .override(245,180)
//                .centerCrop()
//                .into(categ2);
//
//        Glide.with(getActivity())
//                .load("http://api.pindad.com/as/files/pictures/categ3.JPG")
//                .override(245,180)
//                .centerCrop()
//                .into(categ3);
//
//        Glide.with(getActivity())
//                .load("http://api.pindad.com/as/files/pictures/categ1.JPG")
//                .override(245,180)
//                .centerCrop()
//                .into(categ4);

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

//        mKExcava.setOnClickListener(this);
//        mKAMP.setOnClickListener(this);
//        mKAPKL.setOnClickListener(this);
//        mAll.setOnClickListener(this);
        mLayoutManager  = new GridLayoutManager(getActivity(),2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        catLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        catRecyclerView.setLayoutManager(catLayoutManager);

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
                List<ListCatalogue> categValues = new ArrayList<ListCatalogue>();

                try {
                    for (int i = 0; i < KontakList.size(); i++) {
                        List<ListCatalogue> tes = new ArrayList<ListCatalogue>();
                        tes.add(KontakList.get(i));
                        if (!categValues.contains(tes)) {
                            categValues.add(KontakList.get(i));
                        }
                    }
                }catch(Exception e){

                }
                catAdapter = new CategoryAdapter(getContext(), categValues);
                mRecyclerView.setAdapter(mAdapter);
                catRecyclerView.setAdapter(catAdapter);
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
                String data = KontakList.get(i).getTipe_produk();
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
        catRecyclerView.setAdapter(catAdapter);
    }
//
//    @Override
//    public void onClick(View view) {
//
//    }
}
