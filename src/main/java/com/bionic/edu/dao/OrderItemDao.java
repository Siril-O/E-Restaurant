package com.bionic.edu.dao;

import java.sql.Date;
import java.util.List;

import com.bionic.edu.extra.ReportByCategories;
import com.bionic.edu.extra.ReportByDays;

public interface OrderItemDao {

	public void updateStaus(int id, boolean status);

	public List<ReportByDays> getReportByDays(Date startDate, Date endDate);

	public List<ReportByCategories> getReportByCategories(Date startDate, Date endDate);
}
