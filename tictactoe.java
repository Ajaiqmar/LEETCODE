// THE PROBLEM STATEMENT IS TO RETURN THE RESULT OF THE TIC TAC TOE GAME. THE RULES OF TIC TAC TOE IS THERE ARE TWO PLAYERS EACH REPRESENTING THE CHARACTERS 'X' OR 'O'.
// THE BOARD CONSISTS OF A THREE BY THREE MATRICES WHOEVER FILLS THE BOARD WITH THREE CONTINOUS SAME CHARACTERS EITHER BY ROW OR COLUMN OR
// A DIAGONAL WINS THE MATCH.

// HERE WE SHOULD RETURN 'A' IF PLAYER A WINS, 'B' IF PLAYER B WINS, 'PENDING' IF BOTH THE PLAYERS DIDN'T WIN AND THERE ARE SOME REMAINING MOVES TO BE MADE, 'DRAW'
// IF NEITHER OF THEM WINS AND THERE ARE NO EXTRA MOVES.

// MY APPROACH IS TO TRAVERSE THE MOVES AND CHECK WHETHER EACH PLAYER HAS MADE A MOVE WHERE THE ROWS OR THE COLUMNS ALIGN AND ALSO CHECK FOR THE DIAGONALS
// ALIGNMENT USING THE HASTABLE. IF IT IS RETURN THE PLAYER CHARACTER WHO WON. IF GAME IS STILL ON AFTER TRAVERSING THE MOVES ARRAY.
// CHECK IF THE NUMBER OF MOVES IS LESS THAN 9 IF IT IS RETURN PENDING ELSE RETURN DRAW.

class Solution {
    public String tictactoe(int[][] moves) {
        int[][] playerA = new int[2][3];
        int[][] playerB = new int[2][3];
        int da1 = 0,da2 = 0,db1 = 0,db2 = 0;
        
        // TRAVERSING THE MOVES ARRAY.
        for(int i=0;i<moves.length;i++)
        {
            if(i%2 == 0)
            {
                playerA[0][moves[i][0]] += 1;
                playerA[1][moves[i][1]] += 1;
                
                if(moves[i][0] == moves[i][1])
                {
                    da1 += 1;
                }
                
                if(moves[i][0]+moves[i][1] == 2)
                {
                    da2 += 1;
                }
                
                if(playerA[0][moves[i][0]] == 3 || playerA[1][moves[i][1]] == 3 || da1 == 3 || da2 == 3)
                {
                    return "A";
                }
            }
            else
            {
                playerB[0][moves[i][0]] += 1;
                playerB[1][moves[i][1]] += 1;
                
                if(moves[i][0] == moves[i][1])
                {
                    db1 += 1;
                }
                
                if(moves[i][0]+moves[i][1] == 2)
                {
                    db2 += 1;
                }
                
                if(playerB[0][moves[i][0]] == 3 || playerB[1][moves[i][1]] == 3 || db1 == 3 || db2 == 3)
                {
                    return "B";
                }
            }
        }
        
        if(moves.length == 9)
        {
            return "Draw";
        }
        
        return "Pending";
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1) SINCE THE NUMBER OF ROWS AND COLUMNS OF A TIC TAC TOEB BOARD DOESN'T INCREASE LINEARLY.
