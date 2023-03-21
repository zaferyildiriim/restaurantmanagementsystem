package restaurantmanagementsystem;

import java.util.ArrayList;

public class Menu
{
    private  String Type;
    private  String name;
    private  double salecost;
    public Menu(String type, String name, double salecost)
    {
        Type = type;
        this.name = name;
        this.salecost = salecost;
    }

    public String getType()
    {
        return Type;
    }

    public void setType(String type)
    {
        Type = type;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getSalecost()
    {
        return salecost;
    }

    public void setSalecost(double salecost)
    {
        this.salecost = salecost;
    }
    public void AllMenu(ArrayList<Menu> A)
    {
        System.out.println("Drinks");
        printMenu(A,"Drinks");
        System.out.println("Deserts");
        printMenu(A,"Deserts");
        System.out.println("Main Course");
        printMenu(A,"Main Course");

    }
    public void printMenu(ArrayList<Menu> A, String type)
    {
        if(A.size()<1)
        {
            System.out.println("Menü Boþ");
        }
        else
        {
            for (int i = 0; i <A.size() ; i++)
            {
                if(A.get(i).getType().equals(type))
                {
                    System.out.println("Name: "+A.get(i).getName()+" Type :"+A.get(i).getType()+" Salecost :"+A.get(i).getSalecost());
                }
            }
        }

    }
}
