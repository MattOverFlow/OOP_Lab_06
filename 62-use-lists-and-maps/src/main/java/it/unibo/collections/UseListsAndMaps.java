package it.unibo.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
       
       final int ELEMS=100_000;
       
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer>list=new ArrayList<>();

        for(int i=1000;i<2000;i++){
            list.add(i);
        }
        System.out.println(list.toString());
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */

         System.out.println("----------");
        List<Integer>linkList=new LinkedList<>(list);
        System.out.println(linkList.toString());
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int elem = list.get(list.size()-1);
        list.set(list.size()-1, list.get(0));
        list.set(0,elem);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        System.out.println("----------");
        for (int i: list) {
            System.out.print(i+" ");
        }
        System.out.println("\n----------");
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        List<Integer>list1=new ArrayList<>();
        List<Integer>list2=new LinkedList<>();
        
         long time = System.nanoTime();
        /*
         * Run the benchmark
         */ 
        for (int i = 1; i <= ELEMS; i++) {
            list1.add(i);
        }
        /*
         * Compute the time and print result
         */
        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Converting "
                + list1.size()
                + " ints to String and inserting them in a Set took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        System.out.println("---------");
        
         time = System.nanoTime();
        /*
         * Run the benchmark
         */ 
        for (int i = 1; i <= ELEMS; i++) {
            list2.add(i);
        }
        /*
         * Compute the time and print result
         */
        time = System.nanoTime() - time;
        final var millise = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Converting "
                + list2.size()
                + " ints to String and inserting them in a Set took "
                + time
                + "ns ("
                + millise
                + "ms)"
        );

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */
        System.out.println("---------");

          time = System.nanoTime();
        /*
         * Run the benchmark
         */ 
        for (int i = 1; i <= 1000; i++) {
            list1.get(list1.size()/2);
        }
        /*
         * Compute the time and print result
         */
        time = System.nanoTime() - time;
        final var millisec = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Converting "
                + list1.size()
                + " ints to String and inserting them in a Set took "
                + time
                + "ns ("
                + millisec
                + "ms)"
        );
        System.out.println("---------");

          time = System.nanoTime();
        /*
         * Run the benchmark
         */ 
        for (int i = 1; i <= 1000; i++) {
            list1.get(list1.size()/2);
        }
        /*
         * Compute the time and print result
         */
        time = System.nanoTime() - time;
        final var milliseco = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Converting "
                + list1.size()
                + " ints to String and inserting them in a Set took "
                + time
                + "ns ("
                + milliseco
                + "ms)"
        );
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

        Map<String,Long>mappa=new HashMap<>();

        mappa.put("Africa", 1_110_635_000L);
        mappa.put("Americas",972_005_000L);
        mappa.put("Antartica",0L);
        mappa.put("Asia",4_298_723_000L);
        mappa.put("Europe",742_452_000L);
        mappa.put("Oceania",38_304_000L);

        /*
         * 8) Compute the population of the world
         */
        long res=0;
        for(long population: mappa.values()){
            res+=population;
        }

        System.out.println(res);
    }
}
