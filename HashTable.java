
import java.lang.Math;  // for the power function
import java.util.Arrays;

/**
 * Author: Norhan Abbas
 * Date: 31st of May, 2019
 *
 * Overview: this program implements hash table
 *           it allows the following:
 *
 *           1- Insertion by Linear probing
 *           2- Insertion by Quadratic probing
 *           3- delete an integer and returning the array without that integer
 *           4- Search for an integer and get to know if it exists (True)
 *           Or it is not there (False)
 *
 *           All the above take place by the user choice,
 *           Also, the loading factor of our table is always taken into consideration
 *           WHILE INSERTING ANY INTEGER
 *
 * NB. In this program, any Zero is considered to be a NULL element
 * Accordingly, the user should insert any integer OTHER THAN ZERO
 */

public class HashTable {

    //TODO: insert function -Quadratic probing
    public static int[] insertQuadratic(int[] arr, int val, int key, int x){

        x++;
        if (key < arr.length) {

            if (arr[key] == 0) {
                arr[key] = val;
                return arr;

            }

            else if (arr[key] != 0) {
                key += Math.pow(x, 2);
                insertQuadratic(arr, val, key, x);
            }

        }

        else if (key >= arr.length){
            key = key - arr.length;
            insertQuadratic(arr, val, key, x);
        }

        return arr;

    }
/***********************************************************************************/

//TODO: insert function -Linear probing

    public static int[] insertLinear(int[] arr, int val, int key){

        if (key < arr.length) {

            // base case
            if (arr[key] == 0) {
                arr[key] = val;

                return arr;
            }


            else if (arr[key] != 0){
                key++;
                insertLinear(arr, val, key);
            }

        }

        else if (key >= arr.length){

            key = key - arr.length;
            insertLinear(arr, val, key);
        }
        return arr;

    }
/***********************************************************************************/

    //TODO: Search function

    public static boolean search(int[] arr, int val, int i){

        if (i < arr.length) {
            if (arr[i] == val) {
                return true;
            } else {
                i++;
                return search(arr, val, i);
            }
        }

        return false;

    }

    static boolean searchGo(int[]arr, int val){
        return search(arr, val, 0);
    }
/***********************************************************************************/

    //TODO: delete function

    public static int[] delete(int[] arr, int val){

        int index = 0;
        if (searchGo(arr, val) == true) {   // if the value entered by the user exists
            int[] newArray = new int[arr.length - 1];

            for (int y = 0; y < arr.length; y++)
            {
                if (arr[y] == val) {
                    index = y;
                    break;
                }
            }

            for (int i = 0, k = 0; i < arr.length; i++) {

                if (i == index) {
                    arr[i] = 0;
                    continue;
                }

                newArray[k] = arr[i];


            }

            System.out.println("After deletion");
            //System.out.println(Arrays.toString(newArray));

/*            for (int i = 0; i < newArray.length; i++) {
                System.out.println(newArray[i]);
            }*/

            return newArray;
        }

        System.out.println("The value inserted DOES NOT EXIST");
        return arr;
    }
/***********************************************************************************/
    //TODO: resize function
    public static void reSize(int[] arr, String userChoice, int value, int key){

        // the new array is double the size
        int[] newArr = new int[arr.length * 2];

        double s = 0;

        // counting how many integers in my array are not ZERO
        // TAKEN INTO CONSIDERATION THAT in this program, Zero is being dealt with as if it was NULL

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                s++;
            }
        }

        // calculate the loading factor
        s = s/arr.length;

        // resize happens ONLY when the loading factor is greater than 0.8
        if (s > 0.8) {

            //key = value%newArr.length;

            switch (userChoice) {
                case "IL":

                    for (int i = 0; i < arr.length; i++) {
                        key = arr[i]%newArr.length;
                        insertLinear(newArr, arr[i], key);
                    }
                    key = value%newArr.length;     // my hash function
                    insertLinear(newArr, value, key);
                    break;

                case "IQ":
                    for (int i = 0; i < arr.length; i++) {
                        key = arr[i]%newArr.length;

                        // x starts from 2 as key + (1^2) has been already included in linear probing
                        insertQuadratic(newArr, arr[i], key, 2);
                    }
                    key = value%newArr.length;     // my hash function
                    insertLinear(newArr, value, key);
                    break;
            }
            System.out.println("PS. the loading factor is greater than 0.8");
            System.out.println("Accordingly, resizing is needed\n");
            System.out.println("After rehashing again");
            System.out.println(Arrays.toString(newArr));

        }

        else {

            // No resizing needed if S less than or equal to 0.8
            switch (userChoice) {
                case "IL":
                        key = value%arr.length;   // my hash function
                        insertLinear(arr, value, key);

                    break;

                case "IQ":
                         key = value%arr.length;   // my hash function
                        insertQuadratic(arr, value, key, 1);

                    break;
            }

            System.out.println("PS. the loading factor is less than or equal to 0.8");
            System.out.println("Accordingly, resizing is NOT needed\n");
            System.out.println("After rehashing again");
            System.out.println(Arrays.toString(arr));

        }



/*            System.out.println("After resizing");
            for (int i = 0; i < newArr.length; i++) {
                System.out.println(newArr[i]);
            }*/
        }

    }





