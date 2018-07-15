package org.pindad.aftersalepindad.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import org.pindad.aftersalepindad.BarangActivity;
import org.pindad.aftersalepindad.Model.ListCatalogue;
import org.pindad.aftersalepindad.R;

import java.util.ArrayList;
import java.util.List;

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
        holder.nameCatalogue.setText(listItems.get(position).getTipe_produk());
        holder.description.setText(listItems.get(position).getJenis_produk());
        Glide.with(mContext)
                .load(listItems.get(position).getPic())
                .apply(new RequestOptions().override(245,180).centerCrop())
                .into(((ViewHolder) holder).image);
        holder.gambar = listItems.get(position).getPic();
    }

    @Override
    public int getItemCount() {
        try {
            return listItems.size();
        }catch (Exception e){
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView nameCatalogue, description;
        public CardView cardView;
        public String gambar;
        public ViewHolder(final View itemView) {
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
                    intent.putExtra("getPic",gambar);
                    mContext.startActivity(intent);
                    Log.d("Tes", "berhasil");
                }
            });
        }
    }
}
