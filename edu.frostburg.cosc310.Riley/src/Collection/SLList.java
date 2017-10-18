/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author kdriley0
 */
public class SLList 
{
    private SLListNode head;
    private SLListNode tail;
    
    public  SLList()
    {
        head=tail=null;
    }
    public void append (Object element)
    {
        if(head == null)
        {
            head=tail=new SLListNode(element, null);
        }
        else
        {
            tail =tail.next= new SLListNode(element, null);
        }
        
    }
    public void insert(Object element)
        {
            if(head == null)
                {
                    head=tail=new SLListNode(element, null);
                }
            else
            head= new SLListNode(element, head);
            
        }
    public boolean isEmpty(SLListNode ssl)
    {
        return (ssl==null);
    }
    @Override
    public String toString()
    {
        String out =" the SSList contains";
        if (head== null)
        {
            return out + " 0 nodes";
        }
        else out+= " head -> ";
         SLListNode ref = head;
         int m=0;
        while(ref.next !=null)
        {
            if(m %5 ==0)
            {
                out+="\n";
            }
            out+=ref.data +" \t -> \t " ; 
            ref=ref.next;
            
            ++m;
        }
        out += ref.data + "\t -> null";
        return out;
    }
     public boolean remove(Object element)
     {
         if(head == null) return false;
         if(((Comparable)(head.data)).compareTo(element)==0)
                 {
                     if (head ==tail)
                     {
                         head=tail=null;
                         return true;
                     }
                     head=head.next;
                     return true;
                 }if(head==tail)return false;
                 SLListNode ref = head;
             while(ref.next!= tail)
             {
                     
                
                 if(((Comparable)(ref.data)).compareTo(element)==0) 
                 {
                      ref.next=ref.next.next;
                      return true;
                 }
                 ref=ref.next;
             }
             if(((Comparable)(ref.data)).compareTo(element)==0) 
             {
                tail=ref;
                ref.next=null;
                return true;
             }
             return false;
         
     }
}
