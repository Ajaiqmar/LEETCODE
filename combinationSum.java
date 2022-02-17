// PROBLEM DESCRIPTION : https://leetcode.com/problems/combination-sum/

// MY APPROACH IS TO USE RECURSION AND FIND OUT ALL THE COMBINATIONS WHOSE SUM IS THE GIVEN TARGET VALUE. SO I AM GOING TO CREATE A FIND UNIQUE COMBINATIONS 
// FUNCTION WHICH TAKES ANS TWO DIMENSIONAL ARRAY WHICH IS GOING CONTAIN ALL THE COMBINATIONS, A TEMP ARRAY, A UNIQUE COMBINATION HASHMAP WHICH IS GOING TAKE STRING 
// AS THE KEY AND BOOLEAN AS ITS CORRESPONDING VALUE, A FREQ ARRAY, A CANDIDATES ARRAY AND THE TARGET INTERGER AS ITS PARAMETER. FOR EACH RECURSIVE CALL, WE WILL
// FIRST CHECK WHETHER THE GIVEN TARGET VALUE IS ZERO OR NOT, IF IT IS ZERO WE CREATE A STRING KEY USING THE FREQ ARRAY AND CHECK IF THE STRING IS 
// PRESENT IN THE HASHMAP, IF IT IS NOT PRESENT IN THE HASHMAP THEN WE INSERT IT INTO THE HASHMAP AND INSERT CURRENT COMBINATION INTO THE ANS 2D ARRAY.
// THIS IS TO MAKE SURE THAT ALL THE COMBINATIONS ARE UNIQUE. IF THE TARGET IS NOT ZERO, THEN WE TRAVERSE THE CANDIDATES ARRAY AND CHECK IF THE CURRENT INDEX VALUE IS
// LESS THAN OR EQUAL TO THE TARGET VALUE, IF IT IS THEN WE MAKE A RECURSIVE CALL TO FIND UNIQUE COMBINATIONS FUNCTION WHERE THE CURRENT VALUE HAS BEEN
// ADDED TO THE TEMPORARY ARRAY, REDUCE THE TARGET VALUE BY THE CURRENT VALUE AND INCREMNET THE VALUE AT THAT INDEX IN THE FREQUENCY ARRAY.
// REPEAT THIS PROCESS TO FIND ALL THE COMBINATIONS.

class Solution 
{
    static void findUniqueCombinations(List<List<Integer>> ans,ArrayList<Integer> temp,HashMap<String,Boolean> uniqueCombination,int[] freq,int[] candidates,int target)
    {
        if(target == 0)
        {
            String key = "";
            
            for(int i=0;i<freq.length;i++)
            {
                key += freq[i]+" ";
            }
            
            if(uniqueCombination.get(key) == null)
            {
                uniqueCombination.put(key,true);
                
                List<Integer> t = new ArrayList<Integer>();
                
                for(int i=0;i<temp.size();i++)
                {
                    t.add(temp.get(i));
                }
                
                ans.add(t);
            }
        }
        else
        {
            for(int i=0;i<candidates.length;i++)
            {
                if(candidates[i] <= target)
                {
                    temp.add(candidates[i]);
                    freq[i] += 1;
                    
                    findUniqueCombinations(ans,temp,uniqueCombination,freq,candidates,target-candidates[i]);
                    
                    freq[i] -= 1;
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        findUniqueCombinations(ans,new ArrayList<Integer>(),new HashMap<String,Boolean>(),new int[candidates.length],candidates,target);
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N*(2^N))
// SPACE COMPLEXITY : O(N*N)
