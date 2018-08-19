package com.abani.exercise.android.byjuclone;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import android.widget.TextView;

import com.abani.exercise.android.byjuclone.adapters.MyCardAdapter;
import com.abani.exercise.android.byjuclone.adapters.MyCornerAdapter;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView tvWish, tvName, tvShare, tvToolbar;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private RecyclerView mCRecyclerView;
    private RecyclerView.Adapter mCAdapter;
    private RecyclerView.LayoutManager mCLayoutManager;

    private AppBarLayout appBarLayout;
    private ScrollView scrollView;
    private boolean scrollFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvWish = findViewById(R.id.tv_wish);
        tvName = findViewById(R.id.tv_name);
        tvShare = findViewById(R.id.text_share);
        tvToolbar = findViewById(R.id.txt_toolbar);

        Shader textShader=new LinearGradient(0, 0, 150, 20,
                new int[]{Color.parseColor("#9C27B0"), Color.BLUE},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        tvName.getPaint().setShader(textShader);

        tvWish.getPaint().setShader(textShader);

        tvShare.getPaint().setShader(textShader);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);


        mRecyclerView = (RecyclerView) findViewById(R.id.rv_study_cards);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyCardAdapter(new String[]{"0", "1", "2", "3", "4", "5"}, this);
        mRecyclerView.setAdapter(mAdapter);

        mCRecyclerView = (RecyclerView) findViewById(R.id.rv_corner);

        mCRecyclerView.setHasFixedSize(true);

        mCLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mCRecyclerView.setLayoutManager(mCLayoutManager);

        mCAdapter = new MyCornerAdapter(new String[]{"0", "1", "2", "3", "4", "5"}, this);
        mCRecyclerView.setAdapter(mCAdapter);

        appBarLayout = findViewById(R.id.app_bar);

        appBarLayout.bringToFront();

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_hamburgar);


        scrollView = findViewById(R.id.scrollView);
        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                int scrollY = scrollView.getScrollY();
                if (scrollY > 100){
                    if (!scrollFlag) {
                        toolbar.setBackgroundColor(Color.WHITE);
                        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_hamburgar_2);
                        tvToolbar.setVisibility(View.VISIBLE);
                        scrollFlag = true;
                    }
                } else {
                    if (scrollFlag) {
                        toolbar.setBackgroundColor(Color.TRANSPARENT);
                        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_hamburgar);
                        tvToolbar.setVisibility(View.INVISIBLE);
                        scrollFlag = false;
                    }
                }
            }
        });
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_call) {
            // Handle the camera action
        } else if (id == R.id.nav_redeem) {

        } else if (id == R.id.nav_parent) {

        } else if (id == R.id.nav_subscribe) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_terms) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
