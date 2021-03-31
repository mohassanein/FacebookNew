package com.example.facebooknew.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.facebooknew.R;
import com.example.facebooknew.pogo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private PostViewModel postViewModel;
RecyclerView recyclerView;
PostsAdapter postsAdapter;
RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postViewModel = new ViewModelProvider(this).get(PostViewModel.class);
        initview();
        postViewModel.getPosts();
        postViewModel.postMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                postsAdapter.setPostModels((ArrayList<PostModel>) postModels);
            }
        });
    }
    private void initview(){
        recyclerView = findViewById(R.id.posts_recycler);
        postsAdapter = new PostsAdapter();
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(postsAdapter);
    }
}