package com.herandher.android.herher;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.herandher.android.herher.adapters.PostsAdapter;
import com.herandher.android.herher.models.Post;

import java.util.ArrayList;

public class GroupActivity extends AppCompatActivity {
    private RecyclerView postsRecycler;
    private PostsAdapter postsAdapter;
    private ArrayList<Post> posts;
    private SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        Toolbar toolbar = (Toolbar) findViewById(R.id.group_toolbar);
        setSupportActionBar(toolbar);
        // Displaying the back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Setting the title of the toolbar
        getSupportActionBar().setTitle("Level Group");

        initialize();

        refreshLayout = findViewById(R.id.refresh_layout);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPosts();
                refreshLayout.setRefreshing(false);
            }
        });
    }

    public void initialize() {
        postsRecycler = findViewById(R.id.group_posts_recycler);
        postsRecycler.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false));
        posts = getPosts();
        postsAdapter = new PostsAdapter(posts, null);
        postsRecycler.setAdapter(postsAdapter);
    }

    public ArrayList<Post> getPosts() {
        posts = new ArrayList<>();
        Post demoPost1 = new Post("Jane H.", getString(R.string.text1),
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background);
        Post demoPost2 = new Post("Jane H.", getString(R.string.text2),
                R.drawable.ic_launcher_background);
        Post demoPost3 = new Post("Jane H.", getString(R.string.text1),
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background);
        posts.add(demoPost1);
        posts.add(demoPost2);
        posts.add(demoPost3);

        return posts;
    }

    // Code for the back arrow
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
