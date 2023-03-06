package Unit;

import java.util.ArrayList;

public class Spearman extends Character{


    public Spearman(String name, Vector2D pos) {
        super(name, 10, 4, 4, 5, 1, 3, pos.posX, pos.posY);
    }

    @Override
    public String getInfo() {
        return "\uD83D\uDC82" +
                " H:" + Math.round(hp) +
                " D:" + defence +
                " A:" + attack +
                " Dmg:" + Math.round(Math.abs((damageMin+damageMax)/2)) + " " +
                state +
                " " + "Я копейщик!";
    }

    @Override
    public void step(ArrayList<Character> teamList1, ArrayList<Character> teamList2) {
        if (state.equals("dead")) {hp = 0; return;}
        int target = findNearest(teamList2);
        if (target < 2) {
            float damage = (teamList2.get(target).defence - attack > 0) ?
                    damageMin : (teamList2.get(target).defence - attack < 0) ?
                    damageMax : ( (damageMax+damageMin) / 2);
            teamList2.get(target).getDamage(damage);
            return;
        }
        moveToOpponent(target, teamList2);
    }
    void moveToOpponent(int target, ArrayList<Character> teamList2) {
        if (pos.onTheTop(teamList2.get(target).pos) & (pos.posY != teamList2.get(target).pos.posY)) {
            pos.posY++;
            return;
        } else if (!pos.onTheTop(teamList2.get(target).pos) & (pos.posY != teamList2.get(target).pos.posY)) {
            pos.posY--;
            return;
        }
        if (pos.onTheLeft(teamList2.get(target).pos)) {
            pos.posX++;
            return;
        } else if (!pos.onTheLeft(teamList2.get(target).pos)) {
            pos.posX--;
            return;
        }
    }
}