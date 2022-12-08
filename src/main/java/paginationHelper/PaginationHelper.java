package paginationHelper;

public class PaginationHelper {

    /*
    *   Getters / Setters
    */
    public String[] getArrOfVals() {
        return arrOfVals;
    }

    public void setArrOfVals(String[] arrOfVals) {
        this.arrOfVals = arrOfVals;
    }

    public int getHowManyItems() {
        return howManyItems;
    }

    public void setHowManyItems(int howManyItems) {
        this.howManyItems = howManyItems;
    }

    /*
     *   Fields
     */
    private String[] arrOfVals = null;
    private int howManyItems = 0;

    /*
     *  CStor
     */
    PaginationHelper(String[] vals, int items) {
        setArrOfVals(vals);
        setHowManyItems(items);
    }

    /*
     *  Public Methods
     */

    // count the number of pages
    public int pageCount() {
        return arrOfVals.length;
    }

    // count the number of items
    public int itemCount() {
        return getHowManyItems();
    }

    public int pageItemCount(int idx) {

        // placeholder
        return 0;
    }

    public int pageIndex(int idx) {

        // placeholder
        return 0;
    }

}
