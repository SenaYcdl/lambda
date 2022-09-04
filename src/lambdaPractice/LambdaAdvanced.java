package lambdaPractice;

import lambda.Utils;

import java.util.Arrays;

public class LambdaAdvanced {
    public static void main(String[] args) {

        arrayYazdir();
    }


    public static void arrayYazdir(){


          /*TASK :
2 Boyutlu bir Multidimensional array i input kabul edip, arraydeki tüm
elemanları bir listeye kopyalayan ve harf sırasına göre yazdıran bir METHOD yazınız.
Eg : Input : {{Ali,Veli,Ayse},{Hasan,Can},{Suzan}}
Output:[Ali, Ayse, Can, Hasan, Suzan, Veli]
*/
        String[][] arr = {{"Ali", "Veli", "Ayse"}, {"Hasan", "Can"}, {"Suzan"}};

        Arrays.stream(arr).flatMap(Arrays::stream).sorted().forEach(Utils::ayniSatirdaBosluklaYazdir);

    }

}
