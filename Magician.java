package Unit;

import java.util.ArrayList;

public class Magician extends Character {
    int mana_max = 100;
    int mana_has = mana_max;

    public Magician(String name, Vector2D pos) {
        super (name, 30, 17, 9, 12, -5, -5, pos.posX, pos.posY);
    }

    @Override
    public String getInfo() {
        return "\uD83E\uDDD9" +
                " H:" + Math.round(hp) +
                " D:" + defence +
                " A:" + attack +
                " Dmg:" + Math.round(Math.abs((damageMin+damageMax)/2)) + " " +
                state +
                " " + "Я маг!";
    }

    @Override
    public void step(ArrayList<Character> teamList1, ArrayList<Character> teamList2) {
        if (state.equals("dead") || mana_has <= 0) {
            hp = 0;
            return;
        }
        for (int i = 0; i < teamList1.size(); i++) {
            if (teamList1.get(i).hp < teamList1.get(i).maxHp) {
                teamList1.get(i).getDamage(damageMax);
                System.out.println(teamList1.get(i).getInfo());
                break;
            }
        }
    }
}