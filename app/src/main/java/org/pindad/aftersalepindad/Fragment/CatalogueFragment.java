package org.pindad.aftersalepindad.Fragment;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
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

public class CatalogueFragment extends Fragment implements SearchView.OnQueryTextListener {
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    ApiInterface mApiInterface;
    RelativeLayout relativeLayout;
    List<ListCatalogue> KontakList;
    public CatalogueFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_catalogue, container, false);
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
        for (int i=0; i<KontakList.size(); i++){
            String data = KontakList.get(i).getNama();
            if (data.toLowerCase().contains(newText.toLowerCase())) {
                filteredValues.add(KontakList.get(i));
            }

        }

        mAdapter = new CatalogueAdapter(getContext(), filteredValues);
        mRecyclerView.setAdapter(mAdapter);

        return false;
    }

    public void resetSearch() {
        mAdapter = new CatalogueAdapter(getContext(), KontakList);
        mRecyclerView.setAdapter(mAdapter);
    }

}
