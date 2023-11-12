package homework05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {
    public static TV createTV(String model, int channelNumber, int volume, boolean isOn, List<Channel> channels) {
        return new TV(model, channelNumber, volume, isOn, channels);
    }

    ;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String model = " ";
        int channelNumber, volume, action;
        boolean isOn;

        //Создам вручную набор каналов с программой
        List<Channel> channels = new ArrayList<>();
        List<TVProgram> programSTS = new ArrayList<>();
        TVProgram filmSTS = new TVProgram("Фильм: Один дома");
        TVProgram showSTS = new TVProgram("Шоу: Уральские пельмени");
        programSTS.add(filmSTS);
        programSTS.add(showSTS);
        Channel channel13 = new Channel("СТС", 13, programSTS);

        List<TVProgram> programTNT = new ArrayList<>();
        TVProgram showTNT = new TVProgram("Шоу: Камеди Клаб");
        TVProgram serialTNT = new TVProgram("Сериал: Великолепный век");
        programTNT.add(showTNT);
        programTNT.add(serialTNT);
        Channel channel19 = new Channel("ТНТ", 19, programTNT);

        channels.add(channel13);
        channels.add(channel19);

        List<TV> listTV = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            System.out.println("Введите модель телевизора, канал, громкость, включён ли ТВ(true/false):");
            model = scanner.next();
            channelNumber = scanner.nextInt();
            volume = scanner.nextInt();
            isOn = scanner.nextBoolean();
            TV tv = new TV(model, channelNumber, volume, isOn, channels);
            listTV.add(tv);

            System.out.println("Если хотите выключить телевизор - введите 1," +
                    " если хотите включить - 2, если хотите переключить канал - 3");
            action = scanner.nextInt();
            switch (action) {
                case (1):
                    tv.off();
                    break;
                case (2):
                    tv.on();
                    break;
                case (3):
                    System.out.println("Введите канал, на который хотите переключить");
                    tv.switchChannel(13);
                default:
                    break;

            }


        }
        System.out.println("Введите максимальную громкость:");
        int maxVolume = scanner.nextInt();
        System.out.println("Только включённый с допустимой громкостью:");
        for (TV tv : listTV) {
            if (tv.isOn() && tv.getVolume() <= maxVolume) {
                System.out.println(tv);
            }

        }

        System.out.println("-----------------------------------------------------------------");
        System.out.println("Сортировка по каналам");


        Collections.sort(listTV);
        for (TV tv : listTV) {
            System.out.println(tv);

        }

        System.out.println("-----------------------------------------------------------------");


    }
}