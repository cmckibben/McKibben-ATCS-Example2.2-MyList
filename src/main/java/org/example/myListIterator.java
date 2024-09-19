package org.example;
import java.util.ListIterator;

public class myListIterator<E> implements ListIterator<E> {
    private int position;
    private int start;
    private MyList<E> list;

    public myListIterator(MyList<E> M) {
        position = start = 0;
        list = M;
    }

    public myListIterator(MyList<E> M, int N) {
        position = N;
        start = N;
        list = M;
    }
    public boolean hasNext() {
        return position < list.size();
    }

    public boolean hasPrevious() {
        return position > start;
    }
    public E next() {
      position++;
      if(position>=list.size())
        throw new ArrayIndexOutOfBoundsException();
      else
        return (E) list.get(position);
    }    

    public E previous() {
      position--;
      if(position<start)
        throw new ArrayIndexOutOfBoundsException();
      else
        return (E) list.get(position);
    }    


    public void remove(){
      list.remove(position);  
    }

    public void set(E e) {
      list.set(e,position);
    }

    public void add(E e) {
      throw new UnsupportedOperationException();
    }

    public int nextIndex() { return position+1;}
    public int previousIndex() { return position -1;}
}