import java.util.Collection;
import java.util.AbstractCollection;
import java.util.Iterator;

class SimpleCollection<E> implements Collection<E>{
    private E[] elements;
    private int size;
    private int capacity;

    public SimpleCollection(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.elements = (E[]) new Object[capacity]; // 
    }

    public boolean add(E element){
        if(size < capacity){
            elements[size++] = element;
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public boolean contains(Object o){
        for(int i = 0; i < size; i++){ // simple linear search to find the element
            if(elements[i].equals(o)){ 
                return true;
            }
        }
        return false;
    }

    public boolean remove(Object o){
        for(int i = 0; i < size; i++){
            if(elements[i].equals(o)){
                elements[i] = elements[size - 1];
                size--;
                return true;
            }
        }
        return false;
    }

    public boolean addAll(Collection<? extends E> c){
        for(E e : c){
            add(e);
        }
        return true;
    }

    public void clear(){
        size = 0;
    }

    public boolean containsAll(Collection<?> c){
        for(Object o : c){
            if(!contains(o)){
                return false;
            }
        }
        return true;
    }

    public boolean removeAll(Collection<?> c){
        for(Object o : c){
            remove(o);
        }
        return true;
    }

    public boolean retainAll(Collection<?> c){
        for(int i = 0; i < size; i++){
            if(!c.contains(elements[i])){
                remove(elements[i]);
            }
        }
        return true;
    }

    public Object[] toArray(){
        Object[] arr = new Object[size];
        for(int i = 0; i < size; i++){
            arr[i] = elements[i];
        }
        return arr;
    }

    public <T> T[] toArray(T[] a){
        if(a.length < size){
            return (T[]) toArray();
        }
        for(int i = 0; i < size; i++){
            a[i] = (T) elements[i];
        }
        return a;
    }

    public Iterator<E> iterator(){
        return new java.util.Iterator<E>(){ // anonymous class
            private int index = 0;

            public boolean hasNext(){
                return index < size;
            }

            public E next(){
                return elements[index++];
            }

            public void remove(){
                SimpleCollection.this.remove(elements[index]);
            }
        };
    }

    public String toString(){
        String s = "[";
        for(int i = 0; i < size; i++){
            s += elements[i];
            if(i != size - 1){
                s += ", ";
            }
        }
        s += "]";
        return s;
    }
}


class SimpleCollection2<E> extends AbstractCollection<E>{ // Abstract class exists because at that time default keyword didn't exist.
    private E[] elements;
    private int size;
    private int capacity;

    public SimpleCollection2(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.elements = (E[]) new Object[capacity]; // 
    }

    public int size(){
        return size;
    }

    public Iterator<E> iterator(){
        return new Iterator<E>(){
            private int  index = 0;

            public boolean hasNext(){
                return index<size;
            }

            public E next(){
                return elements[index++];
            }
        }; 
    } 

    public boolean add(E element){
        if(size >= capacity)
            return false;
        elements[size++] = element;
        return true;
    }
}

public class collection_interface {
    public static void main(String[] args) {
        SimpleCollection<String> c1 = new SimpleCollection<>(10);
        c1.add("Hello");
        c1.add("monkey");

        // We can iterate by getting the iterator and using while
        Iterator<String> i = c1.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }

        // We can use forEach to iterate also because iterator is formed using java.util.iterator ;
        for(String s : c1){
            System.out.println(s);
        }
        System.out.println(c1);

        // SimpleCollection2
        SimpleCollection2<Integer> c2 = new SimpleCollection2<>(10);
        try{
            c2.clear();
            c2.add(1);
            c2.add(2);
            c2.forEach(System.out::println);
        }
        catch (UnsupportedOperationException e) {
            System.out.println("Unsupported method.");
        }
        System.out.println(c2);
    }
}
