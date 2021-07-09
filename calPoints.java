class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<Integer>();
        int score = 0,currScore,prevScore;
        
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
