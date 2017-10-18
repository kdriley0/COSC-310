/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

/**
 *
 * @author kevin
 */
public class KidNode  
{
    
    int age;
    char gender;
    String name;
    double bordem;
    Kid next ;
       
 KidNode(String n ,char g, int a, Kid nx)
 {
     age =a;
     gender = g;
     name =n;
     bordem =0; 
     next= nx;
     
 }
 
}
