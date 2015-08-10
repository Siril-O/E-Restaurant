package com.bionic.edu.mbeans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.springframework.context.annotation.Scope;

import com.bionic.edu.extra.ReportByCategories;
import com.bionic.edu.extra.ReportByDays;
import com.bionic.edu.service.OrderItemService;

@Named
@Scope("request")
public class ReportBean {

	@Inject
	private OrderItemService orderItemService;

	private LineChartModel quantityDateModel;

	private List<ReportByDays> report;
	private List<ReportByCategories> reportByCategories;
	private Date startDate;
	private Date endDate;

	private void createQuantityDateModel() {
		quantityDateModel = new LineChartModel();
		LineChartSeries quantitySeries = new LineChartSeries();
		quantitySeries.setLabel("Order Quantity");

		for (ReportByDays item : report) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String stringDate = sdf.format(item.getOrderDate());

			quantitySeries.set(stringDate, item.getOrderQuantity());
		}

		// LineChartSeries summSeries = new LineChartSeries();
		// summSeries.setLabel("Order Summs");
		//
		// for (ReportByDays item : report) {
		// quantitySeries.set(item.getOrderDate(), item.getTotalSumm());
		// }
		quantityDateModel.addSeries(quantitySeries);
		// quantityDateModel.addSeries(summSeries);

		quantityDateModel.setTitle("Zoom for Details");
		quantityDateModel.setZoom(true);
		quantityDateModel.getAxis(AxisType.Y).setLabel("Values");
		DateAxis axis = new DateAxis("Dates");
		axis.setTickAngle(-50);
		Date maxDate = new Date(new Date().getDay() + 1);
		axis.setMax("2015-08-07");
		axis.setTickFormat("%b , %y");

		quantityDateModel.getAxes().put(AxisType.X, axis);
	}

	public void viewReport() {
		java.sql.Date sDate = new java.sql.Date(startDate.getTime());
		java.sql.Date eDate = new java.sql.Date(endDate.getTime());

		report = orderItemService.getReportByDays(sDate, eDate);
		reportByCategories = orderItemService.getReportByCategories(sDate,
				eDate);
	}

	public String viewReportChart() {
		viewReport();
		createQuantityDateModel();
		return "reportChart";
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

}
