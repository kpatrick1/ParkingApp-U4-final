package us.kpatrick;

/**
 *  This is the checkin Machine used to check vehicles into the garage
 *
 * @author kpatr
 * @version 1.0.0
 */
public class CheckIn extends Machine {
    private static CheckIn obj;

    /**
     *This is the private constructor - Singleton is enforced here
     */
    private CheckIn(){}

    /**
     * This is part of the singleton to load the existing or new instance of Checkin Object
     * @return CheckIn - the current instance
     */
    public static CheckIn getInstance(){ //CONSTRUCTOR DOES NOT GET UNIT TESTED
        if (obj ==null) {
            obj = new CheckIn();
        }
        return obj;
    }

    /**
     * This will display the checkin options the user can choose from
     * @return Tickets - Based on the user choice
     */
    @Override
    public Tickets displayOptions() { //REQUIRES USER INPUT - CANNOT UNIT TEST
        int ans = 0;
        System.out.println("BEST VALUE PARKING GARAGE");
        System.out.println("=========================");
        System.out.println("1 - Check In");
        System.out.println("2 - Special Event");
        System.out.println("3 - Close Garage");
        while (ans != 1 && ans != 3 && ans != 2) {
            ans = ReadUserInput.GetInt_Positive();
            if (ans != 1 && ans !=3 && ans != 2) {
                System.out.println("That was an invalid number.  Please Try again.");
            }
        }

        TicketFactory t = new TicketFactory();
        if (ans == 1) {
            return t.getTicket(TicketType.REGULAR);
        } else if (ans==2) {
            return t.getTicket(TicketType.SPECIAL_EVENT);
        }else{
            return t.getTicket(TicketType.CLOSE_GARAGE);
        }
    }

    /**
     * This method checks the vehicle in and provides a new ticket ID
     * @param t  the ticket provided
     */
    public void CheckVehicle(Tickets t) { //VOID METHODS DO NOT GET UNIT TESTED
        int ticketNum = t.CreateNewTicket();
        //Tickets ticket = new Tickets();
        //int ticketNum = ticket.CreateNewTicket();
        System.out.println("Your vehicle has been checked In with ID: " + ticketNum);

    }



}
