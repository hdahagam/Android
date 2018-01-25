package com.example.hdahagam.app3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements OnListItemSelectedListener{

    int saveLastUsedId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar=(Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        if(savedInstanceState !=null)
        {
            saveLastUsedId = savedInstanceState.getInt("saveId");
        }
        else {
            saveLastUsedId = R.id.coverpage_id;
        }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main, CoverPageFragment.newInstance(saveLastUsedId)).commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.values_menu,menu );
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.action_one:
                saveLastUsedId = R.id.abtme_id;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main, CoverPageFragment.newInstance(saveLastUsedId)).addToBackStack(null).commit();
                return true;
            case R.id.action_two:
                Intent intent2=new Intent(MainActivity.this, ViewPageActivity.class);
                startActivity(intent2);
                return true;
            case R.id.action_three:
                Intent intent3=new Intent(MainActivity.this, MasterDetail.class);
                startActivity(intent3);
                return true;
            default:
// If we got here , the user ’s action was not recognized .
// Invoke the superclass to handle it .
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void OnListItemSelected(int postition) {
        saveLastUsedId = postition;
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main, CoverPageFragment.newInstance(postition)).addToBackStack(null).commit();
    }

    @Override
    public void onSaveInstanceState(Bundle outstate) {
        super.onSaveInstanceState(outstate);
        outstate.putInt("saveId", saveLastUsedId);
    }
}
