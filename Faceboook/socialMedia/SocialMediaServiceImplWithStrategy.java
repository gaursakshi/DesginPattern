package Faceboook.socialMedia;

import Faceboook.paginationStartegy.PaginationStrategy;

import java.util.Collections;
import java.util.List;

public class SocialMediaServiceImplWithStrategy implements SocialMediaService {
    private SocialMediaServiceImpl delegate;
    private PaginationStrategy paginationStrategy;

    public SocialMediaServiceImplWithStrategy(PaginationStrategy paginationStrategy) {
        this.delegate = SocialMediaServiceImpl.getInstance();
        this.paginationStrategy = paginationStrategy;
    }

    @Override
    public void post(int userId, int postId, String content) {
        delegate.post(userId, postId, content);
    }

    @Override
    public void follow(int followerId, int followeeId) {
        delegate.follow(followerId, followeeId);
    }

    @Override
    public void unfollow(int followerId, int followeeId) {
        delegate.unfollow(followerId, followeeId);
    }

    @Override
    public List<Integer> getNewsFeed(int userId) {
        return delegate.getNewsFeed(userId);
    }

    @Override
    public List<Integer> getNewsFeedPaginated(Integer userId, Integer pageNumber) {
        List<Integer> feed = getNewsFeed(userId);
        return paginationStrategy.paginate(feed, pageNumber);
    }

    @Override
    public void deletePost(int postId) {
        delegate.deletePost(postId);
    }

    @Override
    public List<Integer> getUserPostList(int userId) {
        return delegate.getUserPostList(userId);
    }



}