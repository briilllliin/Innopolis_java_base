package homework05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {
    public static TV createTV(String model, int channelNumber, int volume, boolean isOn) {
        return new TV(model, channelNumber, volume, isOn);
    }

    ;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String model = " ";
        int channelNumber, volume;
        boolean isOn;

        List<TV> listTV = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            System.out.println("Введите модель телевизора, канал, громкость, включён ли ТВ(true/false):");
            model = scanner.next();
            channelNumber = scanner.nextInt();
            volume = scanner.nextInt();
            isOn = scanner.nextBoolean();
            listTV.add(createTV(model, channelNumber, volume, isOn));


        }
        System.out.println("Введите максимальную громкость:");
        int maxVolume = scanner.nextInt();
        System.out.println("Только включённый с допустимой громкостью:");
        for (TV tv : listTV) {
            if( tv.isOn() && tv.getVolume() <= maxVolume){
                System.out.println(tv);
            }

        }

        System.out.println("-----------------------------------------------------------------");
        System.out.println("Сортировка по каналам");


        Collections.sort(listTV);
        for (TV tv: listTV) {
            System.out.println(tv);

        }
    }
}
