import java.util.Map;

public interface Communication {
    default double costOfItem(Item item) {
        return item.getCost();
    }

    default void isItemsAvailable(Item item, int qt, Map<Item, Integer> list) {
        if (!list.containsKey(item)) {
            System.out.println("We do not have" + item);
        } else if (qt > list.get(item)) {
            int qtstr = list.get(item);
            System.out.println("In our store there is not enough quantity " + item.getNameOfItem() +
                    " available quantity =" + qtstr + " pcs");
        } else {
            int qtstr = qt - list.get(item);
            System.out.println("You can buy more" + item.getNameOfItem()
                    + ". You can get " + qtstr + " pcs more.");
        }
    }

    default double totalCost(Map<Item, Integer> list) {
        double summ = 0;
        for (Map.Entry<Item, Integer> entry : list.entrySet()) {
            summ += entry.getKey().getCost() * entry.getValue();
        }
        return summ;
    }


    default void welcomeToStore(Consumer consumer) {
        System.out.println(consumer.getName() + "Welcome to the store");
    }
}
















