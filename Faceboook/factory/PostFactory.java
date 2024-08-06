package Faceboook.factory;

import Faceboook.Post;

public class PostFactory {
    public static Post createPost(int postId, int userId, String content) {
        return new Post(postId, userId, content);
    }
}