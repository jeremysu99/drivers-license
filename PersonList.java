package driverslicense;

public class PersonList 
{
	   private ListNode list;

	   //----------------------------------------------------------------
	   //  Sets up an empty list of Persons.
	   //----------------------------------------------------------------
	   public PersonList()
	   {
	      list = null;
	   }
	   //----------------------------------------------------------------
	   //  Creates a new PersonNode object and adds it to the end of
	   //  the linked list.
	   //----------------------------------------------------------------
	   public ListNode getHead() 
	   {
		   return list;
	   }
	   public void add (Person mag)
	   {

	      ListNode node = new ListNode (mag, null);
	      ListNode current;

	      if (list == null)
	         list = node;
	      else
	      {
	         current = list;
	         while (current.getNext() != null)
	            current = current.getNext();
	         current.setNext(node);
	      }
	   }
	    public ListNode getNode(Person val)
	    {
	        ListNode n = new ListNode(val, null);
	        ListNode current = null;
	        if (list == null)
	            list = n;
	        else
	        {
	            current = list;
	            while (current.getValue() != val)
	                current = current.getNext();
	        }
	        return current;
	    }
	    public ListNode getNode1(String name) 
	    {
	    	ListNode current = list;
	    	Person pers = (Person) current.getValue();
	    	
	    	while (pers.getName() != name)
	    	{
	    		current = current.getNext();
	    		pers = (Person) current.getValue();
	    	}
	    	return current;
	    }
	    public ListNode getNode2(int val) 
	    {
	    	ListNode current = list;
	    	Person pers = (Person) current.getValue();
	    	
	    	while (pers.getNumber() != val)
	    	{
	    		current = current.getNext();
	    		pers = (Person) current.getValue();
	    	}
	    	return current;
	    }
	    public void insertAfter(int index, Person new_data, Person head)
	    {
	        ListNode curr = getNode(head);
	        
	        for (int i = 0; i < index-1; i++)
	            curr = curr.next;
	        
	        ListNode new_node = new ListNode(new_data, curr.next);
	        curr.next = new_node;
	       
	    }
	    public void delete(int index, Person data, Person head)
	    {
	        ListNode curr = getNode(head);
	        for (int i = 0; i < index-1; i++)
	            curr = curr.next;
	        
	        curr.next = curr.next.next;
	    }
	    public void selectionSort (PersonList numbers)
	    {
	       String min, temp;
	       ListNode node = list;
	       ListNode node2 = list.next;
	       while (node2 != null)
	       {
	    	   Person p = (Person) node.getValue();
	           min = p.getName();
	           while (node2 != null)
	           {
	        	   Person p1 = (Person) node2.getValue(); 
	               if (p1.getName().compareTo(min)<0)
	                   min = p1.getName();
	               node2 = node2.next;
	           } 
	           node2 = numbers.getNode1(min);
	           Person p2 = (Person) node2.getValue(); 
	           if (!(min.equals(p.getName())))
	           {
	               node2.setValue(p);
	               node.setValue(p2);
	           }
	           node2 = node.next;
	           node = node.next;
	           node2 = node2.next;
	           
	       }
	    }
	    
	    public void selectionSort2 (PersonList numbers)
	    {
	       String min, temp;
	       ListNode node = list;
	       Person minp = null;
	       ListNode node2 = list.next;
	       while (node2 != null)
	       {
	    	   Person p = (Person) node.getValue();
	           min = p.getGender();
	           while (node2 != null)
	           {
	        	   Person p1 = (Person) node2.getValue(); 
	               if (p1.getGender().compareTo(min)<0)
	               {
	            	   minp = (Person) node2.getValue();
	                   min = p1.getGender();
	               }
	               node2 = node2.next;
	           } 
	           node2 = numbers.getNode(minp);
	           Person p2 = (Person) node2.getValue(); 
	           if (!(min.equals(p.getGender())))
	           {
	               node2.setValue(p);
	               node.setValue(p2);
	           }
	           node2 = node.next;
	           node = node.next;
	           node2 = node2.next;
	           
	       }
	    }
	    
	    public void selectionSort3 (PersonList numbers)
	    {
	       int min, temp;
	       ListNode node = list;
	       ListNode node2 = list.next;
	       
	       while (node2 != null)
	       {
	    	   Person p = (Person) node.getValue();
	           min = p.getNumber();
	           while (node2 != null)
	           {
	        	   Person p1 = (Person) node2.getValue(); 
	               if (p1.getNumber() < min)
	               {
	                   min = p1.getNumber();
	               }
	               node2 = node2.next;
	           } 
	           node2 = numbers.getNode2(min);
	           Person p2 = (Person) node2.getValue(); 
	           if (min != p.getNumber())
	           {
	               node2.setValue(p);
	               node.setValue(p2);
	           }
	           node2 = node.next;
	           node = node.next;
	           node2 = node2.next;
	           
	       }
	    }
	   //----------------------------------------------------------------
	   //  Returns this list of Persons as a string.
	   //----------------------------------------------------------------
	   public String toString ()
	   {
	      String result = "";
	      ListNode current = list;

	      while (current != null)
	      {
	         result += current.getValue().toString() + "\n";
	         current = current.getNext();
	      }
	      result += "\n";
	      return result;
	   }
}
