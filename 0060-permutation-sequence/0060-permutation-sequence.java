class Solution {
    public String getPermutation(int n, int k) {
        
        int[] factArray = new int[n];
        factArray[0] = 1;
        List<Integer> numberList = new ArrayList<>();
        for(int i=1; i<factArray.length; i++){
            factArray[i] = i*factArray[i-1];
            numberList.add(i);
        }
        numberList.add(n);
        k = k-1;
        StringBuilder resultSb = new StringBuilder();
        for(int i=1; i<=n; i++){
            int index = k / factArray[n-i];
            resultSb.append(numberList.get(index));
            numberList.remove(index);
            k = k % factArray[n-i];
        }
        return resultSb.toString();
    }
}