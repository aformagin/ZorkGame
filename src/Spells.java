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

    public Spells() 
    {
        this.spellType = "DIRECT";
        this.damage = SpellDamage(1,6);//Assigns base spell a damage of d6
    }
    //Where the client or another class/method will put the information required to create the spell
    public Spells(int damage, boolean learned, int manaRequired, int mana, String spellType)
    {

    }
    //Randomly assigns spell damage
    public int SpellDamage(int lowDMG, int highDMG)
    {
       Math.round(Math.random(highDMG-lowDMG+1)+lowDMG));
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
