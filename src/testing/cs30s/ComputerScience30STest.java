
/** required package class namespace */
package testing.cs30s;

import testing.Output;
import java.awt.Color;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
//import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * ComputerScience30STest.java - description here...
 *
 * @author Mr. Wachs (login: lawrence.wachs)
 * @since Mar 2, 2018 
 * @instructor Mr. Wachs
 */
public class ComputerScience30STest 
{

    /** 
     * Default constructor for the class 
     */
    public ComputerScience30STest() {
        Output.header("Computer Science 30S course test",true,false);
        unit1();
        unit2();
        unit3();
        unit4();        
        unit5();
        Output.header("Computer Science 30S course test",false,false);
    }
  
    /**
     * Unit 1 - The basics of Java programming
     */
    private static void unit1() {
        Output.header("Java Basics unit",true,false);
        //////////////////////////////////////////////////////////////////////
        Output.comment("JAVA BASICS:");
        //////////////////////////////////////////////////////////////////////
        // This is a comment on a line, everything after // is a comment
        /*
        This is another comment (a multi-line comment) because it keeps
        commenting until another star and slash comes up
         */
        Output.comment("Simple screen outputs:");
        Output.show("Hello World..."); // end of line comment
        Output.comment("output with a new line break afterwards");
        Output.show("Goodbye world");
        Output.comment("examples of escape characters:");        
        Output.show(" \n Escape character 1 \n\n");  // new line        
        Output.show(" \t Escape character 2");       // tab
        Output.show(" \" Escape character 3 \" ");   // quote
        Output.show(" \\ Escape character 4 \\ ");   // slash
        //////////////////////////////////////////////////////////////////////
        Output.comment("INPUT AND OUTPUT DIALOG BOXES:");
        //////////////////////////////////////////////////////////////////////
        Output.comment("a simple output dialog");
        Output.dialog("Basic message dialog");
        Output.comment("options for the dialogs, you can change the title and icon style");
        Output.dialog("Information Icon");
        Output.dialog("Question Icon");
        Output.dialog("Blank Icon");
        Output.comment("a simple dialog for getting user input");
        Output.dialog("Enter something");
        Output.comment("you have the same title and icon options for input dialogs");
        Output.dialog("Enter:");
        Output.dialog("Enter:");
        Output.dialog("Enter:");
        Output.dialog("Enter:");
        Output.comment("confirm dialog and its options");
        Output.dialog("Basic confirm");
        Output.dialog("Confirm 1");
        Output.dialog("Confirm 2");
        //////////////////////////////////////////////////////////////////////
        Output.comment("VARIABLES:");
        //////////////////////////////////////////////////////////////////////
        boolean a = true;
        Output.comment("declares the variable");
        a = false;
        Output.comment("using the variable");
        Output.show("a = " + a);
        Output.comment("output the contents of the variable");
        Output.comment("other primitive (simple) data types:");
        int b = 0;
        Output.comment("whole #s, no decimals");
        double c = 0.0;
        Output.comment("allow for decimals");
        char d = '@';
        Output.comment("1 single character");
        String e = "words";
        Output.comment("a more advanced data type... ");
        Output.show("b = " + b);
        Output.comment("output the variables:");
        Output.show("c = " + c);
        Output.show("d = " + d);
        Output.show("e = " + e);
        Output.comment("manipulate the variables:");   
        int x = 10;
        Output.comment("x is 10");
        Output.show("x = " + x);
        x = 20;
        Output.comment("x is 20");
        Output.show("x = " + x);
        int y = x + 10;
        Output.comment("y is 30");
        Output.show("y = " + y);
        y = y + 10;
        Output.comment("y is 40");
        Output.show("y = " + y);
        Output.comment("shorthand code, not needed:");
        y++;
        Output.comment("same as y = y + 1");
        Output.show("y = " + y);
        y--;
        Output.comment("same as y = y - 1");
        Output.show("y = " + y);
        Output.comment("more shorthand code:");        
        y += 10;
        Output.comment("same as y = y + 10");
        Output.show("y = " + y); // 50        
        y -= 20;
        Output.comment("30");
        y *= 30;
        Output.comment("900");
        y /= 40;
        Output.comment("22");
        y %= 50;
        Output.comment("22");
        Output.show("y = " + y);
        Output.comment("% is for modulus division gives you the remainder:");        
        x = 28;
        y = x % 5;
        Output.show("y = " + y);
        Output.comment("constants (variables which don't change):");        
        final double PI = 3.14159;
        final int PROBLEMS = 99;
        final char YES = 'y';
        final boolean FOUND = false;
        final String TEACHER_NAME = "Wachs";
        Output.comment("constants are written in ALL CAPS with underscores");
        Output.show(PI + ","
                + PROBLEMS + ","
                + YES + ","
                + FOUND + ","
                + TEACHER_NAME);
        Output.comment("converting between data types:");        
        int f = 15;
        Output.comment("15"); 
        double g = f;
        Output.comment("15.0");         
        Output.show("f = " + f);
        Output.show("g = " + g);
        int h = (int) g;
        Output.comment("15");         
        Output.show("h = " + h);
        Output.comment("here casting the double into an "
                + "integer doesn't round it off, it  cuts off the decimal (truncates)");
        double k = 2.999999999;
        int l = (int) k;
        Output.comment("2"); 
        double m = (double) l * 2.5;
        Output.comment("5.0");         
        Output.show("k = " + k);
        Output.show("l = " + l);
        Output.show("m = " + m);
        Output.comment("characters can be cast as numbers:");        
        char n = 'z';
        int o = (int) n;
        Output.show("n = " + n);
        Output.show("o = " + o);
        Output.comment("stores the value as a ASCII value user input with a string:"); 
        Output.dialog("Enter");
        Output.dialog("p");
        Output.comment("convert strings into numbers:"); 
        Output.dialog("Integer");
        int r = Integer.parseInt("0");
        Output.dialog("q = r");
        Output.comment("also doubles:");
        Output.dialog("Double:");
        double t = Double.parseDouble("0");
        Output.dialog("s = t");        
        Output.comment("built-in string actions (methods/functions):");
        String word = "water";
        int count = word.length();
        Output.show(word + " length is " + count);
        char letter = word.charAt(1);
        Output.comment("index starts at 0"); 
        Output.show("Index 1 is " + letter);
        Output.comment("the length method gets the number of "
                + "characters and the charAt method gets a "
                + "character (char) at the specified index. "
                + "There are many more built-in actions "
                + "(methods) and the java documentation "
                + "available in NetBeans will help to "
                + "learn them");
        Output.comment("the built-in Math library:");        
        double answer1 = Math.abs(-8.5);
        Output.comment("absolute value");
        double answer2 = Math.PI;
        Output.comment("the value of Pi");
        double answer3 = Math.cos(0.5);
        Output.comment("cosine (sin,tan, and arcs also)");
        double answer4 = Math.log(0.5);
        Output.comment("logarithms");
        double answer5 = Math.pow(5, 3);
        Output.comment("5 to the power of 3");
        double answer6 = Math.sqrt(9);
        Output.comment("square root   ");     
        Output.show("answer 1 = " + answer1);
        Output.show("answer 2 = " + answer2);
        Output.show("answer 3 = " + answer3);
        Output.show("answer 4 = " + answer4);
        Output.show("answer 5 = " + answer5);
        Output.show("answer 6 = " + answer6);
        Output.comment("The Math library and random numbers:");
        double seed = Math.random();
        double low = 1.0;
        double high = 6.0;
        double random = (high - low + 1.0) * seed + low;
        int die = (int) random;
        Output.show("random = " + random);
        Output.show("die = " + die);
        ////////////////////////////////////////////////////////////////////
        Output.comment("CONDITIONAL STATEMENTS:");
        ////////////////////////////////////////////////////////////////////
        int value1 = 20;
        int value2 = 20;
        if (value1 == value2) {
            Output.show("Equal");
        }
        double value3 = 2.45;
        double value4 = 1.5;
        if (value3 < value4) {
            Output.show("less than");
        }
        else {
            Output.show("not less than");
        }
        char value5 = 'A', value6 = 'a';
        if (value5 != value6) {
            Output.show("Not equal");
        }
        Output.comment("not recommended, but if the block of "
                + "code controlled by the if statement is "
                + "only 1 line, the curly braces can be "
                + "ommitted using  string is a little more complicated");
        String word1 = "cat";
        String word2 = "cAt";
        if (word1.equals(word2)) {
            Output.show("are ==");
        }
        else if (word1.equalsIgnoreCase(word2)) {
            Output.show("== but not same case");
        }
        else {
            Output.show("not ==");
        }
        Output.comment("combining logic using \"and\" \"or\"");
        int age = 10;
        double iq = 0.05;
        Output.comment("&& means \"and\" || mans \"or\"");
        if (age >= 15 && iq >= 0.5) {
            Output.show("get in");
        }
        else if (age >= 15 || iq >= 0.5) {
            Output.show("get part way in");
        }
        else {
            Output.show("get out");
        }
        ////////////////////////////////////////////////////////////////////
        Output.comment("LOOPING:");
        ////////////////////////////////////////////////////////////////////
        Output.comment("simple loop");
        int counter = 1;
        while (counter <= 50) {
            Output.show("counter = " + counter);
            counter++;
        }
        Output.comment("while loop with a string");
        String password = "";
        while (password.equals("1234")) {
            Output.show("You cannot use this password!");
            Output.dialog("Password?");
        }
        Output.comment("another version of the while loop");
        String enter = "";
        do {
            Output.comment("this is for not equals, could "
                    + "use == false at the end");
            Output.dialog("Enter Password");
            enter = "";
        }
        while (!enter.equals(password));
        Output.comment("the second version of the while loop is "
                + "more rare, tests at the bottom of the "
                + "loop and runs at least once");        
        Output.comment("the for loop");
        for (int i = 0; i < 10; i++) {
            Output.show("i = " + i);
        }        
        String text = "";
        for (int i = 0; i < 100; i++) {
            text += i + ",";
        }
        Output.show(text);
        Output.comment("count down loop");
        Output.comment("same as i = i - 5");
        for (int i = 100; i >= 1; i -= 5) {            
            Output.show("i = " + i);
        }
        Output.header("Java Basics unit",false,false);
    }

