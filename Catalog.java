import java.util.ArrayList;

public class Catalog {
    private ArrayList<Category> categories;

    public Catalog(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public void display_items_inside_categories() {
        for (Category category : categories) {
            System.out.println("# " + category.get_name());
            category.display_items();
        }
    }
}
