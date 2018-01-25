package com.example.hdahagam.app4;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hdahagam on 9/30/2017.
 */

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.ViewHolder> {

    public interface selectListner{
        public void onClick(View v, int position);
        public void onLongClick(View v,int position);
    }


    public List<Map<String,?>> movDB;
    private Context context;

    selectListner onSelectListner;

    public  MyAdapter(Context mycontext, List<Map<String,?>> movSet){
        context = mycontext;
        movDB = movSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View type = null;

        switch (viewType){
            case 1:
                type = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_view,parent,false);
                break;
            case 2:
                type = LayoutInflater.from(parent.getContext()).inflate(R.layout.middle_card,parent,false);
                break;
            case 3:
                type = LayoutInflater.from(parent.getContext()).inflate(R.layout.bottom_card,parent,false);
                break;
        }

        return new ViewHolder(type);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Map<String,?> movie = movDB.get(position);
        holder.Image.setImageResource(( Integer )movie.get ("image")) ;
        holder.Title.setText(( String)movie.get("title"));
        holder.Overview.setText(( String )movie.get ("overview") );
        holder.checkBox.setChecked ((Boolean) movie.get("selection"));

//        setAnimation(holder.itemView);

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            final HashMap<String,Boolean> t = (HashMap<String,Boolean>) movie;
            @Override
            public void onClick(View v) {
                t.put("selection",true);
            }
        });


    }

    @Override
    public int getItemViewType(int position){
        if(position<=4){
            return 1;
        }
        else if(position>=getItemCount()-5){
            return 3;
        }
        else{
            return  2;
        }
    }


    @Override
    public int getItemCount() {
        return movDB.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView Image;
        public TextView Title;
        public TextView Overview;
        public CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);

            Image = (ImageView)itemView.findViewById(R.id.imageView);
            Title = (TextView) itemView.findViewById(R.id.id_title);
            Overview = (TextView)itemView.findViewById(R.id.id_overview);
            checkBox = (CheckBox)itemView.findViewById(R.id.checkBox);

            //Implement onclick listener for view
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    onSelectListner = (selectListner) v.getContext();
                    onSelectListner.onClick(v,getAdapterPosition());
                }
            });


            itemView.setOnLongClickListener(new View.OnLongClickListener(){
                @Override
                public boolean onLongClick(View v){
                    onSelectListner = (selectListner) v.getContext();
                    onSelectListner.onLongClick(v,getAdapterPosition());
                    return true;
                }
            });

        }


    }

}




