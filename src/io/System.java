

/** required package class namespace */
package io;



/**
 * System.java - 
 *
 * @author Mr. Wachs 
 * @since 8-Mar-2019 
 */
public class System 
{

   
    public static class out {
        
        public static void println(Object object) {
            output(object,true);
        }
       
        public static void println(boolean object) {
            println(new Boolean(object));
        }
        
        public static void println(int object) {
            println(new Integer(object));
        }
        
        public static void println(long object) {
            println(new Long(object));
        }
        
        public static void println(float object) {
            println(new Float(object));
        }
        
        public static void println(double object) {
            println(new Double(object));
        }
        
        public static void print(Object object) {
            output(object,true);
        }
        
        public static void print(boolean object) {
            print(new Boolean(object));
        }
        
        public static void print(int object) {
            print(new Integer(object));
        }
        
        public static void print(long object) {
            print(new Long(object));
        }
        
        public static void print(float object) {
            print(new Float(object));
        }
        
        public static void print(double object) {
            print(new Double(object));
        }
        
        private static void output(Object object, boolean newLine) {
            if (newLine) {
                java.lang.System.out.println(object.toString());
            }
            else {
                java.lang.System.out.print(object.toString());
            }
        }
        
    }    

}
