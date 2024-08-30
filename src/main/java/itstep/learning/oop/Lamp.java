package itstep.learning.oop;

import java.util.Locale;

public class Lamp extends Product implements Testable {

    private double power;

    public Lamp(String manufacturer , double power)
    {
        super.setManufacturer(manufacturer);
        setPower(power);
    }

    public double getPower()
    {
        return power;
    }

    public void setPower(double power)
    {
        this.power = power;
    }
    public void setManufacturer(String manufacturer)
    {

    }

    @Override
    public String getCard() {
        return  String.format(
                Locale.ROOT,
                "Lamp: '%s', Power: %.1f W" ,
                super.getManufacturer() ,
                this.getPower());
    }

    @Override
    public void test(){
        System.out.println("Testing Lamp"  + getCard());
    }

}
