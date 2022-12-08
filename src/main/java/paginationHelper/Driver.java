package paginationHelper;

public class Driver extends PaginationHelper {

    Driver(String[] vals, int items) {
        super(vals, items);
    }

    public static void main(String[] args) {
        String[] pageItems1 = {"a", "b", "c", "d", "e", "f"};

        // first page instance
        PaginationHelper pgHelper1 = new PaginationHelper(pageItems1, 4);
        System.out.println("Total number of pages: " + pgHelper1.pageCount());
    }
}
