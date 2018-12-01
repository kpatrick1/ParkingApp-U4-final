package us.kpatrick;
import java.text.NumberFormat;
import java.time.LocalDateTime;

/**
 *  This is the checkout Machine used to check vehicles out of garage
 *
 * @author kpatr
 * @version 1.0.0
 */
public class CheckOut extends Machine {
    private static CheckOut obj;
    /**
     *This is the private constructor - Singleton is enforced here
     */
    private CheckOut(){}
    /**
     * This is part of the singleton to load the existing or new instance of Checkout Object
     * @return CheckOut - the current instance
     */
    public static CheckOut getInstance(){ //CONSTRUCTOR CANNOT UNIT TEST
        if (obj == null)
            obj = new CheckOut();
        return obj;
    }


    @Override
    public Tickets displayOptions() { //REQUIRES USER INPUT CANNOT UNIT TEST
        int ans = 0;
        System.out.println("BEST VALUE PARKING GARAGE");
        System.out.println("=========================");
        System.out.println("1 - Check Out");
        System.out.println("3 - Lost Ticket");
        while (ans != 1 && ans != 3) {
            ans = ReadUserInput.GetInt_Positive();
            if (ans != 1 && ans !=3) {
                System.out.println("That was an invalid number.  Please Try again.");
            }
        }

        TicketFactory t = new TicketFactory();
        if (ans == 1) {
            return t.getTicket(TicketType.REGULAR);
            //return CheckoutOptions.CHECK_OUT;
        } else {
            return t.getTicket(TicketType.LOST);
            //return CheckoutOptions.LOST_TICKET;
        }
    }

    public void CheckVehicle(Tickets t) { //VOID METHODS DO NOT GET UNIT TESTED
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        int ans = 0;
        while (ans == 0 ) {
            System.out.println("Please Enter your Ticket Number");
            ans = ReadUserInput.GetInt_Positive();
        }
        //FIND EXISTING TICKET
        t = Tickets.FindTicket(ans);
        //Tickets ti = new Tickets(ans);
        double balance = t.CloseTicket();
        System.out.println("BEST VALUE PARKING GARAGE");
        System.out.println("=========================");
        System.out.println("Receipt for a vehicle ID " + t.ID);
        System.out.println("");
        System.out.println(t.hrs + " hours Parked: " + LocalDateTime.parse( t.checkIn).toLocalTime() + " - " + LocalDateTime.parse(t.checkOut).toLocalTime() );
        System.out.println(formatter.format(balance));

    }
}
