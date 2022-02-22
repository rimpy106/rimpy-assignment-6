package com.coderscampus;

import java.text.ParseException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class SalesData {
	private YearMonth salesdate;
	private Integer salesAmount;

	public SalesData(String salesdate, String salesAmount) throws ParseException {
		this.salesdate = YearMonth.parse(salesdate, DateTimeFormatter.ofPattern("MMM-yy"));
		this.salesAmount = Integer.parseInt(salesAmount);
	}

	public YearMonth getSalesdate() {
		return salesdate;
	}

	public void setSalesdate(YearMonth salesdate) {
		this.salesdate = salesdate;
	}

	public int getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(int salesAmount) {
		this.salesAmount = salesAmount;
	}

	@Override
	public String toString() {
		return "SalesData [salesdate=" + salesdate + ", salesAmount=" + salesAmount + "]";
	}

}
