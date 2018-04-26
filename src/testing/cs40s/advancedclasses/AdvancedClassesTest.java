
/** required package class namespace */
package testing.cs40s.advancedclasses;

/** required imports */
import testing.Output;
import testing.cs40s.advancedclasses.ComputerScienceStudent;
import testing.cs40s.advancedclasses.ComputerScienceTeacher;
import testing.cs40s.advancedclasses.Doctor;
import testing.cs40s.advancedclasses.Donut;
import testing.cs40s.advancedclasses.FiletMignon;
import testing.cs40s.advancedclasses.FireFighter;
import testing.cs40s.advancedclasses.HighSchoolStudent;
import testing.cs40s.advancedclasses.House;
import testing.cs40s.advancedclasses.Husky;
import testing.cs40s.advancedclasses.Meeting;
import testing.cs40s.advancedclasses.MrWachs;
import testing.cs40s.advancedclasses.Person;
import testing.cs40s.advancedclasses.Pizza;
import testing.cs40s.advancedclasses.Present;
import testing.cs40s.advancedclasses.SpiderMan;
import testing.cs40s.advancedclasses.Student;
import testing.cs40s.advancedclasses.Teacher;

/**
 * AdvancedClassesTest.java - tests the concepts learned in this unit
 *
 * @author Mr. Wachs 
 * @since Oct 4, 2017 
 * @instructor Mr. Wachs
 */
public class AdvancedClassesTest 
{

    /** 
     * Default constructor for the class 
     */
    public AdvancedClassesTest() {        
        Output.header("Advanced Classes unit test",true,false);
                
        Person person = new Person();
        person.age = 42;
        person.isMale = true;
        person.talk();
        
        Person clone = person.clone();
        clone.talk();
        
        Student student = new Student(101);
        student.talk();
        student.isMale = true;
        
        Student brody     = new Student(12);
        Student christian = new Student(427);
        Student juhyung   = new Student(911);
        Student mason     = new Student(42);
        Student bailey    = new Student(993);
        
        Output.show(christian.totalStudents);
        Output.show(bailey.totalStudents);
        Output.show(juhyung.totalStudents);
        
        juhyung.endOfTheWorld();
        Person.endOfTheWorld();
        Student.endOfTheWorld();
        Teacher.endOfTheWorld();
        person.endOfTheWorld();
        
        FireFighter dirk = new FireFighter();
        Output.show(dirk.toString());
          
        Object object = new Object();
        Output.show(object);
        
        Teacher teacher = new Teacher("Mr. Macwilliam", true, 54);
        Student s1 = new Student("Christian",true,17,102);
        Student s2 = new Student("Brody",true,17,103);
        Student s3 = new Student("Bailey",false,17,104);
        Student s4 = new Student("Juhyung",true,17,105);
        Student s5 = new Student("Mason",true,17,106);
        teacher.add(s1);
        teacher.add(s2);
        teacher.add(s3);
        teacher.add(s4);
        teacher.add(s5);
        teacher.add(new Student(107));
        Output.show(teacher.toString());
        teacher.teach();
        Output.show(teacher);
       
        Teacher evans = teacher.clone();
        Output.show(evans);        
        Doctor phil = new Doctor();
        Output.show(phil);        
        HighSchoolStudent billy = new HighSchoolStudent("William Sing", 
                                                       true, 17, 555);
        Output.show(billy);        
        Husky cameron = new Husky("Cameron Jones", false, 20, 6);
        Output.show(cameron);        
        ComputerScienceTeacher mrTheBuilder = new ComputerScienceTeacher(
                "Bob The Builder", true, 21);        
        Output.show(mrTheBuilder);        
        MrWachs mrWachs = new MrWachs(48);        
        Output.show(mrWachs);
        
        checkStatus(mrWachs);
        checkStatus(mrTheBuilder);
        checkStatus(cameron);
        checkStatus(billy);
        checkStatus(phil);
        checkStatus(person);
        checkStatus(object);
        checkStatus(dirk);
        
        Meeting meeting = new Meeting();
        
        meeting.attend(person);
        meeting.attend(student);
        meeting.attend(dirk);
        meeting.attend(s1);
        meeting.attend(s2);
        meeting.attend(s3);
        meeting.attend(s4);
        meeting.attend(s5);
        meeting.attend(evans);
        meeting.attend(mrWachs);
        meeting.attend(mrTheBuilder);
        meeting.attend(cameron);
        meeting.attend(billy);
        meeting.attend(phil);
        meeting.hold();        
                
        Pizza       pizza       = new Pizza();
        FiletMignon filetMignon = new FiletMignon();
        Donut       donut       = new Donut();
        
        mrWachs.eat(pizza);
        mrWachs.eat(filetMignon);
        mrWachs.eat(donut);
        
        SpiderMan spiderMan = new SpiderMan(55);
        spiderMan.setSecretId("Photographer");
        spiderMan.set("Red and Blue with webs");
        spiderMan.beHeroic();
        spiderMan.eat(donut);
        
        String  string  = new String("pineapple");
        Integer integer = new Integer("28");        
        Double  dbl     = new Double("4.2");        
        Boolean bool    = new Boolean("true");
        
        output(string);
        output(integer);
        output(dbl);        
        output(bool);        
        output(spiderMan);
        
        Present<String>    present1 = new Present<>(string);
        Present<Integer>   present2 = new Present<>(integer);
        Present<Double>    present3 = new Present<>(dbl);
        Present<Boolean>   present4 = new Present<>(bool);
        Present<SpiderMan> present5 = new Present<>(spiderMan);
        Present<MrWachs>   present6 = new Present<>(mrWachs);
                
        Present[] presents = { present1, present2, present3, 
                               present4, present5, present6 };
        
        for (Present present : presents) {
            present.peek();
        }
                
        House<Doctor,Present> house = new House<>(phil,presents);
        
        Output.show(house.homeOwner);
        Output.show(house.items[5].open().toString());
               
        Output.header("Advanced Classes unit test",false,false);      
    }

    
    private static <T> void output(T item) {
        String text = "Class " + 
                item.getClass().getSimpleName() +
                " as a string is " +
                item.toString();
        Output.show(text);
    }
    
    
    private void checkStatus(Object object) {
        if (object instanceof Object) 
            Output.show("Object class");
        if (object instanceof Person) 
            Output.show("Person class");
        if (object instanceof Student) 
            Output.show("Student class");
        if (object instanceof Teacher) 
            Output.show("Teacher class");
        if (object instanceof FireFighter) 
            Output.show("FireFighter class");
        if (object instanceof Doctor) 
            Output.show("Doctor class");
        if (object instanceof HighSchoolStudent) 
            Output.show("HighSchoolStudent class");
        if (object instanceof Husky) 
            Output.show("Husky class");
        if (object instanceof ComputerScienceStudent) 
            Output.show("ComputerScienceStudent class");
        if (object instanceof ComputerScienceTeacher) 
            Output.show("ComputerScienceTeacher class");
        if (object instanceof MrWachs) 
            Output.show("MrWachs class");       
    }

}
