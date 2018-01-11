package org.pindad.aftersalepindad.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.pindad.aftersalepindad.ListCatalogue;
import org.pindad.aftersalepindad.R;

import java.util.ArrayList;

/**
 * Created by ASUS on 10/01/2018.
 */

public class CatalogueAdapter extends RecyclerView.Adapter<CatalogueAdapter.ViewHolder>{
    private ArrayList<ListCatalogue> listItems;

    public CatalogueAdapter() {
        super();
        listItems = new ArrayList<ListCatalogue>();
        ListCatalogue listCatalogue = new ListCatalogue();

        listCatalogue.setNama("a");
        listCatalogue.setDeskripsi("aaaaaaa");
        listCatalogue.setImageUrl(R.drawable.ic_android_black_24dp);
        listItems.add(listCatalogue);

        listCatalogue = new ListCatalogue();
        listCatalogue.setNama("b");
        listCatalogue.setDeskripsi("bbbbbb");
        listCatalogue.setImageUrl(R.drawable.ic_android_black_24dp);
        listItems.add(listCatalogue);

        listCatalogue = new ListCatalogue();
        listCatalogue.setNama("c");
        listCatalogue.setDeskripsi("cccccc");
        listCatalogue.setImageUrl(R.drawable.ic_android_black_24dp);
        listItems.add(listCatalogue);

        listCatalogue = new ListCatalogue();
        listCatalogue.setNama("d");
        listCatalogue.setDeskripsi("dddddd");
        listCatalogue.setImageUrl(R.drawable.ic_android_black_24dp);
        listItems.add(listCatalogue);

        listCatalogue = new ListCatalogue();
        listCatalogue.setNama("e");
        listCatalogue.setDeskripsi("eeeeee");
        listCatalogue.setImageUrl(R.drawable.ic_android_black_24dp);
        listItems.add(listCatalogue);

        listCatalogue = new ListCatalogue();
        listCatalogue.setNama("f");
        listCatalogue.setDeskripsi("fffffff");
        listCatalogue.setImageUrl(R.drawable.ic_android_black_24dp);
        listItems.add(listCatalogue);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.barang_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListCatalogue nature = listItems.get(position);
        holder.nameCatalogue.setText(nature.getNama());
        holder.description.setText(nature.getDeskripsi());
        holder.image.setImageResource(nature.getImageUrl());
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
