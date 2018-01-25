package com.example.hdahagam.app2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class Main3Activity extends AppCompatActivity implements OnClickListener {
    private TextView _screen;
    private String s1, s2, s3, s, sym;
    private Integer num1, num2, output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        _screen = (TextView)findViewById(R.id.calc_scr);
        s = "";
    }
    public void onClick(View v){
        Button button = (Button) v;
        s += button.getText().toString();
        _screen.setText(s);

    }
    public void onClickSigns(View v){
        Button button = (Button) v;
        sym = ((Button) v).getText().toString();
        _screen.setText(sym);
        num1 = Integer.parseInt(s);
        s ="";
    }

    public void reset(View v)
    {
        Button button = (Button) v;
        sym = ((Button) v).getText().toString();
        num1 =null;
        num2 =null;
        output =null;
        s ="";
        _screen.setText("0");
    }
    public void calculate(View v){

        if(output !=null)
        {
            num1 = output;
        }
        Button button = (Button) v;
        s2 = _screen.getText().toString();
        num2 = Integer.parseInt(s2);
        if (sym.equals("+"))
        {
            Log.w("Inside w","");
            output = num1 + num2;
        }
        else if (sym.equals("-")){
            output = num1 - num2;
        }
        else if (sym.equals("*")){
            output = num1 * num2;
        }
        else if (sym.equals("/"))
        {
            if(num2 ==0) {
                Toast.makeText(Main3Activity.this, "Not Defined", Toast.LENGTH_SHORT).show();
                return;
            }
            output = num1 / num2;
        }
        else if (sym.equals("%")){
            output = num1 % num2;
        }
        _screen.setText(output.toString());
    }

}
