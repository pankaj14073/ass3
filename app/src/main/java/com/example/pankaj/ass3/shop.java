package com.example.pankaj.ass3;

/**
 * Created by pankaj on 2/10/16.
 */
public class shop {
    private int id;
    private String name;
    private String address;
    private String owner;
    public shop()
    {}
    public shop(int id,String name,String owner,String address)
    {
        this.id=id;
        this.name=name;
        this.owner=owner;
        this.address=address;
    }
    public shop(String name,String owner,String address)
    {
        this.name=name;
        this.owner=owner;
        this.address=address;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public int getId() {
        return id;
    }
    public String getAddress() {
        return address;
    }
    public String getName() {
        return name;
    }
    public String getOwner() {
        return owner;
    }

}