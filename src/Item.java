////////////////////////////////////////////////////////////////////////////////
//Creation Date: 2017-02-22
//Created By: Austin Formagin
//Items class, this is the generic items class and all items will stem from here and be
//a child of this class
//Updated Date: 2017-02-22
////////////////////////////////////////////////////////////////////////////////
public class Item {
    //Attributes of items
    String itemType;//Type of item it is, item types will be defined in the readMe file
    boolean isWeapon;//Determines if the item is a weapon
    String itemName;//The item's name
    int itemWeight;//The item's weight in the user's inventory
    int itemSize;//The item's physical size

    public Item() {

    }
    public Item(String itemType, boolean isWeapon, String itemName, int itemWeight, int itemSize)
    {
        this.itemName = itemName;
        this.itemSize = itemSize;
        this.itemType = itemType;
        this.isWeapon = isWeapon;
        this.itemWeight = itemWeight;

    }
}
