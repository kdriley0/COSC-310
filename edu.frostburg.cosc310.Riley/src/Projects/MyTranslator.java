/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projects;

import java.util.ArrayList;
import java.io.*;//allows java to input/output files
import java.util.Random;
import java.util.Scanner;//allow java to use the scanner

/**
 *
 * @author kevin
 */
public class MyTranslator 
{
    ArrayList list= new ArrayList();
    static MyTranslator t = new MyTranslator();  
    static int numberOfWords;
    static int numberOfLetters;
    
    public void translate()throws IOException 
    {
        
        String currL = "", currW="";//declares and initilizes a string called current line(currL and currentLine to ""
        FileWriter f = new FileWriter("COSC_310_output_kdriley0.txt");//declares and initilizes a fileWriter object named f
        BufferedWriter b = new BufferedWriter(f);
        File in = new File("input.txt");
        Scanner scan = new Scanner(in);
       
        while(scan.hasNextLine())
        {
            t.yoeffire();
            currL=scan.nextLine();
         Scanner s= new Scanner(currL);  
         while(s.hasNext())
         {
          list.add(s.next());
          
         }
          
         
       System.out.println(list.toString());
        }
    }
    public String izzilfier( String w)
 {
     if(w.charAt(0)!= 'a'&& w.charAt(0)!= 'e'&& w.charAt(0)!= 'i'&& w.charAt(0)!= 'o'&& w.charAt(0)!= 'u'&& w.charAt(0)!= 'y' &&w.charAt(0)!= 'A'&& w.charAt(0)!= 'E'&& w.charAt(0)!= 'I'&& w.charAt(0)!= 'O'&& w.charAt(0)!= 'U'&& w.charAt(0)!= 'Y')
     {
        return w=  w.charAt(0)+"izzle ";
     }
    return w +" ";
 }
 public void yoeffire()
 {
	 int yo = 0;
	 Random r = new Random();
         long startTime= System.currentTimeMillis();//initializes and declares a new long named start time at the current time in nanoseconds
         r.setSeed(startTime);
	 yo = r.nextInt()%2;
	 if (yo ==1)
	 {
		 list.add(0, "Yo!");
	 }
		 
 }
 //public int countWords(String line)
 {
 //   Scanner
 }
 public int countLetters(String word)
 {
  int wc = word.length();
  return wc;
  
 } 
 public String ChangeWords(String word)
 {
        if(word.equalsIgnoreCase("sure"))
         {
             return("sho ");
             
             
         }
         if(word.equalsIgnoreCase("fun")||word.equalsIgnoreCase("awesome") || word.equalsIgnoreCase("cool"))
         {
            return "fly ";
             
            
         }
          return word; 
     
 }
 public String addYadda()
 {
     return "yadda,yadda,yadda…";
 }
     public static void test() throws IOException
 { 
     
     t.translate();
 }
        
}
