import java.util.ArrayList;

/**
 * It represents the catalog of goods that user can order from.
 * 
 * @author Hazem Magdy
 * @version 1.0
 * @since 2023-5-5
 * @see Category
 * @see Item
 */
public class Catalog {
    private ArrayList<Category> categories;

    /**
     * This is the constructor of the class.
     * 
     * @param categories
     */
    public Catalog(ArrayList<Category> categories) {
        this.categories = categories;
    }

    /**
     * This method displays all the items inside the categories.
     */
    public void display_items_inside_categories() {
        for (Category category : categories) {
            System.out.println("# " + category.get_name());
            category.display_items();
        }
    }
}
