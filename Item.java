/**
 * it represents an item/product in the inventory
 * 
 * @author Hazem Magdy
 * @version 1.0
 * @since 2023-5-5
 */
public class Item {
    private String name;
    private int id;
    private String description;
    private String category;
    private String unit;
    private double quantity;
    private double price;

    /**
     * This is the constructor of the class.
     * 
     * @param name
     * @param id
     * @param description
     * @param category
     * @param unit
     * @param quantity
     * @param price
     */
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

    /**
     * This method returns the name of the item.
     * 
     * @return String name
     */
    public String get_name() {
        return this.name;
    }

    /**
     * This method returns the id of the item.
     * 
     * @return int id
     */
    public int get_id() {
        return this.id;
    }

    /**
     * This method returns the description of the item.
     * 
     * @return String description
     */
    public String get_description() {
        return this.description;
    }

    /**
     * This method returns the category of the item.
     * 
     * @return String category
     */
    public String get_category() {
        return this.category;
    }

    /**
     * This method returns the unit of the item.
     * 
     * @return String unit
     */
    public String get_unit() {
        return this.unit;
    }

    /**
     * This method returns the quantity of the item.
     * 
     * @return double quantity
     */
    public double get_quantity() {
        return this.quantity;
    }

    /**
     * This method returns the price of the item.
     * 
     * @return double price
     */
    public double get_price() {
        return this.price;
    }

    /**
     * This method sets the quantity of the item
     * 
     * @param quantity
     */
    public void set_quantity(double quantity) {
        this.quantity = quantity;
    }

    /**
     * This method overrides the toString method to display the item's information.
     * 
     * @return String item's information
     */
    @Override
    public String toString() {
        return "\tItem: " + this.name
                + "\n\t" + "ID: " + this.id
                + "\n\t" + "Description: " + this.description
                + "\n\t" + "Unit: " + this.unit
                + "\n\t" + "Price: " + "$" + this.price + "\n\t";
    }
}