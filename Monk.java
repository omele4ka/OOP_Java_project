package Unit;

import java.util.ArrayList;

public class Monk extends Character {
    int elixir_max = 10;
    int elixir_has = elixir_max;

    public Monk(String name, Vector2D pos) {
        super(name, 30, 12, 5, 7, -4, -4, pos.posX, pos.posY);
    }

    @Override
    public String getInfo() {
        return "\uD83E\uDDD9" +
                " H:" + Math.round(hp) +
                " D:" + defence +
                " A:" + attack +
                " Dmg:" + Math.round(Math.abs((damageMin+damageMax)/2)) + " " +
                state +
                " " + "Я монах!";
    }

    @Override
    public void step(ArrayList<Character> teamList1, ArrayList<Character> teamList2) {
        if (state.equals("dead") || elixir_has <= 0) {
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