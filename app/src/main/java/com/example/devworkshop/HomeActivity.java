package com.example.devworkshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private ListView listview;
    private ArrayList<Startup> startups;
    private ArrayAdapter<Startup> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mAuth = FirebaseAuth.getInstance();
        listview = findViewById(R.id.listview_home);
        startups = new ArrayList<Startup>();
        arrayAdapter = new StartupArrayAdapter(this,R.layout.startup_row, startups);
        listview.setAdapter(arrayAdapter);
        startups.add(new Startup("Objective", "misinformation",true));
        startups.add(new Startup("I really dont know", "problems",false));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.signout){
            mAuth.signOut();
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        return true;
    }
}