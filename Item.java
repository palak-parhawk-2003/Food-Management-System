package food;
public class Item {
    String name;
    int id, stock;
    double price;
    public Item()
    {

    }
    public int addStock(int stock)
    {
        int k;
        k=this.stock+stock;
        if(k>=0){
            this.stock+=stock;
            return this.stock;
        }
        else{
            return -1;
        }
    }
    public Item(String name,int id,double price, int stock)
    {
        this.name = name;
        this.id = id;
        this.price = price;
        this.stock=stock;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }
    public double getPrice()
    {
        return this.price;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return this.id;
    }
    public void setStock(int stock)
    {
        this.stock = stock;
    }
    public int getStock()
    {
        return this.stock;
    }
}