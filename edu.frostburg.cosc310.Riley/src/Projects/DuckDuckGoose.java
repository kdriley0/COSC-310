/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projects;

import collection.*;
import collection.CirclularLinkedList.Node;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
/**
 *
// * @author kevin
 */
public class DuckDuckGoose 
{
    /**
 *
 * declaring variables 
 */ 
    static String ducks= "";
    static Node it;
    static int rounds =0;
    static DuckDuckGoose g = new DuckDuckGoose();
    static Random r = new Random();// creates a new static random variable named r
    static String name;
    static String gender;
    static int age;
    static CirclularLinkedList game = new CirclularLinkedList();
    
         public  void startGame() throws IOException
      {
          String currentKid = "";
          int k=0;
          File in = new File("input.txt");
          Scanner scan= new Scanner(in);
           while (scan.hasNext()) {
            currentKid = scan.nextLine();
            currentKid = currentKid.trim();
            while(currentKid.length()==0)
            {   
                currentKid = scan.nextLine();
            } 
            String[] child =currentKid.split("\\s+");// remove + if does not work
           //  System.out.println(Arrays.toString(child));
                   name =child[0];
                  gender=child[1];
                  age=Integer.parseInt(child[2]);
                  if (k==0)
                  {
                       game.addFirst(name, gender, age);
                       k++;
                  }
                  else
                  {
                       game.addLast(name, gender, age);
                  }
                 
           }
}//end of start game
         /**
          * 
          * the random method to determine the amount of ducks the kid will say 
          */
         public int random()
         {
             int ducks=r.nextInt(30);//I limited the # of ducks to 30 
           return ducks;
         }
         /**
          *  the method choice chooses whoever is it first
          * 
          */
         public void choice(){
             int  choice= r.nextInt(game.getSize());//establishes the int choice as a random number between 0 and the size of the game 
             g.rotate(choice);
             it= game.removeHead();
             System.out.println(game.getSize());
         }

         /**
          * the method goose take an int and returns a different int so the person cannot choose themselves
          * @param g
          * @return 
          */
         public int goose()
         {
             ducks="";
             int numberOfDucks=g.random();
             for(int i =0; i<numberOfDucks;++i){ ducks+= "Duck, ";  }//puts a random # of Ducks, in ducks
             
             return numberOfDucks;//so the number of ducks will allign with the person picked
            }
         /**
          * takes am int value and rotates the circular linked list that # of times
          * so that the person at the head will be the person picked
          * @param r
          */
         public void rotate(int r)
         {
                 for (int i=0;i<r;i++){
                 game.rotate();
             } 
         }
         public boolean isCaught(){
             return r.nextInt()%2==0;
         }
         /**
          * 
          * @param CirclularLinkedList object named ga
          * this method give each of the kids in the list a 5% increaing chance per round chance to get bored and play pokemon
          */
         public static void boredKids(CirclularLinkedList ga ){
             int ppl =0;
             int bordem=0;
             Node tail = ga.first();
             while(ppl < game.getSize())
             {
                 
                 bordem=r.nextInt(20);// 1 /5 of 100 is 20 so every round they are 5% more likely to be bored
                 if(bordem<rounds)
                 {
                   System.out.println(  ga.removeFirst()+ " leaves to play pokemon ... "+ (ga.getSize()+1) +" players remain.");
                 }
                 ppl++;
                 tail=tail.getNext();
             }
             
                     
         }
         
         /** plays the game 
          *
          */  
         public void playGame(){
             
              rounds =0;
          
             
             g.choice();
             System.out.println((game.getSize()+1) +" kids play Duck, Duck, Goose. "+it.getName()+" is it." );
        
            while(game.getSize()>2||rounds ==20)
             {
                 Node temp=null;
                 g.rotate(g.goose());
             
                 System.out.println(ducks +" Goose! "+it.getName()+ " tags "+game.getFirst()+ " and "+ game.getGender()+ " dashes!"); 
                 if(!g.isCaught()){//the person taged runs faster
                     System.out.println(game.getFirst()+" runs faster. "+ it.getName()+" is still it!");
                 }
                 else{//the person that is it run faster
                     System.out.println(it.getName()+" runs faster. "+game.getFirst()+ " is it!");
                    swap(it,game.first());
                    
                     }
                 rounds++;
                 boredKids(game);
//                 System.out.println(it.getName()+" runs faster. "+game.getFirst()+ " is it!");
//                   it= game.insertFirst(it);
                   
                   
             }//end of while
                 
        }
   
         
      public static void test()  throws IOException

      {         
          g.startGame();
          g.playGame();
       //System.out.println(game.toString());
      }
      /**
       * 
       * @param it
       * @param first 
       */
    public void swap(Node it, Node first){
          Node temp=it;
          Node temp2=first;
          this.it=game.removeHead();
          game.addFirst(it.getName(), it.getGender(), it.getAge());
          
          
          
          
      }
 
}


