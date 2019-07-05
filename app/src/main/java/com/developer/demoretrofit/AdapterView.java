package com.developer.demoretrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterView extends RecyclerView.Adapter<AdapterView.ViewHolder> {

    private MainActivity context;
    private List<Datum> data;

    public AdapterView(MainActivity context, List<Datum> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
                 final Datum datum=data.get(position);
                 holder.txt.setText("ID:"+datum.getId()+"\n"+"Email:"+datum.getEmail()+"\n"+"First_name:"+datum.getFirstName()+"\n"+"Last_name:"+datum.getLastName());
        Picasso.get().load(datum.getAvatar()).fit().centerCrop().into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View view) {
                                                   context.click(datum);
                                               }
                                           }
        );
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txt;
        public ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt=itemView.findViewById(R.id.txt);
            img=itemView.findViewById(R.id.img);
        }
    }
}
