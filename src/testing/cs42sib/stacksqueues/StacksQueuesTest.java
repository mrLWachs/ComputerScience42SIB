
/** required package class namespace */
package testing.cs42sib.stacksqueues;

import collections.Queue;
import collections.Stack;
import testing.cs40s.advancedclasses.Athlete;
import tools.Randomizer;



/**
 * StacksQueuesTest.java - 
 *
 * @author Mr. Wachs 
 * @since 1-Mar-2019 
 */
public class StacksQueuesTest 
{

    /**
     * Default constructor for the class, sets class properties
     */
    public StacksQueuesTest() {
        System.out.println("\nStacks and Queues test started...\n");
        
        final int MAX = 10;
        
        Stack<Boolean>   stack1 = new Stack<>();
        Stack<Integer>   stack2 = new Stack<>();
        Stack<Double>    stack3 = new Stack<>();
        Stack<Character> stack4 = new Stack<>();
        Stack<String>    stack5 = new Stack<>();
        Stack<Athlete>   stack6 = new Stack<>();
        
        Queue<Boolean>   queue1 = new Queue<>();
        Queue<Integer>   queue2 = new Queue<>();
        Queue<Double>    queue3 = new Queue<>();
        Queue<Character> queue4 = new Queue<>();
        Queue<String>    queue5 = new Queue<>();
        Queue<Athlete>   queue6 = new Queue<>();
        
        Stack<Boolean>   copyStack1 = new Stack<>();
        Stack<Integer>   copyStack2 = new Stack<>();
        Stack<Double>    copyStack3 = new Stack<>();
        Stack<Character> copyStack4 = new Stack<>();
        Stack<String>    copyStack5 = new Stack<>();
        Stack<Athlete>   copyStack6 = new Stack<>();
        
        Queue<Boolean>   copyQueue1 = new Queue<>();
        Queue<Integer>   copyQueue2 = new Queue<>();
        Queue<Double>    copyQueue3 = new Queue<>();
        Queue<Character> copyQueue4 = new Queue<>();
        Queue<String>    copyQueue5 = new Queue<>();
        Queue<Athlete>   copyQueue6 = new Queue<>();
        
        Stack[] allStacks      = { stack1, stack2, stack3, 
                                   stack4, stack5, stack6, 
                                   copyStack1, copyStack2, copyStack3, 
                                   copyStack4, copyStack5, copyStack6 };        
        Queue[] allQueues      = { queue1, queue2, queue3, 
                                   queue4, queue5, queue6, 
                                   copyQueue1, copyQueue2, copyQueue3, 
                                   copyQueue4, copyQueue5, copyQueue6 };
        
        
        output(allStacks, allQueues, false);
        random(MAX, allStacks, allQueues);
        output(allStacks, allQueues, false);
        
        System.out.println("\nStacks sizes...\n");
        for (int i = 0; i < 6; i++) {
            System.out.println(allStacks[i].size());            
        }
        System.out.println("\nQueues sizes...\n");
        for (int i = 0; i < 6; i++) {
            System.out.println(allQueues[i].size());            
        }
        
        System.out.println("\nStacks is empty...\n");
        for (int i = 0; i < 6; i++) {
            System.out.println(allStacks[i].isEmpty());            
        }
        System.out.println("\nQueues is empty...\n");
        for (int i = 0; i < 6; i++) {
            System.out.println(allQueues[i].isEmpty());            
        }
        
        System.out.println("\nStacks peek...\n");
        for (int i = 0; i < 6; i++) {
            System.out.println(allStacks[i].peek());            
        }
        System.out.println("\nQueues peek...\n");
        for (int i = 0; i < 6; i++) {
            System.out.println(allQueues[i].peek());            
        }
        
        System.out.println("\nStacks pop...\n");
        for (int i = 0; i < 6; i++) {
            System.out.println("\nStack " + i + ":");
            for (int j = 0; j <= MAX; j++) {
                System.out.println(j + " = " + allStacks[i].pop());
            }
        }
        System.out.println("\nQueues dequeue...\n");
        for (int i = 0; i < 6; i++) {
            System.out.println("\nQueue " + i + ":");
            for (int j = 0; j <= MAX; j++) {
                System.out.println(j + " = " + allQueues[i].dequeue());      
            }                    
        }
             
        System.out.println("\nCloning all stacks and queues...\n");
        for (int i = 0; i < 6; i++) {
            allStacks[i + 6] = allStacks[i].clone();
            allQueues[i + 6] = allQueues[i].clone();
        }
        
        output(allStacks, allQueues, true);
        
        System.out.println("\nStacks equals...\n");
        for (int i = 0; i < 6; i++) {
            Stack stackItem     = allStacks[i];
            Stack stackItemCopy = allStacks[i + 6];
            if (stackItem.equals(stackItemCopy)) {
                System.out.println(i + ": Stack == Stack Copy");
            }
            else {
                System.out.println(i + ": Stack != Stack Copy");
            }           
        }
        System.out.println("\nQueues equals...\n");
        for (int i = 0; i < 6; i++) {
            Queue queueItem     = allQueues[i];
            Queue queueItemCopy = allQueues[i + 6];
            if (queueItem.equals(queueItemCopy)) {
                System.out.println(i + ": Queue == Queue Copy");
            }
            else {
                System.out.println(i + ": Queue != Queue Copy");
            }           
        }
        
        output(allStacks, allQueues, true);
        
        System.out.println("\nStacks and Queues test Complete!\n");
    }

