package us.kpatrick;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner k = new Scanner(System.in);
    public static ArrayList<Tickets> tickets = new ArrayList<>();
    public final static double LOST_TICKET_FEE = 25;
    public final static double SPECIAL_EVENT_FEE = 20;
    public final static double REGULAR_BASE_PARKING_FEE = 5;
    public final static double REGULAR_MINS_PER_HOUR = 60;
    public final static double REGULAR_HOURS_GOOD_FOR = 3;
    public final static double REGULAR_MAX_PARKING_FEE = 15;

    public static void main(String[] args) {

        tickets = Tickets.GetTickets();
        Tickets t;
        boolean closeApp = false;
        Machine machine = null;
        while (!closeApp) {
            machine = Machine.SetMachineType();
            t = machine.displayOptions();
            if (t != null) {
                machine.CheckVehicle(t);
            } else {
                closeApp = true;
            }
        }
        machine.CloseGarage();
        Tickets.SaveTickets();
    }
}
