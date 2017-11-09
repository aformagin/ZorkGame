//////////////////////////////
//
//////////////////////////////
public class Character
{
    private int str;
    private int con;
    private int intel;
    private int dex;
    private int armor;
    private int hp;

    public Character (){
        this.str = 10;
        this.con = 10;
        this.intel = 10;
        this.dex = 10;
        this.armor = 0;
        this.hp = this.con * 2;
    }

    // --------- //
    // accessors //
    // --------- //

    public int getStr (){
        return this.str;
    }

    public int getCon (){
        return this.con;
    }

    public int getIntel (){
        return this.intel;
    }

    public int getDex (){
        return this.dex;
    }

    public int getArmor (){
        return this.armor;
    }

    public int getHp (){
        return this.hp;
    }

    // -------- //
    // mutators //
    // -------- //

    public void setStr (int s){
        this.str = s;
    }

    public void setCon (int c){
        this.con = c;
    }

    public void setIntel (int i){
        this.intel = i;
    }

    public void setDex (int d){
        this.dex = d;
    }

    public void setArmor (int a){
        this.armor = a;
    }

    public void setHp (int h){
        this.hp = h;
    }

    // ---------- //
    // behavioral //
    // ---------- //

    public void donArmor(int equip){
    if (equip == 1){
        setArmor(5);
    }
    }
}//End of Character Class
