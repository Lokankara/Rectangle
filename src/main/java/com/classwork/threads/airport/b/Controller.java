package com.classwork.threads.airport.b;

import java.util.*;
import static java.util.stream.Collectors.*;

public class Controller {

    public static Map<String, List<Bus>> boardingBuses(List<Plane> planes, boolean inMultiThreadedMode){

        Map<String, List<Bus>> busMap = new HashMap<>();
        List<Family> families = new ArrayList<>();
        planes.
                parallelStream().
                forEach(p -> families.addAll(p.getFamilies()));

        Map<String, List<Family>> map = families.
                parallelStream().
                collect(groupingByConcurrent(Family::getTravelTo));

        List<Family> familyWhoTravelToKalush = map.get("Kalush");
        List<Family> familyWhoTravelToGalych = map.get( "Galych");
        List<Family> familyWhoTravelToKosiv = map.get("Kosiv");
        List<Family> familyWhoTravelToKolomiya = map.get("Kolomiya");

        if (inMultiThreadedMode){
            List<Terminal> busesByCities = new ArrayList<>();

            busesByCities.add(new Terminal(familyWhoTravelToGalych, "Galych"));
            busesByCities.add(new Terminal(familyWhoTravelToKalush, "Kalush"));
            busesByCities.add(new Terminal(familyWhoTravelToKosiv, "Kosiv"));
            busesByCities.add(new Terminal(familyWhoTravelToKolomiya, "Kolomiya"));

            for(Terminal t : busesByCities){
                try {
                    t.join();
                }catch (InterruptedException interruptedException){
                    interruptedException.printStackTrace();
                }
            }

            busesByCities.forEach(t -> busMap.put(t.getToTravel(), t.getBuses()));
        }else {

            boarderBusByCity(familyWhoTravelToGalych, "Galych", busMap);
            boarderBusByCity(familyWhoTravelToKalush, "Kalush", busMap);
            boarderBusByCity(familyWhoTravelToKosiv, "Kosiv", busMap);
            boarderBusByCity(familyWhoTravelToKolomiya, "Kolomiya", busMap);
        }

        return busMap;
    }

    public static void boarderBusByCity(List<Family> families, String toTravel, Map<String, List<Bus>> busMap){

        List<Bus> buses = new ArrayList<>();
        int counter, seatsOnTheBus = 8;

        Map<Integer, List<Family>> map = families.
                parallelStream().
                collect(groupingByConcurrent(Family::getCount));

        Queue<Family> familyConsistOfOneMember =
                map.get(1) == null ? new LinkedList<>() : new LinkedList<>(map.get(1));
        Queue<Family> familyConsistOfTwoMember =
                map.get(2) == null ? new LinkedList<>() :new LinkedList<>(map.get(2));
        Queue<Family> familyConsistOfThreeMember =
                map.get(3) == null ? new LinkedList<>() :new LinkedList<>(map.get(3));
        Queue<Family> familyConsistOfFourMember =
                map.get(4) == null ? new LinkedList<>() :new LinkedList<>(map.get(4));

        List<Family> tempFamilyList;

        while (!familyConsistOfOneMember.isEmpty() || !familyConsistOfTwoMember.isEmpty() ||
                !familyConsistOfThreeMember.isEmpty() || !familyConsistOfFourMember.isEmpty()){

            counter = 0;
            tempFamilyList = new ArrayList<>();

            while (!familyConsistOfFourMember.isEmpty() && counter < seatsOnTheBus){

                tempFamilyList.add(familyConsistOfFourMember.poll());
                counter+=4;
            }

            while (!familyConsistOfThreeMember.isEmpty() && counter < seatsOnTheBus-2){

                tempFamilyList.add(familyConsistOfThreeMember.poll());
                counter+=3;
            }

            while (!familyConsistOfTwoMember.isEmpty() && counter < seatsOnTheBus-1){

                tempFamilyList.add(familyConsistOfTwoMember.poll());
                counter+=2;
            }

            while (!familyConsistOfOneMember.isEmpty() && counter < seatsOnTheBus){

                tempFamilyList.add(familyConsistOfOneMember.poll());
                counter+=1;
            }

            int limitOfSeats = counter <= 6 ? 6 : counter == 7 ? 7 : 8;
            buses.add(new Bus(counter, toTravel, tempFamilyList, limitOfSeats));
        }

        busMap.put(toTravel, buses);
    }

    public static List<Plane> boardingPlanes(List<Family> families, int seatsOnThePlane){

        List<Plane> planes = new ArrayList<>();
        int id = 1, counter;

        Map<Integer, Queue<Family>> map = families.
                parallelStream().
                collect(groupingBy(Family::getCount, toCollection(LinkedList::new)));
        Queue<Family> familyConsistOfOneMember =
                map.get(1) == null ? new LinkedList<>() : map.get(1);
        Queue<Family> familyConsistOfTwoMember =
                map.get(2) == null ? new LinkedList<>() : map.get(1);
        Queue<Family> familyConsistOfThreeMember =
                map.get(3) == null ? new LinkedList<>() : map.get(3);
        Queue<Family> familyConsistOfFourMember =
                map.get(4) == null ? new LinkedList<>() : map.get(4);

        List<Family> tempFamilyList;

        while (!familyConsistOfOneMember.isEmpty() || !familyConsistOfTwoMember.isEmpty() ||
                !familyConsistOfThreeMember.isEmpty() || !familyConsistOfFourMember.isEmpty()){

            counter = 0;
            tempFamilyList = new ArrayList<>();

            while (!familyConsistOfFourMember.isEmpty() && counter < seatsOnThePlane){

                tempFamilyList.add(familyConsistOfFourMember.poll());
                counter+=4;
            }

            while (!familyConsistOfThreeMember.isEmpty() && counter < seatsOnThePlane-2){

                tempFamilyList.add(familyConsistOfThreeMember.poll());
                counter+=3;
            }

            while (!familyConsistOfTwoMember.isEmpty() && counter < seatsOnThePlane-1){

                tempFamilyList.add(familyConsistOfTwoMember.poll());
                counter+=2;
            }

            while (!familyConsistOfOneMember.isEmpty() && counter < seatsOnThePlane){

                tempFamilyList.add(familyConsistOfOneMember.poll());
                counter+=1;
            }

            planes.add(new Plane(tempFamilyList, id++, seatsOnThePlane, counter));
        }

        return planes;
    }

    public static List<Family> createFamily(int numberOfFamilies){
    	List<String> cities = new ArrayList<>(Arrays.asList("Kalush", "Kosiv", "Galych", "Kolomiya"));

        List<Family> families = new ArrayList<>();
        int countMembers, optionForCity;
        String nameOfFamily, city;
        Random random = new Random();

        for(int i=0;i<numberOfFamilies;i++){

            countMembers = random.nextInt(1,5);

            optionForCity = random.nextInt(0,4);

            city = cities.get(optionForCity);

             nameOfFamily = random.ints(97, 123)
                    .limit(2)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

             families.add(new Family(nameOfFamily, city, countMembers));
        }
        return families;
    }
} 