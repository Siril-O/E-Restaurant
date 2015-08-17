package com.bionic.edu.mbeans;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.context.annotation.Scope;

import com.bionic.edu.extra.ReportByCategories;
import com.bionic.edu.extra.ReportByDays;
import com.bionic.edu.service.OrderItemService;

@Named
@Scope("request")
public class ReportBean {

	@Inject
	private OrderItemService orderItemService;

	private LineChartModel quantityDateModel = new LineChartModel();
	private LineChartModel summDateModel = new LineChartModel();
	private PieChartModel quantityCategoryModel = new PieChartModel();
	private PieChartModel summCategoryModel = new PieChartModel();

	private List<ReportByDays> report;
	private List<ReportByCategories> reportByCategories;
	private Date startDate;
	private Date endDate;

	private void createQuantityDateModel() {
		Map<Date, Number> map = new HashMap<>();
		for (ReportByDays item : report) {
			map.put(item.getOrderDate(), item.getOrderQuantity());
		}
		createDateModel(map, quantityDateModel, "Orders Quantity");
	}

	private void createSummDateModel() {
		Map<Date, Number> map = new HashMap<>();
		for (ReportByDays item : report) {
			map.put(item.getOrderDate(), item.getTotalSumm());
		}
		createDateModel(map, summDateModel, "Orders Total Summ");
	}

	private void createQuantityCategoryModel() {
		for (ReportByCategories item : reportByCategories) {
			quantityCategoryModel.set(item.getCategory().getName(),
					item.getOrderQuantity());
		}
		quantityCategoryModel.setTitle("OrdersQuantity by categories");
		quantityCategoryModel.setLegendPosition("w");
		quantityCategoryModel.setShowDataLabels(true);
	}

	private void createSummCategoryModel() {
		for (ReportByCategories item : reportByCategories) {
			summCategoryModel.set(item.getCategory().getName(),
					item.getTotalSumm());
		}
		summCategoryModel.setTitle("Orders Total Summ by categories");
		summCategoryModel.setLegendPosition("w");
		summCategoryModel.setShowDataLabels(true);
	}

	private void createDateModel(Map<Date, Number> map, LineChartModel model,
			String label) {
		LineChartSeries series = new LineChartSeries();
		series.setLabel(label);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		for (Map.Entry<Date, Number> item : map.entrySet()) {
			series.set(sdf.format(item.getKey()), item.getValue());
		}
		model.addSeries(series);
		model.setTitle(label);
		model.getAxis(AxisType.Y).setLabel(label);
		DateAxis axis = new DateAxis("Dates");
		axis.setTickAngle(-50);
		Date maxDate = java.sql.Date.valueOf(LocalDate.now().plusDays(2));
		axis.setMax(sdf.format(maxDate));
		axis.setTickFormat("%b %#d, %y");
		model.getAxes().put(AxisType.X, axis);
	}

	public void viewReport() {
		java.sql.Date sDate = new java.sql.Date(startDate.getTime());
		java.sql.Date eDate = new java.sql.Date(endDate.getTime());

		report = orderItemService.getReportByDays(sDate, eDate);
		System.out.println(report);
		reportByCategories = orderItemService.getReportByCategories(sDate,
				eDate);
		createQuantityDateModel();
		createSummDateModel();
		createQuantityCategoryModel();
		createSummCategoryModel();
	}

	public String viewReportPage() {
		return "report";
	}

	/**
	 * @return the report
	 */
	public List<ReportByDays> getReport() {
		return report;
	}

	/**
	 * @param report
	 *            the report to set
	 */
	public void setReport(List<ReportByDays> report) {
		this.report = report;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the reportByCategories
	 */
	public List<ReportByCategories> getReportByCategories() {
		return reportByCategories;
	}

	/**
	 * @param reportByCategories
	 *            the reportByCategories to set
	 */
	public void setReportByCategories(
			List<ReportByCategories> reportByCategories) {
		this.reportByCategories = reportByCategories;
	}

	/**
	 * @return the quantityDateModel
	 */
	public LineChartModel getQuantityDateModel() {
		return quantityDateModel;
	}

	/**
	 * @param quantityDateModel
	 *            the quantityDateModel to set
	 */
	public void setQuantityDateModel(LineChartModel quantityDateModel) {
		this.quantityDateModel = quantityDateModel;
	}

	/**
	 * @return the summDateModel
	 */
	public LineChartModel getSummDateModel() {
		return summDateModel;
	}

	/**
	 * @param summDateModel
	 *            the summDateModel to set
	 */
	public void setSummDateModel(LineChartModel summDateModel) {
		this.summDateModel = summDateModel;
	}

	/**
	 * @return the quantityCategoryModel
	 */
	public PieChartModel getQuantityCategoryModel() {
		return quantityCategoryModel;
	}

	/**
	 * @param quantityCategoryModel
	 *            the quantityCategoryModel to set
	 */
	public void setQuantityCategoryModel(PieChartModel quantityCategoryModel) {
		this.quantityCategoryModel = quantityCategoryModel;
	}

	/**
	 * @return the summCategoryModel
	 */
	public PieChartModel getSummCategoryModel() {
		return summCategoryModel;
	}

	/**
	 * @param summCategoryModel
	 *            the summCategoryModel to set
	 */
	public void setSummCategoryModel(PieChartModel summCategoryModel) {
		this.summCategoryModel = summCategoryModel;
	}

}
