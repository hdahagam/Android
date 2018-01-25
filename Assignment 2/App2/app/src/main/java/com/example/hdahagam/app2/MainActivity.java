package com.example.hdahagam.app2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Menu;
import android.content.Intent;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar=(Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_menu,menu );
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.action_one:
                Intent intent=new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_two:
                Intent intent2=new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent2);
                return true;
            case R.id.action_three:
                Intent intent3=new Intent(MainActivity.this, Main3Activity.class);
                startActivity(intent3);
                return true;
            case R.id.action_four:
                Intent intent4=new Intent(MainActivity.this, Main4Activity.class);
                startActivity(intent4);
                return true;
            default:
// If we got here , the user ’s action was not recognized .
// Invoke the superclass to handle it .
                return super.onOptionsItemSelected(item);
        }
    }
}
