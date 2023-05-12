public class Catalog {
    private Category[] categories;

    public Catalog(Category[] categories) {
        this.categories = categories;
    }

    public void display_items_inside_categories() {
        for (Category category : categories) {
            if (category == null) {
                break;
            }
            System.out.println("# " + category.get_name());
            category.display_items();
        }
    }
}
