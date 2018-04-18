
/** required package class namespace */
package WORKAHEAD;


import WORKAHEAD.Searcher;
//import testing.TestController;
import testing.Tester;
//import testing.advancedclasses.Student;

/**
 * SearchTest.java - the testing done on the Searcher class
 * @author Mr. Wachs
 * @since Mar 1, 2017
 * @instructor Mr. Wachs
 */
public class SearchTest 
{
    
//    /** default constructor for the class */
//    public SearchTest() {
////        Tester.start("Searching");        
//////        inClassTest();
////        bigTest(); 
////        Tester.end("Searching");
//    }
//
//    private void inClassTest() {
////        Integer[] a1 = {
////            10,20,30,40,50
////        };
////
////        Student[] a2 = {
////            new Student("A",1,true,1),
////            new Student("B",2,false,2),
////            new Student("C",3,true,3),
////            new Student("D",4,false,4),
////            new Student("E",5,true,5)
////        };
////        
////        Integer item1 = 20;
////        Student item2 = new Student("C",3,true,3);
////        
////        Searcher<Integer> search1 = new Searcher<>();
////        Searcher<Student> search2 = new Searcher<>();
////        
////        int result1 = search1.linearSearch(item1, a1);
////        int result2 = search2.linearSearch(item2, a2);
////       
////        ;
////        new Tester().output(item2);
////                
////        new Tester().output(a1);
////        new Tester().output(a2);
////                        
////        System.out.println("Location = " + result1 + 
////                "\tfor item: ");
////        new Tester().output(item1);
////        System.out.println("Location = " + result2 + 
////                "\tfor item: ");
////        new Tester().output(item2);
//    }
//
//    /** the large test on a variety of data types */
//    private void bigTest() {
//        Searcher search = new Searcher();        
//        System.out.println("Linear Search Tests...\n");
//        SearchingAndSortingTest.resetListAndArrayData();
//        System.out.println("The current lists and arrays...\n");
//        SearchingAndSortingTest.outputListAndArrayData();                
//        SearchingAndSortingTest.randomSearchItems();
//        SearchingAndSortingTest.locationSearchItems();        
//        int result1  = search.linearSearch(SearchingAndSortingTest.item1,  
//                                           SearchingAndSortingTest.list1);
//        int result2  = search.linearSearch(SearchingAndSortingTest.item2,  
//                                           SearchingAndSortingTest.list2);
//        int result3  = search.linearSearch(SearchingAndSortingTest.item3,  
//                                           SearchingAndSortingTest.list3);
//        int result4  = search.linearSearch(SearchingAndSortingTest.item4,  
//                                           SearchingAndSortingTest.list4);
//        int result5  = search.linearSearch(SearchingAndSortingTest.item5,  
//                                           SearchingAndSortingTest.list5);
//        int result6  = search.linearSearch(SearchingAndSortingTest.item6,  
//                                           SearchingAndSortingTest.array1);
//        int result7  = search.linearSearch(SearchingAndSortingTest.item7,  
//                                           SearchingAndSortingTest.array2);
//        int result8  = search.linearSearch(SearchingAndSortingTest.item8,  
//                                           SearchingAndSortingTest.array3);
//        int result9  = search.linearSearch(SearchingAndSortingTest.item9,  
//                                           SearchingAndSortingTest.array4);
//        int result10 = search.linearSearch(SearchingAndSortingTest.item10,  
//                                           SearchingAndSortingTest.array5);  
//        int result11 = search.linearSearch(SearchingAndSortingTest.item11,  
//                                           SearchingAndSortingTest.list1);
//        int result12 = search.linearSearch(SearchingAndSortingTest.item12,  
//                                           SearchingAndSortingTest.list2);
//        int result13 = search.linearSearch(SearchingAndSortingTest.item13,  
//                                           SearchingAndSortingTest.list3);
//        int result14 = search.linearSearch(SearchingAndSortingTest.item14,  
//                                           SearchingAndSortingTest.list4);
//        int result15 = search.linearSearch(SearchingAndSortingTest.item15,  
//                                           SearchingAndSortingTest.list5);
//        int result16 = search.linearSearch(SearchingAndSortingTest.item16,  
//                                           SearchingAndSortingTest.array1);
//        int result17 = search.linearSearch(SearchingAndSortingTest.item17,  
//                                           SearchingAndSortingTest.array2);
//        int result18 = search.linearSearch(SearchingAndSortingTest.item18,  
//                                           SearchingAndSortingTest.array3);
//        int result19 = search.linearSearch(SearchingAndSortingTest.item19,  
//                                           SearchingAndSortingTest.array4);
//        int result20 = search.linearSearch(SearchingAndSortingTest.item20,  
//                                           SearchingAndSortingTest.array5);
//        System.out.println("\nSearching for random data...\n");
//        SearchingAndSortingTest.results("Search 1  of List  1",
//                SearchingAndSortingTest.item1, result1);
//        SearchingAndSortingTest.results("Search 2  of List  2",
//                SearchingAndSortingTest.item2, result2);
//        SearchingAndSortingTest.results("Search 3  of List  3",
//                SearchingAndSortingTest.item3, result3);
//        SearchingAndSortingTest.results("Search 4  of List  4",
//                SearchingAndSortingTest.item4, result4);
//        SearchingAndSortingTest.results("Search 5  of List  5",
//                SearchingAndSortingTest.item5, result5);
//        SearchingAndSortingTest.results("Search 6  of Array 1",
//                SearchingAndSortingTest.item1, result6);
//        SearchingAndSortingTest.results("Search 7  of Array 2",
//                SearchingAndSortingTest.item2, result7);
//        SearchingAndSortingTest.results("Search 8  of Array 3",
//                SearchingAndSortingTest.item3, result8);
//        SearchingAndSortingTest.results("Search 9  of Array 4",
//                SearchingAndSortingTest.item4, result9);
//        SearchingAndSortingTest.results("Search 10 of Array 5",
//                SearchingAndSortingTest.item5, result10);  
//        System.out.println("\nSearching for found data...\n");
//        SearchingAndSortingTest.results("Search 11 of List  1",
//                SearchingAndSortingTest.item6, result11);
//        SearchingAndSortingTest.results("Search 12 of List  2",
//                SearchingAndSortingTest.item7, result12);
//        SearchingAndSortingTest.results("Search 13 of List  3",
//                SearchingAndSortingTest.item8, result13);
//        SearchingAndSortingTest.results("Search 14 of List  4",
//                SearchingAndSortingTest.item9, result14);
//        SearchingAndSortingTest.results("Search 15 of List  5",
//                SearchingAndSortingTest.item10,result15);
//        SearchingAndSortingTest.results("Search 16 of Array 1",
//                SearchingAndSortingTest.item11,result16);
//        SearchingAndSortingTest.results("Search 17 of Array 2",
//                SearchingAndSortingTest.item12,result17);
//        SearchingAndSortingTest.results("Search 18 of Array 3",
//                SearchingAndSortingTest.item13,result18);
//        SearchingAndSortingTest.results("Search 19 of Array 4",
//                SearchingAndSortingTest.item14,result19);
//        SearchingAndSortingTest.results("Search 20 of Array 5",
//                SearchingAndSortingTest.item15,result20);                 
//        System.out.println("\nBinary Search Tests...\n");        
//        SearchingAndSortingTest.resetListAndArrayData();
//        SearchingAndSortingTest.sortAllListsAndArrays();
//        System.out.println("The current lists and arrays...\n");
//        SearchingAndSortingTest.outputListAndArrayData();                
//        SearchingAndSortingTest.randomSearchItems();
//        SearchingAndSortingTest.locationSearchItems();        
//        result1  = search.binarySearch(SearchingAndSortingTest.item1,  
//                                           SearchingAndSortingTest.list1);
//        result2  = search.binarySearch(SearchingAndSortingTest.item2,  
//                                           SearchingAndSortingTest.list2);
//        result3  = search.binarySearch(SearchingAndSortingTest.item3,  
//                                           SearchingAndSortingTest.list3);
//        result4  = search.binarySearch(SearchingAndSortingTest.item4,  
//                                           SearchingAndSortingTest.list4);
//        result5  = search.binarySearch(SearchingAndSortingTest.item5,  
//                                           SearchingAndSortingTest.list5);
//        result6  = search.binarySearch(SearchingAndSortingTest.item6,  
//                                           SearchingAndSortingTest.array1);
//        result7  = search.binarySearch(SearchingAndSortingTest.item7,  
//                                           SearchingAndSortingTest.array2);
//        result8  = search.binarySearch(SearchingAndSortingTest.item8,  
//                                           SearchingAndSortingTest.array3);
//        result9  = search.binarySearch(SearchingAndSortingTest.item9,  
//                                           SearchingAndSortingTest.array4);
//        result10 = search.binarySearch(SearchingAndSortingTest.item10,  
//                                           SearchingAndSortingTest.array5);  
//        result11 = search.binarySearch(SearchingAndSortingTest.item11,  
//                                           SearchingAndSortingTest.list1);
//        result12 = search.binarySearch(SearchingAndSortingTest.item12,  
//                                           SearchingAndSortingTest.list2);
//        result13 = search.binarySearch(SearchingAndSortingTest.item13,  
//                                           SearchingAndSortingTest.list3);
//        result14 = search.binarySearch(SearchingAndSortingTest.item14,  
//                                           SearchingAndSortingTest.list4);
//        result15 = search.binarySearch(SearchingAndSortingTest.item15,  
//                                           SearchingAndSortingTest.list5);
//        result16 = search.binarySearch(SearchingAndSortingTest.item16,  
//                                           SearchingAndSortingTest.array1);
//        result17 = search.binarySearch(SearchingAndSortingTest.item17,  
//                                           SearchingAndSortingTest.array2);
//        result18 = search.binarySearch(SearchingAndSortingTest.item18,  
//                                           SearchingAndSortingTest.array3);
//        result19 = search.binarySearch(SearchingAndSortingTest.item19,  
//                                           SearchingAndSortingTest.array4);
//        result20 = search.binarySearch(SearchingAndSortingTest.item20,  
//                                           SearchingAndSortingTest.array5);
//        System.out.println("\nSearching for random data...\n");
//        SearchingAndSortingTest.results("Search 21  of List  1",
//                SearchingAndSortingTest.item1, result1);
//        SearchingAndSortingTest.results("Search 22  of List  2",
//                SearchingAndSortingTest.item2, result2);
//        SearchingAndSortingTest.results("Search 23  of List  3",
//                SearchingAndSortingTest.item3, result3);
//        SearchingAndSortingTest.results("Search 24  of List  4",
//                SearchingAndSortingTest.item4, result4);
//        SearchingAndSortingTest.results("Search 25  of List  5",
//                SearchingAndSortingTest.item5, result5);
//        SearchingAndSortingTest.results("Search 26  of Array 1",
//                SearchingAndSortingTest.item1, result6);
//        SearchingAndSortingTest.results("Search 27  of Array 2",
//                SearchingAndSortingTest.item2, result7);
//        SearchingAndSortingTest.results("Search 28  of Array 3",
//                SearchingAndSortingTest.item3, result8);
//        SearchingAndSortingTest.results("Search 29  of Array 4",
//                SearchingAndSortingTest.item4, result9);
//        SearchingAndSortingTest.results("Search 30 of Array 5",
//                SearchingAndSortingTest.item5, result10);  
//        System.out.println("\nSearching for found data...\n");
//        SearchingAndSortingTest.results("Search 31 of List  1",
//                SearchingAndSortingTest.item6, result11);
//        SearchingAndSortingTest.results("Search 32 of List  2",
//                SearchingAndSortingTest.item7, result12);
//        SearchingAndSortingTest.results("Search 33 of List  3",
//                SearchingAndSortingTest.item8, result13);
//        SearchingAndSortingTest.results("Search 34 of List  4",
//                SearchingAndSortingTest.item9, result14);
//        SearchingAndSortingTest.results("Search 35 of List  5",
//                SearchingAndSortingTest.item10,result15);
//        SearchingAndSortingTest.results("Search 36 of Array 1",
//                SearchingAndSortingTest.item11,result16);
//        SearchingAndSortingTest.results("Search 37 of Array 2",
//                SearchingAndSortingTest.item12,result17);
//        SearchingAndSortingTest.results("Search 38 of Array 3",
//                SearchingAndSortingTest.item13,result18);
//        SearchingAndSortingTest.results("Search 39 of Array 4",
//                SearchingAndSortingTest.item14,result19);
//        SearchingAndSortingTest.results("Search 40 of Array 5",
//                SearchingAndSortingTest.item15,result20);
//    }
        
}
