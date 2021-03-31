package com.example.facebooknew.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebooknew.R;
import com.example.facebooknew.pogo.PostModel;

import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {
        private ArrayList<PostModel>postModels = new ArrayList<>();

    public void setPostModels(ArrayList<PostModel> postModels) {
        this.postModels = postModels;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.posts_item,parent,false);
        return new PostsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {
        PostModel postModel =  postModels.get(position);
        if(postModel!=null){
            holder.userid.setText(String.valueOf(postModel.getUserId()) );
            holder.title.setText(postModel.getTitle());
            holder.body.setText(postModel.getBody());

        }
    }

    @Override
    public int getItemCount() {
        return postModels.size();
    }

    public class PostsViewHolder extends RecyclerView.ViewHolder{
            TextView userid,title,body;
        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);
            userid = itemView.findViewById(R.id.post_userid);
            title = itemView.findViewById(R.id.post_title);
            body = itemView.findViewById(R.id.post_body);
        }
    }
}
