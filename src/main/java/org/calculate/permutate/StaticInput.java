package org.calculate.permutate;

import java.util.Arrays;
import java.util.List;

/**
 * StaticInput class to run a test using hard coded input variables
 */
public class StaticInput{
    
    /**
    * Run method
    * Uses hard coded inputs for subset size and permutationSet array
    */
    public void run(){
        
        IPermutateCalc perm = new PermutationITR();
        //IPermutateCalc perm = new PermutationREC();
        PermGen permGen = new PermGen();
        	
        String[] sequenceArray = {"1","2","3","4","5","6"};
    	int subset = sequenceArray.length;
        String[] resultArray = permGen.permutate(perm,sequenceArray,subset);
        permGen.display(perm,sequenceArray,resultArray,subset);
  
    	
        //subset not set - use full size all elements
	//	String[] resultsArray = permutation.permutate(sequenceArray,subset);
	//	permutation.display(sequenceArray, resultsArray, subset);
		
	//	IPermutateCalc permutationITR = new PermutationITR();
	//	String[] sequenceArray2 = {"1","2","3","4","5","6","7"};
    //	int subset2 =3;
		
		//String[] resultsArray2 = permutate(sequenceArray2,subset2,permutationITR);
	//	List<String> resultsArray2 =  permutationITR.permutate(Arrays.asList(sequenceArray2), subset2);
	//	permutationITR.display(Arrays.asList(sequenceArray2), resultsArray2, subset2);
    //Test3();

    }
    
//     private Map<String,String> getSeqMap(String[] sequenceArray){
//       List<String> sequenceList = Arrays.asList(sequenceArray);
//       return getSeqMap(sequenceList);
//     }
    
//     private Map<String, String> getSeqMap(List<String> sequenceList){
//         Map<String,String> seqMap = new HashMap<>();
// 		for(int i = 0; i<sequenceList.size();i++){
// 		    seqMap.put(i+"",sequenceList.get(i));
// 		}
// 		return seqMap;
//     }
    
    public void Test1(){
        
        	IPermutateCalc perm = new PermutationITR();
        	//IPermutateCalc perm = new PermutationREC();
        	PermGen permGen = new PermGen();
           
            String seqStr ="a b c d 1";
            int subset = 4;
        	//String resStr = permGen.permutate(perm,seqStr,subset);
        	String[] seqArray = seqStr.split(" ");
            String[] resArray = permGen.permutate(perm,seqArray,subset);
            permGen.display(perm,seqArray,resArray,subset);
		    
    }
    
    public void Test2(){
        
        	IPermutateCalc perm = new PermutationITR();
        	//IPermutateCalc perm = new PermutationREC();
        	PermGen permGen = new PermGen();
           
            String seqStr ="a b c d 2";
            int subset = 4;
        	//String resStr = permGen.permutate(perm,seqStr,subset);
        	String[] seqArray = seqStr.split(" ");
            //List<String> sequenceList = Arrays.asList(seqArray);
            //String[] resArray = resStr.split(" ");
            //List<String> resList = Arrays.asList(resArray);
            String[] resArray = permGen.permutate(perm,seqArray,subset);
            permGen.display(perm,seqArray,resArray,subset);
		    
    }
    
     public void Test3(){
        
        //IPermutateCalc perm = new PermutationITR();
        IPermutateCalc perm = new PermutationREC();
        PermGen permGen = new PermGen();
        String seqStr ="a b c d 3";
        int subset = 4;
        String[] seqArray = seqStr.split(" ");
        List<String> sequenceList = Arrays.asList(seqArray);
        List<String> resList = permGen.permutate(perm,sequenceList,subset);
        permGen.display(perm,sequenceList,resList,subset);
    }
    

}