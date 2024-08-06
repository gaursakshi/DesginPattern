package Faceboook.paginationStartegy;


import java.util.ArrayList;
import java.util.List;

public class DefaultPagingStrategy implements PaginationStrategy {
    private static final int PAGE_SIZE = 3;

    @Override
    public List<Integer> paginate(List<Integer> feed, int pageNumber) {
        int start = (pageNumber - 1) * PAGE_SIZE;
        int end = Math.min(start + PAGE_SIZE, feed.size());
        if (start > feed.size()) {
            return new ArrayList<>();
        }
        return feed.subList(start, end);
    }
}