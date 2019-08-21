package CandyGift;
import java.util.ArrayList;
import java.util.Arrays;

public class Cat extends MainClass{
    private String name;
    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " +name;
    }



    public static void main(String[] args) {
        Cat[] catsArray = new Cat[2];
        ArrayList<Cat> catsList = new ArrayList<>(Arrays.asList(catsArray));

        catsArray[0] = new Cat("Prague");
        catsArray[1] = new Cat("Вася");


        System.out.println(catsList.toString());
    }
}
