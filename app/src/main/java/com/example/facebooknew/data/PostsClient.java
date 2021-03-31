package com.example.facebooknew.data;

import com.example.facebooknew.pogo.PostModel;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    private PostResponse postResponse;
    private PostsClient Instance;
    private Retrofit retrofit;

    public PostsClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                // to convert from retrofit call to rxjava
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        postResponse = retrofit.create(PostResponse.class);
    }

    public PostsClient getInstance() {
        if(Instance==null){
            Instance = new PostsClient();
        }
        return Instance;
    }
    public Observable<List<PostModel>> getPosts(){

        return postResponse.getPosts();
    }
}
