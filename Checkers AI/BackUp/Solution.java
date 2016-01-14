import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    /*
 * Complete the function below.
 */

    static int findMedian(int[] sortedValueArray, int threshold) {
        int i = 0;
        if(sortedValueArray[0] < threshold) throw new EmptyStackException();
        while(sortedValueArray[i] < threshold) i++;
        if((sortedValueArray.length - i) % 2 == 0) 
            return sortedValueArray[i + (sortedValueArray.length - i)/2];
        else
            return findMiddle(sortedValueArray[i + (sortedValueArray.length - i)/2], 1 + i + (sortedValueArray.length - i)/2);
    }
    
    static int findMiddle(int a, int b){
        return (a - b)/2 + a;
    }

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;
        
        int _sortedValueArray_size = 0;
        _sortedValueArray_size = Integer.parseInt(in.nextLine().trim());
        int[] _sortedValueArray = new int[_sortedValueArray_size];
        int _sortedValueArray_item;
        for(int _sortedValueArray_i = 0; _sortedValueArray_i < _sortedValueArray_size; _sortedValueArray_i++) {
            _sortedValueArray_item = Integer.parseInt(in.nextLine().trim());
            _sortedValueArray[_sortedValueArray_i] = _sortedValueArray_item;
        }
        
        int _threshold;
        _threshold = Integer.parseInt(in.nextLine().trim());
        
        res = findMedian(_sortedValueArray, _threshold);
        bw.write(String.valueOf(res));
        bw.newLine();
        
        bw.close();
    }
}