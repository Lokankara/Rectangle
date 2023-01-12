//package com.homework.io;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
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
////        - by Volume, in case of equality вЂ“ by Material, in case of equality вЂ“ by Bottle (main method),
////        - by Bottle, in case of equality - by Volume, in case of equality - by Material,
////        - by Material, in case of equality вЂ“ by Volume, in case of equality вЂ“ by Bottle.
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
//	private static final String regex = " ";
//	private static final String[] bottleFields = { "N", "Bottle", "Volume", "Material" };
//	// folder for three files
//	private static final String dir = "c:\\Users\\PPoliak\\eclipse-workspace\\lab\\src\\main\\resources\\";
//
//	private static List<Bottle> quart = new ArrayList<>();
//	private static List<Bottle> half = new ArrayList<>();
//	private static List<Bottle> point = new ArrayList<>();
//	
//	private static final String ext = ".csv";
//	private static final String newPath = dir + "new.csv";
//	private static final String dataPath = dir + "data.csv";
//
//	public static void main(String[] args) throws IOException {
//
//		String[] fraction = {"quart", "half", "point"};
//		
//		String[] csvFiles;
//		File file = new File(dir);
//		FilenameFilter filter = new FilenameFilter() {
//			@Override
//			public boolean accept(File f, String name) {
//				return name.endsWith(ext);
//			}
//		};
//		csvFiles = file.list(filter);
//		System.out.printf("Filtered by CSV = %s%n", Arrays.toString(csvFiles));
//
//		for (String csvFile : csvFiles) {
//			readFile(csvFile);
//		}
//		saveToFile(quart, fraction[0]);
//		saveToFile(half, fraction[1]);
//		saveToFile(point, fraction[2]);
//	}
//
//	private static void saveToFile(List<Bottle> bottles, String fileName) throws IOException {
//
//    	FileWriter csvWriter = new FileWriter(dir + fileName+ext);
//		for (String field : bottleFields) {
//			csvWriter.append(field).append(" ");
//		}
//		csvWriter.append("\n");
//		
//    	for(Bottle bottle: bottles) {
//      		csvWriter.append(String.format("%s %s %s %s%n", bottle.getId(), bottle.getLiquid(), bottle.getVolume(), bottle.getMaterial()));
//    	}
//    	
////
////      for (String column : bottleFields) {
////          csvWriter.append(column).append(" ");
////      }
////      csvWriter.append(bottleFields[bottleFields.length - 1]).append("\n");
////
////      List<List<String>> rows = Arrays.asList(
////              Arrays.asList(String.format("%d", ++n), "Juice", "1.5", "Paper"),
////              Arrays.asList(String.format("%d", ++n), "Bear", "0.33", "Metal"),
////              Arrays.asList(String.format("%d", ++n), "Water", "0.95", "Plastic"));
////
////      for (List<String> rowData : rows) {
////          csvWriter.append(String.join(" ", rowData));
////          csvWriter.append("\n");
////      }
//
//      csvWriter.flush();
//      csvWriter.close();
//		
//	}
//
//	private static void readFile(String csvFile) {
//		try (FileReader fileReader = new FileReader(dir + csvFile);
//				BufferedReader csvReader = new BufferedReader(fileReader)) {
//			String row;
//			while ((row = csvReader.readLine()) != null) {
//				parseFile(csvFile, row.split(regex));
//			}
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		}
//	}
//
//	private static void parseFile(String csvFile, String[] split) {
////        System.out.printf("%s -> %s%n", Arrays.toString(split), csvFile);
//		if (split.length <= 5) {
////            System.out.printf("%s: ", csvFile);
//			bottleMapper(new Bottle(), split);
//		} else {
//			
////			System.out.printf("%s -> %s%n", Arrays.toString(split), csvFile);
//			int n = split.length;
//			
//			for (String s : split) {
//				
//				System.out.printf("%s%n", s);
//			}
//		}
//	}
//
////        readFromFile(dataPath);
////        readFromFile(newPath);
////
////        int n = lines.size();
////
////    }
//
//	private static void bottleMapper(Bottle bottle, String[] data) {
//		if (data.length != 0) {
//			for (int n = 1; n <= data.length; n++) {
//				if (n % 4 == 1) {
//					try {
//						bottle.setId(Integer.parseInt(data[n - 1]));
//					} catch (NumberFormatException e) {
//						break;
//					}
//				} else if (n % 4 == 2) {
//					bottle.setLiquid(data[n - 1]);
//				} else if (n % 4 == 3) {
//					try {
//						double volume = Double.parseDouble(data[n - 1]);
//						bottle.setVolume(volume);
//						bottle.setCapacity(volume);
//					} catch (NumberFormatException e) {
//						break;
//					}
//				} else if (n % 4 == 0) {
//					bottle.setMaterial(data[n - 1]);
//					bottle.setFull(true);
//				}
//			}
//			if (bottle.getId() != null) {
//
//				if (bottle.getCapacity() == 1) {
//					quart.add(bottle);
//				} else if (bottle.getCapacity() == 2) {
//					half.add(bottle);
//				} else if (bottle.getCapacity() == 3) {
//					point.add(bottle);
//				}
//			}
//		}
//	}
//}
