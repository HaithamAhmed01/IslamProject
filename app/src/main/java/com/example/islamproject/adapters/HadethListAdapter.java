package com.example.islamproject.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.islamproject.R;
import com.example.islamproject.model.HadethItem;

import java.util.List;

public class HadethListAdapter extends RecyclerView.Adapter<HadethListAdapter.ViewHolder> {

  List<HadethItem> hadethItems;

    public HadethListAdapter(List<HadethItem> hadethItems) {
        this.hadethItems = hadethItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_verse,parent,false);

                return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.content.setText(hadethItems.get(position).getTitle());


    }

    @Override
    public int getItemCount() {
        if(hadethItems ==null) return 0;
        return hadethItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

       TextView content;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            content=itemView.findViewById(R.id.content);
        }
    }

}
