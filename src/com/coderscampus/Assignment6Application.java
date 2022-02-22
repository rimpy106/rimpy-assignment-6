package com.coderscampus;

import java.text.ParseException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Assignment6Application {

	public static void main(String[] args) throws ParseException {
		FileService fileService = new FileService();

		List<SalesData> model3Data = fileService.csvReader("model3.csv");
		List<SalesData> modelSData = fileService.csvReader("modelS.csv");
		List<SalesData> modelXData = fileService.csvReader("modelX.csv");

		displayYearlySalesReportData(model3Data, "Model 3");
		displayYearlySalesReportData(modelSData, "Model S");
		displayYearlySalesReportData(modelXData, "Model X");

	}

	public static void displayYearlySalesReportData(List<SalesData> modelSalesData, String modelType) {
		System.out.println(modelType + "  Yearly Sales Report");
		System.out.println("-------------------------");
		Map<Integer, List<SalesData>> groupedByYear = modelSalesData.stream()
				                                                    .collect(Collectors.groupingBy(yyData -> yyData.getSalesdate().getYear()));
		// System.out.println(groupedByYear);

		String yearlySalesData = groupedByYear.entrySet().stream()
				                                         .map(data -> data.getKey() + " -> "+ data.getValue().stream()
				                                        		                                            .collect(Collectors.summingInt(SalesData::getSalesAmount)))
				                                         .collect(Collectors.joining("\n"));
		System.out.println(yearlySalesData + "\n");

		Optional<SalesData> maxSalesData = modelSalesData.stream()
				                                         .max(Comparator.comparing(SalesData::getSalesAmount));
		Optional<SalesData> minSalesData = modelSalesData.stream()
                                                         .min(Comparator.comparing(SalesData::getSalesAmount));
		
		System.out.println("The best month for " + modelType + " was: " + maxSalesData.get().getSalesdate());
		System.out.println("The worst month for " + modelType + " was: " + minSalesData.get().getSalesdate());
		System.out.println();

	}

}
