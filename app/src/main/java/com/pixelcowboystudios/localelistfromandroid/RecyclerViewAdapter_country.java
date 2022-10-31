package com.pixelcowboystudios.localelistfromandroid;

import android.content.Context;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter_country extends RecyclerView.Adapter<RecyclerViewAdapter_country.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    ArrayList<String> array_name = new ArrayList<>();
    ArrayList<String> array_iso = new ArrayList<>();

    private Context mContext;
    private ItemClickListener mitemClickListener;

    public RecyclerViewAdapter_country(Context context, ArrayList<String> adp_name, ArrayList<String> adp_iso, ItemClickListener itemClickListener) {
        this.mContext = context;
        this.array_name = adp_name;
        this.array_iso = adp_iso;

        this.mitemClickListener = itemClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: called.");

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(view -> {
            mitemClickListener.onItemClick(position);
        });

        holder.txt_name.setText(array_name.get(position));
        holder.txt_iso.setText(array_iso.get(position));
    }

    @Override
    public int getItemCount() {
        return array_name.size();
    }

    public interface ItemClickListener{
        void onItemClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_name;
        TextView txt_iso;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_name = itemView.findViewById(R.id.txt_name);
            txt_iso = itemView.findViewById(R.id.txt_iso);
        }
    }

}
