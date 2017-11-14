package org.b2m.lostandfound;

import java.util.Date;

public class Item {
    private String  itemName;
    private Date    itemFindDate;
    private Date    itemReceiveDate;
    private String  itemCityCode;
    private String  itemFindPlace;

    public Item() {
    }

    public Item(String itemName, Date itemFindDate, Date itemReceiveDate, String itemCityCode, String itemFindPlace) {
        this.itemName = itemName;
        this.itemFindDate = itemFindDate;
        this.itemReceiveDate = itemReceiveDate;
        this.itemCityCode = itemCityCode;
        this.itemFindPlace = itemFindPlace;
    }

    public String getItemName() {
        return itemName;
    }

    public Date getItemFindDate() {
        return itemFindDate;
    }

    public Date getItemReceiveDate() {
        return itemReceiveDate;
    }

    public String getItemCityCode() {
        return itemCityCode;
    }

    public String getItemFindPlace() {
        return itemFindPlace;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemFindDate=" + itemFindDate +
                ", itemReceiveDate=" + itemReceiveDate +
                ", itemCityCode='" + itemCityCode + '\'' +
                ", itemFindPlace='" + itemFindPlace + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (!itemName.equals(item.itemName)) return false;
        if (!itemFindDate.equals(item.itemFindDate)) return false;
        if (!itemReceiveDate.equals(item.itemReceiveDate)) return false;
        if (!itemCityCode.equals(item.itemCityCode)) return false;
        return itemFindPlace.equals(item.itemFindPlace);
    }

    @Override
    public int hashCode() {
        int result = itemName.hashCode();
        result = 31 * result + itemFindDate.hashCode();
        result = 31 * result + itemReceiveDate.hashCode();
        result = 31 * result + itemCityCode.hashCode();
        result = 31 * result + itemFindPlace.hashCode();
        return result;
    }
}
