package main.java.com.ua.lab.homework;

import lombok.SneakyThrows;

import java.io.*;
import java.util.*;

public class Dispatcher {
    private static final String regex = " ";
    private static final String[] bottleFields = {"N", "Bottle", "Volume", "Material"};
    // folder for three files
    private static final String dir = "E:\\lab\\sigma\\Rectangle\\src\\main\\resources\\";

    private static List<Bottle> quart = new ArrayList<>();
    private static List<Bottle> half = new ArrayList<>();
    private static List<Bottle> point = new ArrayList<>();

    private static final String ext = ".csv";
//    private static final String newPath = dir + "new.csv";
//    private static final String dataPath = dir + "data.csv";

    static Bottle[] bottles = {new Bottle(), new Bottle(), new Bottle(), new Bottle(), new Bottle(), new Bottle()};

    public static void main(String[] args) {

        String[] fraction = {"quart", "half", "point", "generated"};

        String[] csvFiles;
        File file = new File(dir);
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File f, String name) {
                return name.endsWith(ext);
            }
        };
        csvFiles = file.list(filter);
        System.out.printf("Filtered by CSV = %s%n", Arrays.toString(csvFiles));

        for (String csvFile : csvFiles) {
            readFile(csvFile);
        }

        saveToFile(quart, fraction[0]);
        saveToFile(half, fraction[1]);
        saveToFile(point, fraction[2]);
        saveToFile(List.of(bottles), fraction[3]);

