// Крестьянин:
//  - имя
//  - здоровье
//  - скорость
//  - подносить оружие
//  - возделывать поля
//
//Разбойник:
//  - имя
//  - здоровье
//  - скорость
//  - урон
//  - способность воровать
//
//Снайпер:
//  - имя
//  - здоровье
//  - скорость
//  - урон
//  - боеприпасы

// Колдун:
//  - имя
//  - здоровье
//  - скорость
//  - урон (отрицательный, способность лечить)
//  - боеприпасы (мана)

// Арбалетчик:
//  - имя
//  - здоровье
//  - скорость
//  - урон
//  - боеприпасы

// Копейщик:
//  - имя
//  - здоровье
//  - скорость
//  - урон
//  - владение коьем

// Монах:
//  - имя
//  - здоровье
//  - скорость
//  - урон (отрицательный, способность лечить)
//  - боеприпасы (элексиры)


import Unit.Character;
import java.util.ArrayList;
import java.util.Scanner;
import static Unit.Character.*;


public class main {
    public static ArrayList<Character> teamList1 = new ArrayList<>();
    public static ArrayList<Character> teamList2 = new ArrayList<>();
    public static ArrayList<Character> all = new ArrayList<>();
    static int deadTeamList1 = 0;
    static int deadTeamList2 = 0;

    public static void main(String[] args) {

        Scanner user_input = new Scanner(System.in);
        System.out.print("Press Enter to begin.");
        user_input.nextLine();
        createTeam(teamList1, 0, 1);
        createTeam(teamList2, 3, 10);
        all.addAll(teamList1);
        all.addAll(teamList2);
        sortTeam(all);
        System.out.println(all);

        while (true) {
            View.view();
            user_input.nextLine();
            for (Character character : all) {
                if (teamList1.contains(character)) character.step(teamList1, teamList2);
                else character.step(teamList2, teamList1);
            }
            for (Character character: teamList1) {
                if (character.getState() == "dead") deadTeamList1++;
            }
            if (deadTeamList1 == 10){
                System.out.println("******************************************Green winner!******************************************");
                break;
            } else deadTeamList1 = 0;
            for (Character character: teamList2) {
                if (character.getState() == "dead") deadTeamList2++;
            }
            if (deadTeamList2 == 10){
                System.out.println("******************************************Blue winner!******************************************");
                break;
            } else deadTeamList2 = 0;
        }
    }
}

