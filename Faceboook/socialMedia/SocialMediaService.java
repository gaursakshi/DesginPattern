package Faceboook.socialMedia;

import java.util.List;

public interface SocialMediaService {

    void post(int userId, int postId, String content);
    void follow(int followerId, int followeeId);
    void unfollow(int followerId, int followeeId);
    List<Integer> getNewsFeed(int userId);
    List<Integer> getNewsFeedPaginated(Integer userId, Integer pageNumber);
    void deletePost(int postId);
    List<Integer> getUserPostList(int userId);  // New method





}