//        Controller.sorting(List.of(bottles), "volume");
//        List.of(bottles).forEach(System.out::println);
//
//        Controller.sorting(List.of(bottles), "material");
//        List.of(bottles).forEach(System.out::println);
//
//        Controller.sorting(List.of(bottles), "drink");
//        List.of(bottles).forEach(System.out::println);

    }

    private static void saveToFile(List<Bottle> bottles, String fileName) {

        try (FileWriter csvWriter = new FileWriter(dir + fileName + ext)) {

            for (String field : bottleFields) {
                csvWriter.append(field).append(" ");
            }

            csvWriter.append("\n");

            for (Bottle bottle : bottles) {
                csvWriter.append(String.format(
                        "%s %s %s %s%n",
                        bottle.getId(), bottle.getDrink(), bottle.getVolume(), bottle.getMaterial()));
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            System.out.println("Files not found. ");
        }

    }

    private static void readFile(String csvFile) {
        try (FileReader fileReader = new FileReader(dir + csvFile);
             BufferedReader csvReader = new BufferedReader(fileReader)) {
            String row;
            while ((row = csvReader.readLine()) != null) {
                parseFile(csvFile, row.split(regex));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    @SneakyThrows
    private static void parseFile(String csvFile, String[] split) {
        int n = split.length;
        int step = 6;

        if (split.length <= 5) {
//            System.out.printf("%s: ", csvFile);
            bottleMapper(new Bottle(), split);
        } else {
            System.out.printf("%s -> %s%n", Arrays.toString(split), csvFile);


            for (int i = 0; i < n; i++) {
                if (csvFile.startsWith("material")) {
                    bottles[i].setMaterial(split[i]);
                }
                if (csvFile.startsWith("drink")) {
                    bottles[i].setLiquid(split[i]);
                }
                if (csvFile.startsWith("volume")) {
                    bottles[i].setVolume(Double.parseDouble(split[i]));
                }
            }

        }
    }

    private static void bottleMapper(Bottle bottle, String[] data) {
        if (data.length != 0) {
            for (int n = 1; n <= data.length; n++) {
                if (n % 4 == 1) {
                    try {
                        bottle.setId(Integer.parseInt(data[n - 1]));
                    } catch (NumberFormatException e) {
                        break;
                    }
                } else if (n % 4 == 2) {
                    bottle.setLiquid(data[n - 1]);
                } else if (n % 4 == 3) {
                    try {
                        double volume = Double.parseDouble(data[n - 1]);
                        bottle.setVolume(volume);
                        bottle.setCapacity(volume);
                    } catch (NumberFormatException e) {
                        break;
                    }
                } else if (n % 4 == 0) {
                    bottle.setMaterial(data[n - 1]);
                    bottle.setFull(true);
                }
            }
            if (bottle.getId() != null) {

                if (bottle.getCapacity() == 1) {
                    quart.add(bottle);
                } else if (bottle.getCapacity() == 2) {
                    half.add(bottle);
                } else if (bottle.getCapacity() == 3) {
                    point.add(bottle);
                }
            }
        }
    }

    private static void create(String pathFile) {
        File csvFile = new File(dir + pathFile);
        if (!csvFile.isFile()) {
            System.out.printf("Can`t create the file %s%n", pathFile);
        }
    }
}

class Controller {
    public static void sorting(List<Bottle> bottles, String string) {
        switch (string) {
            case "material":
                bottles.sort(new Bottle.SortByMaterial());
                break;
            case "drink":
                bottles.sort(new Bottle.SortByDrink());
                break;
            case "volume":
                bottles.sort(new Bottle.SortByVolume());
                break;
            default:
                Collections.sort(bottles);
        }
    }
}

class Bottle implements Comparable<Bottle> {

    protected static int referenceCount = 0;
    private Double volume;
    private String material;
    private String drink;
    private boolean full;
    //order 1: 0,5; 2: 0.51-0.99; 3: 1.0
    private int capacity;
    private int id;

    public Bottle() {
        setId(++referenceCount);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(double volume) {
        this.capacity = volume < 0.5 ? 1 : volume >= 0.5 && volume < 1 ? 2 : 3;
    }

    public Integer getId() {
        return id;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDrink() {
        return drink;
    }

    public void setLiquid(String liquid) {
        this.drink = liquid;
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bottle{");
        stringBuilder.append("id=");
        stringBuilder.append(id);
        stringBuilder.append(", volume=");
        stringBuilder.append(volume);
        stringBuilder.append(", measure=");
        stringBuilder.append(capacity);
        stringBuilder.append(", material='");
        stringBuilder.append(material);
        stringBuilder.append('\'');
        stringBuilder.append(", liquid='");
        stringBuilder.append(drink);
        stringBuilder.append('\'');
        stringBuilder.append(", full=");
        stringBuilder.append(full);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void setId(int parseInt) {
        this.id = parseInt;
    }

    @Override
    public int compareTo(Bottle other) {
        int result = this.drink.compareTo(other.drink) != 0
                ? this.drink.compareTo(other.drink)
                : this.material.compareTo(other.material);

        return result != 0 ? result : (this.volume.compareTo(other.volume));
    }

    public static class SortByVolume implements Comparator<Bottle> {
        @Override
        public int compare(Bottle a, Bottle b) {
            int result = a.getDrink().compareTo(b.getDrink()) != 0
                    ? a.getDrink().compareTo(b.getDrink())
                    : a.getMaterial().compareTo(b.getMaterial());

            return result != 0 ? result : a.getVolume().compareTo(b.getVolume());
        }
    }

    public static class SortByDrink implements Comparator<Bottle> {
        @Override
        public int compare(Bottle a, Bottle b) {
            int result = a.getMaterial().compareTo(b.getMaterial()) != 0
                    ? a.getMaterial().compareTo(b.getMaterial())
                    : a.getVolume().compareTo(b.getVolume());
            return result != 0 ? result : a.getDrink().compareTo(b.getDrink());
        }
    }

    public static class SortByMaterial implements Comparator<Bottle> {

        @Override
        public int compare(Bottle a, Bottle b) {
            int result = a.getDrink().compareTo(b.getDrink()) != 0
                    ? a.getDrink().compareTo(b.getDrink())
                    : a.getVolume().compareTo(b.getVolume());

            return result != 0 ? result : a.getMaterial().compareTo(b.getMaterial());
        }
    }
}
