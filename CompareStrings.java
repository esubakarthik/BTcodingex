

public class CompareStrings {
	
	int i;
	
	boolean compare(char[] Param,int Paramsize,char[] Input,int Inputsize)
	{
				
		if(Inputsize!=Paramsize)
		{		
			return false;
		}	
				
		
		for(i=0;i<=Inputsize;i++)
		{

			if(Param[i]!=Input[i])
			{				
				return false;
			}
		}	
		
			return true;	
	}
	}


