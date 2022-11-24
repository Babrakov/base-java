package main.java.part2;

public class MergeArrays {

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int len = a1.length+a2.length;
        int[] result = new int[len];
        for (int i = 0, j = 0, k = 0; k < (len); k++){
            if (i>=a1.length) {
                result[k] = a2[j];
                j++;
                continue;
            }
            if (j>=a2.length) {
                result[k] = a1[i];
                i++;
                continue;
            }
            if (a1[i]<a2[j]) {
                result[k] = a1[i];
                i++;
            } else {
                result[k] = a2[j];
                j++;
            }
        }
        return result;
    }
}
