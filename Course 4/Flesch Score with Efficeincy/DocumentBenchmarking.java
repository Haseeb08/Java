package document;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/** A class for timing the EfficientDocument and BasicDocument classes
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 */

public class DocumentBenchmarking {

	
	public static void main(String [] args) {

	    // Run each test more than once to get bigger numbers and less noise.
	    // You can try playing around with this number.
	    int trials = 500;

	    // The text to test on
	    String textfile = "data/warAndPeace.txt";
		
	    // The amount of characters to increment each step
	    // You can play around with this
		int increment = 2000;

		// The number of steps to run.  
		// You can play around with this.
		int numSteps = 20;
		
		// THe number of characters to start with. 
		// You can play around with this.
		int start = 5000;
		
		// TODO: Fill in the rest of this method so that it runs two loops
		// and prints out timing results as described in the assignment 
		// instructions and following the pseudocode below.
		double startTime,endTime;
		
		for (int numToCheck = start; numToCheck < numSteps*increment + start; 
				numToCheck += increment)
		{
			// numToCheck holds the number of characters that you should read from the 
			// file to create both a BasicDocument and an EfficientDocument.  
			
			/* Each time through this loop you should:
			 * 1. Print out numToCheck followed by a tab (\t) (NOT a newline)
			 * 2. Read numToCheck characters from the file into a String
			 *     Hint: use the helper method below.
			 * 3. Time a loop that runs trials times (trials is the variable above) that:
			 *     a. Creates a BasicDocument 
			 *     b. Calls fleshScore on this document
			 * 4. Print out the time it took to complete the loop in step 3 
			 *      (on the same line as the first print statement) followed by a tab (\t)
			 * 5. Time a loop that runs trials times (trials is the variable above) that:
			 *     a. Creates an EfficientDocument 
			 *     b. Calls fleshScore on this document
			 * 6. Print out the time it took to complete the loop in step 5 
			 *      (on the same line as the first print statement) followed by a newline (\n) 
			 */  
			System.out.print(numToCheck+"\t");
			String text=getStringFromFile(textfile, numToCheck);
			startTime=System.nanoTime();
			for(int i=0;i<trials;i++) {
				BasicDocument doc= new BasicDocument(text);
				doc.getFleschScore();
			}
			
			 endTime=System.nanoTime();
			System.out.print((endTime-startTime)/1000000000);
			
			startTime=System.nanoTime();
			for(int i=0;i<trials;i++) {
				EfficientDocument doc= new EfficientDocument(text);
				
				doc.getFleschScore();
			}
			endTime=System.nanoTime();
			System.out.print("\t"+((endTime-startTime)/1000000000)+(EfficientDocument.total)*trials+"\n");
		
		}
	
	}
	
	/** Get a specified number of characters from a text file
	 * 
	 * @param filename The file to read from
	 * @param numChars The number of characters to read
	 * @return The text string from the file with the appropriate number of characters
	 */
	public static String getStringFromFile(String filename, int numChars) {
		
		StringBuffer s = new StringBuffer();
		try {
			FileInputStream inputFile= new FileInputStream(filename);
			InputStreamReader inputStream = new InputStreamReader(inputFile);
			BufferedReader bis = new BufferedReader(inputStream);
			int val;
			int count = 0;
			while ((val = bis.read()) != -1 && count < numChars) {
				s.append((char)val);
				count++;
			}
			if (count < numChars) {
				System.out.println("Warning: End of file reached at " + count + " characters.");
			}
			bis.close();
		}
		catch(Exception e)
		{
		  System.out.println(e);
		  System.exit(0);
		}
		
		
		return s.toString();
	}
	
}
/* OUTPUT
 * Num      BasicDoc  Efficient
 5000	0.375526461	0.183651939
7000	0.191219314	0.116824062
9000	0.254290239	0.129057086
11000	0.305199642	0.188791802
13000	0.36609876	0.204666653
15000	0.423872544	0.237863351
17000	0.499905205	0.269781046
19000	0.701394219	0.372732065
21000	0.640534956	0.340143828
23000	0.715067231	0.406509618
25000	0.82542867	0.423848202
27000	0.805885771	0.437946605
29000	0.867400122	0.472647426
31000	0.925387533	0.50279643
33000	0.982399149	0.563153781
35000	1.111632429	0.580622167
37000	1.10932704	0.610217026
39000	1.171834612	0.644574359
41000	1.234136507	0.678542995
43000	1.303217259	0.713669985
		*/
