package CandyGift;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class MainClass implements CanDo {

    private static Gift[] gifts = new Gift[6];
    private static ArrayList<Gift> array = new ArrayList<>();
    private static ArrayList<Gift> arrayWeight = new ArrayList<>();
    private static ArrayList<Gift> arrayPrice = new ArrayList<>();

    public static void add(Gift gift) {
        array.add(gift);
    }


    public static void remove(int x) {
        array.remove(x);
    }


    public static int getTotalWeight() {
        return Gift.totalWeight;
    }

    public static int getTotalPrice() {
        return Gift.totalPrice;
    }


    public static void getAllInfo() {
        System.out.println("\nИнформация о всех сладостях в подарке:");
        for (Gift gift : gifts) {
            System.out.println(gift.toString());
        }
    }

    public static void reduceWeight(double weight) {

        double x = MainClass.getTotalWeight();
        while (x > weight) {

            System.out.println("\n Вес коробочки " + x + " больше входного параметра " + weight);
            Collections.sort(arrayWeight, (a, b) -> a.weight < b.weight ? -1 : a.weight == b.weight ? 0 : 1);
            System.out.println("Удаляем сладость с наименьшим весом " + arrayWeight.get(0).weight);
            x = x - arrayWeight.get(0).weight;
            arrayWeight.remove(0);

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


    public static void main(String[] args) {

        gifts[0] = new Cake("Prague", 615.9, 599, "Содержит алкоголь.");
        gifts[1] = new Cake("Tiramisu", 700.6, 699, "Основа - бисквит.");
        gifts[2] = new Candy("Raffaello", 152.2, 215, "Вкус детства.");
        gifts[3] = new Candy("Toffifee", 125.0, 130, "Дешево и сердито.");
        gifts[4] = new IceCream("Movenpick vanilla", 500.00, 609, "Большая упаковка.");
        gifts[5] = new Jellybean("Jellybean", 40.40, 40, "Что-то интересное.");

        System.out.println("Общий вес подарка: " + MainClass.getTotalWeight() + " г");
        System.out.println("Общая стоимость подарка: " + MainClass.getTotalPrice() + " руб");
        MainClass.getAllInfo();


        for (int i = 0; i < gifts.length; i++) {
            array.add(gifts[i]);
        }

        arrayWeight.addAll(0, array);
        arrayPrice.addAll(0, array);


        /*System.out.println(array);
        MainClass.remove(0);  //проверка удаления
        System.out.println(array);
        MainClass.add(new Cake("Prague", 615.9, 599, "Содержит алкоголь.")); //проверка добавления
        System.out.println(array);
        */


        reduceWeight(900.0);
        reducePrice(900);

    }


}
