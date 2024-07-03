public class Stack<T> {
    private Node<T> top;
    private Node<T> topState;

    public Stack() {
        top = null;
    }
    
    public boolean isEmpty() {
        if (topState==null)
            return true;
        return false;
    }
    
    public void push(T n) {
        Node<T> newNode = new Node<>(n);
        newNode.next = top;
        top = newNode;        
    }
    
    public T pop() {
        Node<T> t = top;
        if(!isEmpty())
            topState = topState.next;
        return t.data;
    }

    private static class Node<T>{
        Node<T> next = null;
        T data;

        Node(T data){
            this.data = data;
        }

    }
}
