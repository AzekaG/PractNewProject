package itstep.learning.oop;

public class Accumulator extends Product{
    private double capacity;
    int warranty = 1;

    public Accumulator(String manufacturer, double capacity)
    {
        super.setManufacturer(manufacturer);
        setCapacity(capacity);
    }

    public double getCapacity()
    {
        return capacity;
    }

    public void setCapacity(double capacity)
    {
        this.capacity = capacity;
    }

    @Override
    public String getCard()
    {
        return String.format(
                "Accumulator: '%s' , capacity: %.1f  A",
                super.getManufacturer(), this.getCapacity()
        );
    }

    @Works
    public void accumulate()
    {
        System.out.println("Working on : " + getCard());
    }

    @warranty
    public void Warranty()
    {
        System.out.println("of acum : " + warranty + "years");
    }



}
