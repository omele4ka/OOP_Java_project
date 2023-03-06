package Unit;

import java.util.ArrayList;

public class Crossbowman extends Character {
    int arrows_max = 16;
    int arrows_has = arrows_max;

    public Crossbowman (String name, Vector2D pos) {
        super(name, 10, 6, 4, 3, 2, 3, pos.posX, pos.posY);
    }

    @Override
    public String getInfo() {
        return "🏹" +
                " H:" + Math.round(hp) +
                " D:" + defence +
                " A:" + attack +
                " Dmg:" + Math.round(Math.abs((damageMin+damageMax)/2)) + " " +
                state +
                " " + "Я арбалетчик!";
    }

    @Override
    public void step(ArrayList<Character> teamList1, ArrayList<Character> teamList2) {
        if (state.equals("dead") || arrows_has == 0) return;
        int target = findNearest(teamList1);
        System.out.println(teamList1.get(target) + teamList1.get(target).getInfo());
        float damage = (teamList1.get(target).defence - attack > 0) ?
            damageMin : (teamList1.get(target).defence - attack < 0) ?
            damageMax : ((damageMax + damageMin) / 2);
        teamList1.get(target).getDamage(damage);

        for (int i = 0; i < teamList2.size(); i++) {
            if (teamList2.get(i).getInfo().equals("крестьянин") && teamList2.get(i).state.equals("ready")) {
                System.out.println("Крестьянин занят");
                teamList2.get(i).state = "occupied";
                return;
            }
            arrows_has --;
        }
    }
}