package org.pindad.aftersalepindad.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.pindad.aftersalepindad.BarangActivity;
import org.pindad.aftersalepindad.BaseActivity;
import org.pindad.aftersalepindad.MenuActivity;
import org.pindad.aftersalepindad.Model.ListCatalogue;
import org.pindad.aftersalepindad.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 10/01/2018.
 */

public class CatalogueAdapter extends RecyclerView.Adapter<CatalogueAdapter.ViewHolder>{
    private List<ListCatalogue> listItems;
    private Context mContext;
    public CatalogueAdapter(Context context, List<ListCatalogue> List) {
        mContext = context;
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView nameCatalogue, description;
        public CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.bankcardId);
            image = (ImageView) itemView.findViewById(R.id.imageCatalogue);
            nameCatalogue  = (TextView) itemView.findViewById(R.id.nameCatalogue);
            description = (TextView) itemView.findViewById(R.id.description);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, BarangActivity.class);
                    intent.putExtra("getNama", nameCatalogue.getText().toString());
                    intent.putExtra("getDeskripsi", description.getText().toString());
                    mContext.startActivity(intent);
                    Log.d("Tes", "berhasil");
                }
            });
        }
    }
}
