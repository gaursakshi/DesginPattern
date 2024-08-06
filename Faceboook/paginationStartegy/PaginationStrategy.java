package Faceboook.paginationStartegy;

import java.util.List;

public interface PaginationStrategy {
    List<Integer> paginate(List<Integer> feed, int pageNumber);
}

