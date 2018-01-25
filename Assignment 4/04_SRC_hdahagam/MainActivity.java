package com.example.hdahagam.app4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hdahagam.app4.CoverPage;
import com.example.hdahagam.app4.R;

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
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main, CoverPage.newInstance(saveLastUsedId)).commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.values,menu );
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.action_one:
                 saveLastUsedId = R.id.abtme_id;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main, CoverPage.newInstance(saveLastUsedId)).addToBackStack(null).commit();
                return true;
            case R.id.action_two:
                Intent intent2=new Intent(this, MovieActivity.class);
               startActivity(intent2);
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
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main, CoverPage.newInstance(postition)).addToBackStack(null).commit();
    }

    @Override
    public void onSaveInstanceState(Bundle outstate) {
        super.onSaveInstanceState(outstate);
        outstate.putInt("saveId", saveLastUsedId);
    }
}
