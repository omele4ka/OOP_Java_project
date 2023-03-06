package Unit;

import java.util.ArrayList;

public interface GameInterface {
    void step(ArrayList<Character> teamList1, ArrayList<Character> teamList2);
    String getInfo();
}