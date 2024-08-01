/*
 * HashMapFunctions.java
 */
import java.util.*;
/** 
 * This file contains methods to operate on HashMaps, specifically to order them
 * @author qbend
 */
public class HashMapFunctions {
    
    /**
     * This function takes a HashMap and converts it to a sorted LinkedHashMap by values
     * I converted it back to LinkedHashMap, because I thought we had to write to the file
     * in order.
     * @param map HashMap of String and Integer to be converted to sorted LinkedHashMap
     * @return The sorted LinkedHashMap
     */
    public LinkedHashMap<String, Integer> sortByCount(HashMap<String, Integer> map){
        //Create and Linked List of HashMap entries
        LinkedList<Map.Entry<String, Integer>> hashMapList = new LinkedList<>(map.entrySet());
        //Sort the LinkedList by the values, Comparator of map entries
        Collections.sort(hashMapList, new Comparator<Map.Entry<String, Integer>>(){
            //Override the compare method to sort by value in descending order
            //Using in-line because creating a separate class was giving me issues
            @Override
            public int compare(Map.Entry<String, Integer> mapValue1, Map.Entry<String, Integer> mapValue2){
                //Use mapValue2 first in order to sort in descending order
                return mapValue2.getValue().compareTo(mapValue1.getValue());}
        });
        // Create LinkedHashMap
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        //Loop through every entry in the linked list
        for (Map.Entry<String, Integer> hmEntry : hashMapList){
            //Add ordered entries into LinkedHashMap in order to keep the order
            lhm.put(hmEntry.getKey(), hmEntry.getValue());
        }
        return lhm;
    }
    /**
     * This function takes a HashMap and converts it to a sorted TreeMap by the key values alphabetically
     * @param map HashMap of String and Integer to be converted to sorted TreeMap
     * @return The alphabetically sorted TreeMap
     */
    public TreeMap<String, Integer> sortByAlpha(HashMap<String, Integer> map){
        //Create TreeMap
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        //TreeMaps automatically order keys alphabetically 
        treeMap.putAll(map);
        return treeMap;      
    }

    /**
     * This function returns the top 5 values of a LinkedHashMap
     * @param map Sorted LinkedHashMap to get the top 5 values
     */
    public String getTop5(LinkedHashMap<String, Integer> map){
        int count = 0;
        String[] top5 = new String[5];
        
        //Loop through entire LinkedHashMap
        for (Map.Entry<String, Integer> entry: map.entrySet()){
            //Print first 5 values of LinkedHashMap
            if (count < 5){
                top5[count] = (entry.getKey() + ":" + entry.getValue());
                count++;
            }
        }
        return Arrays.toString(top5);
    }

    /**
     * This function returns the bottom 5 values of a LinkedHashMap
     * @param map Sorted LinkedHashMap to get the bottom 5 values
     */
    public String getBottom5(LinkedHashMap<String, Integer> map){
        int count = 0;
        int i = 0;
        String[] bottom5 = new String[5];

        //Loop through entire LinkedHashMap
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            //Only print for the last 5 values of LinkedHashMap
            if (count > (map.size()-6) && count < map.size()){
                bottom5[i] = (entry.getKey() + ":" + entry.getValue());
                count++;
                i++;
            }
            //Increment until you get to final 5 values
            else{
                count++;
            }
        }
        return Arrays.toString(bottom5);
    }

    /**
     * Gets the count of total words in file
     * @param map HashMap containing the words and their count
     * @return Returns the total words in the File
     */
    public int getCount(HashMap<String,Integer> map){
        int total = 0;
        for (Integer wordCount : map.values()){
            total += wordCount;
        }
        return total;
    }
}

