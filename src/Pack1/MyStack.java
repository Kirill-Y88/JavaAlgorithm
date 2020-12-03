package Pack1;

public class MyStack<T> {
    private MyOneLinkedList<T> stack= new MyOneLinkedList<>();
    public int size(){
        return stack.size();
    }
    public void add(T item){
        stack.insertFirst(item);
    }
    public T remove(){
        return stack.removeFirst();
    }
    public T get(){
        return stack.getFirst();
    }

}
