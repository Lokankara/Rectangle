//package com.exam.airport;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.ThreadLocalRandom;
//import java.util.stream.Stream;
//
//public class Manager {
//
//    private static List<Plane> generatePlanes(int[] places) {
//
//        List<Plane> planes = new ArrayList<>();
//        int sum;
//        int amount;
//        int count;
//        List<Family> families = new ArrayList<>();
//        for (int planeId = 1; planeId <= places.length; planeId++) {
//            sum = 0;
//            amount = places[planeId - 1];
//
//            while (sum < amount - 3) {
//                count = generateMemberFamily();
//                sum += count;
//                families.add(getFamily(count, planeId));
//            }
//
//            if (sum != amount) {
//                families.add(getFamily(amount - sum, planeId));
//            }
//            Plane air = new Plane(planeId, families);
//            planes.add(air);
//            families.addAll(air.getFamilies());
//            families.clear();
//        }
//        System.err.println(planes);
//        return planes;
//    }
//
//    public static List<Plane> buildPlanes(int planes, int total) {
//        return generatePlanes(getPlaneSeats(planes, total));
////        System.out.printf("\u001B[35m%s planes contains %s families and %s seats%n\u001B[m", planes,
////                aircraft.stream().mapToInt(plane -> plane.getFamilies().size()).sum(),
////                passengers.stream().mapToInt(Family::getCount).sum());
////         aircraft;
//    }
//
//    private static Family getFamily(int count, int plane) {
//        return new Family(count, generateName(97, 122, 5), plane, generateCity());
//    }
//
//    private static Integer generateMemberFamily() {
//        return ThreadLocalRandom.current().nextInt(1, 5);
//    }
//
//    private static String generateCity() {
//        return Stream.of(City.values()).map(City::name).toList().get(ThreadLocalRandom.current().nextInt(0, 4));
//    }
//
//    private static String generateName(int min, int max, int length) {
//        StringBuilder builder = new StringBuilder();
//        builder.append((char) (ThreadLocalRandom.current().nextInt(min, max + 1) - 32));
//        for (int i = 0; i < length - 1; i++) {
//            builder.append((char) ThreadLocalRandom.current().nextInt(min, max + 1));
//        }
//        return new String(builder);
//    }
//
//    static int[] getPlaneSeats(int planes, int all) {
//        int[] places = new int[planes];
//        int total = all;
//        for (int plane = 0; plane < planes - 1; plane++) {
//            places[plane] = ThreadLocalRandom.current().nextInt(all / (planes + 2), all / (planes - 1));
//            total -= places[plane];
//        }
//        places[planes - 1] = total;
//        return places;
//    }
//}
