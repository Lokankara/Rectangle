package com.classwork.stream.warburton;

import static com.classwork.stream.warburton.Dao.aLoveSupreme;
import static com.classwork.stream.warburton.Dao.albums;
import static com.classwork.stream.warburton.Dao.master;
import static com.classwork.stream.warburton.Dao.membersOfMetallica;
import static com.classwork.stream.warburton.Dao.membersOfTheBeatles;
import static com.classwork.stream.warburton.Dao.metallica;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import static java.util.stream.Collectors.toSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Handler {

    public static void main(String[] args) {

        long count = membersOfMetallica.stream().filter(artist -> artist.isFrom("UK")).count();

        List<String> namesAndOrigins = Controller.getNamesAndOrigins(membersOfTheBeatles);

        Optional<String> largestString = Controller.getLargestString(namesAndOrigins);
        System.err.println(largestString.get());

//		assertEquals("c", largestString.orElseGet(() -> "c"));

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        Integer evenFactorial = integers.stream().reduce(1, (a, b) -> a * (b % 2 == 0 ? b : 1));
        System.err.println(evenFactorial);

        long factorial = integers.stream().reduce(1, (a, b) -> a * b);

        Stream<Integer> map = integers.stream().map(a -> a + 2);

        Integer reduce = map.reduce(1, (a, b) -> a * b);

        System.err.println(reduce);

        System.err.println(factorial);

//		Integer parallelFactorial = integers.parallelStream().reduce(1, (a, b) -> a + b, (a, b) -> a * b);
        Integer parallelFactorial = integers.stream().sequential().reduce(0, (a, b) -> a + b, (a, b) -> a * b);
        System.out.println(parallelFactorial);

        Stream<Artist> news = membersOfMetallica.stream().filter(artist -> artist.getNationality().startsWith("US"))
                .map(a -> new Artist(a.getName(), a.getNationality()));

        news.toList().forEach(System.err::println);

        LinkedList<Artist> lla = membersOfMetallica.stream().collect(() -> new LinkedList<>(),
                (list, element) -> list.addFirst(element), (a, b) -> a.addAll(b));

        LinkedList<Artist> llnaall = membersOfMetallica.stream().collect(
                LinkedList::new,
                (l, e) -> l.add(e),
                LinkedList::addAll);
//				LinkedList::addFirst,

        System.out.println(llnaall);

        IntStream cStrm = integers.stream().mapToInt((a) -> (int) Math.ceil(a));

//	int addUps = Exercise.addUp(integers);

        long count2 = membersOfMetallica.stream().filter(artist -> {
            System.out.println(artist.getName());
            return artist.isFrom("US");
        }).count();

        for (Artist artist : master.getMusicianList()) {
            if (artist.getName().startsWith("J")) {
                System.out.println(artist.getNationality());
            }
        }

        Set<String> longTracks = Controller.findLongStreamTracks(albums);
        int sum = Controller.parallelArraySum(albums);

        System.out.println("sum: " + sum);

        System.err.println(Controller.countLowerCase("QerHwqFw"));

        Set<String> origins = aLoveSupreme.getMusicians().filter(artist -> artist.getName().startsWith("The"))
                .map(artist -> artist.getNationality()).collect(toSet());

        System.out.println(metallica.getAllMembers());
    }
}
