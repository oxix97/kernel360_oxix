package theater.before;

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Bag getBag() {
        return bag;
    }

    public Long buy(Ticket ticket) {
        if (bag.hasInvitation()) {
            bag.setTicket(ticket);
            return 0L;
        }
        Long fee = ticket.getFee();
        bag.minusAmount(fee);
        bag.setTicket(ticket);
        return fee;
    }
}
