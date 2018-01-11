package org.pindad.aftersalepindad.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pindad.aftersalepindad.Adapter.CatalogueAdapter;
import org.pindad.aftersalepindad.R;

public class CatalogueFragment extends Fragment {
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;

    public CatalogueFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_catalogue, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.catalogueRV);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager  = new GridLayoutManager(getActivity(),2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new CatalogueAdapter();
        mRecyclerView.setAdapter(mAdapter);

        return view ;
    }
}
