package itstep.learning.oop;

public class Pump extends Product implements Manual {

    int productivity;
    int warranty = 2;


    public Pump(String manufacturer, int productivity) {
        setProductivity(productivity);
        super.setManufacturer(manufacturer);
    }

    public void setProductivity(int productivity) {
        this.productivity = productivity;
    }

    public int getProductivity() {
        return productivity;
    }


    @Override
    public String getCard()
    {
        return String.format(
                "Pump : '%s , Productivity : $d l/h",
                super.getManufacturer(), this.getProductivity()
        );
    }

    @Works("as pump ")
    public void pump()
    {
        System.out.println("Working on : " + getCard());
    }

    @warranty("warranty")
    public void Warranty()
    {
        System.out.println("of pump " + warranty + " years");
    }



}
