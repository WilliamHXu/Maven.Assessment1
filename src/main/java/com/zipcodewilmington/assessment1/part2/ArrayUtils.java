package com.zipcodewilmington.assessment1.part2;

import sun.awt.SunHints;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by leon on 2/16/18.
 */
public class ArrayUtils {
    /**
     * @param objectArray   an array of any type of Object
     * @param objectToCount any non-primitive value
     * @return the number of times the specified `value` occurs in the specified `objectArray`
     * Given an array of objects, named `objectArray`, and an object `objectToCount`, return the number of times the `objectToCount` appears in the `objectArray`
     */
    public static Integer getNumberOfOccurrences(Object[] objectArray, Object objectToCount) {
        Integer count = 0;
        for (Object o : objectArray) {
            if (o.equals(objectToCount)) {
                count++;
            }
        }
        return count;
    }

    /**
     * @param objectArray    an array of any type of Object
     * @param objectToRemove a value to be removed from the `objectArray`
     * @return an array with identical content excluding the specified `objectToRemove`
     * Given an array of objects, name `objectArray`, and an object `objectToRemove`, return an array of objects with identical contents excluding `objectToRemove`
     */
    public static Integer[] removeValue(Integer[] objectArray, Integer objectToRemove) {
        ArrayList<Integer> values = new ArrayList<>();
        for (Integer o : objectArray) {
            if (!o.equals(objectToRemove)) {
                values.add(o);
            }
        }
        Integer[] newArray = new Integer[values.size()];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = values.get(i);
        }
        return newArray;
    }

    /**
     * @param objectArray an array of any type of Object
     * @return the most frequently occurring object in the array
     * given an array of objects, named `objectArray` return the most frequently occuring object in the array
     */
    public static Object getMostCommon(Object[] objectArray) {
        TreeMap<Object, Integer> tracker = createCountTracker(objectArray);
        // Find highest value
        Object mostCommon = tracker.firstKey();
        Integer howCommon = tracker.get(tracker.firstKey());
        Set<Object> keys = tracker.keySet();
        for (Object key : keys) {
            if (tracker.get(key) > howCommon) {
                mostCommon = key;
                howCommon = tracker.get(key);
            }
        }
        return mostCommon;
    }

    public static TreeMap<Object, Integer> createCountTracker(Object[] objectArray){
        TreeMap<Object, Integer> tracker = new TreeMap<>();
        // Fill out tracker
        for (Object o : objectArray) {
            // Checks to see if key exists and if not, creates new entry;
            if (!tracker.containsKey(o)) {
                tracker.put(o, 1);
            }
            // If key exists, value++
            else {
                Integer value = tracker.get(o);
                tracker.put(o, ++value);
            }
        }
        return tracker;
    }


    /**
     * @param objectArray an array of any type of Object
     * @return the least frequently occurring object in the array
     * given an array of objects, named `objectArray` return the least frequently occuring object in the array
     */
    public static Object getLeastCommon(Object[] objectArray) {
        TreeMap<Object, Integer> tracker = createCountTracker(objectArray);
        // Find lowest value
        Object leastCommon = tracker.firstKey();
        Integer howCommon = tracker.get(tracker.firstKey());
        Set<Object> keys = tracker.keySet();
        for (Object key : keys) {
            if (tracker.get(key) < howCommon) {
                leastCommon = key;
                howCommon = tracker.get(key);
            }
        }
        return leastCommon;
    }

    /**
     * @param objectArray      an array of any type of Object
     * @param objectArrayToAdd an array of Objects to add to the first argument
     * @return an array containing all elements in `objectArray` and `objectArrayToAdd`
     * given two arrays `objectArray` and `objectArrayToAdd`, return an array containing all elements in `objectArray` and `objectArrayToAdd`
     */
    public static Integer[] mergeArrays(Integer[] objectArray, Integer[] objectArrayToAdd) {
        Integer[] newArray = new Integer[objectArray.length + objectArrayToAdd.length];
        for (int i = 0; i < objectArray.length ; i++) {
            newArray[i] = objectArray[i];
        }
        for (int i = objectArray.length; i < objectArray.length + objectArrayToAdd.length ; i++) {
            newArray[i] = objectArrayToAdd[i - objectArray.length];
        }
        return newArray;
    }
}
