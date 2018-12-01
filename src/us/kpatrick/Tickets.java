package us.kpatrick;

import java.util.ArrayList;

/**
 * This is an Abstract Ticket Class
 * @author kpatr
 * @version 1.0.0
 */
public abstract class Tickets {

    private final static FileInput indata = new FileInput("parking.csv");
    public int ID;
    public String checkIn;
    public String checkOut;
    public boolean lostTicket;
    public boolean specialEvent;
    public int hrs;

    /**
     * Abstract Method to be implemented by different Ticket Types
     * @param ID Id of the Ticket
     * @param d1 Check in Time
     * @param d2 Check out Time
     * @param lost Indicator if ticket was lost
     * @param specialEvent Indicator if ticket was a special Event Ticket
     */
    public abstract void LoadTicketFromFile(int ID, String d1, String d2, Boolean lost, Boolean specialEvent);

    /**
     * Find a specific Ticket
     * @param ID the ticket to find
     * @return Tickets - The ticket with that ID
     */
    public static Tickets FindTicket (int ID) {
        for (Tickets t : Main.tickets) {

            if (t.ID == ID) {
                return t;
            }
        }
        return null;
    }

    /**
     * Load the tickets into an array
     * @return ArrayList of Tickets regardless of type
     */
    public static ArrayList<Tickets> GetTickets() {
        ArrayList<Tickets> tickets = new ArrayList();

        String line;
        String[] fields;
        TicketFactory t = new TicketFactory();
        Tickets ticketObject;
        while ((line = indata.fileReadLine()) != null) {
            fields = line.split(",");
            int ID = Integer.parseInt(fields[0]);
            String d1 = fields[1];
            String d2 = fields[2];
            Boolean lost = Boolean.parseBoolean(fields[3]);
            Boolean specialEvent = Boolean.parseBoolean(fields[4]);

            if (lost) {
                ticketObject = t.getTicket(TicketType.LOST);
            } else if (specialEvent) {
                ticketObject = t.getTicket(TicketType.SPECIAL_EVENT);
            } else {
                ticketObject = t.getTicket(TicketType.REGULAR);
            }
            ticketObject.LoadTicketFromFile(ID,d1,d2,lost,specialEvent);
            tickets.add(ticketObject);
            //tickets.add(new Tickets(ID, d1, d2, lost, specialEvent));
        }
        indata.fileClose();
        return tickets;
    }

    /**
     * Create and Return a new Ticket ID
     * @return Number of the New Ticket
     */
    public int CreateNewTicket() {
        int ticketNum = this.LastTicketNum()+1;
        String checkInTime = CustomTime.MorningTime();
        this.ID = ticketNum;
        this.checkIn = checkInTime;
        this.checkOut = "null";
        Main.tickets.add(this);
        //Main.tickets.add(new Tickets(ticketNum, LocalDateTime.now().toString(),null,false));
        return ticketNum;
    }

    /**
     * Get the last Number of the ticket that was created
     * @return int of the last ticket
     */
    private int LastTicketNum() {
        int ticketNum = 0;

        for (Tickets t : Main.tickets){
            if (t.ID > ticketNum) {
                ticketNum = (t.ID);
            }
        }

        return ticketNum;
    }

    /**
     * Set the checkout time of the ticket and return the amount owed
     * @return double - the amount owed
     */
    public double CloseTicket() {
        double balanceOwed = 0;
        this.checkOut = CustomTime.EveningTime();
        long minutes = CustomDate.minuteDifference1(this.checkIn, this.checkOut);
        //balanceOwed = CalculateFee(minutes, this.lostTicket);
        balanceOwed = CalculateFee();
        for (Tickets t : Main.tickets) {
            if (t.ID == ID){
                t.checkOut = CustomTime.EveningTime();
                break;
            }
        }
        hrs = (int) Math.ceil((double)minutes/60);
        return balanceOwed;
    }

    /**
     * Calculate the Fee to be down at the Ticket Type Level
     * @return double - the amount owed
     */
    public abstract double CalculateFee();

    /**
     * Write the tickets from the array to the csv file
     */

    public static void SaveTickets() {
        FileOutput outData = new FileOutput("parking.csv");
        for (Tickets t : Main.tickets) {
            outData.fileWrite(t.ID + "," + t.checkIn + "," + t.checkOut + "," + t.lostTicket + "," + t.specialEvent);
        }
        outData.fileClose();


    }

    /**
     * Calculate the Total Tickets at the type level
     * @return double amount of all tickets of this type
     */
    public abstract double TicketTotal();

    /**
     * Calculate the count of tickets at the type level
     * @return double count all tickets of this type
     */
    public abstract double TicketCount();



}
