package org.calculate.permutate;

import java.util.*;
import java.util.stream.Collectors;

/**
 * MyPermuationCalc Application
 * 
 * PermutationBFS_ITR : This class works out all permutations of a given set of 
 * elements. This class implements Iterative BFS Algorithm
 *  
 * @author arshadmayet
 *
 */
public class PermutationBFS_ITR implements  IPermutateCalc{
    private static final String ALGOTITHM_NAME = "Iterative Breadth First Search";
    
     /**
     * This method returns a name of this Tree Search implementation
     */ 
    @Override
    public String getAlgorithmName(){
        return ALGOTITHM_NAME;
    }
    
     /**
	 * Iterative BFS Algorithm to find all permutaions on a sequence of elements
	 * 
	 * @param sequence    list of elements to permutate
	 * @param base        subset size, use size of sequence for entire size per 
	 *                    permutations
	 * @seqMap            Map of set of elements to be permutated
	 * @return all permutations of the given sequence as a String List
	 */
    @Override
    public List<String> permutate(List<String> sequence, int base, Map<String,String> seqMap) {
        
        List<String> result = new ArrayList<>();
        Queue<State> queue = new LinkedList<>();
        State state =  new State();
        //state.diff = sequence;
        state.diff =seqMap.keySet().stream().collect(Collectors.toList());
        queue.add(state);
        
        while(!queue.isEmpty()){
            
            State currState = queue.remove();
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
            
            //for(int i = currState.diff.size()-1; i>=0; i--){
             for(int i=0; i<currState.diff.size(); i++){
                State childState = new State();
                childState.pref = currState.pref+currState.diff.get(i);
                if(childState.pref.length()>base) break;
                //childState.diff = sequence.stream().filter(x -> !(childState.pref).contains(x)).collect(Collectors.toList());
                childState.diff = seqMap.keySet().stream().filter(x -> !(childState.pref).contains(x)).collect(Collectors.toList());
                queue.add(childState);
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