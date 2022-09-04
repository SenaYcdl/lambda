package lambda;

import jdk.jshell.execution.Util;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp03 {
    public static void main(String[] args) {

        List<String> liste = new ArrayList<>();
        liste.add("Ali");
        liste.add("Ali");
        liste.add("Mark");
        liste.add("Amanda");
        liste.add("Christopher");
        liste.add("Jackson");
        liste.add("Mariano");
        liste.add("Alberto");
        liste.add("Tucker");
        liste.add("Benjamin");
        System.out.println(liste);

        buyukHarfleYazdir(liste);
        System.out.println();
        kucukHarfleYazdir(liste);
        System.out.println();
        //buyukHarfleYazdir2(liste);
        uzunlugaGoreYazdir(liste);
        System.out.println();
        uzunlugagoreTerstenYazdir(liste);
        System.out.println();
        sonKarakteregoreTekrarsizSirala(liste);
        System.out.println();
        uzunlukveIlkHarfegoreSiralaYazdir(liste);
        System.out.println();
        //uzunluguBestenBuyukleriSil(liste);
        // baslangiclariAyadaSonuNolaniSil(liste);
        //baslangiclariAyadaSonuNolaniSil2(liste);
        //uzunluguSekizIleOnArasiveoIleBiteniSil(liste);
        System.out.println("uzunlugu12denAzMi = " + uzunlugu12denAzMi(liste));
        System.out.println("xileBaslamiyorMu = " + xileBaslamiyorMu(liste));
        System.out.println("rIleBitenVarMi= " + rIleBitenVarMi(liste));

    }

    //1) Tüm elemanları büyük harf ile yazdıran bir method oluşturun.

    public static void buyukHarfleYazdir(List<String> list) {

        list.stream().map(String::toUpperCase).forEach(Utils::ayniSatirdaBosluklaYazdir);
    }

    public static void kucukHarfleYazdir(List<String> list){

        list.stream().map(String::toLowerCase).forEach(Utils::ayniSatirdaBosluklaYazdir);

    }

    //1. soru 2.yol

   /* public static void buyukHarfleYazdir2(List<String> list) {

    list.replaceAll(String::toUpperCase);
    System.out.println(list);
    }*/

    //2) Elemanları uzunluklarına göre sıralayıp yazdıran bir method oluşturun.

    public static void uzunlugaGoreYazdir(List<String> list){

        list.stream().
                sorted(Comparator.comparing(String::length)). //karsilastirma yapar ve ona gore siralar
                forEach(Utils::ayniSatirdaBosluklaYazdir);
    }

    //3) Elemanları uzunluklarına göre ters sıralayıp yazdıran bir method oluşturun.

    public static void uzunlugagoreTerstenYazdir(List<String> list){

        list.
                stream().
                sorted(Comparator.comparing(String::length).reversed()).
                forEach(Utils::ayniSatirdaBosluklaYazdir);
    }

    //4) Elemanları son karakterlerine göre sıralayıp tekrarsız yazdıran bir method oluşturun.

    public static void sonKarakteregoreTekrarsizSirala(List<String> list){

        list.stream().
                distinct().
                sorted(Comparator.comparing(Utils::sonKarakterAl)).
                forEach(Utils::ayniSatirdaBosluklaYazdir);
    }

    //5) Elemanları önce uzunluklarına göre ve sonra ilk karakterine göre sıralayıp yazdıran bir method oluşturun.

    public static void uzunlukveIlkHarfegoreSiralaYazdir(List<String> list){

        list.stream().
                sorted(Comparator.comparing(String::length).thenComparing(Utils::ilkKarakteriAl)).
                forEach(Utils::ayniSatirdaBosluklaYazdir);
    }

    //6) Uzunluğu 5'ten büyük olan elemanları silen bir method oluşturun.

    /*public static void uzunluguBestenBuyukleriSil(List<String> list){

        //thenComparing() :==>siralam icin bir kosul daha belirtir

        list.removeIf(t->t.length()>5); //elemanin uzunlugu 5'ten buyukse sil
        System.out.println(list);

    }*/

    //7) ‘A’, ‘a’ ile başlayan yada ‘N’, ‘n’ ile biten elemanları silen bir method oluşturun.

    //1.yol
    /*public static void baslangiclariAyadaSonuNolaniSil(List<String> list){

        list.removeIf(t->t.charAt(0)=='A' || t.charAt(0)=='a' || t.charAt(t.length()-1)=='N' || t.charAt(t.length()-1)=='n' );
        System.out.println(list);
    }*/

    //2.yol

    /*public static void baslangiclariAyadaSonuNolaniSil2(List<String> list){

        list.removeIf(t->t.startsWith("A") || t.startsWith("a") || t.endsWith("N") || t.endsWith("n"));
        System.out.println(list);
    }*/

    //8) Uzunluğu 8 ile 10 arası olan yada 'o' ile biten elemanları silen bir method oluşturun.

   /* public static void uzunluguSekizIleOnArasiveoIleBiteniSil(List<String> list){

        list.removeIf(t->(t.length()>7 && t.length()<11) || t.endsWith("o"));
        System.out.println(list);

    }*/


    //9) Tüm elemanların uzunluklarının 12'den az olup olmadığını kontrol eden bir method oluşturun.

    public static boolean uzunlugu12denAzMi(List<String> list){

        return list.stream().allMatch(t->t.length()<12);
    }

    //10) Hiçbir elemanın 'X' ile başlamadığını kontrol eden bir method oluşturun.

    public static boolean xileBaslamiyorMu(List<String> list){

        return list.stream().noneMatch(t->t.startsWith("X") || t.startsWith("x"));

    }

    //11) Herhangi bir elemanın 'r' ile bitip bitmediğini kontrol eden bir method oluşturun.

    public static boolean rIleBitenVarMi(List<String> list) {

        return list.stream().anyMatch(t->t.endsWith("r"));
    }

}



