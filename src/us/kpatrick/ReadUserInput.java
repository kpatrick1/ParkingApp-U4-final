package us.kpatrick;

import java.util.Scanner;

/**
 * CLASS USED TO GET AND VALIDATE THE INFORMATION PROVIDED FROM THE USER IS CORRECT AND OF THE CORRECT TYPE
 * @author kpatr
 * @version 1.0.0
 */

public class ReadUserInput {
    private static Scanner keyboard = new Scanner(System.in);
    private static final int POSITIVE_INT_INITIALIZER = -1;

    /**
     * THIS METHOD WILL VALIDATE AND CATCH AND HANDLE EXCEPTIONS FOR GETTING ANY POSITIVE INTEGER 0 AND GREATER
     * @return int NUMBER 0 OR GREATER
     */
    public static int GetInt_Positive() { //STATIC METHOD CANNOT TEST
        int res = POSITIVE_INT_INITIALIZER;
        while (res == POSITIVE_INT_INITIALIZER) {
            try {
                System.out.print("=>_");
                res = keyboard.nextInt();
                if ( res < 0 ) {
                    System.out.println("Must be a positive Number.  Please Try again.");
                }
            } catch (Exception e){
                System.out.println("That was an invalid response. Please Try again.");
                res=POSITIVE_INT_INITIALIZER;
                keyboard.nextLine();
            }
        }

        return res;
    }

}
