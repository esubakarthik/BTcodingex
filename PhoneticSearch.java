
import java.util.ArrayList;

public class PhoneticSearch {
	
	int noofparams,i,j;
	static int size;

	
	public static char[]  process(String string)
	{
		int i,j=1;
		char[] concattext= new char[20];
		char[] finaltext= new char[20];
		
		// step 1: remove all non alphabetical characters
		string=string.replaceAll("[^a-zA-Z]", "");

		if(string.isEmpty())
		{
			// returns null if no alphabets where present in the given search parameter
			return null ;
		}
		
		// Step 2: convert to lower case 
		string = string.toLowerCase();
				
		//System.out.println(string);
		concattext[0] = string.charAt(0);
		// remove A, E, I, H, O, U, W, Y from the char array
		int len = string.length();
		//loop from 2nd char to last char
		for(i=1;i<len;i++)
		{
			// Step 3 : remove any char a,e,i,h,o,u,w,y after the first letter 
			char t = string.charAt(i);
			if((t=='a')||(t=='e')||(t=='i')||(t=='h')||(t=='o')||(t=='u')||(t=='w')||(t=='y'))
					{
				// remove
					}
			else
			{
				concattext[j]=t;
				j++;
			}
		}
		
		finaltext=RemoveEquals(concattext);
	
		return finaltext;
	}
	
	public static char[] RemoveEquals(char[] text)
	{
		int i,len,j,equal=1;
		size=0;
		len = text.length;
		for(i=0;i<len;i++)
		{
			/*
			 * Step 4:
			 * The equivalent letters will be replaced by first letter in the group
			 * a,e,i,o,u will be replaced by a
			 * c,g,j,k,q,s,x,y,z will be replaced by c
			 * b,f,p,v,w will be replaced by b
			 * d,t will be replaced by d
			 * m,n will be replaced by m
			 */
			if((text[i]=='a')||(text[i]=='e')||(text[i]=='i')||(text[i]=='o')||(text[i]=='u'))
			{
				text[i]='a';
			}
			else if((text[i]=='c')||(text[i]=='g')||(text[i]=='j')||(text[i]=='k')||(text[i]=='q')||(text[i]=='s')||(text[i]=='x')||(text[i]=='y')||(text[i]=='z'))
			{
				text[i]='c';
			
			}
			else if((text[i]=='b')||(text[i]=='f')||(text[i]=='p')||(text[i]=='v')||(text[i]=='w'))
			{
				text[i]='b';
			}
			else if((text[i]=='d')||(text[i]=='t'))
			{
				text[i]='d';
			}
			else if((text[i]=='m')||(text[i]=='n'))
			{
				text[i]='m';
			}
		}
		
		
		// step 5: remove repeating char
		
		char[] finalstring = new char [20];
		len= text.length;
		finalstring[0]=text[0];
		
		for(i=1;i<len;i++)
		{
			 int len1=finalstring.length;
			for(j=0;j<len1;j++){
			if(text[i]==finalstring[j])
			{
				equal=0;
			}
			
			}
			
			if(equal==1)
			{
				size++;
				finalstring[size]= text[i];
				
			}
			else
			{
				equal =1;
			}
			
		}	
		return finalstring;
	}
	
	PhoneticSearch(ArrayList<String> InputNames,ArrayList<String> ParameterNames){
		
		CompareStrings cs = new CompareStrings();
		
		//Shows the number of parameters
	    noofparams=ParameterNames.size();
	    
		for(i=0;i<(ParameterNames.size());i++)
		{
			boolean MatchFound= false;
			/* 
			 * MatchFound is used to indicate if any match has been found
			 * first = false; no matches found
			 * first = true ; atleast  one match has been found
			 */
			char[] Param = process(ParameterNames.get(i));
			int Paramsize =  size;
			
			
			for(j=0;j<InputNames.size();j++)
			{
				char[] Input = process(InputNames.get(j));
				int Inputsize =  size;
				
				// compare both strings and returns true if there are a match
				boolean match = cs.compare(Param,Paramsize,Input,Inputsize);
				
				if(match)
				{
					if(!MatchFound)
					{
						// print the fist match preceded by parameter name and colon
						System.out.print("\n"+ParameterNames.get(i)+":"+InputNames.get(j));
						MatchFound = true;
						

					}
					else 
					{
						
						//print second and later matches preceded by a comma
						System.out.print(","+InputNames.get(j));
					}
				}

			}
			
			if(!MatchFound)
			{
				// print statement if no match is found
				System.out.print("\n"+ParameterNames.get(i)+": No match found");
			} 
		}
	}

}
