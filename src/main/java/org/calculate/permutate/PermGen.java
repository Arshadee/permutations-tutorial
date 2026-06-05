package org.calculate.permutate;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 *  MyPermutationCalc Application
 * 
 *  PermGen, this class uses generic method that require objects instatiated 
 *  from a class that implements IPermutateCalc interface used by all our 
 *  Tree Search class implementations.
 * 
 *  This Allows us to swap between different Tree Search implementations
 *  easily and dynamically  (no code changess)
 * 
 *  @author arshadmayet
 */
public class PermGen{
    
    /*
    *  Overriding and Overloading permutate method call adapt for 
    *  String input and output
    *  
    *  @param sequenceString String of elements to permutate
    *  @return all permutations of the given sequence as a String
    */
    public <T extends IPermutateCalc> String permutate(T perm, String sequenceString, int base) {
        
        List<String> sequence = new ArrayList<String>(Arrays.asList(sequenceString.split(" ")));
        Map<String,String> seqMap = getSeqMap(sequence);
        List<String> results = perm.permutate(sequence, base,seqMap);
        String resultsString = String.join(" ", results);
        return resultsString;
    }
    
    /*
    *  Overriding and Overloading permutate method call adapt for 
    *  String[] input and output
    *  
    *  @param sequenceString String[] of elements to permutate
    *  @return all permutations of the given sequence as a String[]
    */
    public <T extends IPermutateCalc> String[] permutate(T perm, String[] sequenceArray, int base) {
        
        List<String> sequence = Arrays.asList(sequenceArray);
        Map<String,String> seqMap = getSeqMap(sequence);
	    List<String> results =  perm.permutate(sequence,base, seqMap);
        String[] resultsArray = new String[results.size()];
        results.toArray(resultsArray); // fill the array
        return resultsArray;
    }
    
    /*
    *  Overriding and Overloading permutate method call
    *  
    *  @param sequence String List of elements to permutate
    *  @return all permutations of the given sequence as a String List
    */
    public <T extends IPermutateCalc> List<String> permutate(T perm, List<String> sequence, int base) {
        
        Map<String,String> seqMap = getSeqMap(sequence);
        List<String> results = perm.permutate(sequence, base, seqMap);
        return results;
    }
    
    /**
    *  Overloaded display method for results display
    * 
    * @param sequenceArray String array of element to permutate
    * @param resultArray String array permutated results to display
    */
    public <T extends IPermutateCalc>  void display(T perm, String[] sequenceArray, String[] resultArray,int subset) {
     
        List<String> sequenceList = Arrays.asList(sequenceArray);
        List<String> resultsList = Arrays.asList(resultArray);
        perm.display(sequenceList,resultsList,subset);    
    }
    
    /**
    *  Overloaded display method for results display
    * 
    * @param sequenceList String list of element to permutate
    * @param resultsList String list permutated results to display
    */
    public void display(IPermutateCalc perm, List<String> sequenceList, List<String> resultsList,int subset) {
        
        perm.display(sequenceList, resultsList, subset);
    }
    
    private Map<String, String> getSeqMap(List<String> sequenceList) {
        
        Map<String,String> seqMap = new HashMap<>();
		for(int i = 0; i<sequenceList.size();i++){
		    seqMap.put(i+"",sequenceList.get(i));
		}
		return seqMap;
    }
    
}