    /**
     * Randomly adds to the stacks and queues random values
     * 
     * @param number the number of items to add
     * @param allStacks an array of all stack objects
     * @param allQueues an array of all queue objects
     */
    private void random(int number, Stack[] allStacks, Queue[] allQueues) {
        System.out.println("\nRandomizing all stacks and queues...\n");
        for (int i = 0; i < number; i++) {
            allStacks[0].push(Randomizer.generate());
            allStacks[1].push(Randomizer.generate(
                    Integer.MIN_VALUE, Integer.MAX_VALUE));
            allStacks[2].push(Randomizer.generate(
                    Double.MIN_VALUE, Double.MAX_VALUE));
            allStacks[3].push(Randomizer.generate('a', 'z'));
            allStacks[4].push(Randomizer.generate(5, 'a', 'z'));
            allStacks[5].push(Randomizer.generateAthlete());
        }        
        for (int i = 0; i < number; i++) {
            allQueues[0].enqueue(Randomizer.generate());
            allQueues[1].enqueue(Randomizer.generate(
                    Integer.MIN_VALUE, Integer.MAX_VALUE));
            allQueues[2].enqueue(Randomizer.generate(
                    Double.MIN_VALUE, Double.MAX_VALUE));
            allQueues[3].enqueue(Randomizer.generate('a', 'z'));
            allQueues[4].enqueue(Randomizer.generate(5, 'a', 'z'));
            allQueues[5].enqueue(Randomizer.generateAthlete());
        }    
    }

    /**
     * Outputs all stacks and queues to the standard output (screen)
     * 
     * @param allStacks an array of all stack objects
     * @param allQueues an array of all queue objects
     * @param showCopies flag to indicate whether or not to show the copies 
     */
    private void output(Stack[] allStacks, Queue[] allQueues, 
            boolean showCopies) {
        System.out.println("\nOutputting all stacks and queues...\n");
        System.out.println("\nAll Stacks...\n");        
        for (int i = 0; i < 6; i++) {            
            System.out.println(allStacks[i].toString());
        }
        if (showCopies) {
            System.out.println("\nAll Stack copies...\n");
            for (int i = 6; i < allStacks.length; i++) {            
                System.out.println(allStacks[i].toString());
            }
        }
        System.out.println("\nAll Queues...\n");
        for (int i = 0; i < 6; i++) {            
            System.out.println(allQueues[i].toString());
        }
        if (showCopies) {
            System.out.println("\nAll Queue copies...\n");
            for (int i = 6; i < allQueues.length; i++) {            
                System.out.println(allQueues[i].toString());
            }
        }
    }

}
