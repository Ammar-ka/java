package de.uni_bremen.pi2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Array<E> implements Iterable<E>
{

//größe des Arrays
private int size=0;
private E[] puffer;

    /** !! wir haben unseren Code und die Tests zusammen geschrieben
     *  !! und ausversehen jdk 18 benutzt
     * Konstruktor: Erstellt ein Objekt dieser Klasse,
     * dieses beinhaltet ein Array vom typ E, die Größe wird übergeben
     * @param initialArrayLength Anfangsgröße des Arrays
     * @throws IllegalArgumentException bei negativer Kapazität
     */
    public Array(final int initialArrayLength){
        if(initialArrayLength <0) throw new IllegalArgumentException("negative Kapazität");

        puffer= (E[]) new  Object[initialArrayLength];

    }

    /**
     * size() liefert die Größe des Arrays
     */
    int size(){
        return size;
    }

    /**
     * capacity() Liefert die aktuelle Kapazität des Puffers
     * @return int the puffer lenght
     */
    int capacity(){
        return puffer.length;
    }

    /**
     *  Schreibt einen Wert (element) an eine durch einen (index) definierte Stelle in das Array.
     * @param  index der Stelle, an die geschrieben werden soll
     * @param  Element das an der Stelle index hinzugefügt wird
     */

    void set(final int index,final E element){
        if (index >= 0 && index < Integer.MAX_VALUE) {
            growIfNeeded(index);
                puffer[index] = element;
                size = size > index ? size : index + 1;
        }else
            throw new ArrayIndexOutOfBoundsException("der Index ist out of array-range");
    }

    /**
     * @param  index des Arrays
     * @return E  Liefert das Objekt am gegebenen Index des Arrays zurück.
     */
    E get(final int index){
        if(index > size || index < 0) throw new ArrayIndexOutOfBoundsException("index out of range");
        return puffer[index];
    }

    /**
     * die Methode bekommt einen Index und vergrößert das Array,
     * sodass ein Element an diesem index gespeichert werden kann (solange die Integer-grenze nicht überschritten wird).
     * Wird der Maximal mögliche Index überschritten wird die Arraygröße auf Integer.MAX_VALUE gesetzt, sonst wächst das
     * Array in (2er Potenzen)*(Ursprungsgröße)
     * @param index der Stelle an die geschrieben werden soll
     *
     */
    void growIfNeeded(final int index){
        // Eine Kapazität von 0 wird auf 1 vergrößert
        if(puffer.length == 0) puffer= (E[]) new  Object[1];
        // wie oft wird mit 2 multipliziert
        double x= (double) (index+1)/ (double) puffer.length;
        /**
         *
         *  2^x*puffer.length >= index+1 => x=log2((index+1)/puffer)
         */
        x=(Math.log(x) / Math.log(2));
        x=Math.ceil(x);
        x=Math.pow(2,x);

      double  arrayLength= puffer.length*x;
        if(arrayLength > Integer.MAX_VALUE) {
            arrayLength = Integer.MAX_VALUE;

        }
        if (puffer.length<= index  ){
        E[] tempPuffer = (E[]) new  Object[((int) (arrayLength))];
        System.arraycopy(puffer,0,tempPuffer,0,puffer.length);
        puffer=tempPuffer;
        }
    }
    

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int counter=0;
            @Override

            public boolean hasNext() {
            if(counter<Array.this.size)
                return true;
                return false;
            }

            @Override
            public E next() {
                if(!hasNext())
                throw new NoSuchElementException("there are no more elements inside the array");
                    return puffer[counter++];

            }
        };
    }
}