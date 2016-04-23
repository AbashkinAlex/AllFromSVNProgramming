package dao;

import model.Report;

import java.util.List;


/**
 * Created by Abashkin Alexandr on 16.03.2015.
 */
public interface ReportDao {
    boolean createReport(Report user);
    Report readReport(long id);
    List<Report> readAll();
    boolean updateReport(Report user);
    boolean deleteReport(long id);
}
