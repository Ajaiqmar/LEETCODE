class Solution {
    public boolean isVowel(char ch)
    {
        if(ch == 'A' || ch == 'a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='E' || ch=='I' || ch=='O' || ch=='U')
        {
            return true;
        }
        return false;
    }
    
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        
        int i = 0, j = s.length()-1;
        
        while(i<j)
        {
            if(this.isVowel(arr[i]) && this.isVowel(arr[j]))
            {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i+=1;
                j-=1;
            }
            else if(!this.isVowel(arr[i]))
            {
                i+=1;
            }
            else if(!this.isVowel(arr[j]))
            {
                j-=1;
            }
        }
        
        s = "";
        
        for(char k:arr)
        {
            s+=k;
        }
        
        return s;
    }
}
