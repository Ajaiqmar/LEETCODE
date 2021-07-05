

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
