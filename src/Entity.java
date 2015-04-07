import java.awt.Color;

/**
 * Entity.java
 *
 * Used to be an Interface (by Elijah Hursey),
 * now a Superclass.
 *
 * @author Wilton Latham
 * @author Elijah Hursey
 * @version 1.0
 */
public abstract class Entity
{
    public static final double EXP_CAP = 0.936;
    public static final int LVL_CAP = 10;

    private String name;
    private int health;
    private int mana;
    private double exp;
    private double ad;
    private double ap;
    private double mr;
    private Color color;
    private int level;

    public Entity()
    {
        this.name = "???";
        setLevel(1);
        setHealth(getMaxHealth());
        setMana(getMaxMana());
    }
    
    public Entity(String name, int level)
    {
        this.name = name;
        setLevel(level);
        setHealth(getMaxHealth());
        setMana(getMaxMana());
    }

    public void increaseExp()
    {
        if ((getExp() == 0.0) || getExp() % EXP_CAP != getExp())
        {
            setExp(getExp() + expByLevel(getLevel()));
        }
        else
        {
            setLevel(getLevel() + 1);
        }
    }

    // a rather lethargic 'Surge Function'
    public double getExpByLevel(double level)
    {
        return ((2 * level) / Math.pow(Math.E, level)) + 0.2;
    }

    public int getExpPoints()
    {
        return (int) Math.round(1000 * getExp());
    }
    
    public int getMaxHealth()
    {
        return (int) Math.round(1000 * expByLevel(11 - getLevel()));
    }
    
    public int getMaxMana()
    {
        return (int) Math.round(100 * expPerLevel(11 - getLevel()));
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {   
        if (level > LVL_CAP)
        {
            this.level = LVL_CAP;
        }
        else if (level == 0)
        {  
            this.level = 1;
        }
        else
        {
            this.level = level;
        }
    }
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(double health)
    {
        this.health = (int) Math.round(health);
    }

    public int getMana()
    {
        return mana;
    }

    public void setMana(int mana)
    {
        this.mana = mana;
    }

    public double getExp()
    {
        return exp;
    }
    
    public void setExp(double exp)
    {
        this.exp = exp;
    }

    public double getAd()
    {
        return ad;
    }

    public void setAd(double ad)
    {
        this.ad = ad;
    }

    public double getAp()
    {
        return ap;
    }

    public void setAp(double ap)
    {
        this.ap = ap;
    }

    public double getMr()
    {
        return mr;
    }

    public void setMr(double mr)
    {
        this.mr = mr;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }
}
