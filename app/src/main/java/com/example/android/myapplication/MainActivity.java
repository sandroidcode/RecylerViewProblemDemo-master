package com.example.android.myapplication;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public List<Integer> listOfValues;
    public RecViewAdapter recViewAdapter;
    public LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.rec_view);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        listOfValues = getListOfValues();
        recViewAdapter = new RecViewAdapter(listOfValues);
        mRecyclerView.setAdapter(recViewAdapter);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mRecyclerView.setOnScrollListener(new EndlessRecyclerOnScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int current_page) {
                loadMore();
            }
        });
    }

    private List<Integer> getListOfValues() {
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            values.add(i);
        }
        return values;
    }

    private void loadMore() {
        int lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
/**
 * Same result when an item removed at notified
 */
        // listOfValues.remove(lastVisibleItemPosition-3);
        // recViewAdapter.notifyItemRemoved(lastVisibleItemPosition-3);
        listOfValues.add(lastVisibleItemPosition + 1);
        recViewAdapter.notifyItemInserted(lastVisibleItemPosition + 1);
        listOfValues.add(lastVisibleItemPosition + 2);
        recViewAdapter.notifyItemInserted(lastVisibleItemPosition + 2);
        listOfValues.add(lastVisibleItemPosition + 3);
        recViewAdapter.notifyItemInserted(lastVisibleItemPosition + 3);
        listOfValues.add(lastVisibleItemPosition + 4);
        recViewAdapter.notifyItemInserted(lastVisibleItemPosition + 4);
        listOfValues.add(lastVisibleItemPosition + 5);
        recViewAdapter.notifyItemInserted(lastVisibleItemPosition + 5);
        listOfValues.add(lastVisibleItemPosition + 6);
        recViewAdapter.notifyItemInserted(lastVisibleItemPosition + 6);
        listOfValues.add(lastVisibleItemPosition + 7);
        recViewAdapter.notifyItemInserted(lastVisibleItemPosition + 7);
        listOfValues.add(lastVisibleItemPosition + 8);
        recViewAdapter.notifyItemInserted(lastVisibleItemPosition + 8);
        listOfValues.add(lastVisibleItemPosition + 9);
        recViewAdapter.notifyItemInserted(lastVisibleItemPosition + 9);
        listOfValues.add(lastVisibleItemPosition + 10);
        recViewAdapter.notifyItemInserted(lastVisibleItemPosition + 10);
        listOfValues.add(lastVisibleItemPosition + 11);
        recViewAdapter.notifyItemInserted(lastVisibleItemPosition + 11);
/**
 * Same result when items added together and then notifyDataSetChanged() called
 */
        //listOfValues.add(lastVisibleItemPosition + 1);
        //listOfValues.add(lastVisibleItemPosition + 2);
        //listOfValues.add(lastVisibleItemPosition + 3);
        //listOfValues.add(lastVisibleItemPosition + 4);
        //listOfValues.add(lastVisibleItemPosition + 5);
        //listOfValues.add(lastVisibleItemPosition + 6);
        //listOfValues.add(lastVisibleItemPosition + 7);
        // recViewAdapter.notifyDataSetChanged();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
