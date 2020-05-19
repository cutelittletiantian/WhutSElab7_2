package LiveAndDeath;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("请输入每个细胞死亡的概率");
        java.util.Scanner scan  =new Scanner(System.in);
        double i;
        i = scan.nextDouble();
        scan.close();
        TimeCtrl timeCtrl = new TimeCtrl(i);
        timeCtrl.run();
    }
}