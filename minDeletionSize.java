// THE PROBLEM STATEMENT IS TO RETURN THE NUMBER OF COLUMNS TO BE DELETED FOR THE MATRIX TO BE STRICTLY INCREASING COLUMN WISE.

// MY APPROACH IS TO TRAVERSE THE MATRIX AND IF THE ELEMENT AT A CERTAIN ROW IS LESSER THAN THE PREVIOUS ROW OF THE SAME COLUMN THEN MARK THAT COLUMN TRUE IN 
// A HASHTABLE THEN INCREMENT THE ANSWER. FINALLY RETURN THE ANSWER.

class Solution {
    public int minDeletionSize(String[] strs) {
        Boolean[] columns = new Boolean[strs[0].length()];
        int noOfColumns = 0;
        
        // TRAVERSING THE GIVEN MATRIX.
        for(int i=1;i<strs.length;i++)
        {
            for(int j=0;j<strs[i].length();j++)
            {
                if(strs[i].charAt(j) < strs[i-1].charAt(j) && columns[j] == null)
                {
                    columns[j] = true;
                    noOfColumns += 1;
                }
            }
        }
        
        return noOfColumns;
    }
}

// TIME COMPLEXITY : O(N*M)
// SPACE COMPLEXITY : O(M)
