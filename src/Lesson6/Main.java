package Lesson6;

import java.util.Random;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        MyTreeMap<Integer, Integer>[] mapArray = new MyTreeMap[20];
        for (int i = 0; i < 20; i++) {
            mapArray[i] = generateTree(6);
            System.out.println("-------");
            mapArray[i].info();
        }

    }
    public static MyTreeMap generateTree (int n){
        Random random = new Random();
        MyTreeMap<Integer, Integer> map = new MyTreeMap<>();
        while (map.height() < n ){
            map.put( -100+ random.nextInt(200), -100+  random.nextInt(200));
        }
        return map;
    }

}
