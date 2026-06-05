package org.calculate.permutate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

/**
 * MyPermuationCalc Application
 * 
 * PermutationREC : This class works out all permutations of a given set of 
 * elements. This class implements Recursive DFS Algorithm
 *  
 * @author arshadmayet
 *
 */
public class PermutationREC implements IPermutateCalc{
    
    public static final String EMPTY_STRING = "";
    
    private static final String ALGOTITHM_NAME = "Recursive Debth First Search";
    
    /**
     * This method returns a name of this Tree Search implementation
     */ 
    @Override
    public String getAlgorithmName(){
        return ALGOTITHM_NAME;
    }
    
    /*
    *  Overriding and Overloading permutate method call
    *  
    *  @param sequence String List of elements to permutate
    *  @return all permutations of the given sequence as a String List
    */
    @Override
    public List<String> permutate(List<String> sequence, int base, 
        Map<String,String> seqMap){
            
        List<String> results =  
        permutate(EMPTY_STRING,new ArrayList<String>(),sequence,base,seqMap);
        return results;
    }
    
	/**
	 * Recursve DFS Algorithm to find all permutaions on a sequence of elements
	 * 
	 * @param pref        path of current element in permutation tree
	 * @param result      to store permutations
	 * @param sequence    list of elements to permutate
	 * @param base        subset size, use size of sequence for entire size per
	 *                    permutation
	 * @seqMap            Map of set of elements to be permutated
	 * @return all permutations of the given sequence as a String List
	 */
	 private List<String> permutate(String pref, List<String> result, List<String> sequence, int base, Map<String,String> seqMap) {
    
		/*
		 * Get just the children for tree element
		 */
	//	List<String> diff = seqMap.keySet().stream().filter(x -> !(pref).contains(x)).collect(Collectors.toList());

         List<String> diff = new ArrayList<>();
         for (String x : seqMap.keySet()) {
             if (pref.indexOf(x) == -1) {
                 diff.add(x);
             }
         }

		/*
		 * No more children therefore reached end of branch store branch paths
		 */
		 int limit = seqMap.keySet().size() - base;
		 
	
		if(diff.size()==limit){
		//	result.add(pref);
			String res = "";
			List<String> lst = new ArrayList<>(Arrays.asList(pref.split("")));
			for(String e : lst){
			    res = res+seqMap.get(e);
			}
            result.add(res);
            return result;
		}

		/*
		 * Loop thru each child
		 */
		for (String s : diff) {
		    if(pref.length()>base) break; // to trim permuatation tree based on result sequence limit
			permutate(pref+s, result,sequence,base, seqMap); // recursively traverse tree
		}
		return result;
	}
}
