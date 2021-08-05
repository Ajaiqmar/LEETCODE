// THE PROBLEM STATEMENT IS TO FIND OUT WHETHER WE COULD PLANT ATLEAST N FLOWERS IN A FLOWER BED. WHILE PLACING A FLOWER THE ADJACENT PLOTS MUST BE EMPTY.
// 1 REPRESENT FLOWER AND 0 REPRESENTS EMPTY PLOT IN THE FLOWER BED.

// MY APPROACH IS TO TRAVERSE TH FLOWERBED ARRAY AND CHECK AT EACH INDEX WHETHER IT IS A EMPTY PLOT, IF IT IS THEN CHECK WHTHER THE ADJACENT PLOTRS ARE EMPTY TOO.
// IF IT IS THEN PLACE A FLOWER AND INCREMENT THE COUNTOFFREEBEDS VARIABLE. FINALLY CHECK WHETHER THE COUNTOFFREEBEDS IS GREATER THAN OR EQUAL TO N. IF IT IS RETURN TRUE,
// ELSE RETURN FALSE.

bool canPlaceFlowers(int* flowerbed, int flowerbedSize, int n){
    int countOfFreeBeds = 0;
    
    if(flowerbedSize == 1)
    {
        if(flowerbed[0] == 0)
        {
            countOfFreeBeds++;
            flowerbed[0] = 1;
        }
        
        return countOfFreeBeds >= n;
    }
    
    // TARVERSING THE FLOWERBED ARRAY TO CHECK FOR EMPTY PLOTS.
    for(int i=0;i<flowerbedSize;i++)
    {
        if(i == 0 && flowerbed[i] == 0 && flowerbed[i+1]==0)
        {
            countOfFreeBeds++;
            flowerbed[i] = 1;
        }
        else if(i == flowerbedSize-1 && flowerbed[i] == 0 && flowerbed[i-1] == 0)
        {
            countOfFreeBeds++;
            flowerbed[i] = 1;
        }
        else if(i>0 && i<flowerbedSize-1 && flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1]==0)
        {
            countOfFreeBeds++;
            flowerbed[i] = 1;
        }
    }
    
    return countOfFreeBeds >= n;
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
