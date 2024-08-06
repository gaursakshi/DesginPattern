package Faceboook.socialMedia;

import Faceboook.Post;
import Faceboook.User;

import java.util.Collections;
import java.util.List;

import java.util.*;

public class SocialMediaServiceImpl implements SocialMediaService {
    private static SocialMediaServiceImpl instance;
    private Map<Integer, User> users;
    private Map<Integer, Post> posts;

    private SocialMediaServiceImpl() {
        users = new HashMap<>();
        posts = new HashMap<>();
    }

    public static synchronized SocialMediaServiceImpl getInstance() {
        if (instance == null) {
            instance = new SocialMediaServiceImpl();
        }
        return instance;
    }

    @Override
    public void post(int userId, int postId, String content) {
        Post post = new Post(postId, userId, content);
        posts.put(postId, post);
        if (!users.containsKey(userId)) {
            users.put(userId, new User(userId));
        }
        User user = users.get(userId);
        user.getPosts().add(0, postId);
        notifyFollowers(userId, postId);
    }

    @Override
    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            users.put(followerId, new User(followerId));
        }
        if (!users.containsKey(followeeId)) {
            users.put(followeeId, new User(followeeId));
        }
        User follower = users.get(followerId);
        User followee = users.get(followeeId);
        follower.getFollowees().add(followeeId);
        followee.getFollowers().add(followerId);
    }

    @Override
    public void unfollow(int followerId, int followeeId) {
        if (users.containsKey(followerId) && users.containsKey(followeeId)) {
            User follower = users.get(followerId);
            User followee = users.get(followeeId);
            follower.getFollowees().remove(Integer.valueOf(followeeId));
            followee.getFollowers().remove(Integer.valueOf(followerId));
        }
    }

    @Override
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        if (users.containsKey(userId)) {
            User user = users.get(userId);
            for (Integer followeeId : user.getFollowees()) {
                feed.addAll(users.get(followeeId).getPosts());
            }
        }
        Collections.sort(feed, Collections.reverseOrder());
        return feed;
    }

    @Override
    public List<Integer> getNewsFeedPaginated(Integer userId, Integer pageNumber) {
        List<Integer> feed = getNewsFeed(userId);
        int pageSize = 10; // Example page size
        int start = (pageNumber - 1) * pageSize;
        int end = Math.min(start + pageSize, feed.size());
        if (start > feed.size()) {
            return new ArrayList<>();
        }
        return feed.subList(start, end);
    }

    @Override
    public void deletePost(int postId) {
        if (posts.containsKey(postId)) {
            Post post = posts.get(postId);
            User user = users.get(post.getUserId());
            user.getPosts().remove(Integer.valueOf(postId));
            posts.remove(postId);
        }
    }

    private void notifyFollowers(int userId, int postId) {
        User user = users.get(userId);
        for (Integer followerId : user.getFollowers()) {
            // Notify followers (could be implemented with Observer pattern)
            System.out.println("Notifying user " + followerId + " about post " + postId);
        }
    }


    @Override
    public List<Integer> getUserPostList(int userId) {
        if (users.containsKey(userId)) {
            List<Integer> userPosts = new ArrayList<>(users.get(userId).getPosts());
            System.out.println(String.format("Fetched posts for user %s: %s", userId, userPosts));
            return userPosts;
        } else {
            System.out.println(String.format("User % does not exist", userId));
            return new ArrayList<>();
        }
    }
}
