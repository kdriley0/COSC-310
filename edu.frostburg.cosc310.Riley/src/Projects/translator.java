/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projects;
import java.io.*;//allows java to input/output files
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;//allow java to use the scanner
/**
 * @author Kevin Riley on 8/30/17 to translate 90's slang as is instucted 
    */
   public class translator 
{
       
  static translator t = new translator();  
  static int numberOfWords;
  static StringBuilder C_L = new StringBuilder(); 
  static int i;
    
 public void translator() throws IOException
 {
     int i,j,k, pp1, pp2, pp3, pp4,pp5  ;//declares  ints called i, j ,k for a counter and punctuation position 1, 2 , 3  , 4 and 5 
     char pc1='x', pc2='x',pc3='x',  pc4='x',pc5='x';
     String currL = "", currentLine="";//declares and initilizes a string called current line(currL and currentLine to ""
     FileWriter f = new FileWriter("COSC_310_output_kdriley0.txt");//declares and initilizes a fileWriter object named f
     BufferedWriter b = new BufferedWriter(f);//declares and initilizes a buffered writer object to write to the file writer
     File in = new File("input.txt");// the input file 
     Scanner scan = new Scanner(in);//the scanner object thst reades the input file
     
     
     while (scan.hasNextLine()) //loops though the file
     {
         
        
         i=0; k=0;
         numberOfWords=0;
         t.yoeffire();
        currL = scan.nextLine();
        currentLine=currL;
        for( j=0; j<currentLine.length();++j)
        {
            if(Character.isUnicodeIdentifierPart(44)&&k==0)
            {
                pp1=j;
                pc1=currentLine.charAt(j);
                k++;
            }
                
        }
       
        Scanner s = new Scanner(currL);   
        while (s.hasNext())//loops though the current line
        {
          

             i=0;
            //  t.yoeffire();
            numberOfWords++;// counts the number of words in the current line 
            if(numberOfWords > 10 )
            {
             
                if(i == 0)
                {
                    C_L.append(t.addYadda());
                }
                i++;
                break;
                
                
            }
        
         String word = s.next();
         if(word.length()<4 &&( !word.equalsIgnoreCase("fun")|| !word.equalsIgnoreCase("fly")) )
         {
                C_L.append(word+" ");
                i++;
                
         }
        if(!word.equalsIgnoreCase("sure")&& !(word.equalsIgnoreCase("fun")||word.equalsIgnoreCase("awesome") || word.equalsIgnoreCase("cool")) && i==0)
                {
                   C_L.append(t.izzilfier(word));
                   i++;
                }
        if(i==0)
                {
                    C_L.append(t.ChangeWords(word)); 
                }
        
        
         
        
        }//end of inner while
        // System.out.println(wc);
        // currW =s2.next();
        // wc= t.countLetters(currW);
        System.out.println(currL);
        
        currL= C_L.toString();
        b.flush();
        b.write(currL);
        b.newLine();
        C_L.delete(0, C_L.length());
     }// end of outer while
     b.close();
 }
 public String izzilfier( String w)//method the "izzilfier to add izzle to the end words that dont start with a vowel 
 {
     ArrayList<Character> arraylist =  new ArrayList<>(); //to scan through characters
     char c ='x'; //temp variable
     for(int i=0; i<w.length(); i++){
         c=w.charAt(i);
         arraylist.add(c);//ad string to char array
     }
           char temp=' ';// to hold punc. values
      for(int i=0; i<arraylist.size(); i++){   
      if(arraylist.contains('?')){
          temp='?';
      }if(arraylist.contains('.')){
          temp='.';
      } 
      }if(arraylist.contains(',')){
          temp=',';
      }if(arraylist.contains('!')){
          temp='!';
      }
      
      
     if(w.charAt(0)!= 'a'&& w.charAt(0)!= 'e'&& w.charAt(0)!= 'i'&& w.charAt(0)!= 'o'&& w.charAt(0)!= 'u'&& w.charAt(0)!= 'y' &&w.charAt(0)!= 'A'&& w.charAt(0)!= 'E'&& w.charAt(0)!= 'I'&& w.charAt(0)!= 'O'&& w.charAt(0)!= 'U'&& w.charAt(0)!= 'Y')
     {
       if((arraylist.size()<5 && arraylist.contains('.'))) //if small word that contains punc.
      {
          return w +" ";
      }
         System.out.println(arraylist.toString());
         System.out.println(temp + "temp");
   
        return w= ( w.charAt(0)+"izzle" + temp +" ");
     }
    return (w + temp);
 }
 	 
 public void yoeffire()// the yoeffire to randomly add yo! to the beginning of the word
 {
	 int yo = 0;
	 Random r = new Random();
         long startTime= System.currentTimeMillis();//initializes and declares a new long named start time at the current time in nanoseconds
         r.setSeed(startTime);
	 yo = r.nextInt()%2;
	 if (yo ==1)
	 {
		 C_L.append("Yo! ");
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
 public String ChangeWords(String word)// a method to change the 4 words specified sure fun awespme and cool
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
 public String addYadda()// this method adds yadda,yadda,yadda… to sentences that go on too long
 {
     return "yadda,yadda,yadda…";
 }
 public static void test() throws IOException// the main method 
 { 
     
     t.translator();
 }
}//end of class

