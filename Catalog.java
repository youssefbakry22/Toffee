public class Catalog {
    private Category[] categories;

    public Catalog(Category[] categories) {
        this.categories = categories;
    }

    public void display_categories() {
        System.out.println("Categories in the Catalog:");
        for (Category category : categories) {
            System.out.println(category.get_name());
        }
    }

    public void display_items_in_category(String category_name) {
        System.out.println("Items in Category: " + category_name);
        for (Category category : categories) {
            if (category_name == category.get_name()) {
                category.display_items();
            }
        }
        System.out.println("Category not found.");
    }

    public void search_for_item(String name) {
        System.out.println("Searching for item with name is: " + name);
        boolean is_found = false;
        for (Category category : categories) {
            for (Item item : category.get_items()) {
                if (item != null && name == item.get_name()) { 
                    System.out.println("Item is found.");
                    System.out.println(item);
                    is_found = true;
                    
                }
            }
        }
        if (!is_found) {
            System.out.println("Item not found.");
        }
    }
}
