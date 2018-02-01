package org.pindad.aftersalepindad.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.pindad.aftersalepindad.BarangActivity;
import org.pindad.aftersalepindad.Model.ListCatalogue;
import org.pindad.aftersalepindad.R;

import java.util.List;

/**
 * Created by WIDHIYANTO NUGROHO on 01/02/2018.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{
    private List<ListCatalogue> listItems;
    private Context mContext;

    public CategoryAdapter(Context context, List<ListCatalogue> List) {
        mContext = context;
        listItems = List;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.description.setText(listItems.get(position).getJenis_produk());
        Glide.with(mContext)
                .load(listItems.get(position).getPic())
                .override(245,180)
                .centerCrop()
                .into(((ViewHolder) holder).image);
    }

    @Override
    public int getItemCount() {
        try {
            return listItems.size();
        } catch (Exception e){
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView nameCatalogue, description;
        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.cImage);
            description = (TextView) itemView.findViewById(R.id.cText);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }
}