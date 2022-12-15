//import java.util.ArrayList;
//
//public class ClassWork {
//    public static void main(String[] args) {
//        Controller.defineTypeOfList(args);
//    }
//}
//
// class DaysOfWeekList {
//    ArrayList<String> weekDays;
//    String typeOfList;
//
//    public DaysOfWeekList() {
//        typeOfList = "WEEK_DAYS";
//
//        weekDays = new ArrayList<>();
//        weekDays.add("Monday");
//        weekDays.add("Tuesday");
//        weekDays.add("Wednesday");
//        weekDays.add("Thursday");
//        weekDays.add("Friday");
//        weekDays.add("Saturday");
//        weekDays.add("Sunday");
//    }
//}
//
//public class MarksList {
//    ArrayList<String> marks;
//    String typeOfList;
//
//    public MarksList() {
//        typeOfList = "MARKS";
//
//        marks = new ArrayList<>();
//        marks.add("Unsatisfactory");
//        marks.add("Satisfactory");   
//        marks.add("Good");          
//        marks.add("Excellent");     
//    }
//}
//
//public class PlanetsList {
//    ArrayList<String> planets;
//    String typeOfList;
//
//    public PlanetsList() {
//        typeOfList = "PLANETS";
//
//        planets = new ArrayList<>();
//        planets.add("Mercury");
//        planets.add("Venus");
//        planets.add("Earth");
//        planets.add("Mars");
//        planets.add("Jupiter");
//        planets.add("Saturn");
//        planets.add("Uran");
//        planets.add("Neptune");
//    }
//}
//
//public class Controller {
//    public static void defineTypeOfList(String[] array) {
//        if (array.length == 0) {
//            System.out.println("Arguments have not been entered");
//        } else {
//            String typeOfList = array[0];
//            switch (typeOfList) {
//                case "MARKS" -> {
//                    MarksList marksList = new MarksList();
//                    printList(marksList, array);
//                }
//                case "WEEK_DAYS" -> {
//                    DaysOfWeekList daysOfWeekList = new DaysOfWeekList();
//                    printList(daysOfWeekList, array);
//                }
//                case "PLANETS" -> {
//                    PlanetsList planetsList = new PlanetsList();
//                    printList(planetsList, array);
//                }
//                default -> System.out.println("Incorrect type of list");
//            }
//        }
//    }
//
//    private static void printList(MarksList marksList, String[] array) {
//        for (String mark : array) {
//            switch (mark) {
//                case "0", "1", "2" -> System.out.println(marksList.marks.get(0));
//                case "3" -> System.out.println(marksList.marks.get(1));
//                case "4" -> System.out.println(marksList.marks.get(2));
//                case "5" -> System.out.println(marksList.marks.get(3));
//                // default -> System.out.println("Incorrect mark");
//            }
//        }
//    }
//
//    private static void printList(PlanetsList planetsList, String[] array) {
//        for (String planet : array) {
//            switch (planet) {
//                case "1" -> System.out.println(planetsList.planets.get(0));
//                case "2" -> System.out.println(planetsList.planets.get(1));
//                case "3" -> System.out.println(planetsList.planets.get(2));
//                case "4" -> System.out.println(planetsList.planets.get(3));
//                case "5" -> System.out.println(planetsList.planets.get(4));
//                case "6" -> System.out.println(planetsList.planets.get(5));
//                case "7" -> System.out.println(planetsList.planets.get(6));
//                case "8" -> System.out.println(planetsList.planets.get(7));
//                // default -> System.out.println("Incorrect name of planet");
//            }
//        }
//    }
//
//Ñåðãåé Èùåðÿêîâ, [12/6/2022 6:59 PM]
//
//
//    private static void printList(DaysOfWeekList daysOfWeekList, String[] array) {
//        for (String day : array) {
//            switch (day) {
//                case "1" -> System.out.println(daysOfWeekList.weekDays.get(0));
//                case "2" -> System.out.println(daysOfWeekList.weekDays.get(1));
//                case "3" -> System.out.println(daysOfWeekList.weekDays.get(2));
//                case "4" -> System.out.println(daysOfWeekList.weekDays.get(3));
//                case "5" -> System.out.println(daysOfWeekList.weekDays.get(4));
//                case "6" -> System.out.println(daysOfWeekList.weekDays.get(5));
//                case "7" -> System.out.println(daysOfWeekList.weekDays.get(6));
//                // default -> System.out.println("Incorrect day of week");
//            }
//        }
//    }
//
//}
//
//Ñåðãåé Èùåðÿêîâ, [12/6/2022 7:26 PM]
//import java.util.List;
//public class Model {
//List&lt;String&gt; weekDays;
//List&lt;String&gt; marks;
//List&lt;String&gt; planets;
//public Model(List&lt;String&gt; weekDays, List&lt;String&gt; marks, List&lt;String&gt; planets) {
//this.weekDays = weekDays;
//this.marks = marks;
//this.planets = planets;
//}
//}
//
//package sigma.main;
//import java.util.ArrayList;
//import java.util.List;
//public class Controller {
//public static List&lt;String&gt; processInput(String[] args, Model model) {
//List&lt;String&gt; result = new ArrayList&lt;&gt;();
//for (int i = 0; i &lt; args.length; i++) {
//if (i &gt; 0) {
//switch (args[0]) {
//case &quot;Planets&quot;:
//switch (Integer.parseInt(args[i])) {
//case 1:
//result.add(model.planets.get(0));
//break;
//case 2:
//result.add(model.planets.get(1));
//break;
//case 3:
//result.add(model.planets.get(2));
//break;
//case 4:
//result.add(model.planets.get(3));
//break;
//case 5:
//result.add(model.planets.get(4));
//break;
//case 6:
//result.add(model.planets.get(5));
//break;
//
//case 7:
//result.add(model.planets.get(6));
//break;
//case 8:
//result.add(model.planets.get(7));
//break;
//default:
//throw new IllegalStateException(&quot;Íåèçâåñòíàÿ ïëàíåòà: &quot; +
//args[i]);
//}
//break;
//case &quot;Week&quot;:
//switch (Integer.parseInt(args[i])) {
//case 1:
//result.add(model.weekDays.get(0));
//break;
//case 2:
//result.add(model.weekDays.get(1));
//break;
//case 3:
//result.add(model.weekDays.get(2));
//break;
//case 4:
//result.add(model.weekDays.get(3));
//break;
//case 5:
//result.add(model.weekDays.get(4));
//break;
//case 6:
//result.add(model.weekDays.get(5));
//break;
//case 7:
//result.add(model.weekDays.get(6));
//break;
//default:
//throw new IllegalStateException(&quot;Íåèçâåñòíûé äåíü íåäåëè: &quot;
//+ args[i]);
//}
//break;
//case &quot;Marks&quot;:
//switch (Integer.parseInt(args[i])) {
//case 0:
//case 1:
//case 2:
//result.add(model.marks.get(0));
//break;
//case 3:
//result.add(model.marks.get(1));
//break;
//
//case 4:
//result.add(model.marks.get(2));
//break;
//case 5:
//result.add(model.marks.get(3));
//break;
//default:
//throw new IllegalStateException(&quot;Íåèçâåñòíàÿ îöåíêà: &quot; +
//args[i]);
//}
//break;
//default:
//throw new IllegalStateException(&quot;Íåèçâåñòíûé âèä ìîäåëè: &quot; +
//args[0]);
//}
//}
//}
//return result;
//}
//}
//
//package sigma.main;
//import java.util.Arrays;
//import java.util.List;
//public class Dispatcher {
//public static void main(String[] args) {
//List&lt;String&gt; weekDays = Arrays.asList(&quot;Monday&quot;, &quot;Tuesday&quot;, &quot;Wednesday&quot;,
//«Thursday&quot;, &quot;Friday&quot;, &quot;Saturday&quot;, &quot;Sunday&quot;);
//List&lt;String&gt; marks = Arrays.asList(&quot;Unsatisfactory&quot;, &quot;Satisfactory&quot;, &quot;Good&quot;,
//&quot;Excellent&quot;);
//List&lt;String&gt; planets = Arrays.asList(&quot;Mercury&quot;, &quot;Venus&quot;, &quot;Earth&quot;, &quot;Mars&quot;,
//«Jupiter&quot;, &quot;Saturn&quot;, &quot;Uran&quot;, &quot;Neptune&quot;);
//Model model = new Model(weekDays, marks, planets);
//// Input: Planets 3 5 6
//// Output: Earth
//// Jupiter
//// Saturn
//List&lt;String&gt; result = Controller.processInput(args, model);
//result.forEach(System.out::println);
//}
//}
//
//Ñåðãåé Èùåðÿêîâ, [12/6/2022 7:39 PM]
//public class Dispatcher {
//    public static void main(String[] args) {
//       Controller.defineDataListAndDisplayValues(args);
//    }
//}
//
//class Controller {
//    public static void defineDataListAndDisplayValues(String[] args) {
//        switch (args[0]) {
//            case "WEEK_DAYS":
//                displayWeekDaysValues(args);
//                break;
//            case "MARKS":
//                displayMarksValues(args);
//                break;
//                case "PLANETS":
//                displayPlanetsValues(args);
//        }
//    }
//
//    private static void displayWeekDaysValues(String[] args) {
//        for (int i = 1; i < args.length; i++) {
//            System.out.println(WeekDays.getWeekDays()
//                    .get(Integer.parseInt(args[i])));
//        }
//    }
//
//    private static void displayMarksValues(String[] args) {
//        for (int i = 1; i < args.length; i++) {
//            System.out.println(Marks.getMarks()
//                    .get(Integer.parseInt(args[i])));
//        }
//    }
//
//    private static void displayPlanetsValues(String[] args) {
//        for (int i = 1; i < args.length; i++) {
//            System.out.println(Planets.getPlanets()
//                    .get(Integer.parseInt(args[i])));
//        }
//    }
//
//}
//
//class Marks {
//    private static String[] marksValue = { "Unsatisfactory", "Satisfactory", "Good", "Excellent" };
//    private static ArrayList<String> marks = createMarksList();
//
//    private static ArrayList<String> createMarksList() {
//        marks = new ArrayList<>();
//        for (int i = 0; i < 6; i++) {
//            if (i < 3) {
//                marks.add(i, Marks.marksValue[0]);
//            } else {
//                marks.add(i, Marks.marksValue[i - 2]);
//            }
//        }
//        return marks;
//    }
//
//    public static ArrayList<String> getMarks() {
//        return marks;
//    }
//}
//
//class Planets {
//    private static String[] planetsValues = { "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uran",
//            "Neptune" };
//    private static ArrayList<String> planets = createWeekDaysList();
//
//    private static ArrayList<String> createWeekDaysList() {
//        planets = new ArrayList<>();
//        for (int i = 0; i < Planets.planetsValues.length; i++) {
//            if (i == 0) {
//                planets.add(i, null);
//            } else {
//                planets.add(i, Planets.planetsValues[i]);
//            }
//        }
//        return planets;
//    }
//
//    public static ArrayList<String> getPlanets() {
//        return planets;
//    }
//}
//
//class WeekDays {
//    private static String[] weekDaysValues = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",
//            "Sunday" };
//    private static ArrayList<String> weekDays = createWeekDaysList();
//
//    private static ArrayList<String> createWeekDaysList() {
//        weekDays = new ArrayList<>();
//        for (int i = 0; i < WeekDays.weekDaysValues.length; i++) {
//            if (i == 0) {
//                weekDays.add(i, null);
//            } else {
//                weekDays.add(i, WeekDays.weekDaysValues[i]);
//            }
//        }
//        return weekDays;
//    }
//
//    public static ArrayList<String> getWeekDays() {
//        return weekDays;
//    }
//}
//
//Evgeniya Lyahovec, [12/6/2022 7:42 PM]
//package sigma.main;
//
//import java.util.List;
//
//public class Model {
//    List<String> weekDays;
//    List<String> marks;
//    List<String> planets;
//
//    public Model(List<String> weekDays, List<String> marks, List<String> planets) {
//        this.weekDays = weekDays;
//        this.marks = marks;
//        this.planets = planets;
//    }
//}
//
//
//package sigma.main;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Controller {
//
//Evgeniya Lyahovec, [12/6/2022 7:42 PM]
//public static List<String> processInput(String[] args, Model model) {
//        List<String> result = new ArrayList<>();
//        for (int i = 0; i < args.length; i++) {
//            if (i > 0) {
//                switch (args[0]) {
//                    case "Planets":
//                        switch (Integer.parseInt(args[i])) {
//                            case 1:
//                                result.add(model.planets.get(0));
//                                break;
//                            case 2:
//                                result.add(model.planets.get(1));
//                                break;
//                            case 3:
//                                result.add(model.planets.get(2));
//                                break;
//                            case 4:
//                                result.add(model.planets.get(3));
//                                break;
//                            case 5:
//                                result.add(model.planets.get(4));
//                                break;
//                            case 6:
//                                result.add(model.planets.get(5));
//                                break;
//                            case 7:
//                                result.add(model.planets.get(6));
//                                break;
//                            case 8:
//                                result.add(model.planets.get(7));
//                                break;
//                            default:
//                                throw new IllegalStateException("Íåèçâåñòíàÿ ïëàíåòà: " + args[i]);
//                        }
//                        break;
//                    case "Week":
//                        switch (Integer.parseInt(args[i])) {
//                            case 1:
//                                result.add(model.weekDays.get(0));
//                                break;
//                            case 2:
//                                result.add(model.weekDays.get(1));
//                                break;
//                            case 3:
//                                result.add(model.weekDays.get(2));
//                                break;
//                            case 4:
//                                result.add(model.weekDays.get(3));
//                                break;
//                            case 5:
//                                result.add(model.weekDays.get(4));
//                                break;
//                            case 6:
//                                result.add(model.weekDays.get(5));
//                                break;
//                            case 7:
//                                result.add(model.weekDays.get(6));
//                                break;
//                            default:
//                                throw new IllegalStateException("Íåèçâåñòíûé äåíü íåäåëè: " + args[i]);
//                        }
//                        break;
//                    case "Marks":
//                        switch (Integer.parseInt(args[i])) {
//                            case 0:
//                            case 1:
//                            case 2:
//                                result.add(model.marks.get(0));
//                                break;
//                            case 3:
//                                result.add(model.marks.get(1));
//                                break;
//                            case 4:
//                                result.add(model.marks.get(2));
//                                break;
//                            case 5:
//                                result.add(model.marks.get(3));
//                                break;
//                            default:
//                                throw new IllegalStateException("Íåèçâåñòíàÿ îöåíêà: " + args[i]);
//                        }
//                        break;
//                    default:
//                        throw new IllegalStateException("Íåèçâåñòíûé âèä ìîäåëè: " + args[0]);
//                }
//            }
//        }
//        return result;
//    }
//}
//
//
//package sigma.main;
//
//Evgeniya Lyahovec, [12/6/2022 7:42 PM]
//import java.util.Arrays;
//import java.util.List;
//
//public class Dispatcher {
//    public static void main(String[] args) {
//        List<String> weekDays = Arrays.asList("Monday", "Tuesday", "Wednesday", «Thursday", "Friday", "Saturday", "Sunday");
//
//        List<String> marks = Arrays.asList("Unsatisfactory", "Satisfactory", "Good", "Excellent");
//
//        List<String> planets = Arrays.asList("Mercury", "Venus", "Earth", "Mars", «Jupiter", "Saturn", "Uran", "Neptune");
//
//        Model model = new Model(weekDays, marks, planets);
//
//        // Input: Planets 3 5 6
//        // Output: Earth
//        //          Jupiter
//        //          Saturn
//
//        List<String> result = Controller.processInput(args, model);
//        result.forEach(System.out::println);
//    }
//}
//
//Ñåðãåé Èùåðÿêîâ, [12/6/2022 7:48 PM]
//import java.util.Arrays;
//import java.util.List;
//
//public class DispatcherForArgMain {
//    public static void main(String[] args) {
//        try {
//            Controller.printArgs(TypeArgs.valueOf(args[0]) ,args);
//        } catch (Exception e) {
//            System.out.println("You write wrong first parameters");
//        }
//    }
//}
//enum TypeArgs {
//    WEEK_DAYS(Arrays.asList("Monday","Tuesday","Wednesday",
//            "Thursday","Friday","Saturday","Sunday"),1),
//    MARKS (Arrays.asList("Unsatisfactory","Unsatisfactory","Unsatisfactory",
//            "Satisfactory","Good","Excellent"),0),
//    PLANETS (Arrays.asList("Mercury","Venus","Earth",
//            "Mars","Jupiter","Saturn","Uran","Neptune"),1);
//    TypeArgs(List<String> listNameParameters, int indexFirstParameters){
//        this.listNameParameters = listNameParameters;
//        this.indexFirstParameters = indexFirstParameters;
//    }
//    List<String> listNameParameters;
//    int indexFirstParameters;
//}
//class Controller {
//    static void printArgs (TypeArgs typeArgs, String[] args) {
//        List<String> listNameParameters = typeArgs.listNameParameters;
//        int indexFirstParameters = typeArgs.indexFirstParameters;
//        for (int i = 1; i < args.length; i++){
//            int index = Integer.parseInt(args[i]);
//            String temp = ((listNameParameters.size() + indexFirstParameters) > index) ?
//                            listNameParameters.get(index-indexFirstParameters) :
//                            "Error index parameters";
//            System.out.println(temp);
//        }
//    };
//}
//
//Ñåðãåé Èùåðÿêîâ, [12/6/2022 7:51 PM]
//Çàâäàííÿ íà 9-å ãðóäíÿ - òåìè 6, 7, 8 (³í³ö³àë³çàö³ÿ, ïàêåòè, íàñë³äóâàííÿ)
//
//Ñåðãåé Èùåðÿêîâ, [12/6/2022 7:58 PM]
//package org.example.SigmaTasks;
//
//import java.util.*;
//
//public class MainTask {
//    public static void main (String[] args) throws Exception {
//        switch(args[0]){
//            case "MARKS":
//                SequenceController.printResultsCollection (args, Mark.values ()[0]);
//                break;
//            case "WEEK_DAYS":
//                SequenceController.printResultsCollection (args, WeekDay.values ()[0]);
//                break;
//            case "PLANETS":
//                SequenceController.printResultsCollection (args, Planet.values ()[0]);
//                break;
//            default:
//                throw new Exception ("No such group exists");
//        }
//    }
//}
//
//class SequenceController {
//    public static <E extends Enum<E> & SequenceOption> void printResultsCollection (String[] args, E e) throws Exception {
//        List<String> results = new ArrayList<> ();
//
//        for(int i =1; i < args.length; i++){
//            results.add (e.getName (Integer.parseInt (args[i]))
//                    .orElseThrow (() -> new Exception ("Wrong value in sequence")));
//        }
//        System.out.println (results);
//    }
//}
//
//interface SequenceOption {
//    Optional<String> getName(int value);
//}
//
//enum Mark implements SequenceOption {
//    UNSATISFACTORY("Unsatisfactory", 0, 2),
//    SATISFACTORY("Satisfactory", 3, 3),
//    GOOD("Good", 4, 4),
//    EXCELLENT("Excellent", 5, 5);
//
//    private String name;
//    private int minValue;
//    private int maxValue;
//
//    Mark(String name, int minValue, int maxValue){
//        this.name = name;
//        this.minValue = minValue;
//        this.maxValue = maxValue;
//    }
//
//    public static Optional<String> getNameByValue (int value){
//        for(Mark mark : Mark.values ()){
//            if(value >= mark.minValue && value <= mark.maxValue){
//                return Optional.of (mark.name);
//            }
//        }
//        return Optional.empty ();
//    }
//
//    @Override
//    public Optional<String> getName (int value){
//        return Mark.getNameByValue (value);
//    }
//}
//
//enum WeekDay implements SequenceOption {
//    MON("Monday", 1),
//    TUES("Tuesday", 2),
//    WED("Wednesday", 3),
//    THURS("Thursday", 4),
//    FRI("Friday", 5),
//    SAT("Saturday", 6),
//    SUN("Sunday", 7);
//
//    private String name;
//    private int position;
//
//    WeekDay(String name, int position){
//        this.name = name;
//        this.position = position;
//    }
//
//    public static Optional<String> getNameByPosition (int position){
//        for(WeekDay weekDay : WeekDay.values ()){
//            if(weekDay.position == position){
//                return Optional.of (weekDay.name);
//            }
//        }
//        return Optional.empty ();
//    }
//
//    @Override
//    public Optional<String> getName (int value){
//        return WeekDay.getNameByPosition (value);
//    }
//}
//
//enum Planet implements SequenceOption {
//    MERCURY("Mercury", 1),
//    VENUS("Venus", 2),
//    EARTH("Earth", 3),
//    MARS("Mars", 4),
//    JUPITER("Jupiter", 5),
//    SATURN("Saturn", 6),
//    URAN("Uran", 7),
//    NEPTUNE("Neptune", 8);
//
//    private String name;
//    private int position;
//
//    Planet(String name, int position){
//        this.name = name;
//        this.position = position;
//    }
//
//    public static Optional<String> getNameByPosition (int position){
//        for(Planet planet : Planet.values ()){
//            if(planet.position == position){
//                return Optional.of(planet.name);
//            }
//        }
//        return Optional.empty ();
//    }
//
//    @Override
//    public Optional<String> getName (int value){
//        return Planet.getNameByPosition (value);
//    }
//}