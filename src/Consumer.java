import java.util.HashMap;
import java.util.Map;

ppublic class Consumer extends Human {
    private final Map<Item, Integer> wishList = new HashMap<>();


    public Consumer(String name, double money, int loveIndex) {
        super(name, money, loveIndex);
    }

    public void addToWishList(Item item, int qt) {
        wishList.putIfAbsent(item, 0);
        wishList.put(item, wishList.get(item) + qt);
    }

    public Map<Item, Integer> getWishList() {
        return wishList;
    }
    public void printWishList() {
        int count = 1;
        System.out.println("* " + this.getName() + "Wishlist *");
        for (Map.Entry<Item, Integer> entry : wishList.entrySet()) {
            System.out.println(count++ + ". " + entry.getKey().getNameOfItem() + " ______ " + entry.getValue() + " pcs.");
        }
    }
    void notEnoughMoney() {
        double cost = totalCost(wishList);
        if (cost > this.getMoney()) {
            System.out.println("not enough money");
        } else {
            this.walkInStore();
        }
    }
    public void walkInStore() {
        System.out.println("walk in store");
    }
    public void walkInStorage() {
        System.out.println("walk in storage");
    }
}