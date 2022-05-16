package de.uni_bremen.pi2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayTest
{
/**
 * test für size()
 * 2 Fälle: 1. größer werden
 *          2. die gleiche Größe beibehalten
 */
@Test
    public void size(){
    Array<String> s= new Array<>(7);
    assertEquals(0,s.size());
    s.set(5,"H");
    assertEquals(6,s.size());
    s.set(4,"k");
    s.set(5,"j");
    assertEquals(6,s.size());
    s.set(20,"a");
    assertEquals(21,s.size());
}
/**
 * test capacity:
 * testet ob die Kapatität in zweierpotenz wächst,
 *  b Index = Größe entspricht
 * und der sonder Fall (Anfangskapazität) 0 und wächst auf 1
 *
 */
@Test
    public void capacity(){
    Array<Integer> i=new Array<>(0);
    Array<Integer> o=new Array<>(7);
    assertEquals(0,i.capacity());
    i.set(0,11);
    assertEquals(1,i.capacity());
    i.set(5,12);
    assertEquals(8,i.capacity());
    i.set(8,13);
    assertEquals(16,i.capacity());
    i.set(33,14);
    assertEquals(64,i.capacity());


    assertEquals(7,o.capacity());
    o.set(9,15);
    assertEquals(14,o.capacity());
}

/**
 * get testet ob die Werte lesbar sind
 */
@Test
    public void get(){
    Array<Integer> i = new Array<>(2);
    i.set(0,1);
    i.set(500,500);

    assertEquals(1,i.get(0));
    assertEquals(500,i.get(500));
}
/**
 * negative Kapazität test
 *
 */
@Test
public void nigativeCapacity() {
    IllegalArgumentException thrrown = assertThrows(IllegalArgumentException.class,
            () -> new Array<Integer>(-1),"expected IllegalArgumentException");
}
//test Nigative Indeces
@Test
public void setNigativIndex(){
    ArrayIndexOutOfBoundsException thrrown = assertThrows(ArrayIndexOutOfBoundsException.class,
            () -> new Array<Integer>(5).set(-1,5),"expected IllegalArgumentException");
}
//test Index > als Integer Grenze
@Test
public void setMaxValue(){
    ArrayIndexOutOfBoundsException thrrown = assertThrows(ArrayIndexOutOfBoundsException.class,
            () -> new Array<Integer>(5).set(Integer.MAX_VALUE,5),"expected IllegalArgumentException");
}

@Test
public void getInvalidIndex(){
    ArrayIndexOutOfBoundsException thrrown = assertThrows(ArrayIndexOutOfBoundsException.class,
            () -> new Array<Integer>(5).get(10),"expected IllegalArgumentException");
}


/**
 * iterator test
 */
@Test
    public void iterator(){
    final Array<Integer> i = new Array<>(5);
    assertFalse(i.iterator().hasNext());
    i.set(0,11);
    i.set(1,12);
    i.set(3,14);
    assertTrue(i.iterator().hasNext());
    final Iterator itr = i.iterator();
    itr.next();
    assertEquals(12,itr.next());
    assertNull(itr.next());
}

    @Test
    public void iteratorOutOfRang() {
        NoSuchElementException thrrown = assertThrows(NoSuchElementException.class,
                () -> new Array<Integer>(4).iterator().next(),"expected NoSuchElementException");
    }

}