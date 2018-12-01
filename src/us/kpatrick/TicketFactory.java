package us.kpatrick;

/**
 * This Factory returns the unique Ticket Types
 *
 * @author kpatr
 * @version 1.0.0
 */
public class TicketFactory {

    /**
     * Returns a Ticket Type
     * @param t Ticket Type
     * @return Tickets object
     */
    public Tickets getTicket (TicketType t){
        if (t == TicketType.REGULAR) {
            return new RegularTicket();
        } else if (t == TicketType.SPECIAL_EVENT) {
            return new SpecialEventTicket();
        } else if (t == TicketType.LOST) {
            return new LostTicket();
        };
        return null;
    }


}
