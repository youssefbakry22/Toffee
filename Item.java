public class Item {
    private String name;
    private int id;
    private String description;
    private String category;
    private String unit;
    private double quantity;
    private double price;

    public Item(String name, int id, String description, String category, String unit, double quantity,
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

    public String get_category() {
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

    public void set_quantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "\tItem: " + this.name
                + "\n\t" + "ID: " + this.id
                + "\n\t" + "Description: " + this.description
                + "\n\t" + "Unit: " + this.unit
                + "\n\t" + "Price: " + "$" + this.price + "\n\t";
    }
}
