package com.herandher.android.herher;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
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

import com.herandher.android.herher.adapters.PostsAdapter;
import com.herandher.android.herher.models.Post;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView postsRecycler;
    private PostsAdapter postsAdapter;
    private ArrayList<Post> posts;
    private SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("HER & her");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            writePost();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initialize();

        refreshLayout = findViewById(R.id.refresh_layout2);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPosts();
                refreshLayout.setRefreshing(false);
            }
        });

    }

    public void profile(View view) {
        Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    public void writePost() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Write Post");
        builder.setMessage(" ");
        builder.create().show();
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
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_group) {
            Intent intent = new Intent(HomeActivity.this, GroupActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.logout) {

        } else if (id == R.id.hope) {
            Intent intent = new Intent(HomeActivity.this, ChatbotActivity.class);
            startActivity(intent);
        } else if (id == R.id.notifications) {

        } else if (id == R.id.saved_posts) {

        } else if (id == R.id.gifts_vouches) {

        } else if (id == R.id.settings) {

        } else if (id == R.id.feedback) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void initialize() {
        postsRecycler = findViewById(R.id.group_posts_recycler2);
        postsRecycler.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false));
        posts = getPosts();
        postsAdapter = new PostsAdapter(posts, null);
        postsRecycler.setAdapter(postsAdapter);
    }

    public ArrayList<Post> getPosts() {
        posts = new ArrayList<>();
        Post demoPost1 = new Post("Jane H.", getString(R.string.text1),
                R.drawable.profile_pic, R.drawable.post_image);
        Post demoPost2 = new Post("Jane H.", getString(R.string.text2),
                R.drawable.profile_pic);
        Post demoPost3 = new Post("Jane H.", getString(R.string.text1),
                R.drawable.profile_pic, R.drawable.post_image);
        posts.add(demoPost1);
        posts.add(demoPost2);
        posts.add(demoPost3);

        return posts;
    }

}
