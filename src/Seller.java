import java.util.HashMap;
import java.util.Map;

public class Seller extends Human {
    private final Map<Item, Integer> items = new HashMap<>();
    private final Map<Item, Integer> shoppingCart = new HashMap<>();

    public Seller(String name, double money, int loveIndex) {
        super(name, money, loveIndex);
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    public Map<Item, Integer> getShoppingCart() {
        return shoppingCart;
    }

    public void printStorage() {
        int count = 1;
        System.out.println("* " + this.getName() + "'Storage *");
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            System.out.println(count++ + ". " + entry.getKey().getNameOfItem() + " ______ " + entry.getValue() + " pcs.");
        }
    }

    public void printShoppingCart(Consumer consumer) {
        int count = 1;
        System.out.println("* " + consumer.getName() + "Shopping Cart *");
        for (Map.Entry<Item, Integer> entry : shoppingCart.entrySet()) {
            System.out.println(count++ + ". " + entry.getKey().getNameOfItem() + " ______ " + entry.getValue() + " pcs.");
        }
    }

    public void addToStorage(Item item, int qt) {
        items.putIfAbsent(item, 0);
        items.put(item, items.get(item) + qt);
    }

    public void addToCart(Item item, int qt) {
        if (items.containsKey(item) && items.get(item) >= qt) {
            shoppingCart.putIfAbsent(item, 0);
            shoppingCart.put(item, shoppingCart.get(item) + qt);
            if (items.get(item) == qt) {
                items.remove(item);
            } else items.put(item, items.get(item) - qt);
        } else if (!items.containsKey(item)) {
            System.out.println(this.getName() + ": do not have" + item.getNameOfItem() + " in our store.");
        }
    }

    public void addToCart(Consumer consumer) {
        for (Map.Entry<Item, Integer> entry : consumer.getWishList().entrySet()) {
            addToCart(entry.getKey(), entry.getValue());
        }
    }
}