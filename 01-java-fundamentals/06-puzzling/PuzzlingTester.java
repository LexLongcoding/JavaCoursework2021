import java.util.*;

public class PuzzlingTester{
    public static void main(String[] args){
        Puzzling pz = new Puzzling();
        int[] myArr = {3,5,1,2,7,9,8,13,25,32};
        String[]  myArr2 = {"Nancy","Jinichi","Fujibayashi","Momochi","Ishikawa"};
        ArrayList<String> nameArr = new ArrayList<String>(Arrays.asList(myArr2));
        System.out.println(" Greater than 10: " + pz.OverTen(myArr));
        System.out.println(pz.Names(nameArr));
        pz.Vowels();
        System.out.println(Arrays.toString(pz.RandomIntArray(1, 55)));
        System.out.println(pz.RandomString());
        System.out.println(Arrays.toString(pz.RandomStringArr()));
    }


}    