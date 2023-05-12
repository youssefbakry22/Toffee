import java.util.ArrayList;

public class ShoppingCart {
       private ArrayList<Item> items;

        public ShoppingCart() {
           items=new ArrayList<Item>(100);

        }

        public ArrayList<Item> get_items() {
            // implementation of ShoppingCart.get_items
            return items;
        }

        public void add_item(Item item, double quantity) {
            // implementation of ShoppingCart.add_item
            items.add(item);
            item.set_quantity(quantity);
        }

        public void display_items() {
            // implementation of ShoppingCart.display_items
            for(int i=0;i<items.size();i++){
                System.out.print("# "+(i+1));
                System.out.print(items[i]);
                System.out.println("quantity: "+item.get_quantity());
            }
        }

        public boolean is_empty() {
            // implementation of ShoppingCart.is_empty
            if(items.size()==0){
                return true;
            }
            else {
                return false;
            }
        }

    }

