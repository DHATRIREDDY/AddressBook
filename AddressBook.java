import java.util.*;
class LastNameComparator implements Comparator{
	public int compare(Object o1,Object o2){
		Person p1=(Person)o1;  
		Person p2=(Person)o2;  
		int compares=(int)p1.lastName.compareTo(p2.lastName);
		return compares;
	}
}
class ZIPComparator implements Comparator{
	public int compare(Object o1,Object o2){
		Person p1=(Person)o1;  
		Person p2=(Person)o2;  
		int compares=(int)p1.zip.compareTo(p2.zip);
		return compares;
	}
}

class Person
{
	String firstName, lastName, city, state,zip, phoneNumber;
	public Person(String firstName,String lastName,String city,String state,String zip,String phoneNumber)
	{
		this.firstName=firstName;
		this.lastName=lastName;
		this.city=city;
		this.state=state;
		this.zip=zip;
		this.phoneNumber=phoneNumber;
	}
	public String toString()
	{
		return "FirstName:"+firstName+" LastName:"+lastName+" City:"+city+" State:"+state+" ZIP:"+zip+" PhoneNumber:"+phoneNumber;
	}
	
}
public class AddressBook
{
	static Scanner sc=new Scanner(System.in);
	ArrayList<Person> listOfPersons = new ArrayList<Person>();
    public void addPerson()
    {
    	System.out.print("Enter the FirstName:");
    	String firstName=sc.next();
    	System.out.print("Enter the LastName:");
    	String lastName=sc.next();
    	System.out.print("Enter the City:");
    	String city=sc.next();
    	System.out.print("Enter the State:");
    	String state=sc.next();
    	System.out.print("Enter the ZIP:");
    	String zip=sc.next();
    	System.out.print("Enter the PhoneNumber:");
    	String phoneNumber=sc.next();
    	Person person=new Person(firstName,lastName,city,state,zip,phoneNumber);
    	listOfPersons.add(person);
    	System.out.println("Person Details entered Successfully");
    }
    public void editPerson()
    {
        System.out.println("Enter the Firstname of Person to be edited");
        String searchPerson=sc.next();
        int chooseField;
        String editInformation;
    	boolean personExist=false;
        Person person;
    	for(Person p:listOfPersons)
    	{
    		if(p.firstName.equals(searchPerson))
    		{
    			personExist=true;
    			person=p;
    			while(true)
            	{
        			System.out.println("select the filed to edit:");
            		System.out.println("1.FirstName\n2.LastName\n3.City\n4.State\n5.ZIP\n6.PhoneNumber\n7.Edited");
            		chooseField=sc.nextInt();
            		switch(chooseField)
            		{
            		   case 1:
            			      System.out.print("Enter the FirstName:");
            		          editInformation=sc.next();
            			      person.firstName=new String(editInformation);
            			      break;
            		   case 2:
            			      System.out.print("Enter the LastName:");
            		          editInformation=sc.next();
     			              person.lastName=new String(editInformation);
     			              break;
            		   case 3:
            			      System.out.print("Enter the City:");
            		          editInformation=sc.next();
			                  person.city=new String(editInformation);
			                  break;
            		   case 4:
            			      System.out.print("Enter the State:");
            			      editInformation=sc.next();
		                      person.state=new String(editInformation);
		                      break;
            		   case 5:
            			      System.out.print("Enter the ZIP:");
            			      editInformation=sc.next();
	                          person.zip=new String(editInformation);
	                          break;
            		   case 6:
            			      System.out.print("Enter the PhoneNumber:");
            		          editInformation=sc.next();
                              person.phoneNumber=new String(editInformation);
                              break;
                       default:break;
            		}
            		if(chooseField==7)
            			break;
            	}
    		}
    	}
    	if(personExist==false)
    		System.out.println("Person doesnot exists");
    }
    
    public void deletePerson()
    {
    	if(listOfPersons.size()==0)
    		System.out.println("Address book is empty");
    	System.out.println("Enter the FirstName of Person to be deleted:");
    	String delete_obj=sc.next();
    	boolean personExist=false;
    	for(int i=0;i<listOfPersons.size();i++)
    	{
    		if(listOfPersons.get(i).firstName.equals(delete_obj))
    		{
    			listOfPersons.remove(i);
    			personExist=true;
    			System.out.println("Deleted Person Successfully");
    		}
    	}
    	if(personExist==false)
    		System.out.println("Person doesnot exists");
    }
    
    public void searchPerson()
    {
    	if(listOfPersons.size()==0)
    		System.out.println("Address book is empty");
    	System.out.println("Enter the FirstName of person to search");
    	String searchPerson=sc.next();
    	boolean personExist=false;
    	for(Person p:listOfPersons)
    	{
    		if(p.firstName.equals(searchPerson))
    		{
    			personExist=true;
    			System.out.println(p);
    		}
    	}
    	if(personExist==false)
    		System.out.println("Person doesnot exists");
    }
    
    public void sortByLastName()
    {
    	Collections.sort(listOfPersons,new LastNameComparator());
    }
    public void sortByZIP()
    {
    	Collections.sort(listOfPersons,new ZIPComparator());
    }
    public void printDetails()
    {
    	System.out.println("FirstNmae\tLastName\tCity\tState\t\tZIP\tPhoneNumber");
    	for(Person p:listOfPersons)
    		System.out.println(p.firstName+"\t\t"+p.lastName+"\t\t"+p.city+"\t"+p.state+"\t"+p.zip+"\t"+p.phoneNumber);
    }
    
    public static void main(String[] args)
    {
		AddressBook addressBook = new AddressBook();
		int choice;
        while(true)
        {
        	System.out.println("1.Add Person\n2.Delete Person\n3.Search Person\n4.Edit Person\n5.Sort by LastName\n6.Sort by ZIP\n7.printDetails\n8.Exit");
        	System.out.print("Enter your Choice:");
        	choice=sc.nextInt();
        	switch(choice)
        	{
        	  case 1:addressBook.addPerson();
        	  		 break;
        	  case 2:addressBook.deletePerson();
        	         break;
        	  case 3:addressBook.searchPerson();
        	         break;
        	  case 4:addressBook.editPerson();
        	         break;
        	  case 5:addressBook.sortByLastName();
        	         addressBook.printDetails();
                     break;
        	  case 6:addressBook.sortByZIP();
 	                 addressBook.printDetails();
                     break;
        	  case 7:addressBook.printDetails();
        	         break;
        	  default:break ;
        	  		 
        	} 
        }		
	}
}
