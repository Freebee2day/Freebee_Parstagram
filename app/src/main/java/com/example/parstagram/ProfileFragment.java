package com.example.parstagram;

import android.util.Log;

import com.example.parstagram.fragments.PostsFragment;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class ProfileFragment extends PostsFragment {

    @Override
    protected void queryPost() {
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.setLimit(20);
        query.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser());
        query.addDescendingOrder(Post.KEY_CREATED_AT);
        query.include(Post.KEY_USER);
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> objects, ParseException e) {
                if(e!=null){
                    Log.i(TAG, "fail to load post from DB");
                    return;
                }
                for(Post post: objects){
                    Log.i(TAG, "successfully load post from DB: "+ post.getUser().getUsername());
                    collection.addAll(objects);
                    adapter.notifyDataSetChanged();
                }
            }
        });

    }
}
