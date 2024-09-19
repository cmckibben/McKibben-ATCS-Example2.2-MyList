package org.example;

import java.util.*;

class MyList<E> implements List {
  private static final int DEFAULT_CAPACITY = 10;
  private Object[] storage = new Object[DEFAULT_CAPACITY];
  private int listSize = 0;

  public MyList() {
    storage = new Object[DEFAULT_CAPACITY];
    listSize = 0;
  }

  public void clear() {
    listSize = 0;
  }

  public int size() {
    return listSize;
  }

  @SuppressWarnings("unchecked")
  public E get(int N) {
    if(N>=listSize || N < 0)
      throw new ArrayIndexOutOfBoundsException();
    else
      return (E) storage[N];
  }

  public void set(E e, int N) {
    if(N>=listSize || N < 0)
      throw new ArrayIndexOutOfBoundsException();
    else
      storage[N] = e; 
  }


  @SuppressWarnings("unchecked")
  public E remove(int N) {
    if (N>=listSize || N<0)
      throw new ArrayIndexOutOfBoundsException();
    else {
      Object item = storage[N];
      for (int m=N+1;m<listSize;++m)
        storage[m-1]=storage[m];
      --listSize;
      return (E) item;
    }
  }

  //Double the size of the array if no space
  public boolean add(Object e) {
    if (storage.length<=listSize) {
      Object[] s=new Object[storage.length*2];
      for (int m=0; m<listSize; ++m)
        s[m]=storage[m];
      storage=s;
    }
    storage[listSize] = e;
    ++listSize;
    return true; // We changed the collection (added e)
  }

  public MyList<E> subList(int lower, int upper) {
    MyList<E> list = new MyList<>();
    for(int i = lower; i<upper; i++)
      list.add(storage[i]);
    return list;
  }

  public myListIterator<E> listIterator() {
    return new myListIterator<E>(this);
  }
  
  public myListIterator<E> listIterator(int N) {
    //check position first
    return new myListIterator<E>(this,N);
  }

  @Override
  public String toString() 
  {
    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for(int i = 0; i < listSize ;i++) {
        sb.append(storage[i].toString());
        if(i<listSize-1){
            sb.append(",");
        }
    }
    sb.append(']');
    return sb.toString();
  }
  
  //Stuff put in just to make the example compile, should be implemented properly
  public int lastIndexOf(Object e) {return -1;}
  public int indexOf(Object e) {return -1;}
  public void add(int N, Object e) {;}
  public E set(int N, Object e) {set((E) e,N);return (E) storage[N];}
  public boolean retainAll(Collection op) {return false;}
  public boolean removeAll(Collection op) {return false;}
  public boolean addAll(int N,Collection op) {return false;}
  public boolean addAll(Collection op) {return false;}
  public boolean containsAll(Collection op) {return false;}
  public boolean remove(Object e) {return false;}
  public Object[] toArray() { return storage;}
  public Object[] toArray(Object e[]) { return storage;}
  public myListIterator<E> iterator() {return new myListIterator<E>(this);}
  public boolean contains(Object o) {return false;}
  public boolean isEmpty() {
    if(listSize >0) return false;
    else return true;
  }
  public static void main(String[] args) {
        MyList<Double> list = new MyList<>();

        //Add elements
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);

        //Remove elements from index
        list.remove(2);
        System.out.println(list);

        //Get element with index
        System.out.println( list.get(0) );
        System.out.println( list.get(1) );

        //List Size
        System.out.println(list.size());
  }
}