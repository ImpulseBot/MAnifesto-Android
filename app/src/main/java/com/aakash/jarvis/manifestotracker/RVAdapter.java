package com.aakash.jarvis.manifestotracker;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by chi6rag on 8/30/15.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ManifestoViewHolder>{

    List<JSONObject> manifestos;
    RVAdapter(List<JSONObject> manifestos){
        this.manifestos = manifestos;
    }

    @Override
    public RVAdapter.ManifestoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.manifesto, viewGroup, false);
        ManifestoViewHolder manifestoViewHolder = new ManifestoViewHolder(v);
        return manifestoViewHolder;
    }

    @Override
    public void onBindViewHolder(RVAdapter.ManifestoViewHolder holder, int position) {
        try {
            holder.manifesto_name.setText((String) manifestos.get(position).get("name"));
            holder.manifesto_organizer.setText((String) manifestos.get(position).get("organizer"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return this.manifestos.size();
    }

    public static class ManifestoViewHolder extends RecyclerView.ViewHolder {
        CardView cardview;
        TextView manifesto_name;
        TextView manifesto_organizer;

        ManifestoViewHolder(View itemView) {
            super(itemView);
            cardview = (CardView)itemView.findViewById(R.id.cardview);
            manifesto_name = (TextView) itemView.findViewById(R.id.manifesto_name);
            manifesto_organizer = (TextView) itemView.findViewById(R.id.manifesto_organizer);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
