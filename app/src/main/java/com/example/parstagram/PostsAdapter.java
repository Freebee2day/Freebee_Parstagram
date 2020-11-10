package com.example.parstagram;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    List<Post> listOfPost;
    Context fromcontext;

    public PostsAdapter(List<Post> listOfPost,Context context) {
        this.listOfPost = listOfPost;
        fromcontext= context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View postview =  LayoutInflater.from(fromcontext).inflate(R.layout.post_item,parent,false);
        return new ViewHolder(postview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post single_post= listOfPost.get(position);
        holder.bind(single_post);
    }

    @Override
    public int getItemCount() {
        return listOfPost.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivPost;
        TextView tvDescription;
        TextView tvName;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPost=itemView.findViewById(R.id.ivPost);
            tvDescription=itemView.findViewById(R.id.tvDescription);
            tvName=itemView.findViewById(R.id.tvName);
        }

        public void bind(Post single_post) {
            tvDescription.setText(single_post.getDes());
            tvName.setText(single_post.getUser().getUsername());
            ParseFile image= single_post.getImage();
            if (image!=null) {
                Glide.with(fromcontext).load(image.getUrl()).into(ivPost);
            }
        }
    }
}
