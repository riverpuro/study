package singleton.q1;

public class Main {
    public static void main(String... args) {
        TicketMaker ticketMaker = TicketMaker.getInstance();

        System.out.println(ticketMaker.getNextTicketNumber());
        System.out.println(ticketMaker.getNextTicketNumber());
        System.out.println(ticketMaker.getNextTicketNumber());

        ticketMaker = TicketMaker.getInstance();
        System.out.println(ticketMaker.getNextTicketNumber());
        System.out.println(ticketMaker.getNextTicketNumber());
    }
}
