
/** required package class namespace */
package testing.cs40s;

/** required imports */
import io.Simulator;
import testing.cs40s.advancedclasses.BonelessPizza;
import testing.cs40s.advancedclasses.Box;
import testing.cs40s.advancedclasses.ComputerScienceTeacher;
import testing.cs40s.advancedclasses.Food;
import testing.cs40s.advancedclasses.House;
import testing.cs40s.advancedclasses.Husky;
import testing.cs40s.advancedclasses.HuskyAthlete;
import testing.cs40s.advancedclasses.KraftDinner;
import testing.cs40s.advancedclasses.Meeting;
import testing.cs40s.advancedclasses.Person;
import testing.cs40s.advancedclasses.Potato;
import testing.cs40s.advancedclasses.Student;
import testing.cs40s.advancedclasses.Teacher;
import testing.cs40s.advancedclasses.WellDoneSteak;
import testing.cs40s.advancedclasses.Animals;
import testing.cs40s.advancedclasses.Creatures;
import testing.cs40s.advancedclasses.Fairy;
import testing.cs40s.advancedclasses.Genie;
import testing.cs40s.advancedclasses.Hercules;
import testing.cs40s.advancedclasses.Jimmies;
import testing.cs40s.advancedclasses.King;
import testing.cs40s.advancedclasses.Magic;
import testing.cs40s.advancedclasses.Prince;
import testing.cs40s.advancedclasses.Princess;
import testing.cs40s.advancedclasses.Rapunzel;
import testing.cs40s.advancedclasses.Royalty;
import io.System;

/**
 * AdvancedClassesTest.java - tests the concepts learned in this unit
 *
 * @author Mr. Wachs
 * @since Sep. 30, 2019, 11:43:07 a.m.
 */
public class AdvancedClassesTest 
{
    
