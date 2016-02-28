package singleton.q1;

public class TicketMaker {
    public static TicketMaker singleton = new TicketMaker();

    private int ticket = 1000;

    private TicketMaker() {
        // nop
    }

    public static TicketMaker getInstance() {
        return singleton;
    }

    public int getNextTicketNumber() {
        return ticket++;
    }
}