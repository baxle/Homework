package CandyGift;

public interface CanDo {
    static void add(Gift gift){}
    static void remove(int x) {
        System.out.println("Удаление элемента");
    }
    static double getWeight(){
        return Gift.totalWeight;
    }
    static int getPrice(){
        return Gift.totalPrice;
    }
    static void getAllInfo(){
        System.out.println("Информация о всех сладостях в подарке:");
    }


}
