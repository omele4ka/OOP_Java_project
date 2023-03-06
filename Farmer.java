package Unit;

import java.util.ArrayList;

public class Farmer extends  Character{
    int ammunition = 300;

    public Farmer(String name, Vector2D pos){
        super(name, 1, 1, 3, 1, 1, 1, pos.posX, pos.posY);
    }


    @Override
    public String getInfo() {

        return  " H:" + Math.round(hp) +
                " D:" + defence +
                " A:" + attack +
                state +
                " " + "Я крестьянин!";
    }

    @Override
    public void step(ArrayList<Character> teamList1, ArrayList<Character> teamList2) {
        if (!this.state.equals("dead")) {
            this.state = "ready";
            ammunition --;
        }
    }
}