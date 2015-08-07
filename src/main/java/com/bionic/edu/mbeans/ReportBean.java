package com.bionic.edu.mbeans;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.extra.ReportByCategories;
import com.bionic.edu.extra.ReportByDays;
import com.bionic.edu.service.OrderItemService;

@Named
@Scope("request")
public class ReportBean {

	@Inject
	private OrderItemService orderItemService;

	private List<ReportByDays> report;
	private List<ReportByCategories> reportByCategories;
	private Date startDate;
	private Date endDate;

	public void viewReportByDays() {

		System.out.println(startDate);
		System.out.println(endDate);

		java.sql.Date sDate = new java.sql.Date(startDate.getTime());
		java.sql.Date eDate = new java.sql.Date(endDate.getTime());

		report = orderItemService.getReportByDays(sDate, eDate);
		reportByCategories = orderItemService.getReportByCategories(sDate,
				eDate);
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

}
