package dao.imp;

import dao.ReportDao;
import model.Report;
import utils.GenericStorage;

import java.util.List;


/**
 * Created by Abashkin Alexandr on 16.03.2015.
 */
public class ReportDaoImpl implements ReportDao {

    final private static GenericStorage<Long, Report> reportGenericStorage = new GenericStorage<Long, Report>();

    @Override
    public boolean createReport(Report report) {
        return reportGenericStorage.put(report.getId(), report);
    }

    @Override
    public Report readReport(long id) {
        return reportGenericStorage.get(id);
    }

    @Override
    public List<Report> readAll() {
        return reportGenericStorage.getAll();
    }

    @Override
    public boolean updateReport(Report report) {
        if(readReport(report.getId()) != null){
            Report tempUser = reportGenericStorage.get(report.getId());
            deleteReport(report.getId());
            if(!createReport(report)){
                createReport(tempUser) ;
            }else{
                return  true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteReport(long id) {
        return reportGenericStorage.delete(id);
    }
}
