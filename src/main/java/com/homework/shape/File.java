//package com.homework;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;
//
////Program task. Read and process data from three existing files and enter
////        processed data into files created by Java tools.
////        1. Existing files contain information about arbitrary bottles in the following format:
////        N Bottle Volume Material (class file Bottle)
////2. Contents of data processing from files:
////        - read data from existing files, (csv files)
////        - create three files in which to enter bottles with a capacity of no more than 0.5 (the first
////        file), in the range from 0.51 to 0.99 (second file), not less than 1.0 (third file),
////        - sort the bottles in all created files according to one of three options:
////        - by Volume, in case of equality – by Material, in case of equality – by Bottle (main method),
////        - by Bottle, in case of equality - by Volume, in case of equality - by Material,
////        - by Material, in case of equality – by Volume, in case of equality – by Bottle.
////- the sorting method can be set in any way (Scanner, String[] args array of the method
////        main, etc.).
////        3. Save the files in the InputFiles, OutputFiles directories.
////        4. Provide for the output of the necessary information in case of Exceptions
////        working with files.
////        5. Use the split() class method to convert a text string into a Strings array
////        String. To convert text variables into numeric ones, use the parseDouble() method
////class Double.
//
//public class Files {
//    public static final String[] columns = {"N", "Bottle", "Volume", "Material"};
//    public static final String dir = "E:\\lab\\sigma\\rectangle\\src\\main\\resources\\";
//    public static final String dataPath = new StringBuilder().append(dir).append("data.csv").toString();
//    public static final String regex = " ";
//    public static final List<String[]> lines = new ArrayList<>();
//
//    static Predicate<Integer> less = i -> i < 0.5;
//    static Predicate<Integer> between = i -> 0.5 > i && i < 1;
//    static Predicate<Integer> most = i -> i > 1.0;
//
//    public static void main(String[] args) throws IOException {
//
//        readFromFile("drink.csv");
////        readFromFile("volume.csv");
//        readFromFile("material.csv");
//        readFromFile("shop.csv");
////        readFromFile(dir + "data.csv");
////        readFromFile(dir + "new.csv");
//
////        upload();
//
////        lines.stream().map(Arrays::toString).forEach(System.out::println);
//
//
////        List<List<String>> stream = createStream();
////
////        System.out.println(stream);
//
//        int n = 1;
////        int n = lines.size();
//
//        List<List<String>> rows = Arrays.asList(
//                Arrays.asList(String.format("%d", ++n), "Juice", "1.5", "Paper"),
//                Arrays.asList(String.format("%d", ++n), "Bear", "0.33", "Metal"),
//                Arrays.asList(String.format("%d", ++n), "Water", "0.95", "Plastic"));
//
//        writeRows(rows, new FileWriter(dir + "new.csv"));
//    }
//
//    private static void writeRows(List<List<String>> rows, FileWriter csvWriter) throws IOException {
//
//        for (int i = 0; i < columns.length - 1; i++) {
//            String column = columns[i];
//            csvWriter.append(column).append(",");
//        }
//        csvWriter.append(columns[columns.length - 1]).append("\n");
//
//        for (List<String> rowData : rows) {
//            csvWriter.append(String.join(" ", rowData));
//            csvWriter.append("\n");
//        }
//
//        csvWriter.flush();
//        csvWriter.close();
//    }
//
//    private static void readFromFile(String file) throws IOException {
//        List<Bottle> bottles = new ArrayList<>();
//
//        try (FileReader fileReader = new FileReader(dir.concat(file));
//             BufferedReader csvReader = new BufferedReader(fileReader)) {
//
//            String row;
//            while ((row = csvReader.readLine()) != null) {
//                Bottle bottle = bottleMapper(new Bottle(), row.split(regex));
//                if (bottle.getId() != null) {
//                    bottles.add(bottle);
//                }
//            }
//            System.out.println(bottles);
//        }
//    }
//
//    private static Bottle bottleMapper(Bottle bottle, String[] data) {
//
//        if (data.length != 0) {
//            for (int n = 1; n <= data.length; n++) {
//                if (n % 4 == 1) {
//                    try {
//                        bottle.setId(Integer.parseInt(data[n - 1]));
//                    } catch (NumberFormatException e) {
//                        break;
//                    }
//                } else if (n % 4 == 2) {
//                    bottle.setLiquid(data[n - 1]);
//                } else if (n % 4 == 3) {
//                    try {
//                        bottle.setVolume(Double.parseDouble(data[n - 1]));
//                        bottle.setMeasure(Double.parseDouble(data[n - 1]));
//                    } catch (NumberFormatException e) {
//                        break;
////                                bottle.setVolume(0D);
//                    }
//                } else if (n % 4 == 0) {
//                    bottle.setMaterial(data[n - 1]);
//                    bottle.setFull(true);
//                }
//            }
//            lines.add(data);
//        }
//        return bottle;
//    }
//
////    private static void upload(String path) {
////        File csvFile = new File(dir + path);
////        if (!csvFile.isFile()) {
////            System.out.printf("Can`t upload the file %s%n", dir + path);
////        }
////    }
//
//    private static List<List<String>> createStream() {
//        try (BufferedReader csvReader = new BufferedReader(new FileReader(dataPath))) {
//            return csvReader.lines()
//                    .map(row -> row.split(regex))
//                    .map(Arrays::asList)
//                    .collect(Collectors.toList());
//        } catch (IOException e) {
//            System.out.printf("Can`t open the file %s%n", dataPath);
//            return new ArrayList<>();
//        }
//    }
//}
////TODO
////                Stream<Bottle> bottleStream = csvReader.lines()
////                        .map(eachLine -> eachLine.split(CSV_DELIMETER))
////                        .map(eachRecord -> bottleMapper.mapToBottle(eachRecord));
//
