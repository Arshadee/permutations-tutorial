package org.calculate.permutate;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author arshadmayet
 */
public interface IPermutateCalc{
    
    String getAlgorithmName();
    
    List<String> permutate(List<String> sequence, int base, 
        Map<String,String> seqMap);
    
    //int getResultSize(List<String> resultsList);
    /**
	 * This method gets the total number of permutations
	 */ 
    default int getResultSize(List<String> resultsList){
        return resultsList.size();
    }
    
    /**
    *  Default display method for results display
    * 
    * @param sequenceList String list of element to permutate
    * @param resultsList String list permutated results to display
    */
    default void display(List<String> sequenceList, List<String> resultsList,int subset){
        displ(sequenceList,resultsList,subset);
    }
    
    private void displ(List<String> sequenceList, List<String> resultsList,int subset){
        System.out.println(getAlgorithmName());
        System.out.println("sequenceList size = "+sequenceList.size());
        System.out.println("subset size = "+subset);
		System.out.println("Sequence "+sequenceList);
		System.out.println("results size = " +getResultSize(resultsList));
		System.out.println("-----------------------------------------------");
		System.out.println(resultsList);
	    System.out.println("-----------------------------------------------");
		System.out.println(getAlgorithmName());
		System.out.println("sequenceList size = "+sequenceList.size());
        System.out.println("subset size = "+subset);
		System.out.println("Sequence "+sequenceList);
		System.out.println("results size = " +getResultSize(resultsList));
		System.out.println("-----------------------------------------------");
    }
    
}