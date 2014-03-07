
import java.util.ArrayList;
import java.util.Scanner;

public class Main {	
	
	public static void main(String[] args)  {
		
				
		ArrayList<String> InputNames = new ArrayList<String>();
		ArrayList<String> ParameterNames = new ArrayList<String>();
		int j=0,noofparams;
					
			noofparams= args.length; // Indicate number of search parameters given in the command line
			if(noofparams==0)
			{
				// print error if no search parameters where given
				System.out.println("Please provide search parametrs in the command line");
				System.exit(0);
			}
		    //add the parameters to the string arraylist
			for(j=0;j<=(noofparams-1);j++)    
			{
				ParameterNames.add(args[j]);
			}
			
		    //add the input names to the string arraylist
			Scanner InputScanner = new Scanner(System.in);
			while (InputScanner.hasNext()) {
     		 String inputname = InputScanner.nextLine();
						InputNames.add(inputname);
						
	}
			InputScanner.close();	
			PhoneticSearch ps = new PhoneticSearch(InputNames,ParameterNames);
	}
	
}
			
	