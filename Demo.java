import java.util.Scanner;
import java.util.Arrays;

class Demo {

    public static void main(String[] args) {

        HashTable hash_t = new HashTable();

        int[] array_values;
        String userChoice;

        array_values = new int[] {0, 0, 9, 8, 3, 7};
        System.out.println("\nHere's your initial array");
        System.out.println(Arrays.toString(array_values));

        do {



        /*for (int i = 0; i < array_values.length; i++){
            System.out.println(array_values[i]);
        }*/

        //System.out.println(Arrays.toString(arrayNew));


        System.out.println("\nPick something according to what you would like to do ");
        System.out.println("------------------------------------------------------");
        System.out.println("IL- Insert using Linear probing");
        System.out.println("IQ- Insert using Quadratic probing");
        System.out.println("D- Delete");
        System.out.println("S- Search");
        System.out.println("Q- Quit");

        Scanner input = new Scanner(System.in);
        // convert the user input to upper case in case s/he was lazy to follow the instructions
        userChoice = input.next().toUpperCase();

        switch (userChoice) {
            case "IL":   //Insert by Linear probing
                System.out.println("Enter a value");
                Scanner v = new Scanner(System.in);

                while (!v.hasNextInt()) {     // Robustness: ensure user enters an integer
                    v.next();
                    System.out.println("Enter INTEGER");
                }
                int value = v.nextInt();

                int key = value % array_values.length;
                hash_t.reSize(array_values, "IL", value, key);


                break;

            case "IQ":   //Insert by Quadratic probing
                System.out.println("Enter a value");
                Scanner v2 = new Scanner(System.in);

                while (!v2.hasNextInt()) {     // Robustness: ensure user enters an integer
                    v2.next();
                    System.out.println("Enter INTEGER");
                }
                int value2 = v2.nextInt();

                int key1 = value2 % array_values.length;
                hash_t.reSize(array_values, "IQ", value2, key1);


                break;

            case "D":    //Delete an element and return the new array
                System.out.println("Enter a value");
                Scanner d = new Scanner(System.in);

                while (!d.hasNextInt()) {     // Robustness: ensure user enters an integer
                    d.next();
                    System.out.println("Enter INTEGER");
                }

                int deleteVal = d.nextInt();

                hash_t.delete(array_values, deleteVal);
                //return array_values;

                break;
                //continue;

            case "S":    //Search
                System.out.println("Enter a value");
                Scanner s = new Scanner(System.in);

                while (!s.hasNextInt()) {     // Robustness: ensure user enters an integer
                    s.next();
                    System.out.println("Enter INTEGER");
                }

                int searchVal = s.nextInt();

                System.out.println(hash_t.searchGo(array_values, searchVal));

                break;

            case "Q":    //Quit
                System.exit(0);


            default:   // Robustness: for Smartie users :D
                System.out.println("Invalid input, Bummer");
                System.out.println("\n");
        }
            //System.out.println(Arrays.toString(array_values));

/*        arrayNew = array_values;
        return arrayNew;*/

        } while (userChoice.equals("Q") == false);


    }
}