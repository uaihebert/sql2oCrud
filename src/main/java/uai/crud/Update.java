package uai.crud;

import org.sql2o.Connection;
import uai.model.Customer;
import uai.model.Gender;

public class Update extends AbstractCrud{
    private final static String SQL_UPDATE = "UPDATE `CRUD`.`customer` " +
                                                " SET `name` = :name, " +
                                                " `birth` = :birth, " +
                                                " `gender` = :gender, " +
                                                " `social_security_number` = :socialSecurityNumber " +
                                                " WHERE `id` = :id";

    public static void main(String[] args) {
        Connection connection = getOpenedConnection();

        try{
            Customer customer01 = new Customer(1, parseDate("01/01/2001"), "Updated John", Gender.MALE, "111111111");

            connection.createQuery(SQL_UPDATE, true)
                    .addParameter("name", customer01.getName())
                    .addParameter("birth", customer01.getBirth())
                    .addParameter("gender", customer01.getGender())
                    .addParameter("socialSecurityNumber", customer01.getSocialSecurityNumber())
                    .addParameter("id", customer01.getId())
                    .executeUpdate();

        } finally {
            connection.close();
        }
    }
}
