package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyListTest {
    @Test
    void testSize() {
        MyList<Integer> list = new MyList<>();
        assertEquals(0,list.size());
        //Add elements
        list.add(1);
        assertEquals(1,list.size());
        list.add(2);
        assertEquals(2,list.size());
        list.add(3);
        assertEquals(3,list.size());
        list.clear();
        assertEquals(0,list.size());
    }
    @Test
    void testClear() {
        MyList<Integer> list = new MyList<>();

        //Add elements
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        assertEquals(0,list.size());
    }

    @Test
    void testSet() {
        MyList<Integer> list = new MyList<>();

        //Add elements
        list.add(1);
        list.set((Integer) 2,0);
        assertEquals(2, list.get(0));  
        list.add(3);
        list.set(1, (Integer) 4);
        assertEquals(4, list.get(1));      
    }

    @Test
    void testRemove() {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals("[1,2,3]",list.toString());
        list.remove(2);
        assertEquals("[1,2]",list.toString());
        list.remove((Integer) 1);
        assertEquals("[2]",list.toString());

        
    }

    @Test 
    void testAdd() {
        final int size = 1000000;
        MyList<Integer> list = new MyList<>();
        for(int i =0; i < size; i ++) list.add(0);
        assertEquals(size, list.size());
        list.clear();
        for(int i =0; i < size; i ++) {
            list.add(i,i);
            assertEquals(i, list.get(i));
        }
    }

    @Test
    void testSubList() {
        MyList<Integer> list = new MyList<>();
        for(int i = 0; i < 10; i++) list.add(i);
        assertEquals(1,list.subList(1, 3).get(0));
        assertEquals(2,list.subList(1, 3).get(1));
    }
    @Test
    void testLastIndexOf() {
        MyList<Integer> list = new MyList<>();
        for(int i = 0; i < 10; i++) list.add(10);
        list.set((Integer) 3,3);
        assertEquals(3, list.lastIndexOf(3));        
    }        
    @Test
    void testIndexOf() {
        MyList<Integer> list = new MyList<>();
        for(int i = 0; i < 10; i++) list.add(i);
        for(int i = 0; i < 10; i++) assertEquals(i, list.indexOf(i));
    }
    @Test
    void testRetainAll() {
    }        
    @Test
    void testRemoveAll() {
    }   
    @Test
    void testAddAll() {
    }
    @Test
    void containsAll() {
    }
    @Test
    void toArray() {
        MyList<Integer> list = new MyList<>();

        //Add elements
        list.add(1);
        list.add(2);
        list.add(3);

        Integer[] array = {1,2,3};
        assertArrayEquals(array,list.toArray());


        assertArrayEquals(array,list.toArray(array));        
    }
    @Test
    void testIterator() {
        MyList<Integer> list = new MyList<>();
        for(int i = 0; i < 10; i++) list.add(i);
        myListIterator<Integer> iterator = list.iterator();

        int i = 0;
        assertFalse(iterator.hasPrevious());
        while(iterator.hasNext()) {
            assertEquals(i, iterator.next());
            assertTrue(iterator.hasPrevious());
            assertEquals(i, iterator.previousIndex());
            i++;
            assertEquals(i, iterator.nextIndex());
        }
        assertFalse(iterator.hasNext());
        while(iterator.hasPrevious()) {
            i--;
            assertEquals(i, iterator.previous());
            assertTrue(iterator.hasNext());
        }        
    }  
    @Test
    void testContains() {
        MyList<Integer> list = new MyList<>();

        //Add elements
        list.add(1);
        list.add(2);
        list.add(3);

        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));                
        assertFalse(list.contains(4));      
    }     
    @Test
    void testIsEmpty() {
        MyList<Integer> list = new MyList<>();

        assertTrue(list.isEmpty());
        //Add elements
        list.add(1);
        list.add(2);
        list.add(3);              
        assertFalse(list.isEmpty());           
    }              
}