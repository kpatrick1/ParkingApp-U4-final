package us.kpatrick;
import java.text.NumberFormat;

/***
 * This is an abstract Machine class that creates either a CheckIn or CheckOut Machine and provides methods
 *
 * @author kpatr
 * @version 1.0.0
 */
public abstract class Machine {

    /**
     * This method returns the ticket type that was chosen based on the available options.
     * @return Tickets type the user wanted
     */
    public abstract Tickets displayOptions();

    /**
     * This method will either checkIn or checkOut a vehicle based on the Ticket type
     * @param t  the ticket provided
     */
    public abstract void CheckVehicle(Tickets t);

    /***
     * This methods sets the machine type to either checkin or checkout
     * @return Machine - the type of machine the user wants to utilize
     */
    public static Machine SetMachineType() {
        int ans = 0;
        System.out.println("BEST VALUE PARKING GARAGE");
        System.out.println("=========================");
        System.out.println("1 - Check In Machine");
        System.out.println("3 - Check Out Machine");

        while (ans != 1 && ans != 3) {
            ans = ReadUserInput.GetInt_Positive();
            if (ans != 1 && ans !=3) {
                System.out.println("That was an invalid number.  Please Try again.");
            }
        }

        if (ans == 1) {
            return CheckIn.getInstance();
            //return new CheckIn();
        } else {
            return CheckOut.getInstance();
            //return new CheckOut();
        }


    }

    /**
     * This method closes down the garage and calculates earnings
     */
    public void CloseGarage() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        double totalTickets = 0;
        System.out.println("BEST VALUE PARKING GARAGE");
        System.out.println("=========================");
        System.out.println("Activity To Date");
        System.out.println("");

        TicketFactory factory = new TicketFactory();
        for (TicketType t : TicketType.values()) {
            Tickets ticket = factory.getTicket(t);
            if (ticket != null) {
                double TypeTotal = ticket.TicketTotal();
                double TypeCount = ticket.TicketCount();
                System.out.println(formatter.format(TypeTotal) + " Collected from " + TypeCount + " " + t.name() + " Tickets.");
                totalTickets += TypeTotal;
            }
        }

        System.out.println("");
        System.out.println(formatter.format(totalTickets) + " was collected overall!");

    }

}
