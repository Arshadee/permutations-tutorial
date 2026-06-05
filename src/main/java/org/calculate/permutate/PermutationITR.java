package org.calculate.permutate;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.stream.Collectors;
import java.util.Map;

/**
 * MyPermuationCalc Application
 * 
 * PermutationITR : This class works out all permutations of a given set of 
 * elements. This class implements Iterative DFS Algorithm
 *  
 * @author arshadmayet
 *
 */
public class PermutationITR implements IPermutateCalc{
    
    private static final String ALGOTITHM_NAME = "Iterative Debth First Search";
    
    /**
     * This method returns a name of this Tree Search implementation
     */ 
    @Override
    public String getAlgorithmName(){
        return ALGOTITHM_NAME;
    }
    
    /**
	 * Iterative DFS Algorithm to find all permutaions on a sequence of elements
	 * 
	 * @param sequence    list of elements to permutate
	 * @param base        subset size, use size of sequence for entire size per 
	 *                    permutations
	 * @seqMap            Map of set of elements to be permutated
	 * @return all permutations of the given sequence as a String List
	 */
    @Override
    public List<String> permutate(List<String> sequence, int base, 
        Map<String,String> seqMap) {
        
        List<String> result = new ArrayList<>();
        Deque<State> stack = new ArrayDeque<>();
        State state =  new State();
        //state.diff = sequence;
        state.diff =seqMap.keySet().stream().collect(Collectors.toList());
        stack.push(state);
        
        while(!stack.isEmpty()){
             
            State currState = stack.pop();
            //int limit = sequence.size() - base; 
            int limit = seqMap.keySet().size() - base;
            
            if(currState.diff.size()==limit){
			 //   result.add(currState.pref);
			   	String res = "";
			    List<String> lst = new ArrayList<>(Arrays.asList(currState.pref.split("")));
			    for(String e : lst){
			        res = res+seqMap.get(e);
			    }
                result.add(res);
	     	}

            for(int i = currState.diff.size()-1; i>=0; i--){
                State childState = new State();
                childState.pref = currState.pref+currState.diff.get(i);
                if(childState.pref.length()>base) break;
                //childState.diff = sequence.stream().filter(x -> !(childState.pref).contains(x)).collect(Collectors.toList());
                childState.diff = seqMap.keySet().stream().filter(x -> !(childState.pref).contains(x)).collect(Collectors.toList());
                stack.push(childState);
            }
        }
        return result;
     }
    
    
    /**
     * Required to hold state per iteration.
     */ 
    public class State{
        String pref;
        List<String> diff;
        
        public State(){
            pref="";
            diff = new ArrayList<>();
        }
    }
}