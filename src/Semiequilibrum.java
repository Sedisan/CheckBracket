import java.util.Scanner;

public class Semiequilibrum {

	
	
	public static void validationTest(Scanner scan)
	{
		
		while(true)
		{
			if(scan.hasNextInt())break;
			else
			{
				System.out.println("Sprobuj ponownie...\n");
				
				scan.next();
				
			}
			
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		System.out.println("Wprowadz liczbe indeksow: \n");
		int tempForNumberOfItems;
		
		validationTest(scan);
		
		//try{
		tempForNumberOfItems=scan.nextInt();
		//}
		/*catch(NumberFormatException e)
		{
			System.out.println("Unrecognized value");
			System.exit(1);
		}
		*/
		int mainTableOfItems[]=new int [tempForNumberOfItems];
		int leftSize=0
		,fullSizeOfTable=leftSize;
		for(int i=0;i<tempForNumberOfItems;i++){
		System.out.println("Wprowadz element: "+i+" :");
		validationTest(scan);
		mainTableOfItems[i]=scan.nextInt();
		fullSizeOfTable+=mainTableOfItems[i];
		
		
		}
		
		int whichElement=0;
		for(int numberElementOfMainTable:mainTableOfItems)
		{
			
			leftSize+=numberElementOfMainTable;
			fullSizeOfTable-=numberElementOfMainTable;
			
			if(leftSize>fullSizeOfTable)break;
			whichElement++;
			
		}
		
		
		System.out.println("Z wprowadzonych danych, indeks: "+whichElement+" jest minimalnym przegieciem sumy lewostronnej");
		
		
		
		
		
		scan.close();
	}

}
