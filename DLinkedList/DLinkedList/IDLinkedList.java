
/**
 * Write a description of interface IDLinkedList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface IDLinkedList<E>
{
    void add(E e);          // adds object to the end of LinkedList
    void add(int index, E e);   // adds object object at int index in LinkedList
    void addFirst(E e);     // adds object to beginning of LinkedList
    void addLast(E e);      // adds object to end of LinkedList
    Node<E> delete(int index);    // deletes and returns object at int index in LinkedList
    void deleteFirst();     // deletes first object in LinkedList
    void deleteLast();      // deletes last object in LinkedList
    int size();             // returns int size of LinkedList
    void clear();           // removes all objects of LinkedList and sets start to null
    boolean contains(E e);  // returns boolean if object is in LinkedList
    Node<E> get(int index);       // returns object at int index in LinkedList
    Node<E> getFirst();           // returns first object in LinkedList
    Node<E> getLast();            // returns last object in LinkedList
    void set(int index, E e);   // replaces object into LinkedList at int index
}
