package com.herandher.android.herher.models;

/**
 * Created by Afnan A. A. Abed on 10/25/2018.
 */

public class Post {
    String username;
    String postText;
    int userImage;
    int postImage;

    public Post(String username, String postText, int userImage, int postImage) {
        this.username = username;
        this.postText = postText;
        this.userImage = userImage;
        this.postImage = postImage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }

    public int getPostImage() {
        return postImage;
    }

    public void setPostImage(int postImage) {
        this.postImage = postImage;
    }
}
