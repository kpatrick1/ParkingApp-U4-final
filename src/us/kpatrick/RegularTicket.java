package us.kpatrick;
/**
 * This is a class for Regular Tickets which extends Tickets
 *
 * @author kpatr
 * @version 1.0.0
 */
public class RegularTicket extends Tickets {

    /**
     * Create the Regular Ticket Object
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
        double fee = Main.REGULAR_BASE_PARKING_FEE;
        double maxMins = (Main.REGULAR_MINS_PER_HOUR * Main.REGULAR_HOURS_GOOD_FOR);
        long minutes = CustomDate.minuteDifference1(this.checkIn, this.checkOut);
        if (minutes > maxMins) {
            long additional = 0;
            additional = (long) (Math.ceil((double)(minutes - maxMins) / Main.REGULAR_MINS_PER_HOUR));

            fee += additional;
        }
        if (fee > Main.REGULAR_MAX_PARKING_FEE ) {
            fee = Main.REGULAR_MAX_PARKING_FEE;
        }

        return fee;
    }
    /**
     * Get the total of all these types of Tickets
     * @return double - total of all tickets
     */
    @Override
    public double TicketTotal() {
        double total = 0;
        for (Tickets t : Main.tickets) {
            if ( t instanceof RegularTicket) {
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
            if ( t instanceof  RegularTicket) {
                count++;
            }
        }
        return count;
    }
}
