public class Item {
    private String name;
    private int id;
    private String description;
    private Category category;
    private String unit;
    private double quantity;
    private double price;

    public Item(String name, int id, String description, Category category, String unit, double quantity,
            double price) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.category = category;
        this.unit = unit;
        this.quantity = quantity;
        this.price = price;
    }

    public String get_name() {
        return this.name;
    }

    public int get_id() {
        return this.id;
    }

    public String get_description() {
        return this.description;
    }

    public Category get_category() {
        return this.category;
    }

    public String get_unit() {
        return this.unit;
    }

    public double get_quantity() {
        return this.quantity;
    }

    public double get_price() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Item: " + this.name + "\n" + "ID: " + this.id + "\n" + "Description: " + this.description + "\n"
                + "Category: " + this.category + "\n" + "Unit: " + this.unit + "\n" + "Quantity: " + this.quantity
                + "\n" + "Price: " + this.price + "\n";
    }
}