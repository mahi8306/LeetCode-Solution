class Solution {
    public void reverseString(char[] n) {
        int left = 0;
        int right =n.length-1;

        while(left < right ) {
           char temp = n[left];
           n[left] = n[right];
           n[right] = temp;

           left ++;
           right --; 
        }    
    }
}  