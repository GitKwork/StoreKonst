public class Main {
    public static void main(String[] args) {

        Seller seller = new Seller("Avito", 100000, 90);
        Consumer consumer = new Consumer("Ivan", 100, 5);

        Item sports = new Item("Bike", 25, Category.Sports);
        Item clothes = new Item("Jacket", 150, Category.Clothes);

        consumer.addToWishList(sports, 1);
        consumer.addToWishList(clothes, 2);
        seller.addToStorage(sports, 1);
        seller.addToStorage(clothes, 2);
        consumer.welcomeToStore(consumer);
        consumer.printWishList();
        System.out.println("Total cost = " + consumer.totalCost(consumer.getWishList()));
        seller.addToCart(consumer);
        seller.printShoppingCart(consumer);
        consumer.walkInStore();
        consumer.walkInStorage();
    }
}
