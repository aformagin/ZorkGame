////////////////////////////////////////////////////////////////////////////////
//Creation Date: 2017-02-22
//Created By: Austin Formagin
//Spells class, this is the generic spell class and all spells that are added will be
//a child of this class
//Updated Date: 2017-02-22
////////////////////////////////////////////////////////////////////////////////
public class Spells {

    String spellType;//The type of spell it is, damage, healing, etc. Types will be defined me in the readMe
    int damage;//The amount of damage it will do, or will determine if it heals
    boolean learned;//Determines if the user has the spell learned
    int manaRequired;//The amount of 'mana' required to use this spell
    int mana;//User's total mana, will go into character generation at somepoinr

    public Spells() {

    }
//Where the client or another class/method will put the information required to create the spell
    public Spells(int damage, boolean learned, int manaRequired, int mana, String spellType)
    {

    }
  
 /*Accessors/Mutators for spell stats
  public int getDamage()
  {
    return this.damage;
  }
  public void setDamage(int damage)
  {
    
  }
  */
}
