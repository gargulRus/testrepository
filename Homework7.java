/**
 * Java. Level 1. Lesson 7. Homework
 *
 * @author Nikolay Gabaraev
 * @version date Oct 20, 2017
 */

import java.util.Scanner;

class Homework7 {

    public static void main(String[] args) {
        int a = 0;
        Scanner sc = new Scanner(System.in);
        int d =0;
        int c = 0;
        for (a = 1; a>0; c = d+a) {

            Plate plate = new Plate(c);

            Cat[] cats = {new Cat("Barsik", 15, false), new Cat("Murzik", 15, false),
                    new Cat("Kukuruza", 10, false), new Cat("Kyza", 10, false)};

            for (int i = 0; i < cats.length; i++) {
                cats[i].eat(plate);
                System.out.println(cats[i].toString());
            }

            System.out.println("На сколько наполнить тарелку? ");
            a = sc.nextInt();
            if (a != 0) {
                plate.fuelfood(a);
            }
            System.out.println(plate.toString());
            a=plate.getFood();
        }
    }
}

class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    void eat(Plate plate) {
        if (plate.getFood() >= appetite) {
            this.satiety = true;
        }else {
           System.out.println("Не хватает еды!");
        }
        plate.decreaseFood(appetite);
    }

public int getApppetite(){
        return appetite;
    }

    @Override
    public String toString (){
        return ("Имя "  + name + " Аппетит " + appetite + " Сытость " + satiety);
    }
}

class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }

    void fuelfood (int a) {
        this.food = food +a;
    }

    public int getFood() {
        return food;
    }

    void decreaseFood(int food) {
        if(this.food<food) {
        }else {
            this.food -= food;
            System.out.println(this.food);
        }
    }

    @Override
    public String toString() {
        return ("Plate: " + food);
    }
}