class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
    //     char a[]=s.toCharArray();
    //     char b[]=t.toCharArray();
    //     Arrays.sort(a);
    //     Arrays.sort(b);
    //     if(Arrays.equals(a,b)){
    //         return true;
    //     } else return false;
    int arr[] = new int[256];
    for(int i=0;i<s.length();i++){
        arr[s.charAt(i)]++;
        arr[t.charAt(i)]--;
    }
    for(int i=0;i<256;i++){
        if(arr[i]!=0) return false;
    }
    return true;
    }
}