package com.vtb.kortunov.lesson8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        //Task 1
        System.out.println(getStringLongerFive("We had 2 bags of grass, 75 pellets of mescaline, 5 sheets of high-powered blotter acid, a saltshaker half-full of cocaine, a whole galaxy of multi-colored uppers, downers, screamers, laughers... Also, a quart of tequila, a quart of rum, a case of beer, a pint of raw ether, and two dozen amyls. Not that we needed all that for the trip, but once you get locked into a serious drug collection, the tendency is to push it as far as you can. The only thing that really worried me was the ether. There is nothing in the world more helpless and irresponsible and depraved than a man in the depths of an ether binge, and I knew we'd get into that rotten stuff pretty soon."));

        //Task 2
        String[][] strings = {
                {"AAA", "BB", "AAA"},
                {"CCC", "BB", "BB"},
                {"GG", "BB", "CC"},
                {"PPP", "JJJ ", "A"}};
        System.out.println(getListUniqueWord(strings));

        //Task 3
        System.out.println(getSumEvenNumbers());

        //Task4
        String[] str = {"sss", "ooo", "qq", "e", "BB", "AAA"};
        System.out.println(getSumLength(str));

        //Task 5
        System.out.println(getThreeWord(str));
    }

    //Task 1
    public static String getStringLongerFive(String str) {
        return Optional.ofNullable(str)
                .stream()
                .map(s -> s.split("\\s"))
                .flatMap(Stream::of)
                .filter(s -> s.length() > 5)
                .collect(Collectors.joining(" "));
    }

    //Task 2
    public static List<String> getListUniqueWord(String[][] strings) {
        return Optional.ofNullable(strings)
                .stream()
                .flatMap(Stream::of)
                .flatMap(Stream::of)
                .distinct()
                .collect(Collectors.toList());
    }

    //Task 3
    public static int getSumEvenNumbers() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 100; i <= 200; i++) {
            arrayList.add(i);
        }
        return arrayList.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
    }

    //Task 4
    public static int getSumLength(String[] strings) {
        return Optional.ofNullable(strings)
                .stream()
                .flatMap(Stream::of)
                .map(String::length)
                .reduce(0, Integer::sum);
    }

    //Task 5
    public static List<String> getThreeWord(String[] strings) {
        return Optional.ofNullable(strings)
                .stream()
                .flatMap(Stream::of)
                .sorted()
                .limit(3)
                .collect(Collectors.toList());

    }
}
