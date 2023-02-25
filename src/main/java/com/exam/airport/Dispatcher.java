//package main.java.com.exam.airport;
//
//import java.util.*;
//import java.util.concurrent.*;
//import java.util.stream.Stream;
//
//import static main.java.com.exam.airport.Dispatcher.AMOUNT;
//import static main.java.com.exam.airport.Dispatcher.PLANES;
//
//
//public class Dispatcher {
//    public static final int PLANES = 5;
//    public static final int AMOUNT = 100;
//
//    public static void main(String[] args) {
//
//        Controller.producerConsumerMode();
////        Controller.runMultiThread();
////        Controller.runOneSingleThread();
////        Controller.executorMultiMode();
//    }
//}
//
//class Controller {
//    static List<Family> passengers = new ArrayList<>();
//    protected static List<Plane> aircraft = new ArrayList<>();
//
//    private Controller() {
//    }
//
//    public static void producerConsumerMode() {
//        List<Plane> aircraft = Controller.buildPlanes(PLANES, AMOUNT);
//        List<Plane> planes = new ArrayList<>();
//        long start = System.nanoTime();
//        Terminal terminal = new Terminal(planes, aircraft);
//        Station station = new Station(planes, aircraft.size());
//
//        terminal.thread.start();
//        station.thread.start();
//        terminal.join();
//        station.join();
//
//        long end = System.nanoTime();
//        System.out.printf("\u001B[31mExecution time Producer-Consumer mode %s%n\u001B[m", (end - start) / 1000);
//
//    }
//
//    public static void runOneSingleThread() {
//        List<Plane> aircraft = buildPlanes(PLANES, AMOUNT);
//        long start = System.nanoTime();
//        aircraft.forEach(plane -> plane.thread.start());
//        aircraft.forEach(Transport::join);
//        Station station = new Station(Gate.getGate().getArrivedPlane(), PLANES);
//        station.thread.start();
//        long end = System.nanoTime();
//
//        System.out.printf("\u001B[31mExecution time Single-Thread mode %s%n\u001B[m", (end - start) / 1000);
//
//    }
//
//
//    public static void runMultiThread() {
//        List<Plane> aircraft = buildPlanes(PLANES, AMOUNT);
//
//        long start = System.nanoTime();
//        aircraft.forEach(plane -> plane.thread.start());
//
//        aircraft.forEach(Transport::join);
//
//        Station.departure(Gate.getGate().getArrivedPassengers());
//        Station.getBuses().forEach(Transport::join);
//
//        long end = System.nanoTime();
//        System.err.printf("Execution time Multi-Thread mode: %s%n", (end - start) / 1000);
//    }
//
//    public static void executorMultiMode() {
//
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(
//                Runtime.getRuntime().availableProcessors(),
//                Runtime.getRuntime().availableProcessors(),
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<>());
//
//        List<Plane> aircraft = buildPlanes(PLANES, AMOUNT);
//        List<Callable<Plane>> planes = new ArrayList<>();
//        List<Plane> arrivedPlanes = new ArrayList<>();
//
//        for (Plane plane : aircraft) {
//            planes.add(new Caller(plane));
//        }
//        long start = System.nanoTime();
//
//        try {
//            for (Future<Plane> future : executor.invokeAll(planes)) {
//                System.out.println(future.get());
//                arrivedPlanes.add(future.get());
//            }
//        } catch (InterruptedException | ExecutionException e) {
//            Thread.currentThread().interrupt();
//            System.err.println(e.getMessage());
//        } finally {
//            executor.shutdown();
//        }
//        Station station = new Station(arrivedPlanes, PLANES);
//        station.thread.start();
//        long end = System.nanoTime();
//        System.err.printf("Executor-threaded mode invoke time: %d millis%n", (end - start) / 1_000);
//    }
//
//    public static List<Plane> buildPlanes(int planes, int total) {
//        aircraft = new ArrayList<>();
//        passengers = new ArrayList<>();
//        int[] places = getPlaneSeats(planes, total);
//        generatePlanes(places);
//        System.out.printf("\u001B[35m%s planes contains %s families and %s seats%n\u001B[m", planes,
//                aircraft.stream().mapToInt(plane -> plane.getFamilies().size()).sum(),
//                passengers.stream().mapToInt(Family::getCount).sum());
//        return aircraft;
//    }
//
//    static int[] getPlaneSeats(int planes, int all) {
//        int[] places = new int[planes];
//
//        int total = all;
//        for (int plane = 0; plane < planes - 1; plane++) {
//            places[plane] = ThreadLocalRandom.current().nextInt(all / (planes + 2), all / (planes - 1));
//            total -= places[plane];
//        }
//        places[planes - 1] = total;
//        return places;
//    }
//
//    private static void generatePlanes(int[] places) {
//        int sum;
//        int amount;
//        int count;
//        List<Family> families = new ArrayList<>();
//        for (int plane = 1; plane <= places.length; plane++) {
//            sum = 0;
//            amount = places[plane - 1];
//
//            while (sum < amount - 3) {
//                count = Controller.generateMemberFamily();
//                sum += count;
//                families.add(getFamily(count, plane));
//            }
//
//            if (sum != amount) {
//                families.add(getFamily(amount - sum, plane));
//            }
//
//            aircraft.add(new Plane(plane, families));
//            passengers.addAll(families);
//            families.clear();
//        }
//    }
//
//    private static Family getFamily(int count, int plane) {
//        return new Family(count, Controller.generateName(97, 122, 5), plane, Controller.generateCity());
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
//}
//
//class Terminal implements Runnable {
//    private final int size;
//    protected final Thread thread;
//    private final List<Plane> planes;
//    private final List<Plane> aircraft;
//
//    public Terminal(List<Plane> planes, List<Plane> aircraft) {
//        this.size = aircraft.size();
//        this.planes = planes;
//        this.aircraft = aircraft;
//        this.thread = new Thread(this);
//    }
//
//    @Override
//    public void run() {
//        fly();
//    }
//
//    private void fly() {
//        int i = 0;
//        while (i < size) {
//            synchronized (planes) {
//                while (planes.size() == size) {
//                    try {
//                        System.out.printf("The queue#%s is full%n",
//                                Thread.currentThread().getName());
//                        planes.wait();
//                    } catch (InterruptedException e) {
//                        Thread.currentThread().interrupt();
//                        System.out.printf(e.getMessage());
//                    }
//                }
//            }
//
//            synchronized (planes) {
//                Plane plane = (aircraft.get(i));
//                System.out.printf("%s\u001B[36m took off from the airport with %s families on board \u001B[0m%n", plane, plane.getFamilies().size());
//                planes.add(plane);
//                i++;
//                if (planes.size() == 1) {
//                    System.out.println("Notifying Airplane");
//                    planes.notifyAll();
//                }
//            }
//        }
//    }
//
//    protected void join() {
//        try {
//            this.thread.join();
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            System.err.println(e.getMessage());
//        }
//    }
//}
//
//class Gate {
//    private static Gate gate;
//    private static final List<Plane> planes = new ArrayList<>();
//    private static final Queue<Family> arrivedPassengers = new PriorityBlockingQueue<>(5, new FamilyComparator());
//
//    private Gate() {
//    }
//
//    public static Gate getGate() {
//        return Objects.requireNonNullElseGet(gate, () -> gate = new Gate());
//    }
//
//    public void arrive(Plane plane) {
//        planes.add(plane);
//        arrivedPassengers.addAll(plane.getFamilies());
//        System.out.println(plane);
//    }
//
//    public Queue<Family> getArrivedPassengers() {
//        return arrivedPassengers;
//    }
//
//    public List<Plane> getArrivedPlane() {
//        return planes;
//    }
//
//    @Override
//    public String toString() {
//        return "\u001B[32m%s passengers arrived at the Gates%n\u001B[m%s".formatted(arrivedPassengers.stream().mapToInt(Family::getCount).sum(), planes);
//    }
//}
//
//class Station implements Runnable {
//    private final int size;
//
//    protected Thread thread;
//    private final List<Plane> planes;
//    private final static List<Bus> buses = new ArrayList<>();
//    private Queue<Family> arrivedFamilies;
//    private static final List<String> cities = Stream.of(City.values()).map(City::name).toList();
//    private static final int[] seats = new int[cities.size()];
//    private static final List<List<Family>> towns =
//            new ArrayList<>(Arrays.asList(
//                    new ArrayList<>(),
//                    new ArrayList<>(),
//                    new ArrayList<>(),
//                    new ArrayList<>()
//            ));
//
//    private static final List<Queue<Family>> tour =
//            new ArrayList<>(Arrays.asList(
//                    new PriorityBlockingQueue<>(cities.size(), new FamilyComparator()),
//                    new PriorityBlockingQueue<>(cities.size(), new FamilyComparator()),
//                    new PriorityBlockingQueue<>(cities.size(), new FamilyComparator()),
//                    new PriorityBlockingQueue<>(cities.size(), new FamilyComparator())
//            ));
//
//    public Station(List<Plane> planes, int size) {
//        this.size = size;
//        this.planes = planes;
//        this.thread = new Thread(this);
//        arrivedFamilies = new PriorityBlockingQueue<>(cities.size(), new FamilyComparator());
//    }
//
//    public static void arrive(Bus bus) {
//        System.out.println(bus);
//        int town = cities.indexOf(bus.getDriveTo());
//        tour.get(town).addAll(bus.getFamilies());
//    }
//
//
//    public static List<Bus> getBuses() {
//        return buses;
//    }
//
//    @Override
//    public void run() {
//        arrivedFamilies = land();
//        departure(arrivedFamilies);
//    }
//
//    public static void departure(Queue<Family> boardingPassengers) {
//        int town;
//        List<Family> families;
//        Bus bus;
//        Family family = boardingPassengers.poll();
//        while (family != null) {
//            town = cities.indexOf(family.getTravelTo());
//            seats[town] += family.getCount();
//            families = towns.get(town);
//            families.add(family);
//            if (seats[town] > 5 && seats[town] < 9) {
//                bus = new Bus(cities.get(town), families, seats[town]);
//                families.clear();
//                seats[town] = 0;
//                buses.add(bus);
//                bus.thread.start();
//            }
//            family = boardingPassengers.poll();
//            if (family == null && seats[town] != 0) {
//                bus = new Bus(cities.get(town), families, 6);
//                buses.add(bus);
//                bus.thread.start();
//            }
//        }
//    }
//
//    private Queue<Family> land() {
//        int i = size - 1;
//        while (i >= 0) {
//            Plane remove;
//
//            synchronized (planes) {
//                while (planes.isEmpty()) {
//                    try {
//                        planes.wait();
//                    } catch (InterruptedException e) {
//                        Thread.currentThread().interrupt();
//                        System.err.println(e.getMessage());
//                    }
//                }
//            }
//            synchronized (planes) {
//                if (this.planes.size() - size == i) {
//                    Collections.reverse(planes);
//                }
//
//                if (planes.size() > i) {
//                    remove = planes.remove(i);
//                    arrivedFamilies.addAll(remove.getFamilies());
//                    i--;
//                } else {
//                    continue;
//                }
//
//                if (this.planes.size() == size - 1) {
//                    this.planes.notifyAll();
//                }
//            }
//        }
//        return arrivedFamilies;
//    }
//
//    public void join() {
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            System.err.println(e.getMessage());
//        }
//    }
//}
//
//class Caller implements Callable<Plane> {
//    private final Plane plane;
//
//    public Caller(Plane plane) {
//        this.plane = plane;
//    }
//
//    public Plane call() {
//        return this.plane;
//    }
//}
//
//class Family implements Comparator<Family> {
//    private final int count;
//    private final int planeId;
//    private final String name;
//    private final String travelTo;
//
//    public Family(int count, String name, int plane, String travelTo) {
//        this.planeId = plane;
//        this.count = count;
//        this.name = name;
//        this.travelTo = travelTo;
//    }
//
//    public int getCount() {
//        return count;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getTravelTo() {
//        return travelTo;
//    }
//
//    @Override
//    public String toString() {
//        return "%s %s family %s".formatted(count, name, travelTo);
//    }
//
//    @Override
//    public int compare(Family a, Family b) {
//        return Integer.compare(b.getCount(), a.getCount());
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Family family = (Family) o;
//        return count == family.count && planeId == family.planeId && Objects.equals(name, family.name) && Objects.equals(travelTo, family.travelTo);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(count, planeId, name, travelTo);
//    }
//}
//
//class FamilyComparator implements Comparator<Family> {
//    @Override
//    public int compare(Family a, Family b) {
//        return Integer.compare(b.getCount(), a.getCount());
//    }
//}
//
//class Plane extends Transport {
//    private final int id;
//    private final Gate gate;
//
//    public Plane(int id, List<Family> families) {
//        super(new ArrayList<>(families));
//        this.id = id;
//        this.thread = new Thread(this, "Plane");
//        this.gate = Gate.getGate();
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    @Override
//    public String toString() {
//        return "\u001B[36m%s-seat aircraft#%s who arrive at the gate\u001B[m".formatted(getMembers(), id);
//    }
//
//    @Override
//    public void run() {
//        gate.arrive(this);
//    }
//}
//
//class Bus extends Transport {
//    private final int places;
//    private final String driveTo;
//
//    public Bus(String city, List<Family> families, int places) {
//        super(new ArrayList<>(families));
//        this.driveTo = city;
//        this.places = places;
//        this.thread = new Thread(this, city);
//    }
//
//    public String getDriveTo() {
//        return driveTo;
//    }
//
//    @Override
//    public void run() {
//        Station.arrive(this);
//    }
//
//    @Override
//    public String toString() {
//        return "The %s-bus with %s goes to %s".formatted(places, getFamilies(), driveTo);
//    }
//}
//
//abstract class Transport implements Runnable {
//
//    protected Thread thread;
//    private final List<Family> families;
//
//    protected Transport(List<Family> families) {
//        this.families = families;
//    }
//
//    public List<Family> getFamilies() {
//        return families;
//    }
//
//    public int getMembers() {
//        return families.stream().mapToInt(Family::getCount).sum();
//    }
//
//    public void join() {
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            System.err.println(e.getMessage());
//        }
//    }
//}
//
//enum City {
//    Kalush, Kosiv, Galych, Kolomiya
//}
