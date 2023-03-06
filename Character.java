package Unit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public abstract class Character implements GameInterface {
    protected String name;
    protected int hp, maxHp;
    protected int attack;
    protected int speed;
    protected int defence;
    protected int damageMax, damageMin;
    protected Vector2D pos;
    protected String state;
    public int getHp() {
        return hp;
    }

    protected Character(String name, int maxHp, int attack, int speed, int defence, int damageMin, int damageMax, int posX, int posY) {
        this.name = name;
        this.speed = speed;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attack = attack;
        this.defence = defence;
        this.damageMax = damageMax;
        this.damageMin = damageMin;
        pos = new Vector2D(posX, posY);
        state = "ready";

    }

    public static String getName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length-1)]);
    }

    @Override
    public String toString() {
        return name +
                " H:" + Math.round(hp) +
                " D:" + defence +
                " A:" + attack +
                " Dmg:" + Math.round(Math.abs((damageMin+damageMax)/2)) +
                " " + state;
    }
    @Override
    public String getInfo() {
        return "Я человек!";
    }
    @Override
    public void step(ArrayList<Character> teamList1, ArrayList<Character> teamList2) {

    }
    public int[] getPos() {return new int[]{pos.posX, pos.posY};}
    public int findNearest(ArrayList<Character> team) {
        double min = 100;
        int index = 0;
        for (int i = 0; i < team.size(); i++) {
            if (min > pos.getDistance(team.get(i).pos) & !team.get(i).state.equals("dead")) {
                index = i;
                min = pos.getDistance(team.get(i).pos);
            }
        }
        return index;
    }
    protected void getDamage(float damage) {
        hp -= damage;
        if (hp > maxHp) hp = maxHp;
        if (hp < 0) {
            System.out.println(name + " " + getInfo() + " " + "убит");
            state = "dead";
        }
    }
    public int getSpeed() {
        return speed;
    }

    static final int CHARACTERS = 10;

    public static void createTeam(ArrayList team, int offset, int posY) {

        for (int i = 0; i < CHARACTERS; i++) {
            int rnd = new Random().nextInt(4) + offset;
            switch (rnd) {
                case (0):
                    team.add(new Sniper(getName(), new Vector2D(i + 1, posY)));
                    break;
                case (1):
                    team.add(new Robber(getName(), new Vector2D(i + 1, posY)));
                    break;
                case (2):
                    team.add(new Magician(getName(), new Vector2D(i + 1, posY)));
                    break;
                case (3):
                    team.add(new Farmer(getName(), new Vector2D(i + 1, posY)));
                    break;
                case (4):
                    team.add(new Crossbowman(getName(), new Vector2D(i + 1, posY)));
                    break;
                case (5):
                    team.add(new Monk(getName(), new Vector2D(i + 1, posY)));
                    break;
                case (6):
                    team.add(new Spearman(getName(), new Vector2D(i + 1, posY)));
                    break;
            }
        }
    }

    public static void sortTeam(ArrayList<Character> team) {
        team.sort (new Comparator<Character>() {
            @Override
            public int compare(Character t0, Character t1) {
                if (t1.getSpeed() == t0.getSpeed()) return (t1.getHp() - t0.getHp());
                else return (t1.getSpeed() - t0.getSpeed());
            }
        });
    }

    public String getState() {
        return state;
    }
}


