package com.example.hdahagam.app3;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.HashMap;

public class MovieActivity extends AppCompatActivity {
    ImageView imageView;
    TextView text_title;
    TextView text_count;
    TextView text_id;
    TextView text_avg;
    TextView text_overview;
    int index=0;
    movie_data mvs = new movie_data();
    private GestureDetectorCompat gDect;
    ViewGroup.LayoutParams intial_params;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        this.gDect.onTouchEvent(event);
        boolean value = super.onTouchEvent(event);
        return  value;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_movie_data);
        imageView= (ImageView) findViewById(R.id.imageView);
        intial_params = imageView.getLayoutParams();
        intial_params.width=500;
        intial_params.height=500;
        imageView.setLayoutParams(intial_params);
        text_title = (TextView) findViewById(R.id.text_title);
        text_count = (TextView) findViewById(R.id.text_count);
        text_avg = (TextView) findViewById(R.id.text_avg);
        text_id = (TextView) findViewById(R.id.text_id);
        text_overview = (TextView) findViewById(R.id.text_overview);
        Display(index);
        gDect = new GestureDetectorCompat(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDown(MotionEvent event) {
                return true;
            }
        });
    }
                public void Display(int index) {
                HashMap<String, ?> firstItem = mvs.getItem(index);
                text_id.setText("ID:" + firstItem.get("id").toString());
                text_title.setText((firstItem.get("title").toString()));
                text_avg.setText("Voting Average:" + firstItem.get("voteAverage").toString());
                text_overview.setText("Overview" + firstItem.get("overview").toString());
                text_count.setText("Votes:" + firstItem.get("voteCount").toString());
                imageView.setImageResource((Integer) firstItem.get("image"));
            }
}