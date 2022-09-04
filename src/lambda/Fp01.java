package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp01 {
    public static void main(String[] args) {

        /*
        1) Lambda (Functional Programming) Java 8 ile kullanilmaya baslanmistir
        2) Functional Programming de "Ne yapilacak(what to do)" uzerine yogunlasilir.Structured Programming
        "Nasil yapilacak(how to do)" uzerine yogunlasilir
        3) Functional Programming Arrays ve Collections ile kullanilir
        4) "entrySet() methodu ile Map , Set e donusturulerek Functional Programming de kullanilabilir
         */

        List<Integer> liste = new ArrayList<>();
        liste.add(8);
        liste.add(9);
        liste.add(131);
        liste.add(10);
        liste.add(9);
        liste.add(10);
        liste.add(2);
        liste.add(8);
        System.out.println(liste);

        //1) Ardışık list elementlerini aynı satırda aralarında boşluk
        // bırakarak yazdıran bir method oluşturun.(Structured)

        listElemanlariniYazdirStructured(liste);
        System.out.println();
        listElemanlariniYazdirFunctional(liste);
        System.out.println();
        CiftElemanlariYazdirStructured(liste);
        System.out.println();
        CiftElemanlariYazdirFunctional(liste);
        System.out.println();
        TekElemanlariYazdirFunctional(liste);
        System.out.println();
        tekrarsizElemanlarinKupunuYazdir(liste);
        System.out.println();
        tekrarsizCiftElemanlarinKareToplami(liste);
        System.out.println();
        tekrarsizCiftElemanlarinKupuCarpimi(liste);
        System.out.println();
        getMaxEleman(liste);
        System.out.println();
        getMinEleman(liste);
        System.out.println();
        getMaxEleman02(liste);
        System.out.println();
        getMinEleman02(liste);
        System.out.println();
        getYedidenBuyukCiftMin(liste);
        System.out.println();
        getYedidenBuyukCiftMin2(liste);
        System.out.println();
        getYedidenBuyukCiftMin3(liste);
        System.out.println();
        getTersSiralamaTekrarsizElemanlarinYarisi(liste);

    }

    public static void listElemanlariniYazdirStructured(List<Integer> list ){

        for (Integer each:list) {
            System.out.print(each + " ");

        }
    }

    //2)Ardışık list elementlerini aynı satırda aralarında boşluk
    // bırakarak yazdıran bir method oluşturun.(Functional)

    public static void listElemanlariniYazdirFunctional(List<Integer> list) {

        list.stream().forEach(t-> System.out.print(t+" "));

        /*
        stream() methodu collection dan elementleri akisa dahil etmek icin ve methodlara
        ulasmak icin kullanilir

         Java IO sınıflarında yer alan ve art arda işlemler için kullanılmaktadır.
         Java 8 ile birlikte gelen Stream API fonksiyonel programlama yaklaşımına göre koleksiyon,
         dizi gibi veriler üzerinde filtreleme, döngü, dönüştürme, dönüşüm gibi işlemler yapmayı sağlar.
         */
    }

    //3) çift list elementlerini aynı satırda aralarında
    // boşluk bırakarak yazdıran bir method oluşturun.(Structured)

    public static void CiftElemanlariYazdirStructured(List<Integer> list) {

        for (Integer each:list) {
            if (each%2==0){
                System.out.print(each+ " ");
            }

        }
    }

    //4)Ardışık çift list elementlerini aynı satırda aralarında
    // boşluk bırakarak yazdıran bir method oluşturun.(Functional)

    public static void CiftElemanlariYazdirFunctional(List<Integer> list) {

        list.stream().filter(t -> t % 2 == 0).forEach(t -> System.out.print(t+" "));
    }

    //5) Ardışık tek list elementlerinin karelerini aynı satırda
    // aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional)

    public static void TekElemanlariYazdirFunctional(List<Integer> list){

        list.stream().filter(t->t%2!=0).map(t->t*t).forEach(t -> System.out.print(t+" "));
        //elemanlarin degerlerini degisecekse map() methodu kullanilir
    }

    //6) Ardışık tek list elementlerini kuplerini tekrarsiz olarak ayni satırda aralarında
    //boşluk bırakarak yazdıran bir method oluşturun.(Functional)

    public static void tekrarsizElemanlarinKupunuYazdir(List<Integer> list) {

        list.stream().distinct().filter(t->t%2!=0).map(t->t*t*t).forEach(t -> System.out.print(t+" "));
        //distinct tekrarlari kaldirir
        //distinct ve filter i stream olmadan kullanamayiz
    }

    //7) Tekrarsız çift elementlerin karelerinin toplamını hesaplayan bir method oluşturun.

    public static void tekrarsizCiftElemanlarinKareToplami(List<Integer> list) {

        Integer toplam=list.stream().distinct().filter(t->t%2==0).map(t->t*t).reduce(0,(t,u)->t+u);
        System.out.print(toplam);
    }

    //8) Tekrarsız çift elemanların küpünün çarpımını hesaplayan bir method oluşturun.

    public static void tekrarsizCiftElemanlarinKupuCarpimi(List<Integer> list) {

        Integer carpim=list.stream().distinct().filter(t->t%2==0).map(t->t*t*t).reduce(1,(t,u)->t*u);
        System.out.print(carpim);
    }

    //9) List elemanları arasından en büyük değeri bulan bir method oluşturun.

    public static void getMaxEleman(List<Integer> list) {

        Integer max= list.stream().distinct().reduce(Integer.MIN_VALUE,(t,u)->t>u ?t : u);
        System.out.print("En buyuk deger:" + max);
    }

    //10) en kucuk elemani getir

    public static void getMinEleman(List<Integer> list) {

        Integer min=list.stream().distinct().reduce(Integer.MAX_VALUE,(t,u)->t<u ? t : u );
        System.out.print("En kucuk deger:" + min);
    }

    // Max sayinin 2.yolu

    public static void getMaxEleman02(List<Integer> list) {

        Integer max2= list.stream().distinct().sorted().reduce(Integer.MIN_VALUE,(t,u)-> u);
        System.out.print("En buyuk deger 2.yol:" + max2);
    }

    //Ödev Min sayi 2. yol
    //11)List elemanları arasından en küçük değeri bulan bir method oluşturun.(2 Yol ile)

    public static void getMinEleman02(List<Integer> list) {

        Integer min2= list.stream().distinct().reduce(Integer.MAX_VALUE,(t,u)-> u);
        System.out.print("En kucuk deger 2.yol:" + min2);
    }

    //12) List elemanları arasından 7'den büyük, çift, en küçük değeri bulan bir method oluşturun.

    public static void getYedidenBuyukCiftMin(List<Integer> list) {

        Integer min= list.stream().distinct().filter(t-> t%2==0).filter(t->t>7).reduce(Integer.MAX_VALUE,(t,u)->t<u ? t :u);
        System.out.print("1. min yol:" + min);
    }

    //12. sorunun 2.yolu

    public static void getYedidenBuyukCiftMin2(List<Integer> list) {

        Integer min= list.stream().distinct().filter(t-> t%2==0).filter(t->t>7).sorted(Comparator.reverseOrder()).
                reduce(Integer.MAX_VALUE,(t,u)->u);
        System.out.print("2. min yol:" + min);

    }

    //12.sorunun 3.yolu

    public static void getYedidenBuyukCiftMin3(List<Integer> list) {

        Integer min=list.stream().filter(t-> t%2==0).filter(t->t>7).sorted().findFirst().get();
        System.out.print("3. min yol:" + min);
    }

    //13) Ters sıralama ile tekrarsız ve 5'ten büyük elemanların yarı değerlerini
    // (elamanın ikiye bölüm sonucunu) bulan bir method oluşturun.

    public static void getTersSiralamaTekrarsizElemanlarinYarisi(List<Integer> list) {

        List<Double> sonuc=list.stream().distinct().
                filter(t->t>5).map(t->t/2.0).
                sorted(Comparator.reverseOrder()).
                collect(Collectors.toList());
        System.out.print(sonuc);
    }


}
