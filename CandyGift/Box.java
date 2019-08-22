package CandyGift;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class Box implements CanDo {

    private static final int N = 1;
    private static int size = 0;
    private static Sweet[] sweets = new Sweet[N];


    private void ensureCapacity(int n) {
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

    public void add(Sweet sweet) {

        if (sweet == null) {
            System.out.println("Вы ввели null");
        } else {
            ensureCapacity(size + 1);
            if (sweet == null) {
                System.out.println("Вы ввели null");
                throw new NullPointerException();
            } else {
                Box.sweets[size++] = sweet;

            }
        }
    }

    public void remove() {
        if (sweets.length > 0) {
            sweets = Arrays.copyOf(sweets, sweets.length - 1);
        } else {

            System.out.println("В массиве нет элементов для удаления");

        }

    }


    public double getTotalWeight() {
        double x = 0;
        for (int i = 0; i < sweets.length; i++) {
            x = x + sweets[i].weight;
        }
        return x;
    }


    public int getTotalPrice() {
        int x = 0;
        for (int i = 0; i < sweets.length; i++) {
            x = x + sweets[i].price;
        }
        return x;
    }


    public void getAllInfo() {
        System.out.println("\nИнформация о всех сладостях в подарке:");
        for (Sweet sweet : sweets) {
            System.out.println(sweet.toString());
        }
        System.out.println(" ");
    }

    public void reduceWeight(double weight) {
        sweets = Arrays.copyOf(sweets, sweets.length);
        double x = getTotalWeight();
        Comparator weightComparator = new MaxWeightComparator();
        Arrays.sort(sweets, weightComparator);
        for (Sweet sweet : sweets) {
            System.out.println(sweet.toString());
        }


        while (x > weight) {
            if (sweets.length == 1) {
                System.out.println("Коробочка пуста");
                break;
            }
            System.out.println("\n Вес коробочки " + x + " больше входного параметра " + weight);
            System.out.println("Удаляем сладость с наименьшим весом " + sweets[sweets.length - 1].weight);
            x = x - sweets[sweets.length - 1].weight;
            sweets = Arrays.copyOf(sweets, sweets.length - 1);


        }
        System.out.println("Вес коробочки " + x + " меньше входного параметра (>" + weight + ")");

    }


    public  void reducePrice(int price) {
        sweets = Arrays.copyOf(sweets, sweets.length);
        int x = getTotalPrice();


        Comparator priceComparator = new MaxPriceComparator();
        Arrays.sort(sweets, priceComparator);
        for (Sweet sweet : sweets) {
            System.out.println(sweet.toString());
        }


        while (x > price) {
            if (sweets.length == 1) {
                System.out.println("Коробочка пуста");
                break;
            }
            System.out.println("\n Цена коробочки " + x + " больше входного параметра " + price);
            System.out.println("Удаляем сладость с наименьшей ценой " + sweets[sweets.length - 1].price);
            x = x - sweets[sweets.length - 1].price;
            sweets = Arrays.copyOf(sweets, sweets.length - 1);


        }
        System.out.println("Цена коробочки " + x + " меньше входного параметра (>" + price + ")");

    }
}