package CandyGift;

public class IceCream extends Gift {
    private String uniqueParameter;

    public IceCream(String name, double weight, int price, String uniqueParameter) {
        super.name = name;
        super.weight = weight;
        super.price = price;
        this.uniqueParameter = uniqueParameter;
        totalPrice += price;
        totalWeight += weight;

    }

    @Override
    public String toString() {
        return "Название: " +name + "; Вес, [г]: " +weight+ "; Цена, [руб]: " +price + "; Уникальный Параметр = " +uniqueParameter;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public String getUniqueParameter() {
        return uniqueParameter;
    }

}
