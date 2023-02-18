import java.util.*;

interface Iterator{
    public boolean has_next();
    public Object get_next();
}

class Sequence{
    private final int maxLimit = 80;
    private SeqIterator _iter = null;
    int[] iArr; 
    int size;
    int top = 0;
    //implement the parameterized constructor to initialize size
    public Sequence(int size_){
        size = size_;
        iArr = new int[size];
    }
    //implement addTo(elem) to add an int elem to the sequence 
    public void addTo(int elem){
        if(top < size){
            iArr[top] = elem;
            top++;
        }
    }
    //implement get_Iterator() to return Iterator object
    public Iterator get_Iterator(){
        if(_iter == null)
            _iter = new SeqIterator();
        return _iter;
    }
 
    private class SeqIterator implements Iterator{
        int indx;
        public SeqIterator(){
            indx = -1;
        }
        //implement has_next()
        public boolean has_next(){
            if(indx < size - 1)
                return true;
            return false;
        }
        //implement get_next()
        public Object get_next(){
            if(has_next()){
                indx++;
                return iArr[indx];
            }
            return null;
        }
    }
}

class GRPA4_2_iterator_implementation{
    public static void main(String[] args) {
        Sequence sObj = new Sequence(5);
        Scanner sc = new Scanner(System.in); 
        for(int i = 0; i < 5; i++) {
            sObj.addTo(sc.nextInt());
        }
        Iterator i = sObj.get_Iterator();
        while(i.has_next())
            System.out.print(i.get_next() + ", ");
    }
}