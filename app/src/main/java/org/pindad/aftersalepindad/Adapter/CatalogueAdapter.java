package org.pindad.aftersalepindad.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.pindad.aftersalepindad.Model.ListCatalogue;
import org.pindad.aftersalepindad.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 10/01/2018.
 */

public class CatalogueAdapter extends RecyclerView.Adapter<CatalogueAdapter.ViewHolder>{
    private List<ListCatalogue> listItems;

    public CatalogueAdapter(List<ListCatalogue> List) {
        listItems = List;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.barang_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nameCatalogue.setText(listItems.get(position).getNama());
        holder.description.setText(listItems.get(position).getDeskripsi());
        holder.image.setImageResource(R.drawable.ic_android_black_24dp);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView image;
        public TextView nameCatalogue, description;

        public ViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.imageCatalogue);
            nameCatalogue  = (TextView) itemView.findViewById(R.id.nameCatalogue);
            description = (TextView) itemView.findViewById(R.id.description);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
