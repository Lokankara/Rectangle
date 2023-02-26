package com.classwork.threads.airport.b;

import java.util.*;
import static java.util.stream.Collectors.groupingByConcurrent;

class Terminal extends Thread{

    private final List<Family> families;
    private List<Bus> buses;
    private final String toTravel;

    public Terminal(List<Family> families, String toTravel) {
        this.families = families;
        this.toTravel = toTravel;
        new Thread(this).start();
    }

    @Override
    public void run() {

        this.buses = new ArrayList<>();
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
            this.buses.add(new Bus(counter, this.toTravel, tempFamilyList, limitOfSeats));
        }

    }

    public List<Family> getFamilies() {return families;}

    public List<Bus> getBuses() {return buses;}

    public String getToTravel() {return toTravel;}
} 