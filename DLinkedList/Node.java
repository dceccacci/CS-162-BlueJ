
/**
 * Write a description of class Node here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Node <E>
{
    private E data;
    private Node<E> next;
    private Node<E> prev;

    /**
     * Constructor for objects of class Node
     */
    public Node(E data)
    {
        this.data = data;
        next = null;
        prev = null;
    }
    
    public void setNext(Node<E> node){
        this.next = node;
    }
    
    public void setPrev(Node<E> node){
        this.prev = node;
    }
    
    public Node<E> getNext(){
        return next;
    }
    
    public Node<E> getPrev(){
        return prev;
    }
    
    public E getData(){
        return data;
    }

}
