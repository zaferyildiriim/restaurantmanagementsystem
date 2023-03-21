package restaurantmanagementsystem;
public class Products
{
    //Resim eklesek iyi olur yeğenimmmm
    private String name;
    private double cost;
    private int stock;

    public Products(String name, double cost, int stock)
    {
        this.name = name;
        this.cost = cost;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
