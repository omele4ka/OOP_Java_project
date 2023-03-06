package Unit;

import java.util.ArrayList;

public class Robber extends Character{

    int stealing = -1;

    public Robber(String name, Vector2D pos) {
        super(name, 10, 8, 6, 3, 2, 4, pos.posX, pos.posY);
    }


    @Override
    public String getInfo() {

        return "\uD83D\uDC82" +
                " H:" + Math.round(hp) +
                " D:" + defence +
                " A:" + attack +
                " Dmg:" + Math.round(Math.abs((damageMin+damageMax)/2)) + " " +
                state +
                " " + "Я разбойник!";
    }

    @Override
    public void step(ArrayList<Character> teamList1, ArrayList<Character> teamList2) {
        if (state.equals("dead")) {hp = 0; return;}
        int target = findNearest(teamList1);
        if (target < 2) {
            float damage = (teamList1.get(target).defence - attack > 0) ?
                    damageMin : (teamList1.get(target).defence - attack < 0) ?
                    damageMax : ( (damageMax+damageMin) / 2);
            teamList1.get(target).getDamage(damage);
            return;
        }
        moveToOpponent(target, teamList1);
    }

    void moveToOpponent(int target, ArrayList<Character> teamList1) {
        if (pos.onTheTop(teamList1.get(target).pos) & (pos.posY != teamList1.get(target).pos.posY)) {
            pos.posY++;
            return;
        } else if (!pos.onTheTop(teamList1.get(target).pos) & (pos.posY != teamList1.get(target).pos.posY)) {
            pos.posY--;
            return;
        }
        if (pos.onTheLeft(teamList1.get(target).pos)) {
            pos.posX++;
            return;
        } else if (!pos.onTheLeft(teamList1.get(target).pos)) {
            pos.posX--;
            return;
        }
    }
}