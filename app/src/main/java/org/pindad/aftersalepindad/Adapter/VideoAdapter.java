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

import org.pindad.aftersalepindad.BarangActivity;
import org.pindad.aftersalepindad.Model.ListCatalogue;
import org.pindad.aftersalepindad.Model.ListVideo;
import org.pindad.aftersalepindad.R;
import org.pindad.aftersalepindad.VideoActivity;

import java.util.List;


public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    private List<ListVideo> listItems;
    private Context mContext;

    public VideoAdapter(Context context, List<ListVideo> List) {
        mContext = context;
        listItems = List;
    }


    @Override
    public VideoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_view, parent, false);
        VideoAdapter.ViewHolder viewHolder = new VideoAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nameVideo.setText(listItems.get(position).getNama_video());
        holder.image.setImageResource(R.drawable.ic_android_black_24dp);
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
        public TextView nameVideo;
        public CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.videocardId);
            image = (ImageView) itemView.findViewById(R.id.imageVideo);
            nameVideo  = (TextView) itemView.findViewById(R.id.nameVideo);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, VideoActivity.class);
                    intent.putExtra("getNama", nameVideo.getText().toString());
                    mContext.startActivity(intent);
                    Log.d("Tes", "berhasil");
                }
            });
        }
    }
}