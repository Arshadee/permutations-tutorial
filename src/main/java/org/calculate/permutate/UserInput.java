package org.calculate.permutate;

import java.util.Arrays;
import java.util.List;

/**
 * UserInput class to run a test using user selected input variables
 * from Command line arguments
 */
public class UserInput{
    
    static final String ALGORITHM_RECURSIVE = "REC";
    static final String ALGORITHM_ITERATIVE = "ITR";
    static final String ALGORITHM_ITERATIVE_BFS = "ITRB";
    
     /**
     * run(String[] args) method
     * Uses User inputs from command line args
     * For subsetSize and permutationSet array
     * 
     * Format for user input (args[])
     * size{sizeNumber} {element1 element2 element3 ... elementN} 
     * for just permutation of the specified subset size
     * or
     * {element1 element2 element3 ... elementN} for all permutations
     * 
     * @param args   String Array of user inputs includes SubsetSize and elements
     *               or just elements 
     *
     */ 
    public void run(String[] args){
        
        if(!isInputValid(args)){
	        return;     
	    }
	    
	    // PermutationFormatter permutation = new PermutationFormatter();
        // IPermutateCalc perm = new PermutationITR();
        IPermutateCalc perm = new PermutationREC();
        
        PermGen permGen = new PermGen(); 
	    String endParam = args[args.length-1];
		
		if(   endParam.toUpperCase().equals(ALGORITHM_ITERATIVE) 
		   || endParam.toUpperCase().equals(ALGORITHM_RECURSIVE)
		   || endParam.toUpperCase().equals(ALGORITHM_ITERATIVE_BFS)){
		    args = Arrays.copyOfRange(args, 0, args.length-1);
		}
		
		if(endParam.toUpperCase().equals(ALGORITHM_ITERATIVE)){
		    perm = new PermutationITR();
		}
		
		if(endParam.toUpperCase().equals(ALGORITHM_ITERATIVE_BFS)){
		    perm = new PermutationBFS_ITR();
		}
	    
	    List<String> sequenceList = Arrays.asList(args); 
		int subset = sequenceList.size();
	
		if(args[0].toLowerCase().contains("size")){
		    String[] argument = args;
		    String size = argument[0].replace("SIZE","size");
		    size = size.replace("size","");
		    subset = Integer.parseInt(size);
		    argument = Arrays.stream(argument).skip(1).toArray(String[]::new);
		    sequenceList = Arrays.asList(argument);
		}
		
        List<String> resultsList = permGen.permutate(perm,sequenceList,subset);
        permGen.display(perm,sequenceList, resultsList, subset);
    }
    
    private static boolean isInputValid(String[] args){
	    if(args == null || args.length == 0){
	        System.out.println("Usage: element1 element2 element3 ... elementN");
	        System.out.println("To display permutation of entire set");
	        System.out.println("Usage: Main size{select_subset_size} element1 element2 element3 ... elementN");
	        System.out.println("or Main size{select_subset_size} element1 element2 element3 ... elementN (Algorithm Type) ITR or REC");
	        System.out.println("To display permutation of just a subset of the set");
	        return false;
	    }
	    return true;
	}
    
}