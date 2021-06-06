
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
    
    /**
     * Adds node to last spot in DlinkedList.
     * @param e The data of the node.
     */
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
    
    /**
     * Adds a node to the passed parameter index.
     * @param index The index of where to add the new node.
     * @param e The data of the node.
     */
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
     * Checks if there is a DlinkedList started. 
     * If start == null it starts new DlinkedList.
     * Returns if true or false if new list was made.
     * @returns True or False if new list was made.
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
    
    /**
     * Adds node to start of DlinkedList.
     * @param e The data of the node.
     */
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
    
    /**
     * Adds node to end of DlinkedList
     */
    public void addLast(E e){
        add(e);
    }
    
    /**
     * Returns and removes node at parameter index.
     * @param index The index of node to remove.
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
    
    /**
     * Removes first node in the DlinkedList
     */
    public void deleteFirst(){
        delete(0);
    }
    
    /**
     * Removes last node in the DlinkedList
     */
    public void deleteLast(){
        delete(size() - 1);
    }
    
    /**
     * Returns int size var.
     * @return The int value of size var.
     */
    public int size(){
        return size;
    }
    
    /**
     * Resets Node links
     */
    public void clear(){
        start = null;
        size = 0;
    }
    
    /**
     * Returns True or False if DlinkedList contains parameter data.
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
    
    /**
     * Returns node at parameter index
     * @param index The index of the node to get.
     */
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
    
    /**
     * Return first node in DlinkedList.
     * @return The first node in the DlinkedList.
     */
    public Node<E> getFirst(){
        return start;
    }
    
    /**
     * Returns the last node in DlinkedList.
     * @return The last node of the DlinkedList
     */
    public Node<E> getLast(){
        return get(size()-1);
    }
    
    /**
     * Sets the node at passed parameter index with parameter data.
     * @param index The index number of node.
     * @param e The data to exchange.
     */
    public void set(int index, E e){
        Node<E> node = new Node(e);
        Node<E> tmp = get(index);
        
        node.setNext(tmp.getNext());
        node.setPrev(tmp.getPrev());
        tmp.getNext().setPrev(node);
        tmp.getPrev().setNext(node);
        tmp.setNext(null);
        tmp.setPrev(null);
        if(index == 0){
            start = node;
        }

    }

}
