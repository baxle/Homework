package CandyGift;


import java.util.Arrays;


public class MainClass implements CanDo {

    private static final int N = 1;
    private static int size = 0;
    private static Sweet[] sweets = new Sweet[N];


    private static void ensureCapacity(int n) {
        int oldCapacity = sweets.length;
        if (oldCapacity >= n) {
            // there's nothing to do
            return;
        }

        // grow at least in half, to minimize copying data on each add
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - n < 0)
            newCapacity = n;
        sweets = Arrays.copyOf(sweets, newCapacity);
    }

    public static void add(Sweet sweet) {
        ensureCapacity(size + 1);
        if (sweet == null) {
            System.out.println("Вы ввели null");
            throw new NullPointerException();
        } else if (sweet instanceof Cake || sweet instanceof Candy || sweet instanceof IceCream || sweet instanceof Jellybean) {
            MainClass.sweets[size++] = sweet;

        }
    }

    public static void remove() {
        if (sweets.length > 0) {
            sweets = Arrays.copyOf(sweets, sweets.length - 1);
        } else {

            System.out.println("В массиве нет элементов для удаления");
            throw new NullPointerException();
        }

    }


    public static double getTotalWeight() {
        double x = 0;
        for (int i = 0; i < sweets.length; i++) {
            x = x + sweets[i].weight;
        }
        return x;
    }


    public static int getTotalPrice() {
        int x = 0;
        for (int i = 0; i < sweets.length; i++) {
            x = x + sweets[i].price;
        }
        return x;
    }


    public static void getAllInfo() {
        System.out.println("\nИнформация о всех сладостях в подарке:");
        for (Sweet sweet : sweets) {
            System.out.println(sweet.toString());
        }
    }

  /* public static void reduceWeight(double weight) {

        double x = getTotalWeight();
        while (x > weight) {


        }

        System.out.println("Вес коробочки " +x+ " меньше входного параметра (>" + weight + ")");

    }


    public static void reducePrice(int price) {


        int x = MainClass.getTotalPrice();
        while (x > price) {

            System.out.println("\n Стомость коробочки " + x + " больше входного параметра " + price);
            Collections.sort(arrayPrice, (a, b) -> a.price < b.price ? -1 : a.price == b.price ? 0 : 1);
            System.out.println("Удаляем сладость с наименьшей ценой " +arrayPrice.get(0).price);
            x = x - arrayPrice.get(0).price;
            arrayPrice.remove(0);

        }

        System.out.println("Цена коробочки " +x +" меньше входного параметра (>" + price + ")");

    }
    */


    public static void main(String[] args) {

        add(new Cake("Prague", 615.9, 599, "Содержит алкоголь."));
        add(new Cake("Tiramisu", 700.6, 699, "Основа - бисквит."));
        add(new Candy("Raffaello", 152.2, 215, "Вкус детства."));
        add(new Candy("Toffifee", 125.0, 130, "Дешево и сердито."));
        add(new IceCream("Movenpick vanilla", 500.00, 609, "Большая упаковка."));
        add(new Jellybean("Jellybean", 40.40, 40, "Что-то интересное."));
        //add(null);

        System.out.println("Общий вес подарка: " + MainClass.getTotalWeight() + " г");
        System.out.println("Общая стоимость подарка: " + MainClass.getTotalPrice() + " руб");
        MainClass.getAllInfo();

        remove();
        remove();
        remove();
        remove();
        remove();
        //remove();
        //remove();
        System.out.println("\nПосле удаления: ");
        MainClass.getAllInfo();


        //reduceWeight(900.0);
        //  reducePrice(900);


    }


}
