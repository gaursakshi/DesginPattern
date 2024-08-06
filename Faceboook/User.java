package Faceboook;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int userId;
    private List<Integer> followers;
    private List<Integer> followees;
    private List<Integer> posts;

    public User(int userId) {
        this.userId = userId;
        this.followers = new ArrayList<>();
        this.followees = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Integer> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Integer> followers) {
        this.followers = followers;
    }

    public List<Integer> getFollowees() {
        return followees;
    }

    public void setFollowees(List<Integer> followees) {
        this.followees = followees;
    }

    public List<Integer> getPosts() {
        return posts;
    }

    public void setPosts(List<Integer> posts) {
        this.posts = posts;
    }
}
