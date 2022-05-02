package generics;

import java.util.ArrayList;
import java.util.List;

import generics.functional_interface.GreetingMessage;
import generics.functional_interface.Shapes;
import generics.functional_interface.Square;
import generics.substitution_principle.Building;
import generics.substitution_principle.House;
import generics.substitution_principle.Office;
import generics.threads.ThreadExample;

public class App {

    static Character[] characters = { 'a', 'b', 'c', 'd' };
    static Integer[] integers = { 1, 2, 3, 4 };
    static Boolean[] booleans = { false, true, false, true };

    public static <T> List<T> arrayToList(T[] array, List<T> list) {
        for (T object : array) {
            list.add(object);
        }
        return list;
    }

    public static int sum(int index, int... numbers) {
        int sum = 0;
        int lengthNumbers = numbers.length;
        if (index != lengthNumbers) {
            sum = numbers[index] + sum(index + 1, numbers);
        }
        return sum;
    }

    public static void build(Building building) {
        System.out.println(building.toString());
    }

    public static void printBuildings(List<? extends Building> buildings) {
        for (int i = 0; i < buildings.size(); i++) {
            System.out.println(buildings.get(i).toString() + " " + (i + 1));
        }
    }

    public static void addHouseToList(List<? super House> buildings) {
        buildings.add(new House());
    }

    public static void main(String[] args) {
        // List<Character> charList = arrayToList(characters, new ArrayList<>());
        // List<Boolean> boolList = arrayToList(booleans, new ArrayList<>());
        // List<Integer> integerList = arrayToList(integers, new ArrayList<>());
        // System.out.println(sum(0, 1, 2, 3, 4, 5));

        /** Substitution Principle */
        // Building building = new Building();
        // Office office = new Office();
        // build(building);
        // build(office);

        // List<Building> buildings = new ArrayList<>();
        // buildings.add(new Building());
        // buildings.add(new Building());
        // printBuildings(buildings);

        // List<Office> offices = new ArrayList<>();
        // offices.add(new Office());
        // offices.add(new Office());
        // printBuildings(offices);

        // List<House> houses = new ArrayList<>();
        // houses.add(new House());
        // houses.add(new House());
        // printBuildings(houses);

        // addHouseToList(houses);
        // addHouseToList(buildings);

        /** Functional Interfaces */
        // GreetingMessage greetingMessage = name -> System.out.println("Hey! " + name);
        // greetingMessage.greet("Sebas");

        // Square square = new Square(4);
        // Shapes shapes = Square::calculateArea;
        // System.out.println("Area = " + shapes.getArea(square));

        ThreadExample threadExample = new ThreadExample();
        threadExample.setName("My first thread");
        threadExample.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ThreadExample threadExample2 = new ThreadExample();
        threadExample2.setName("My second thread");
        threadExample2.start();
    }
}
