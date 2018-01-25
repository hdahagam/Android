package com.example.hdahagam.app2;

import android.support.design.widget.Snackbar;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import static com.example.hdahagam.app2.R.id.textView;

public class Main4Activity extends AppCompatActivity {
    ImageView imageView;
    TextView text_title;
    TextView text_count;
    TextView text_id;
    TextView text_avg;
    TextView text_path;
    SeekBar seekBar;
    int index=0;
    MovieData mvs = new MovieData();
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
        setContentView(R.layout.activity_main4);
        imageView= (ImageView) findViewById(R.id.imageView);
        intial_params = imageView.getLayoutParams();
        intial_params.width=500;
        intial_params.height=500;
        imageView.setLayoutParams(intial_params);
        text_title = (TextView) findViewById(R.id.text_title);
        text_count = (TextView) findViewById(R.id.text_count);
        text_avg = (TextView) findViewById(R.id.text_avg);
        text_id = (TextView) findViewById(R.id.text_id);
        text_path = (TextView) findViewById(R.id.text_path);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        Display(index);
        gDect = new GestureDetectorCompat(this, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onDown(MotionEvent event)
            {
                return true;
            }
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
                boolean result = false;
                try {
                    float diffX = e2.getX() - e1.getX();
                    if (Math.abs(diffX) > 100 && Math.abs(velocityX) > 100) {
                        if (diffX > 0) {
                            if(index >= 1 )
                            {
                                index -=1;
                                Display(index);
                            }
                        } else {

                            if(index < (mvs.getSize()-1) )
                            {
                                index +=1;
                                Display(index);
                            }
                        }
                        result = true;
                    }

                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                return result;
            }
        });
        imageView.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                seekBar.setProgress(50);
                imageView.setLayoutParams(intial_params);
                return true;
            }
        });

        //Short Click
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Main4Activity.this,"image short clicked",Toast.LENGTH_LONG).show();
                Snackbar.make(v,"short clicked",Snackbar.LENGTH_LONG).show();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                ViewGroup.LayoutParams params = imageView.getLayoutParams();
                params.width=progress*10;
                params.height=progress*10;
                imageView.setLayoutParams(params);
        }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }});
    }
    public void Display(int index)
    {
        HashMap<String, ?> firstItem = mvs.getItem(index);
        text_id.setText("ID:"+firstItem.get("id").toString());
        text_title.setText((firstItem.get("title").toString()));
        text_avg.setText("Voting Average:"+firstItem.get("voteAverage").toString());
        text_path.setText("Poster path:"+firstItem.get("poster").toString());
        text_count.setText("Votes:"+firstItem.get("voteCount").toString());
        imageView.setImageResource((Integer)firstItem.get("image"));
    }

}
