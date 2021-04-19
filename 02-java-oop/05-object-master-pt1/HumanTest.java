public class HumanTest {
    public static void main(String[] args){
        Human player1 = new Human();
        Human player2 = new Human();
        player1.attack(player2);
        System.out.println(player2.health);

        Ninja nj = new Ninja();
        Samurai sm  = new Samurai();
        Wizard wz = new Wizard();

        nj.steal(player2);
        nj.runAway();
        System.out.println(nj.health);
        System.out.println(player2.health);
        sm.deathBlow(player2);
        System.out.println(sm.health);
        System.out.println(player2.health);
        sm.meditate();
        System.out.println(sm.health);
        System.out.println(sm.howMany());

        wz.heal(player2);
        System.out.println(player2.health);
        wz.fireball(nj);
        System.out.println(nj.health);


    }
}

