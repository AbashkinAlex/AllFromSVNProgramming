package services;

import dao.ReportDao;
import dao.imp.ReportDaoImpl;
import model.Book;
import model.Report;
import model.User;

import java.util.ArrayList;
import java.util.Date;


/**
 * Created by Abashkin Alexandr on 16.03.2015.
 */
public class ReportServices {
    private static long id = 2000;

    public boolean addReport(Book book, User user, Date date) {
        ReportDao reportDao = new ReportDaoImpl();
        return reportDao.createReport(new Report(id++, book, user, date));
    }


    public ArrayList<Report> getHistoryBook(String title){
        ReportDao reportDao = new ReportDaoImpl();
        ArrayList<Report> bookArrayList = new ArrayList<Report>();
        for (Report report : reportDao.readAll()) {
            if (report.getBook().getTitle().equals(title)){
                bookArrayList.add(report);
            }
        }
        return bookArrayList;
    }


    public ArrayList<Report> getHistoryUser(User user){
        ReportDao reportDao = new ReportDaoImpl();
        ArrayList<Report> userArrayList = new ArrayList<Report>();
        for (Report report : reportDao.readAll()) {
            if (report.getUser().getName().equals(user.getName())){
                userArrayList.add(report);
            }
        }
        return userArrayList;
    }

}
