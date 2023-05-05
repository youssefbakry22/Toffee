
public class Category {
    private String name;
    private Item[] items;

    public Category(String name, Item[] items) {
        this.name = name;
        this.items = items;
    }

    public String get_name() {
        return this.name;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public void add_item(Item item) { //add item
        for(int i = 0 ; i < this.items.length ; i++)
        {
            if(this.items[i] == null) //if current index is empty.
            {
                this.items[i] = item ;
                break;
            }
        }
    }

    public void display_items() {
        System.out.println("Items that is in Category: " + this.name);
        for (Item item : items) { //for each item in items_array.
            if (item != null) { //if current index is not empty .
            System.out.println(item);
            }
    }
}
}
