package com.example.facebooknew.ui.main;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.facebooknew.data.PostsClient;
import com.example.facebooknew.pogo.PostModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {
    PostsClient postsClient = new PostsClient();
    MutableLiveData<List<PostModel>> postMutableLiveData = new MutableLiveData<>();
    MutableLiveData<String>postLiveData= new MutableLiveData<>();

  //  public void getPosts(){

 //       postsClient.getInstance().getPosts().enqueue(new Callback<List<PostModel>>() {
//            @Override
 //           public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
  //              postMutableLiveData.setValue(response.body());
  //          }

 //           @Override
//            public void onFailure(Call<List<PostModel>> call, Throwable t) {
 //               postLiveData.setValue("error");
  //          }
   //     });


  //  }

    //to convert from CallBack to Observer (from retrofit to rxjava)
     public void getPosts() {

         Observable observable = postsClient.getInstance().getPosts()
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread());

         Observer<List<PostModel>> observer = new Observer<List<PostModel>>() {
             @Override
             public void onSubscribe(@NonNull Disposable d) {

             }

             @Override
             public void onNext(@NonNull List<PostModel> postModels) {
            postMutableLiveData.setValue(postModels);
             }

             @Override
             public void onError(@NonNull Throwable e) {
                postLiveData.setValue(e.getMessage());

             }

             @Override
             public void onComplete() {

             }
         };
         observable.subscribe(observer);
     }

}
