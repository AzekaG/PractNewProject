package itstep.learning.oop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Shop {

    public List<Product> products;

    public Shop()
    {
        products = new ArrayList<Product>();
        products.add(new Lamp("Philips" , 300.52));
        products.add(new Accumulator("Baseus" , 300000));
        products.add(new Pump("Daison" , 600));
    }




    public void run(){
        printProducts();

        System.out.println("---------------------MANUAL-----------------------------");
        printNonManualProducts();
        System.out.println("-------------------NON--MANUAL-----------------------------");
        printNonManualProducts();
        System.out.println("-------------------ВОРКС-----------------------------");
        showWorks();
        System.out.println("------------------warranty-__----------------------------");
        showWarranty();


    }

    private void printNonManualProducts()
    {
        for(Product product : products)
        {
            if(product instanceof Manual)
            {
                System.out.println(product.getCard());
            }
        }
    }

    private void printTestableProducts()
    {
        for(Product product : products)
        {
            if(product instanceof Testable)
            {
                ((Testable) product).test();
            }
        }
    }

    private void printProducts()
    {
        for(Product product : products)
            System.out.println(product.getCard());
    }

    private void showWorks()
    {
        for(Product product : products)
        {
            for(Method method : product.getClass().getDeclaredMethods())
            {
                if(method.isAnnotationPresent(Works.class))
                {
                    System.out.println(method.getAnnotation(Works.class).value() + "  ");

                    method.setAccessible(true);

                    try{
                        method.invoke(product);
                    }
                    catch (IllegalAccessException | InvocationTargetException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }


    private void showWarranty()
    {
        for(Product product : products)
        {
            for(Method method : product.getClass().getDeclaredMethods())
            {
                if(method.isAnnotationPresent(warranty.class))
                {
                    System.out.println(method.getAnnotation(warranty.class).value() + "  ");
                    method.setAccessible(true);

                    try{
                        method.invoke(product);
                    }
                    catch (IllegalAccessException | InvocationTargetException e )
                    {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }

    }





}
