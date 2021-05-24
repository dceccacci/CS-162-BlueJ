
/**
 * Write a description of class DLinkedList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DLinkedList<E> implements IDLinkedList<E>
{
    private Node<E> start;
    private int size;


    /**
     * Constructor for objects of class DLinkedList
     */
    public DLinkedList()
    {
        start = null;
        size = 0;
    }
    
    public void add(E e){
        Node<E> node = new Node(e);
        if(!startNew(node)){
            Node<E> last = start.getPrev();
            last.setNext(node);
            node.setNext(start);
            node.setPrev(last);
            start.setPrev(node);
        }

        size++;
    }
    
    public void add(int index, E e){
        Node<E> node = new Node(e);
        if(!startNew(node)){
            Node<E> tmp = get(index);
            Node<E> last = tmp.getPrev();
            last.setNext(node);
            tmp.setPrev(node);
            node.setNext(tmp);
            node.setPrev(last);
        }
        
        size++;
    }
    
    /**
     * Checks if the list is empty. If so it will start the new LinkedList
     * returns true if a new LinkedList was started. false if it did not.
     * @return True = new LinkedList; False = No LinkedList Made.
     */
    public boolean startNew(Node<E> node){
        if(start == null){
            start = node;
            node.setNext(node);
            node.setPrev(node);
            return true;
        }
        else{
            return false;
        }
    }
    
    public void addFirst(E e){
        Node<E> node = new Node(e);
        if(!startNew(node)){
            node.setNext(start.getNext());
            node.setPrev(start.getPrev());
            start.setPrev(node);
            start = node;
        }
        size++;
    }
    
    public void addLast(E e){
        add(e);
    }
    
    /**
     * 
     */
    public Node<E> delete(int index){
        Node<E> tmp = get(index);
        tmp.getNext().setPrev(tmp.getPrev());
        tmp.getPrev().setNext(tmp.getNext());
        size--;
        if(index == 0){
            start = tmp.getNext();
        }
        return tmp;
    }
    
    
    public void deleteFirst(){
        delete(0);
    }
    
    public void deleteLast(){
        delete(size() - 1);
    }
    
    public int size(){
        return size;
    }
    
    public void clear(){
        start = null;
        size = 0;
    }
    
    /**
     * 
     */
    public boolean contains(E e){
        for(int i = 0; i < size(); i++){
            Node<E> tmp = get(i);
            if(tmp.getData() == e){
                return true;
            }
        }
        return false;
    }
    
    public Node<E> get(int index){
        if(index >= size){
            System.out.println("Index: " + index + " is out of bounds.");
            return null;
        }
        Node<E> tmp = start;
        for(int i = 0; i < index; i++){
            tmp = tmp.getNext();
        }
        return tmp;
    }
    
    public Node<E> getFirst(){
        return start;
    }
    
    /**
     *
     */
    public Node<E> getLast(){
        return get(size()-1);
    }
    
    public void set(int index, E e){
        Node<E> node = new Node(e);
        Node<E> tmp = get(index);
        
        node.setNext(tmp.getNext());
        node.setPrev(tmp.getPrev());
        tmp.getNext().setPrev(node);
        tmp.getPrev().setNext(node);
        tmp.setNext(null);
        tmp.setPrev(null);

    }

}
