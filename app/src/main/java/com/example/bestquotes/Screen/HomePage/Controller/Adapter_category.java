package com.example.bestquotes.Screen.HomePage.Controller;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bestquotes.R;
import com.example.bestquotes.Screen.HomePage.Model.Model_category;
import com.example.bestquotes.Screen.HomePage.View.MainActivity;
import com.example.bestquotes.Screen.HomePage.View.Quotes_Activity;

import java.util.ArrayList;
import java.util.List;

public class Adapter_category extends RecyclerView.Adapter<Adapter_category.ViewData> {

    Activity activity;
    List<Model_category> l1 = new ArrayList<>();

    public Adapter_category(MainActivity mainActivity, List<Model_category> l1) {
        activity = mainActivity;
        this.l1 = l1;
    }

    @NonNull
    @Override
    public ViewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.item_category,parent,false);

        return new ViewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewData holder, @SuppressLint("RecyclerView") int position) {

        holder.category_txt.setText(l1.get(position).getCategory());
        Glide.with(activity).load(l1.get(position).getImage()).placeholder(R.drawable.img).into(holder.img);

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(activity, ""+l1.get(position).getCategory(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(activity, ""+position, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(activity, Quotes_Activity.class);
                intent.putExtra("n1",l1.get(position).getCategory());
                intent.putExtra("n2",position);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return l1.size();
    }

    class ViewData extends RecyclerView.ViewHolder {

        TextView category_txt;
        ImageView img;

        public ViewData(@NonNull View itemView) {
            super(itemView);

            category_txt = itemView.findViewById(R.id.category_txt);
            img = itemView.findViewById(R.id.img);

        }
    }
}
