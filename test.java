import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   YOUR NAME (YOU@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  TODAY
*
*/
public final class Selector {

    /**
     * Can't instantiate this class.
     *
     * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
     *
     */
    private Selector() { }


    /**
     * Selects the minimum value from the array a. This method
     * throws IllegalArgumentException if a is null or has zero
     * length. The array a is not changed by this method.
     */
    public static int min(int[] a) {
        if (a == null || a.length == 0){
            throw new IllegalArgumentException("Array must not be null or empty.");
        }
        int minValue = a[0];
        for (int value : a){
            if (value < minValue) {
                minValue = value;
            }
           
        }
        
            
        return minValue;
    }


    /**
     * Selects the maximum value from the array a. This method
     * throws IllegalArgumentException if a is null or has zero
     * length. The array a is not changed by this method.
     */
    public static int max(int[] a) {
        if (a == null || a.length == 0){
            throw new IllegalArgumentException("Array must not be null or empty.");
        }
        int maxValue = a[0];
        for (int value : a){
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }


    /**
     * Selects the kth minimum value from the array a. This method
     * throws IllegalArgumentException if a is null, has zero length,
     * or if there is no kth minimum value. Note that there is no kth
     * minimum value if k < 1, k > a.length, or if k is larger than
     * the number of distinct values in the array. The array a is not
     * changed by this method.
     */
    public static int kmin(int[] a, int k) {
        if (a == null || a.length == 0 || k < 1 || k > a.length) {
            throw new IllegalArgumentException("Invalid Argument.");
        }
        int[] copy = Arrays.copyOf(a, a.length);
        Arrays.sort(copy);
        return copy[k - 1];
    }


    /**
     * Selects the kth maximum value from the array a. This method
     * throws IllegalArgumentException if a is null, has zero length,
     * or if there is no kth maximum value. Note that there is no kth
     * maximum value if k < 1, k > a.length, or if k is larger than
     * the number of distinct values in the array. The array a is not
     * changed by this method.
     */
    public static int kmax(int[] a, int k) {
         if (a == null || a.length == 0 || k < 1 || k > a.length) {
            throw new IllegalArgumentException("Invalid Argument.");
        }
        Arrays.sort(a);
        return a[a.length - k];
    }


    /**
     * Returns an array containing all the values in a in the
     * range [low..high]; that is, all the values that are greater
     * than or equal to low and less than or equal to high,
     * including duplicate values. The length of the returned array
     * is the same as the number of values in the range [low..high].
     * If there are no qualifying values, this method returns a
     * zero-length array. Note that low and high do not have
     * to be actual values in a. This method throws an
     * IllegalArgumentException if a is null or has zero length.
     * The array a is not changed by this method.
     */
    public static int[] range(int[] a, int low, int high) {
         if (a == null || a.length == 0) {
         throw new IllegalArgumentException("Array must not be null or empty.");
      }
      int[] result = Arrays.stream(a)
                          .filter(value -> value >= low && value <= high)
                          .toArray();
      return result;
    }


    /**
     * Returns the smallest value in a that is greater than or equal to
     * the given key. This method throws an IllegalArgumentException if
     * a is null or has zero length, or if there is no qualifying
     * value. Note that key does not have to be an actual value in a.
     * The array a is not changed by this method.
     */
    public static int ceiling(int[] a, int key) {
        if (a == null || a.length == 0) {
         throw new IllegalArgumentException("Array must not be null or empty.");
      }
      Arrays.sort(a);
      for (int value : a) {
         if (value >= key) {
            return value;
         }
    }
    throw new IllegalArgumentException("No qualifying value found.");
   }     


    /**
     * Returns the largest value in a that is less than or equal to
     * the given key. This method throws an IllegalArgumentException if
     * a is null or has zero length, or if there is no qualifying
     * value. Note that key does not have to be an actual value in a.
     * The array a is not changed by this method.
     */
    public static int floor(int[] a, int key) {
        if (a == null || a.length == 0) {
         throw new IllegalArgumentException("Array must not be null or empty.");
      }
      Arrays.sort(a);
      for (int i = a.length - 1; i >= 0; i--) {
         if (a[i] <= key) {
            return a[i];
         }
      }
        throw new IllegalArgumentException("No qualifying value found.");
    }
    
    public static void main(String[] args) {
      int[] sampleArray = {2, 8, 7, 3, 4, 5, 9, 1, 7, 3, 8, 7, 6, 5, 4};

      System.out.println("Min: " + min(sampleArray));
      System.out.println("Max: " + max(sampleArray));
      System.out.println("3rd Min: " + kmin(sampleArray, 3));
      System.out.println("2nd Max: " + kmax(sampleArray, 2));

      int[] rangeResult = range(sampleArray, 4, 7);
      System.out.println("Range: " + Arrays.toString(rangeResult));

      System.out.println("Ceiling of 6: " + ceiling(sampleArray, 6));
      System.out.println("Floor of 5: " + floor(sampleArray, 5));
    }
}
