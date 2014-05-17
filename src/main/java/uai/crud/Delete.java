package uai.crud;

import org.sql2o.Connection;

public class Delete extends AbstractCrud{
    private final static String SQL_DELETE = "DELETE FROM `CRUD`.`customer` WHERE id = :id";

    public static void main(String[] args) {
        Connection connection = getOpenedConnection();

        try{
            connection.createQuery(SQL_DELETE, true)
                    .addParameter("id", 2)
                    .executeUpdate();

        } finally {
            connection.close();
        }
    }
}