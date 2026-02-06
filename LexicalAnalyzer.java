

import java.util.Scanner;

public class LexicalAnalyzer {
    
	private static final int[][] transition_table = {
	        { 1, -1, -1}, 
	        { 1,  2, -1}, 
	        {-1, -1,  3}, 
	        {-1, -1, -1} };

	    private static final int init_state = 0;
	    private static final int acc_state = 3;
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		System.out.println("___________________________________");
		System.out.println("   LEXICAL ANALYZER – DFA ENGINE   ");
		System.out.println("       System Status: Ready       ");
        System.out.println("___________________________________");
        
        System.out.print("\nEnter a word to analyze (allowed symbols: a, b, c): ");
        
        String input = sc.nextLine().toLowerCase();
        
        int currentState = init_state;
        boolean crashed = false;
        
        System.out.println("\nAnalysis started.");
        
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            int column = getColumnIndex(symbol);
            System.out.println("\nCurrent State: " + currentState );
            System.out.println("Reading symbol: '" + symbol + "'");

            if (column == -1 || transition_table[currentState][column] == -1) {
                System.out.println("Error: No valid transition from state " 
                                    + currentState + " with symbol " + symbol + "'.");
                System.out.println("Processing stopped.");
                crashed = true;
				 break;
                
            }
        
            currentState = transition_table[currentState][column];
    
			System.out.println("Transition successful. Next State: " + currentState);

        }

        System.out.println("\n_________________________________");
        
        if (!crashed && currentState == acc_state) {
            System.out.println("Result: ACCEPTED");
            System.out.println("The input string belongs to the language.");
        } else {
            System.out.println("Result: REJECTED");
            System.out.println("The input string does not belong to the language.");
        }
	
	
	   System.out.println("____________________________________");
       
       System.out.println("Project: DFA-Based Lexical Analyzer");

       sc.close();
   }
	  private static int getColumnIndex(char symbol) {
	        switch (symbol) {
	            case 'a': return 0;
	            case 'b': return 1;
	            case 'c': return 2;
	            default: return -1;
	        }
	    }
}
