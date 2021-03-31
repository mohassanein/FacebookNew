package com.example.facebooknew.data;

import com.example.facebooknew.pogo.PostModel;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostResponse {

 //   @GET("posts")
  //  public Call<List<PostModel>>getPosts();

    @GET("posts")
    public Observable<List<PostModel>> getPosts();
}
