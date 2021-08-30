// THE PROBLEM STATEMENT IS TO BUILD THE CLASS SUBRECTANGLE QUERIES WHICH TAKES A INTEGER MATRIX AS ONE OF THE PARAMETERS OF THE CONSTRUCTORS.
// THERE ARE TWO FUNCTIONS UPDATE SUBRECTANGLE AND GET VALUE.
// IN UPDATE SUBRECTANGLE FUNCTION, WE GET TWO SETS OF ROWS AND COLUMNS WHICH CORRESPONDS TO A SUBRECTANGLE, WE HAVE TO UPDATE ITS VALUE TO THE NEW VALUE.
// IN GET VALUE FUNCTION, WE HAVE TO RETURN THE VALUE THAT CORRESPONDS TO THE GIVEN ROW AND COLUMN.

// MY APPROACH IS TO STORE THE GIVEN MATRIX, AND ALSO STORE THE ALL THE GIVEN ROWS AND COLUMNS GIVEN IN THE UPDATE SUBRECTANGLE QUERIES FUNCTION IN 
// AN ARRAY. NOW IN THE GET VALUE FUNCTION, TRAVERSE THE ARRAYS THE CONTAIN THE SUBRECTANGLE POINTS AND CHECK WHETHER THE GIVEN ROW AND COLUMN IS
// PRESENT INSIDE IT, IF IT IS RETURN THE VALUE CORRESPONDING TO IT, ELSE RETURN THE VALUE IN THE GIVEN MATRIX.

class SubrectangleQueries {
    vector<int> startRows;
    vector<int> endRows;
    vector<int> startCols;
    vector<int> endCols;
    vector<int> value;
    vector<vector<int>> matrix;
public:
    SubrectangleQueries(vector<vector<int>>& rectangle) {
        matrix = rectangle;
    }
    
    // UPDATE SUBRECTANGLE FUNCTION.
    void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        startRows.push_back(row1);
        endRows.push_back(row2);
        startCols.push_back(col1);
        endCols.push_back(col2);
        value.push_back(newValue);
    }
    
    // GET VALUE FUNCTION.
    int getValue(int row, int col) 
    {
        for(int i=(startRows.size()-1);i>=0;i--)
        {
            if(startRows[i] <= row && endRows[i] >= row && startCols[i] <= col && endCols[i] >= col)
            {
                return value[i];
            }
        }
        return matrix[row][col];
    }
};

// TIME COMPLEXITY : O(M+(N*M)) WHERE N IS THE NUMBER OF CALLS TO GET VALUE FUNCTION AND M IS THE NUMBER OF CALLS TO UPDATE SUBRECTANGLE FUNCTION.
// SPACE COMPLEXITY : O(M)
