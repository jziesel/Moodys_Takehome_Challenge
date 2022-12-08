package paginationHelper;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Driver {

    @BeforeAll
    public void setup() {
    }

    @AfterAll
    public void teardown() {
    }

    @Test
    public void createPage() {
        String[] pageItems = {"a", "b", "c", "d", "e", "f"};
        int items = 4;

        PaginationHelper pgHelper = new PaginationHelper(pageItems, items);
        System.out.println("Total number of pages: " + pgHelper.pageCount());
        System.out.println("Total number of items: " + pgHelper.itemCount());
        Assert.assertEquals(pgHelper.pageCount(), pageItems.length);
        Assert.assertEquals(pgHelper.itemCount(), items);
    }

}
