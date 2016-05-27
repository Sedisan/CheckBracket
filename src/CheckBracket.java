import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckBracket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		MainAssertTrueOrFalse mATOF=new CheckAssertTrue();
		
		mATOF.setUnitTest(new AssertBracket());
		
		
		
		
		if(mATOF.tryTrueOrFalse(" (b(s))"))
		{
			
			System.out.println("Right test is good");
		}
		else System.out.println("Right test...Isn't good");
		
		
		
		mATOF=new CheckAssertFalse();
		mATOF.setUnitTest(new AssertBracket());
		
		
		if(mATOF.tryTrueOrFalse("(a(c)"))
		{
			System.out.println("False test number 1 is ok");
		}
		else System.out.println("False test number 1 isn't ok");
		
		if(mATOF.tryTrueOrFalse(")b"))
		{
			System.out.println("False test number 2 is ok");
		}
		else System.out.println("False test number 2 isn't is ok");
		

		String userTextString;
		
		
		
		
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Enter your text with brackets: ");
		userTextString=scan.nextLine();
		
		UnitTest unitTestBracket;
		unitTestBracket=new AssertBracket();
		
		
		if(unitTestBracket.checkBracket(userTextString))
			{
			System.out.println("Everything is good");
			}
		else
			System.out.println("Your text contain brackets with bad combination, or don't contain it ");
		
		scan.close();

		
	}

}
interface UnitTest
{
	
	abstract public boolean checkBracket(String userString);
	

}
class AssertBracket implements UnitTest
{
	
	
	public boolean checkBracket(String userString) {
		
		if(!userString.contains("("))
		{
			//System.out.println("No pairs of brackets");
			//System.exit(1);
			return false;
		}

		
		int numberOfInstanceLeftBracket=0
		,numberOfInstanceRightBracket=numberOfInstanceLeftBracket;
		boolean issetRightBracket=true;
		List<Integer>listAboutWhereIsBracket=new ArrayList<Integer>();
		for(int i=0;i<userString.length();i++)
		{
			
			
			
			if(userString.charAt(i)=='('&& issetRightBracket)///Save first left bracket
				listAboutWhereIsBracket.add(0, i);
				
			if(userString.charAt(i)=='('){
				numberOfInstanceLeftBracket++;
				issetRightBracket=false;
				
				
			}
			
			if(userString.charAt(i)==')' && issetRightBracket){			
			return false;
			}
			if(userString.charAt(i)==')'){
				numberOfInstanceRightBracket++;
				listAboutWhereIsBracket.add(1,i);
			}
		}
		
		
		for(int i=listAboutWhereIsBracket.get(1);i<userString.length();i++)
					if(userString.charAt(i)=='(')
						return false;
		
		
		
		
			

			int stop=0;
		for(int i=listAboutWhereIsBracket.get(0);i<listAboutWhereIsBracket.get(1);i++)
		{
			
			
			if(userString.charAt(i)=='(')
			{
				
				for(int j=stop;j<listAboutWhereIsBracket.get(1);j++)
				{
					
					
					
					
					
					if(userString.charAt(j)==')')
						{
						if(i>j)return false;
						stop=j;
						break;
						
						}
						}
				
				
			}
			
			
			
		}
		
		
		
		/*for(int i=listAboutWhereIsBracket.get(0);i>listAboutWhereIsBracket.get(1);i++)
		{}
		*/
				return numberOfInstanceLeftBracket==numberOfInstanceRightBracket?true:false;
		
		
		// TODO Auto-generated method stub
		
	}
	
	
}

abstract class MainAssertTrueOrFalse
{

	public UnitTest unitTest;
	
	public void setUnitTest(UnitTest unitTest)
	{
		this.unitTest=unitTest;
	}
	abstract public boolean tryTrueOrFalse(String userString);
	
	
}

class CheckAssertTrue extends MainAssertTrueOrFalse
{

	@Override
	public boolean tryTrueOrFalse(String userString)
	{
		
		return unitTest.checkBracket(userString)==true?true:false;
		
	}
	
}
class CheckAssertFalse extends MainAssertTrueOrFalse
{
	@Override
	public boolean tryTrueOrFalse(String userString)
	{
		return unitTest.checkBracket(userString)==false?true:false;
		
	}

}


