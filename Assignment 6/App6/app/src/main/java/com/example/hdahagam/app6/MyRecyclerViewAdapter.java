package com.example.hdahagam.app6;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Map;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    public List<MyMovie> mDataSet;
    private Context mContext;
    DatabaseHelper myDB;
    int vType;
    int tableId=1;
    public MyMovie movie;

    OnItemClickListner mItemClickListener;



    public MyRecyclerViewAdapter( int vType , DatabaseHelper db , Context context){
        this.vType = vType ;
        myDB = db ;
        mDataSet = myDB.getAllMovies(1) ;
        mContext = context ;
    }

    public void setDB(DatabaseHelper myDB, int i) {
        this.myDB= myDB;
        this.tableId=i;
        mDataSet=myDB.getAllMovies(i);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imgIcon;
        public TextView  tTitle;
        public TextView  dDescription;
        public TextView  mRating;
        public ImageView popup;
        public ViewHolder (View v){
            super(v);
            //Implement filling data;
            imgIcon = (ImageView)v.findViewById(R.id.imgView);
            tTitle = (TextView) v.findViewById(R.id.mName);
            dDescription = (TextView)v.findViewById(R.id.mDesc);
            popup = (ImageView) v.findViewById(R.id.popup);
            v.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if(mItemClickListener != null)
                        mItemClickListener.onItemClick(v,getAdapterPosition());
                }
            });
            v.setOnLongClickListener(new View.OnLongClickListener(){
                @Override
                public boolean onLongClick(View v){
                    if(mItemClickListener != null)
                        mItemClickListener.onItemLongClick(v,getAdapterPosition());
                    return true;
                }
            });
            popup.setOnLongClickListener(new View.OnLongClickListener(){
                @Override
                public boolean onLongClick(View v){
                    if(mItemClickListener != null)
                        mItemClickListener.onOverFlowMenuClick(v,getAdapterPosition());
                    return true;
                }
            });

        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View V = null;

        V = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_recycler, parent, false);
        return new ViewHolder(V);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position){
        movie = mDataSet.get(position);
        //final MyMovie movie = movieData.get(position);
        String url = "http://image.tmdb.org/t/p/w185/";
        Picasso.with(mContext).load(url+movie.getPoster()).into(holder.imgIcon);

        //Setting title and Description
        holder.tTitle.setText (( String ) movie.getTitle () );
        String str = (( String ) movie.getOverview() );
        holder.dDescription.setText (str);


        holder.popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mItemClickListener!=null)
                    mItemClickListener.onOverFlowMenuClick(v,position);
            }
        });
    }


    @Override
    public int getItemCount()
    {
        return mDataSet.size();
    }


    public void setOnClickListner( OnItemClickListner mItemClickListener){
        this.mItemClickListener = mItemClickListener;
    }

    public interface OnItemClickListner{
        public void onItemClick(View v, int position);
        public  void onItemLongClick(View v, int position);
        public void onOverFlowMenuClick(View v, int position);
    }
}



