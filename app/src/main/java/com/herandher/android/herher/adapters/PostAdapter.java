package com.herandher.android.herher.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.herandher.android.herher.R;
import com.herandher.android.herher.models.Post;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Afnan A. A. Abed on 10/25/2018.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private CustomItemClickListener mCallback;
    private View rootView;
    private ArrayList<Post> mItems;

    public PostsAdapter(ArrayList<Post> items, CustomItemClickListener listener) {
        this.mItems = items;
        mCallback = listener;
    }

    @NonNull
    @Override
    public PostsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        rootView = inflater.inflate(R.layout.item_post, parent, false);

        final ViewHolder viewHolder = new ViewHolder(rootView);
//        rootView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mCallback.onItemClick(v, viewHolder.getPosition());
//
//            }
//        });

        return viewHolder;
    }

    public interface CustomItemClickListener {
        void onItemClick(View view, int position);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapter.ViewHolder holder, int position) {
        Post post = mItems.get(position);
        holder.username.setText(post.getUsername());
        holder.userImage.setImageResource(post.getUserImage());
        holder.postText.setText(post.getPostText());
        holder.postImage.setImageResource(post.getPostImage());

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView username;
        CircleImageView userImage;
        TextView postText;
        ImageView postImage;

        // Define what is inside every row
        public ViewHolder(View rootView) {
            super(rootView);
            username = rootView.findViewById(R.id.group_user_name);
            userImage = rootView.findViewById(R.id.group_user_image);
            postText = rootView.findViewById(R.id.group_post_text);
            postImage = rootView.findViewById(R.id.group_post_image);
        }
    }
}

