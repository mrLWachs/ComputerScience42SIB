
package testing.cs42sib;

import collections.LinkedList;
import io.Output;
import numbers.Random;
import searchsort.Searcher;
import searchsort.Sorter;
import testing.testclass.TestClass;

public class SearchingAndSortingTest 
{

    public SearchingAndSortingTest() {
        simple();
//        visual();
    }

    private void simple() {
        System.out.println("Search test started...");
        
        final int SIZE = 10000;
        final int MIN = 0; //-SIZE;
        final int MAX = SIZE;
        
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < SIZE; i++) {
            list.add(Random.generate(MIN, MAX));
        }
        System.out.println(list);
        
        Integer item = Random.generate(MIN, MAX);
        
        Searcher search = new Searcher();
        
        int location = search.linear(item,list);
        
        System.out.println("Item " + item + 
                " at location " + location);
                
        item = list.front();
        location = search.linear(item,list);
        System.out.println("Item " + item + 
                " at location " + location);
        
        item = list.back();
        location = search.linear(item,list);
        System.out.println("Item " + item + 
                " at location " + location);
        
        item = list.get(Random.generate(1, SIZE-2));
        location = search.linear(item,list);
        System.out.println("Item " + item + 
                " at location " + location);
        
        Integer[] array = new Integer[SIZE];
        array = list.toArray(array);
        
        Sorter sort = new Sorter();
        sort.bubble(array);
        
        output(array);
        
        item = Random.generate(MIN, MAX);
        location = search.binary(item, array);
        System.out.println("Item " + item + 
                " at location " + location);
              
        list = new LinkedList<>(array);
        System.out.println(list);
        location = search.binary(item, list);
        System.out.println("Item " + item + 
                " at location " + location);
        
        
        
        
        
        
        
    }
        
    private<T> void output(T[] array) {
        String text = "[";
        for (int i = 0; i < array.length - 1; i++) {
            text += array[i].toString() + ",";
        }
        System.out.println(text + 
                array[array.length-1] + "]");
    }

    private void visual() {
        Output.header("Search Testing",true,false);
        
        final int SIZE = 10;
        
        Searcher search = new Searcher();
        
        TestClass notFindableItem = new TestClass(true,0,0,' ',"");
        
        TestClass item = null;
        int location = 0;       
                    
        Output.comment("Testing LinkedList with random non-duplicates, and display:");
        LinkedList list = TestClass.createLinkedListNoDuplicates(SIZE);
        Output.show(list.toString());
             
        Output.comment("Linear search with LinkedList, testing edges"); 
        
        item = (TestClass)list.front();
        location = search.linear(item, list);        
        Output.show("Linear Search for item " + item.toString() + 
                " IN LinkedList (first item) at location " + location);
                
        item = (TestClass)list.back();
        location = search.linear(item, list);
        Output.show("Linear Search for item " + item.toString() + 
                " IN LinkedList (last item) at location " + location);
        
        location = Random.generate(0, SIZE-1);
        item = (TestClass)list.get(location);
        location = search.linear(item, list);
        Output.show("Linear Search for item " + item.toString() + 
                " IN LinkedList (randomly) at location " + location);
        
        item = notFindableItem.clone();
        location = search.linear(item, list);
        Output.show("Linear Search for item " + item.toString() + 
                " NOT IN LinkedList at location " + location);
        

        Output.comment("Testing array with random non-duplicates, and display:");
        TestClass[] array = new TestClass[SIZE];
        array = (TestClass[])TestClass.createLinkedList(SIZE).toArray(array);
        Output.show(Output.arrayToString(array));
        
        Output.comment("Linear search with array, testing edges"); 
        
        item = array[0];
        location = search.linear(item, array);        
        Output.show("Linear Search for item " + item.toString() + 
                " IN array (first item) at location " + location);
                
        item = array[array.length-1];
        location = search.linear(item, array);
        Output.show("Linear Search for item " + item.toString() + 
                " IN array (last item) at location " + location);
        
        location = Random.generate(0, SIZE-1);
        item = array[location];
        location = search.linear(item, array);
        Output.show("Linear Search for item " + item.toString() + 
                " IN array (randomly) at location " + location);
        
        item = notFindableItem.clone();
        location = search.linear(item, array);
        Output.show("Linear Search for item " + item.toString() + 
                " NOT IN array at location " + location);
        
        
        
        
        Output.header("Search Testing",false,false);
    }
    
}