    /** 
     * Default constructor for the class 
     */
    public AdvancedClassesTest() {
        Simulator.header("Advanced classes unit starting...");
        
        // Review of classes concepts (properties, methods, object, inheritance)
        
        // using the class to create an object with the default constructor:
        // class object = call constructor method (default)
        Person person = new Person();                   // person object
        person.talk();                                  // calls class method 
        
        // class using inheritance
        Student student = new Student(99);              // new student object
        student.talk();                                 // inherited method
        
        // The Object class (parent class of all classes)
        
        // all classes (including ones we create) inherit from the object 
        // class which is the parent (super) of all classes
        Object object1 = new Object();
        Object object2 = object1;                       // parent of all classes
        
        // The toString(), clone(), and equals() methods
        
        System.out.println(object1.toString());         // the toString method
        System.out.println(object2.toString());
                
        // Use of the equals, toString, and clone methods that are inherited 
        // (but over-ridden) from the Object class with student objects:        
        Student brayden = new Student("Brayden Ruby",19,false,11);
        Student owen    = new Student("Owen Notplace",6,true,12);
        Student brady   = brayden.clone();              // clone method
        brady.setName("Brady Nemetchek");               // modifier method
        
        System.out.println(brayden.toString());         // toString overloaded
        System.out.println(owen.toString());
        System.out.println(brady.toString());
        
        // equals overloaded
        if (brayden.equals(owen))  System.out.println("Brayden == Owen");
        if (brayden.equals(brady)) System.out.println("Brayden == Brady");
        if (owen.equals(brady))    System.out.println("Owen == Brady");
        
        // The static keyword (for properties and methods)
        
        Student s = new Student(60);    // Instantiate another student object
        System.out.println(Student.totalStudents);  // access static property
                               
        Person.endTheWorld();           // invoking the static method from the      
        Student.endTheWorld();          // class not the object      
        Teacher.endTheWorld();
        
        // create various custom objects...
        Rapunzel               rapunzel   = new Rapunzel();
        Hercules               hercules   = new Hercules();
        Genie                  genie      = new Genie("");
        Fairy                  tinkerbell = new Fairy();
        Animals                flounder   = new Animals();
        ComputerScienceTeacher rogowy     = new ComputerScienceTeacher();
        Husky                  havoc      = new Husky("Havoc Husky", 13, true, 6556);
        Jimmies                jim        = new Jimmies("Jim Donkey", 17, false, 0);
                
        // and output them (using toString called automatically)
        System.out.println(rapunzel);
        System.out.println(hercules);
        System.out.println(genie);
        System.out.println(tinkerbell);
        System.out.println(flounder);
        System.out.println(rogowy);
        System.out.println(havoc);
        System.out.println(jim);
                
        // call a method with new code...  
        whatIs(person);
        whatIs(student);
        whatIs(brayden);
        whatIs(owen);
        whatIs(brady);
        whatIs(s);
        whatIs(rapunzel);
        whatIs(hercules);
        whatIs(genie);
        whatIs(tinkerbell);
        whatIs(flounder);
        whatIs(rogowy);
        whatIs(havoc);
        whatIs(jim);
        
        // use some polymorphism....        
        Meeting meeting = new Meeting();        // create meeting object
        meeting.attend(person);                 // add various child objects
        meeting.attend(brady);                  // using polymorphic method  
        meeting.attend(brayden);                // arguments
        meeting.attend(student);
        meeting.attend(owen);
        meeting.attend(rapunzel);
        meeting.attend(havoc);
        meeting.attend(jim);
        meeting.attend(hercules);
        meeting.attend(rogowy);        
        meeting.hold();                         // hold the mmeting
        
        // create objects from classes that inherited from an abstract class:        
        Potato        potato = new Potato();
        BonelessPizza boneyM = new BonelessPizza();
        KraftDinner   kd     = new KraftDinner();
        WellDoneSteak meat   = new WellDoneSteak();
        
        // call the polymorphic method of person objects        
        hercules.haveDinner(potato);
        rapunzel.haveDinner(boneyM);
        brayden.haveDinner(meat);
        hercules.haveDinner(kd);
        
        // a class that uses interfaces to test the interfaces        
        HuskyAthlete athlete = new HuskyAthlete("Havoc", 17, true, 2665);        
        for (int round = 0; round < 4; round++) {            
            if (athlete.haveYouGotItSigned()) {                
                athlete.setOpponent("Bears");                
                athlete.score(6, "Havoc");
                athlete.score(3, "Bears");                
                athlete.backFlipKick(true);                
                athlete.endOfQuarter(round);
                athlete.endOfSets(round);                
            }
            else {
                athlete.sign();
            }            
        }       
        if (athlete.didIWin()) athlete.haveDinner(kd);
        
        // use our generic method, starting with primative data types:        
        boolean b = true;
        int     i = 0;
        double  d = 3.14;
        char    c = 'Z';
        
        // now use the primatives with a more complex data type (class) 
        // called a "wrapper" class from the primatives         
        Boolean   bool      = new Boolean(b);
        Integer   integer   = new Integer(i);
        Double    doub      = new Double(d);
        Character character = new Character(c);
        // and also string...
        String    string    = new String("boomer");
        
        // calling the generic method on the variety of objects
        output(bool);
        output(integer);
        output(doub);
        output(character);
        output(string);
        output(athlete);
        
        // using a generic class, when a generic class is instantiated (an 
        // object of the class is created), then you define what type the 
        // generic is       
        Box<Boolean>      box1 = new Box<>(bool);
        Box<Integer>      box2 = new Box<>(integer);
        Box<Double>       box3 = new Box<>(doub);
        Box<Character>    box4 = new Box<>(character);
        Box<String>       box5 = new Box<>(string);
        Box<HuskyAthlete> box6 = new Box<>(athlete);
        
        // peek in the boxes
        box1.peek();
        box2.peek();
        box3.peek();
        box4.peek();
        box5.peek();
        box6.peek();
        
        // open all the boxes
        Boolean   newBool   = box1.open();
        Integer   newInt    = box2.open();
        Double    newDoub   = box3.open();
        Character newChar   = box4.open();
        String    newString = box5.open();
        Person    newPerson = box6.open();
        
        // output the new data type variables
        System.out.println(newBool.toString());
        System.out.println(newInt.toString());
        System.out.println(newDoub.toString());
        System.out.println(newChar.toString());
        System.out.println(newString.toString());
        System.out.println(newPerson.toString());
        
        // generic class with multiple generic types   
        House<Teacher,Royalty> house = new House<>();
        
        house.homeOwner = rogowy;
        house.contents = rapunzel;
        
        House<Hercules,Genie> olympus = new House<>();
        
        olympus.homeOwner = hercules;
        olympus.contents = genie;
        
        // test our generic method        
        Food[] fridge = {
          boneyM,potato  
        };        
        house.party(fridge);
        
        BonelessPizza[] pizzas = new BonelessPizza[100];
        for (int pizza = 0; pizza < pizzas.length; pizza++) {
            pizzas[pizza] = new BonelessPizza();
        }
        olympus.party(pizzas);
        
        Simulator.header("Advanced classes unit complete!");
    }    

    /**
     * Checks the passed object and outputs what class type the object is. 
     * This method uses the instanceof operator to do the logic
     * 
     * @param object the object type to check
     */
    private void whatIs(Object object) {
        String name = "This is a ";
        if (object instanceof Magic)                  name += "Magic -> ";
        if (object instanceof Hercules)               name += "Hercules -> ";
        if (object instanceof Rapunzel)               name += "Rapunzel -> ";
        if (object instanceof Prince)                 name += "Prince -> ";
        if (object instanceof Princess)               name += "Student -> ";
        if (object instanceof King)                   name += "King -> ";
        if (object instanceof ComputerScienceTeacher) name += "ComputerScienceTeacher -> ";
        if (object instanceof Jimmies)                name += "Jimmies -> ";
        if (object instanceof Husky)                  name += "Husky -> ";        
        if (object instanceof Royalty)                name += "Royalty -> ";
        if (object instanceof Teacher)                name += "Teacher -> ";
        if (object instanceof Student)                name += "Student -> ";
        if (object instanceof Person)                 name += "Person -> ";        
        if (object instanceof Genie)                  name += "Genie -> ";
        if (object instanceof Fairy)                  name += "Fairy -> ";
        if (object instanceof Animals)                name += "Animals -> ";        
        if (object instanceof Creatures)              name += "Creatures -> ";
        if (object instanceof Object)                 name += "Object";
        System.out.println(name);
    }

    /**
     * Outputs a generic item with information about the data type
     * 
     * @param <T> the generic type used
     * @param item the item to output
     */
    private static <T> void output(T item) {
        String text = "Class ";
        text += item.getClass().getSimpleName();
        text += " as a string is " + item.toString();
        System.out.println(text);
    } 
    
}
