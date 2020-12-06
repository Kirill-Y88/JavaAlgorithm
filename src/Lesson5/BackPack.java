package Lesson5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BackPack {
   public static int maxBackPackWeight = 30;  //максимальная емкость рюкзака
    public static List<Thing> listThing;    //список предметов к упаковки
    public static List<Thing> backPack;     // список предметов упакованных в рюкзаке

    public static void main(String[] args) {
        listThing = new ArrayList<>();
        backPack = new ArrayList<>();
        int countThing = 10;   //количество вещей
        Random random = new Random();

        for (int i = 0; i < countThing; i++) {
            listThing.add(new Thing(1+ random.nextInt(10), 1 + random.nextInt(10), "name"+i ));
            System.out.println(listThing.get(i).toString());
        }
        listThing.sort(Thing::compareTo);  //сортировка предметов по возрастанию удельной ценности
        System.out.println("---------------");
        for (Thing t : listThing) {
            System.out.println(t.toString());
        }

        recAddIntoBackPack(countThing-1);

        System.out.println("/////////////");
        for ( Thing t: backPack
             ) {
            System.out.println(t.toString());
        }

    }

    public static void recAddIntoBackPack(int i){
        if (i<0){
            throw new IllegalArgumentException();
        }
            if( maxBackPackWeight > listThing.get(i).weigth){
                backPack.add(listThing.get(i));
                maxBackPackWeight-=listThing.get(i).weigth;
                if(i>=1){
                    recAddIntoBackPack(i-1);
                }else return;
            }else {
                if(i>=1){
                    recAddIntoBackPack(i-1);
            }else return;
            }
    }



    private static class Thing implements Comparable<Thing>  {
        protected int weigth;
        protected int price;
        protected String name;
        protected double maxValue;

        Thing(int weigth, int price, String name){
            this.weigth = weigth;
            this.price = price;
            this.name = name;
            maxValue = (double)price/weigth;  // расчет ценности предмета ( перевод стоимости из абсолютного в удельное значение (стоимость единицы массы))
        }

        @Override
        public String toString() {
            return "Name: " + name + " weight: " + weigth + " price: " + price + " maxValue: " + maxValue;
        }

        @Override
        public int compareTo(Thing o) {
            if(this.maxValue > o.maxValue){
                return 1;
            }
            if(this.maxValue < o.maxValue){
                return -1;
            } else return 0;
        }
    }
}
