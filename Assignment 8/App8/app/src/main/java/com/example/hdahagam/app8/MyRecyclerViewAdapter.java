package com.example.hdahagam.app8;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    public List<Map<String, ?>> mDataSet;
    private Context mContext;
    //MovieData movieData = new MovieData();
    public Map <String ,?> movie;
    //HashMap<String,?> movie;
    //public OnItemClickListner mItemOnClickListener;
     OnItemClickListner mItemClickListener;
    LruCache mImgMemoryCache;

    public MyRecyclerViewAdapter(Context myContext, List<Map<String, ?>>  myDataSet){
           mContext = myContext;
           mDataSet = myDataSet;
        if( mImgMemoryCache == null ){
            final int maxMemory = ( int) ( Runtime . getRuntime () . maxMemory () / 1024) ;
            final int cacheSize = maxMemory /16;
            mImgMemoryCache = new LruCache < String , Bitmap>( cacheSize ){
                @Override
                protected int sizeOf ( String key , Bitmap bitmap ){
                    return bitmap . getByteCount () / 1024;
                }
            };
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imgIcon;
        public TextView  tTitle;
        public TextView  dDescription;
        //public CheckBox cCheckBox;
        public TextView  mRating;
        public ImageView popup;
        //public Button selectall,clearall,delete,sort;


        public ViewHolder (View v){
            super(v);
            //Implement filling data;
            imgIcon = (ImageView)v.findViewById(R.id.imgView);
            tTitle = (TextView) v.findViewById(R.id.mName);
            dDescription = (TextView)v.findViewById(R.id.mDesc);
            popup = (ImageView) v.findViewById(R.id.popup);
         //   mRating = (TextView)v.findViewById(R.id.mRating);


            //Implement onclick listener for view
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


    final class MyDownloadImageAsyncTask extends AsyncTask< String , Void , Bitmap > {
        private final WeakReference<ImageView> imageViewWeakReference;
        public MyDownloadImageAsyncTask ( ImageView imageView ){
            imageViewWeakReference = new WeakReference<ImageView>(imageView);
        }
        @Override
        protected Bitmap doInBackground ( String ... urls ) {
            Bitmap result = MyUtility . downloadImageusingHTTPGetRequest ( urls [0]) ;
            if( result != null ) {
               mImgMemoryCache . put ( urls [0] , result ) ;
            }
            return result ;
        }
        @Override
        protected void onPostExecute ( final Bitmap result ) {
            if( result != null ) {
                final ImageView imageView = imageViewWeakReference . get () ;
                if( imageView != null ){
                    imageView . setImageBitmap ( result );
                }
            }
        }
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position){
         movie = mDataSet.get(position);
        Bitmap bitmap = (Bitmap)mImgMemoryCache . get (( String ) movie . get ( "poster" ));
        if( bitmap != null ){
            holder.imgIcon . setImageBitmap ( bitmap ) ;
        }
        else {
            MyDownloadImageAsyncTask task = new MyDownloadImageAsyncTask(holder.imgIcon);
            task.execute((String) movie.get("poster"));
        }
       // holder.imgIcon.setImageResource(( Integer )movie.get ("image")) ;
        holder.tTitle.setText(( String)movie.get("title"));
        holder.dDescription.setText(( String )movie.get ("overview") );
        //Double d = (Double) movie.get("voteAverage");
        //String s = d.toString();
       // holder.mRating.setText(s);

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



