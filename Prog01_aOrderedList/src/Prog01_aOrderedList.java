/**
* <Prog01_aOrderedList class>
*
* CSC 1351 Programming Project No 1
* Section 2
*
* @author <Julianna Mcphail>
* @since <March 17 2024>
*
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Prog01_aOrderedList {
	
		
        
        public static Scanner GetInputFile(String UserPrompt) throws FileNotFoundException{
            System.out.print(UserPrompt);           //method to print commanding instructions for user
            Scanner in = new Scanner(System.in); 
            String input = in.nextLine();          
            File inputFile = new File(input); 
            return new Scanner(inputFile);      //return Scanner object ready for input
        }

	
public static void main (String[] args) {
	aOrderedList orderedList = new aOrderedList();
	Scanner in;
	// prompts  user for the filename of a text input file and return a Scanner object ready for input
    while(true){ 
        try{
            in = GetInputFile("Input filename: ");     
            
            break;
        }
        catch(FileNotFoundException e){
            String message = e.getMessage();
            for(int i = 0; i < message.length(); i++){
                if(message.charAt(i) == '('){
                    message = message.substring(0,i-1);      
                    break;
                }
            }
            System.out.print("File specified <" + message + "> does not exist. Would you like to continue? <Y/N>  ");  
                                                                                                                                    //prompts the user to reenter a corrected value
            Scanner confirm = new Scanner(System.in);
            String input = confirm.next();
            if(input.equalsIgnoreCase("N")){                       
                System.out.println("\nProgram ended.\n");
                System.exit(0);
            }
            else if(!input.equalsIgnoreCase("Y")){                  
                System.out.println("\nN/A.\n");
            }
        }
    }
    System.out.println("Number of cars:\t" + orderedList.size() + "\n\n");
    	
	    for(int i = 0; i < orderedList.size(); i++) {
	    	Comparable compare = orderedList.get(i);
	    	Car car = (Car) compare;
			System.out.println("Make:\t" + car.getMake() + "\n");
			System.out.println("Year:\t" + car.getYear() + "\n");
			System.out.println("Price:\t" + car.getPrice() + "\n\n");
		
    }
    }
   

	
/*
 * prompt the user for the filename of a text
output file and return a PrintWriter object, ready for output
 */

public static PrintWriter GetOutputFile(String UserPrompt) throws FileNotFoundException{
	System.out.print(UserPrompt);
	Scanner in = new Scanner(System.in);
	String input = in.nextLine();
	File outputFile = new File(input);
	return new PrintWriter(outputFile);
	
	
	}
}

