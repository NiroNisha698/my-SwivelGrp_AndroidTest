package com.example.mihkh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class movieList extends AppCompatActivity {

    private RecyclerView recyclerView;


    SwipeRefreshLayout swipeRefreshLayout;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);




        recyclerView = findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        List<ModelClass> modelClassList = new ArrayList<>();

        modelClassList.add(new ModelClass(R.drawable.ic_launcher_background,"Movie one","Hello this is movie one"));
        modelClassList.add(new ModelClass(R.drawable.ic_launcher_background,"Movie two","Hello this is movie two"));
        modelClassList.add(new ModelClass(R.drawable.ic_launcher_background,"Movie three","Hello this is movie three"));
        modelClassList.add(new ModelClass(R.drawable.ic_launcher_background,"Movie four","Hello this is movie four"));
        modelClassList.add(new ModelClass(R.drawable.ic_launcher_background,"Movie five","Hello this is movie five"));
        modelClassList.add(new ModelClass(R.drawable.ic_launcher_background,"Movie six","Hello this is movie six"));
        modelClassList.add(new ModelClass(R.drawable.ic_launcher_background,"Movie seven","Hello this is movie seven"));
        modelClassList.add(new ModelClass(R.drawable.ic_launcher_background,"Movie eight","Hello this is movie eight"));
        modelClassList.add(new ModelClass(R.drawable.ic_launcher_background,"Movie nine","Hello this is movie nine"));
        modelClassList.add(new ModelClass(R.drawable.ic_launcher_background,"Movie ten","Hello this is movie ten"));

        final Adapter adapter = new Adapter(modelClassList);


        swipeRefreshLayout= findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                List<ModelClass> modelClassList = new ArrayList<>();
                modelClassList.add(new ModelClass(R.drawable.ic_launcher_background,"movie1","Hello this is user m1"));
                modelClassList.add(new ModelClass(R.drawable.ic_launcher_background,"movie 2","Hello this is user m2"));
                modelClassList.add(new ModelClass(R.drawable.ic_launcher_background,"movie3","Hello this is user m3"));
                modelClassList.add(new ModelClass(R.drawable.ic_launcher_background,"movie4","Hello this is user m4"));

                adapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);


            }
        });






        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();







    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        MenuItem item = menu.findItem(R.id.action_search);
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:

                Toast.makeText(this, "Logging Out", Toast.LENGTH_SHORT).show();
                logout();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    public void logout(){
        Intent intent = new Intent(this, login.class);
        startActivity(intent);

    }




}
