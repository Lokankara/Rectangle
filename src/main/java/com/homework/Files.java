package com.homework;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Files {
    public static final String path = "E:\\lab\\sigma\\rectangle\\src\\main\\resources\\data.csv";
    public static final String newPath = "E:\\lab\\sigma\\rectangle\\src\\main\\resources\\new.csv";
    public static final String regex = " ";
    public static final List<String[]> lines = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		readFromFile(path);
		readFromFile(newPath);

		lines.stream().map(Arrays::toString).forEach(System.out::println);

//        create();
		List<Bottle> bottles = new ArrayList<>();
		List<List<String>> stream = createStream();

		System.out.println(stream);

		int n = lines.size();

		List<List<String>> rows = Arrays.asList(Arrays.asList(String.format("%d", ++n), "Juice", "1.5", "Paper"),
				Arrays.asList(String.format("%d", ++n), "Bear", "0.33", "Metal"),
				Arrays.asList(String.format("%d", ++n), "Water", "0.95", "Plastic"));

		FileWriter csvWriter = new FileWriter(newPath);
		String[] column = { "N", "Bottle", "Volume", "Material" };
		
		for(String s : )

		csvWriter.append(column[0]).append(",");
		csvWriter.append(column[1]).append(",");
		csvWriter.append(column[2]).append(",");
		csvWriter.append(column[3]).append("\n");

		for (List<String> rowData : rows) {
			csvWriter.append(String.join(" ", rowData));
			csvWriter.append("\n");
		}

		csvWriter.flush();
		csvWriter.close();
	}

    private static void readFromFile(String url) throws IOException {
        try (FileReader fileReader = new FileReader(url);
             BufferedReader csvReader = new BufferedReader(fileReader)) {
            String row;
            Bottle bottle = new Bottle();
            while ((row = csvReader.readLine()) != null) {

                String[] data = row.split(regex);
                bottleMapper(bottle, data);
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
                        bottle.setVolume(Double.parseDouble(data[n - 1]));
                        bottle.setMeasure(Double.parseDouble(data[n - 1]));
                    } catch (NumberFormatException e) {
                        break;
//                                bottle.setVolume(0D);
                    }
                } else if (n % 4 == 0) {
                    bottle.setMaterial(data[n - 1]);
                    bottle.setFull(true);
                }
            }

            if (bottle.getId() != null) {
                System.out.println(bottle);
            }
            lines.add(data);
        }
    }

    private static void create() {
        File csvFile = new File(path);
        if (!csvFile.isFile()) {
            System.out.printf("Can`t upload the file %s%n", path);
        }
    }

    private static List<List<String>> createStream() {
        try (BufferedReader csvReader = new BufferedReader(new FileReader(path))) {
            return csvReader.lines()
                    .map(row -> row.split(regex))
                    .map(Arrays::asList)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.printf("Can`t open the file %s%n", path);
            return new ArrayList<>();
        }
    }
}
//TODO
//                Stream<Bottle> bottleStream = csvReader.lines()
//                        .map(eachLine -> eachLine.split(CSV_DELIMETER))
//                        .map(eachRecord -> bottleMapper.mapToBottle(eachRecord));

