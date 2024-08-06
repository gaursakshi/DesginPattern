package Faceboook;

import Faceboook.paginationStartegy.DefaultPagingStrategy;
import Faceboook.socialMedia.SocialMediaService;
import Faceboook.socialMedia.SocialMediaServiceImplWithStrategy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SocialMediaService service = new SocialMediaServiceImplWithStrategy(new DefaultPagingStrategy());

        // Users create posts
        service.post(1, 101, "First post by user 1");

        service.post(2, 102, "First post by user 2");
        service.post(2, 103, " Second post by user 2");
        service.post(2,104,"Third post by user 2 ");
        service.post(2,105,"Third post by user 2 ");

        // Users follow each other
        service.follow(1, 2);
        service.follow(2, 1);



        // Get news feed
        List<Integer> newsFeed = service.getNewsFeed(1);
        System.out.println("News Feed for user 1: " + newsFeed);

        // Get paginated news feed
        List<Integer> paginatedNewsFeed = service.getNewsFeedPaginated(1, 1);
        System.out.println("Paginated News Feed for user 1: " + paginatedNewsFeed);

        // Unfollow
       // service.unfollow(1, 2);

        // Delete a post
        service.deletePost(104);

        System.out.println(service.getUserPostList(1));
        System.out.println(service.getUserPostList(2));

    }
}
