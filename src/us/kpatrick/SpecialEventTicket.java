package us.kpatrick;
/**
 * This is a class for Special Event Tickets which extends Tickets
 *
 * @author kpatr
 * @version 1.0.0
 */
public class SpecialEventTicket extends Tickets{
    /**
     * Create the Special Event Object
     * @param ID Id of the Ticket
     * @param d1 Check in Time
     * @param d2 Check out Time
     * @param lost Indicator if ticket was lost
     * @param specialEvent Indicator if ticket was a special Event Ticket
     */
    @Override
    public void LoadTicketFromFile(int ID, String d1, String d2, Boolean lost, Boolean specialEvent) {
        this.ID = ID;
        this.checkIn = d1;
        this.checkOut = d2;
        this.lostTicket = lost;
        this.specialEvent = specialEvent;
    }
    /**
     * Calculate the fee
     * @return double - the fee owed
     */
    @Override
    public double CalculateFee() {
        return Main.SPECIAL_EVENT_FEE;
    }
    /**
     * Get the total of all these types of Tickets
     * @return double - total of all tickets
     */
    @Override
    public double TicketTotal() {
        double total = 0;
        for (Tickets t : Main.tickets) {
            if ( t instanceof SpecialEventTicket) {
                total += t.CalculateFee();
            }
        }
        return total;
    }
    /**
     * Get the count of all the tickets
     * @return double count of all the tickets
     */
    @Override
    public double TicketCount() {
        int count = 0;
        for (Tickets t : Main.tickets) {
            if ( t instanceof  SpecialEventTicket) {
                count++;
            }
        }
        return count;
    }
}
