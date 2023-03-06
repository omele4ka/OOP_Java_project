package Unit;

import java.util.ArrayList;

public class Sniper extends Character {
    int ammunition_max = 32;
    int ammunition_has = ammunition_max;

    public Sniper(String name, Vector2D pos) {
        super(name, 15, 12, 9, 10, 8,10, pos.posX, pos.posY);
    }

    @Override
    public String getInfo() {
        return "🏹" +
                " H:" + Math.round(hp) +
                " D:" + defence +
                " A:" + attack +
                " Dmg:" + Math.round(Math.abs((damageMin+damageMax)/2)) + " " +
                state +
                " " + "Я снайпер!";
    }

    @Override
    public void step(ArrayList<Character> teamList1, ArrayList<Character> teamList2) {
        if (state.equals("dead") || ammunition_has == 0) return;
        int target = findNearest(teamList2);
        System.out.println(teamList2.get(target) + teamList2.get(target).getInfo());
        float damage = (teamList2.get(target).defence - attack > 0) ?
                damageMin : (teamList2.get(target).defence - attack < 0) ?
                damageMax : ((damageMax + damageMin) / 2);
        teamList2.get(target).getDamage(damage);

        for (int i = 0; i < teamList2.size(); i++) {
            if (teamList2.get(i).getInfo().equals("крестьянин") && teamList2.get(i).state.equals("ready")) {
                System.out.println("Крестьянин занят");
                teamList2.get(i).state = "occupied";
                return;
            }
            ammunition_has --;
        }
    }
}