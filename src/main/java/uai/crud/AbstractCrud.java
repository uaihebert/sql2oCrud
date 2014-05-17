package uai.crud;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AbstractCrud {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/CRUD";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static final Sql2o sql2o = new Sql2o(DB_URL, USER, PASS);

    protected static Connection getOpenedConnection(){
        return sql2o.open();
    }

    protected static Date parseDate(String dateToBeParsed){
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return format.parse(dateToBeParsed);
        } catch (ParseException e) {
            return null;
        }
    }
}