    /**
     * Unit 2 - examples of code to learn the concept of methods
     */
    private static void unit2() {
        Output.header("Methods unit",true,false);
        drawStar();
        draw("cheesecake");
        draw("ice cream");
        draws("dog", 3);
        draws("dalmatians", 101);
        int number = getNumber();
        Output.show("number = " + number);
        String item = input("Enter item");
        output(item);
        int die = random(1, 6);
        output("die = " + die);
        output("Hello world","Display");
        Output.header("Methods unit",false,false);
    }
        
    /**
     * Unit 3 - examples of code to learn the concept of arrays
     */
    private static void unit3() {
        Output.header("Arrays unit",true,false);      
        Output.comment("regular integer variable for comparison");
        int size = 10;        
        Output.comment("create (declare) an integer array"); 
        int[] array = new int[4];        
        Output.comment("the array has a size of 4 slots filled with "
                + "unknown values (really zeroes)to each index spot "
                + "and it automatically indexes the slots from 0 to 3");        
        Output.comment("here I assign a 64 to slot (index) 3");
        array[3] = 64;
        Output.comment("here index 1 becomes 7");
        array[1] = 7;
        Output.comment("example of a index out of range");
        Output.comment("array[4] = 501; out of bounds   ");     
        Output.comment("created an empty array, no size");
        double[] a;  
        Output.comment("later on ... you can resize an array afterwards");        
        a = new double[100];
        a[78] = 3.14;        
        Output.comment("resize (redimension) again, when you "
                + "resize all contents are lost");
        a = new double[500];        
        Output.show("array at slot 78 = " + a[78]);                
        Output.comment("another way to make arrays, when "
                + "you know the size, and what's going inside:");        
        double[] coins = { 0.05, 0.10, 0.25, 1.00, 2.00 };        
        Output.comment("arrays can be constants as well");        
        final String[] OPTIONS = {
            "New Game",
            "Save Game",
            "Quit"
        };        
        Output.comment("create an empty array");
        int[] numbers = new int[10];
        Output.comment("to travel (traverse) an entire array, use a for loop");
        for (int i = 0; i < 10; i++) {
            numbers[i] = 77;
        }        
        Output.comment("the length feature is built in to arrays");
        for (int i = 0; i < numbers.length; i++) {
            Output.show(i + " = " + numbers[i]);
        }        
        Output.comment("arrays and methods:");        
        Output.comment("array as a parameter:");        
        output(coins);
        double[] percents = {
            0.0, 0.25, 0.50, 0.75, 1.00
        };
        output(percents);
        output(numbers);        
        Output.comment("returning arrays:");        
        int[] stuff = giveMeNumbers();
        output(stuff);        
        Output.comment("combine parameters and return:");        
        int[] values = random(100,-5,80);
        output(values);        
        Output.comment("can create multiple arrays on 1 line:");        
        Output.comment("boolean[] x,y,z;");        
        boolean[] x = new boolean[3],
                  y = new boolean[50],
                  z = new boolean[100];        
        int[] m = {1,2,3}, n = {4,5,6};        
        Output.comment("enter the matrix....");        
        final int ROWS    = 50;
        final int COLUMNS = 70;
        char[][] matrix = new char[ROWS][COLUMNS];
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {                
                matrix[row][column] = random('!','~');                
            }
        }
        output(matrix);                        
        Output.header("Arrays unit",false,false);
    }
    
    /**
     * Unit 4 - examples of code to learn the concept of classes
     */
    private static void unit4() {
        Output.header("Classes unit",true,false);
        Output.comment("create a new person object");
        Person person = new Person();
        Output.comment("make talk");
        person.talk();        
        Output.comment("set new prpoerties and talk again");
        person.name   = "Warren Redfield";  
        person.birthday();
        person.talk();        
        Output.comment("create another person object, and talk");
        Person rob = new Person("Rob Zombie");   
        Output.comment("create another person object, and talk");
        Person brittney = new Person("Britney Spears",35,false,true);
        rob.talk();
        brittney.talk();
        Output.comment("create another person object, and talk");
        Person fred = new Person("Freddie Mercury",45,true,true);        
        fred.talk();       
        Output.comment("set new prpoerties and talk again");
        fred.birthday(26);   
        fred.genderTransition();
        fred.talk();
        Output.comment("create a new student object");
        Student student = new Student("Peter Miereu",17,true,999);                
        student.talk();
        Output.comment("set new prpoerties and talk again");
        student.study();
        student.talk();
        student.cram();
        student.talk();
        student.genderTransition();
        student.slackOff();
        student.talk();
        Output.comment("create a new husky object");
        Husky husky = new Husky("Havoc",10,true,2665);
        husky.talk();
        Output.comment("set new prpoerties and talk again");
        husky.assembly();
        husky.talk();
        husky.pepRally();
        husky.talk();
        husky.cram();
        husky.die();
        husky.talk();
        Output.comment("create a new teacher object");
        Teacher teacher = new Teacher("Mr. Wachs",48,true);
        teacher.students[0] = student;
        student.talk();
        Output.comment("set new prpoerties and talk again");
        teacher.teach();
        student.talk();
        teacher.talk();
        Output.comment("create a new meeting object");
        Meeting meeting = new Meeting();
        meeting.add(person);
        meeting.add(rob);
        meeting.add(brittney);
        meeting.add(fred);
        meeting.add(student);
        meeting.add(husky);
        meeting.add(teacher);
        meeting.hold();
        Output.header("Classes unit",false,false);
    }

    /**
     * Unit 5 - examples of code to learn the concept of graphics
     */
    private static void unit5() {    
        Output.header("Graphics unit",true,false);   
        Output.ui("graphics1 object");
        Output.ui("graphics2 object");
        Output.ui("graphics3 object");
        Output.ui("graphics4 object");
        Output.ui("graphics5 object");         
        Output.header("Graphics unit",false,false);
    }
     
    /**
     * Draws a star
     */
    private static void drawStar() {
        Output.comment("Simple method, no inputs or outputs");
        draw("*");
    }

    /**
     * Draws something on the screen
     * 
     * @param thing the item to draw
     */
    private static void draw(String thing) {
        Output.comment("Simple method with an input (parameter)");
        Output.show(thing);
    }

    /**
     * Draws something on screen multiple times
     * 
     * @param thing the item to draw
     * @param times the number of times to draw it
     */
    private static void draws(String thing, int times) {
        Output.comment("Simple method with multiple inputs (parameters)");
        for (int i = 0; i < times; i++) {
            draw(thing);
        }
    }

    /**
     * Gets a random number
     * 
     * @return a random number
     */
    private static int getNumber() {
        Output.comment("Simple method with a output (return)");
        return random(random(1, 10), random(10, 100));
    }

    /**
     * Gets user input through a dialog
     * 
     * @param text the text to display in the dialog
     * @return the text the user inputs in the dialog
     */
    private static String input(String text) {
        Output.comment("Simple method with an input (parameter), and an output (return)");
        Output.dialog("Simulated input dialog");
//        return JOptionPane.showInputDialog(text);
        return "";
    }

    /**
     * Generates a random number
     * 
     * @param low lowest possible number
     * @param high highest possible number
     * @return random integer in the range between low and high
     */
    private static int random(int low, int high) {
        Output.comment("Reusable method with inputs (parameters), and output (return)");
        double seed   = Math.random();
        double L      = (double) low;
        double H      = (double) high;
        double random = (H - L + 1) * seed + L;
        int    answer = (int) random;
        return answer;
    }
    
    /**
     * Generates a random array of numbers
     * 
     * @param size the size of the array
     * @param low lowest possible number
     * @param high highest possible number
     * @return random integer array of a set size with numbers in the range 
     * between low and high
     */
    private static int[] random(int size, int low, int high) {
        int[] a = new int[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = random(low, high);
        }        
        return a;
    }
    
    /**
     * Generates a random character
     * 
     * @param low lowest possible character
     * @param high highest possible character
     * @return random character between low and high
     */
    private static char random(char low, char high) {
        int L = (int)low;
        int H = (int)high;
        int random = random(L,H);
        return (char)random;
    }

    /**
     * 
     * Displays user input in a dialog
     * 
     * @param text the text to display in the dialog
     */
    private static void output(String text) {
        Output.dialog("Simulated message dialog");
//        JOptionPane.showMessageDialog(null, text);
    }
    
    /**
     * Displays user input in a dialog
     * 
     * @param text the text to display
     * @param title the title of the dialog
     */
    private static void output(String text, String title) {
        Output.dialog("Simulated overloaded message dialog");
//        JOptionPane.showMessageDialog(null, title, text, 
//                JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * 
     * Displays array contents to the screen
     * 
     * @param a the array to display
     */
    private static void output(double[] a) {
        String text = "";
        for (int i = 0; i < a.length; i++) {
            text += a[i] + ", ";
        }
        Output.show(text);
    }

    /**
     * 
     * Displays array contents to the screen
     * 
     * @param a the array to display
     */
    private static void output(int[] a) {
        String text = "";
        for (int i = 0; i < a.length; i++) {
            text += a[i] + ", ";
        }
        Output.show(text);
    }

    /**
     * Displays a matrix in a dialog
     * 
     * @param m the matrix to display
     */
    private static void output(char[][] m) {
        String text = "";
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m[r].length; c++) {
                text = text + m[r][c] + " ";
            }
            text += "\n";
        }
        Output.show(text);        
        Output.comment("Optional Graphics stuff....");        
        Output.comment("a special graphics item to display the text in a \"fancy\" way");
        JTextArea area = new JTextArea();        
        Output.comment("some colors to use in the text area");
        Color background = new Color(0,0,0);
        Color foreground = new Color(0,255,0);        
        Output.comment("create a font to use");
        Font font = new Font("Consolas",Font.PLAIN,10);        
        Output.comment("\"assign\" or set the items to the text area");
        area.setBackground(background);
        area.setForeground(foreground);        
        area.setFont(font);                
        Output.comment("also set the text into the area");
        area.setText(text);        
        Output.comment("a picture icon for the dialog");
        Icon picture = new ImageIcon("matrix.gif");  
        Output.comment("now put the items in the dialog");
        Output.dialog("\n" + text);
    }
        
    /**
     * Gives you a set of 10 numbers
     * 
     * @return a set of 10 numbers
     */
    private static int[] giveMeNumbers() {
        int[] array = new int[10];
        array[0] = 59;
        array[1] = 89;
        array[2] = 56;
        array[3] = 83;
        array[4] = 68;
        array[5] = 3;
        array[6] = 890;
        array[7] = 56;
        array[8] = 89;
        array[9] = 30;
        return array; 
    }
    
}
