// THE PROBLEM STATEMENT IS TO RETURN SUM OF ALL THE SCORES RECORD. AT THE BEGINNING, THE RECORD IS EMPTY, WE HAVE BEEN GIVEN A LIST OF STRING OPS, WHERE OPS[I] IS THE I 
// OPERATION TO PERFORM.
// IF OPS[I] IS AN INTEGER, RECORD A NEW SCORE, ELSE IF OPS[I] IS "+" RECORD A NEW SCROE THAT IS THE SUM OF PREVIOUS TWO SCORES,
// ELSE IF OPS[I] IS "D" RECORD A NEW SCORE THAT IS THE DOUBLE OF PREVIOUS SCORE, ELSE IF OPS[I] IS "C" REMOVE THE LAST SCORE FROM THE RECORD.

// MY APPROACH IS TO USE THE STACK DATA STRUCTURE SINCE THE PUSH AND POP OPERATION TAKES ONLY O(1) TIME. SO WE TRAVERSE THE OPS STRING AND CHECK WHETHER THE GIVEN CHARACTER
// IS A DIGIT,'C','D' OR '+' USING A SWITCH CASE AND PERFORM THE NECESSARY OPERATIONS.

class Solution {
    public int calPoints(String[] ops) {
        // INITIALISNG THE STACK DATA STRUCTURE.
        Stack<Integer> stack = new Stack<Integer>();
        int score = 0,currScore,prevScore;
        
        // TRAVERSING THE STRING.
        for(int i=0;i<ops.length;i++)
        {
            switch(ops[i].charAt(0))
            {
                case 'C':
                    currScore = stack.pop();
                    score -= currScore;
                    break;
                case 'D':
                    currScore = stack.pop();
                    score += (currScore*2);
                    stack.push(currScore);
                    stack.push(currScore*2);
                    break;
                case '+':
                    currScore = stack.pop();
                    prevScore = stack.pop();
                    score += (currScore+prevScore);
                    stack.push(prevScore);
                    stack.push(currScore);
                    stack.push(currScore+prevScore);
                    break;
                default:
                    stack.push(Integer.parseInt(ops[i]));
                    score += Integer.parseInt(ops[i]);
                    break;
            }
        }
        
        return score;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)
