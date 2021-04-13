public class BasicsTest {
    public static void main(String[] args){
        Basics bt = new Basics();
        int[] myArr = {8,9,10,11};
        int[] myArr2 = {1,2,3,4,-5,-6};
        int[] myArr3 = {1,2,10,20,50};
        int[] myArr4 = {2};

        bt.OneTo255();
        bt.PrintOdds();
        bt.LoopArray(myArr);
        bt.FindMax(myArr2);
        bt.GetAverage(myArr3);
        bt.OddArray();
        bt.GreaterThanY(myArr, 9);
        bt.SquareArray(myArr4);
        bt.EliminateNegatives(myArr2);
        bt.MaxMinAverage(myArr3);
        bt.ShiftArrayValues(myArr3);
    }
}
    

