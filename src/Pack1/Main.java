package Pack1;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        System.out.println(reverseString("мама мыла раму"));


    }

    //Метод реверса строки с использованием стека
    public static String reverseString(String inputString){
        MyStack<Character> stack = new MyStack<>(inputString.length());
        String outString = "";
        for (int i = 0; i < inputString.length(); i++) {
            stack.push(inputString.charAt(i));
        }
        for (int i = 0; i < inputString.length(); i++) {
            outString += stack.pop().toString();
        }
        return outString;
    }
}