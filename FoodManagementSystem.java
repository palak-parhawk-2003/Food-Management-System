package food;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
/**
 * BluePrint
 */
interface BluePrint {
    void newItem();
    void getAllItem();
    void searchItem(int id);
    void searchItem(String nameReg);
    void buyItem(int id, int stock);
    void addStock(int id, int stock);
}
public class FoodManagementSystem implements BluePrint{
    static List<Item> itemlist;
    @Override
    public void newItem()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Name: ");
        String name = in.nextLine();
        System.out.print("Price: ");
        double price = in.nextDouble();
        System.out.print("Stock: ");
        int stock = in.nextInt();
        System.out.print("item id: ");
        int id = in.nextInt();
        Item obj = new Item(name,id,price,stock);
        itemlist.add(obj);
    }
    @Override
    public void addStock(int id, int Stock)
    {
        int flag=0;
        Iterator<Item> items= itemlist.iterator();
        Item abcItem=new Item();
        while(items.hasNext()){
            abcItem = items.next();
            if(abcItem.getId()==id){
                flag=1;
                break;
            }
        }
        if(flag==0){
            System.out.println("No such item present");
        }
        else{
            abcItem.addStock(Stock);
            System.out.println("After adding stock");
            System.out.println(abcItem.getName()+"-------"+abcItem.getId()+"-------"+abcItem.getPrice()+"-------"+abcItem.getStock());
        }
    }
    @Override
    public void buyItem(int id, int stock)
    {
        int flag=0;
        Iterator<Item> items= itemlist.iterator();
        Item abcItem=new Item();
        while(items.hasNext()){
            abcItem = items.next();
            if(abcItem.getId()==id){
                flag=1;
                break;
            }
        }
        if(flag==0){
            System.out.println("No such item present");
        }
        else{
            int k=abcItem.addStock((-1)*stock);
            if(k>=0){
                System.out.println("Purchase successful");
                System.out.println(abcItem.getName()+"-------"+abcItem.getId()+"-------"+abcItem.getPrice()+"-------"+abcItem.getStock());
            }
            else{
                System.out.println("Sorry we are out of stock!!");
            }
        }
    }
    @Override
    public void searchItem(int id)
    {
        int flag=0;
        Iterator<Item> items= itemlist.iterator();
        while(items.hasNext()){
            Item abcItem = items.next();
            if(abcItem.getId()==id){
                flag=1;
                System.out.println(abcItem.getName()+"-------"+abcItem.getId()+"-------"+abcItem.getPrice()+"-------"+abcItem.getStock());
            }
        }
        if(flag==0){
            System.out.println("No such item present");
        }
    }
    @Override
    public void searchItem(String nameReg)
    {
        int flag=0;
        Iterator<Item> items= itemlist.iterator();
        while(items.hasNext())
        {
            Item abcItem = items.next();
            if(abcItem.getName().contains(nameReg))
            {
                flag=1;
                System.out.println(abcItem.getName()+"-------"+abcItem.getId()+"-------"+abcItem.getPrice()+"-------"+abcItem.getStock());
            }
        }
        if(flag==0)
        {
            System.out.println("No such item present");
        }
    }
    @Override
    public void getAllItem()
    {
        Iterator<Item> items= itemlist.iterator();
        while(items.hasNext())
        {
            Item abcItem = items.next();
            System.out.println(abcItem.getName()+"-------"+abcItem.getId()+"-------"+abcItem.getPrice()+"-------"+abcItem.getStock());
        }
    }
    static int ch = 0;
    public static void main(String[] args) {
        itemlist = new ArrayList<>();
        FoodManagementSystem obj = new FoodManagementSystem();
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Enter your option: 1) new item 2) all items 3) Search item by id 4) Search item by name 5) Add Stock 6) Buy Item 7) exit");
            ch = in.nextInt();
            if (ch == 1) {
                obj.newItem();
            } else if(ch == 2){
                obj.getAllItem();
            }
            else if(ch == 3)
            {
                System.out.println("Enter the item id");
                int id = in.nextInt();
                obj.searchItem(id);

            }
            else if(ch == 4)
            {
                System.out.println("Enter the Name pattern");
                String name = in.next();
                obj.searchItem(name);
            }
            else if(ch==5)
            {
                System.out.println("Enter id");
                int id=in.nextInt();
                System.out.println("Enter Stock");
                int stock=in.nextInt();
                obj.addStock(id, stock);
            }
            else if(ch==6)
            {
                System.out.println("Enter id");
                int id=in.nextInt();
                System.out.println("Enter quantity");
                int stock=in.nextInt();
                obj.buyItem(id, stock);
            }
        }
        while (ch!=7);
    }
}