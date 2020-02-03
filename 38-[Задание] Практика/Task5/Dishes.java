package hw38;

public class Dishes {
    private boolean isPaid;
    private double price;

    public Dishes(boolean isPaid, double price) {
        this.isPaid = isPaid;
        if(!isPaid) this.price = 0;
        else this.price = price;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
