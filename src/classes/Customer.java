package classes;
public class Customer
{
    private int ID;
    private String Name;
    private String Address;
    private String City;
    private String State;
    private String ZipCode;

    public Customer()
    {

    }
    public void setCustomerID(int id)
    {
        this.ID=id;
    }
    public void setName(String name)
    {
        this.Name=name;
    }
    public void setAddress(String address)
    {
        this.Address=address;
    }
    public void setCity(String city)
    {
        this.City=city;
    }
    public void setState(String state)
    {
        this.State=state;
    }
    public void setZipCode(String zipCode)
    {
        this.ZipCode=zipCode;
    }
    public int getID()
    {
        return this.ID;
    }
    public String getName()
    {
        return this.Name;
    }
    public String getAddress()
    {
        return this.Address;
    }
    public String getCity()
    {
        return this.City;
    }
    public String getState()
    {
        return this.State;
    }
    public String getZip()
    {
        return this.ZipCode;
    }

}