package lambdaPractice;

import lambda.Utils;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Lambda03 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("sayi giriniz");
        int z = scan.nextInt();


        System.out.println("istene sayi giriniz");
        int istenenSayi=scan.nextInt();



        //System.out.println(toplaAmele());
        System.out.println(toplaCincix());
        System.out.println(toplaCift(z));
        System.out.println(toplaIlkXCift(z));
        System.out.println(toplaIlkXTek(z));
        ikininIlkXKuvvetPrint(z);
        isteneSayiIlkXKuvvetPrint(istenenSayi,z);
        System.out.println(istenenSayiFactorial(z));
        System.out.println(xKuvveti(istenenSayi, z));



    }

    //odev
    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar
    // tamsayilari toplayan bir program create ediniz.
    //Structured(AMELE) Programming


    public static int toplaAmele() {


        Scanner scan=new Scanner(System.in);
        System.out.println("bir sayi giriniz");
        int sayi=scan.nextInt();
        int toplam=0;

        for(int i=1; i<=sayi; i++) {
            toplam+=i;
        }
        System.out.println("sayiların toplmai: "+toplam);

        return 0;
    }




    //TODO Functional(cincix Programming
    public static int toplaCincix() {

        return IntStream.rangeClosed(1,100).reduce(Math::addExact).getAsInt();
    }
    //TODO TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int toplaCift(int z) {



        return IntStream.rangeClosed(1,z).filter(Utils::ciftElemanSec).sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int toplaIlkXCift(int z) {


        return IntStream.range(0,z*2).filter(Utils::ciftElemanSec).sum();
    }
    //TODO TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int toplaIlkXTek(int z) {

        return IntStream.rangeClosed(0,z).filter(Utils::tekElemanSec).sum();
    }
    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininIlkXKuvvetPrint(int z) {

        System.out.println(Math.pow(2, z));

    }
    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void isteneSayiIlkXKuvvetPrint(int istenenSayi,int z) {

        System.out.println(Math.pow(istenenSayi, z));


    }
    // TODO TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    public static int istenenSayiFactorial(int z) {


        return IntStream.rangeClosed(1,z).reduce(Math::multiplyExact).getAsInt();
    }

    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.
    public static double xKuvveti(int istenenSayi, int z) {

        return Math.pow(istenenSayi,z);
    }
}

