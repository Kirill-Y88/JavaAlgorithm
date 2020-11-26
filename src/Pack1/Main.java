package Pack1;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        MyArrayList<Integer> mal = new MyArrayList<>(100);  //добавил автоматическое расширение внутреннего массива
        for (int i = 0; i < 100000; i++) {
            mal.add(random.nextInt(1000000));
        }

// Массив на миллион мой компьютер сортирует пузырьком более 10 минут, поэтому есть только 100тысяч
        mal.bubbleSort();
        System.out.println("countAddLength: " + mal.countAddLength);


        MyArrayList<Integer> mal2 = new MyArrayList<>(100);
        for (int i = 0; i < 100000; i++) {
            mal2.add(random.nextInt(1000000));
        }
        mal2.selectionSort(Comparator.naturalOrder());
        System.out.println("countAddLength: " + mal2.countAddLength);


        MyArrayList<Integer> mal3 = new MyArrayList<>(100);
        for (int i = 0; i < 100000; i++) {
            mal3.add(random.nextInt(1000000));
        }
        mal3.insertionSort();
        System.out.println("countAddLength: " + mal3.countAddLength);


        //  System.out.println(mal);
//        mal.selectionSort(Comparator.naturalOrder());
//        mal.selectionSort(Comparator.reverseOrder());
//        mal.selectionSort((a,b)->{return a%10 - b %10;});
        // System.out.println(mal);
//        mal.insertionSort();


    }
}
