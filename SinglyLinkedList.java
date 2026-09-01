public class SinglyLinkedList<E> {
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }

    // Write your codes below
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<E> cursor = head;
        while (cursor != null) {
            sb.append(cursor.getElement());
            cursor = cursor.getNext();
        }
        return sb.toString();
    }

    public E removeLast(){
        if (isEmpty()) return null;
        else if (size == 1) {
            E out = head.getElement();
            head = null;
            tail = null;
            size--;
            return out;
        }

        Node<E> secondLast = head;
        while (secondLast.getNext() != tail) {
            secondLast = secondLast.getNext();
        }

        E out = tail.getElement();
        secondLast.setNext(null);
        tail = secondLast;
        size--;
        return out;
    }

    public void reverse(){   
        if (size <= 1) return;    

        Node<E> prev = null;
        Node<E> cursor = head;
        while (cursor != null) {
            Node<E> next = cursor.getNext();
            cursor.setNext(prev);
            prev = cursor;
            cursor = next;
        }

        Node<E> temp = tail;
        tail = head;
        head = temp;
    }
}
