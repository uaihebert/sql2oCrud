package uai.crud;

import org.sql2o.Connection;
import uai.model.Customer;
import uai.model.Gender;

public class Create extends AbstractCrud{
    private final static String SQL_INSERT = "INSERT INTO `CRUD`.`customer` (`name`,`birth`,`gender`,`social_security_number`) " +
                                             " VALUES(:name,:birth,:gender,:socialSecurityNumber)";

    public static void main(String[] args) {
        Connection connection = getOpenedConnection();

        try{
            Customer customer01 = new Customer(parseDate("01/01/2001"), "John", Gender.MALE, "111111111");

            Object insertedId = connection.createQuery(SQL_INSERT, true)
                    .addParameter("name", customer01.getName())
                    .addParameter("birth", customer01.getBirth())
                    .addParameter("gender", customer01.getGender())
                    .addParameter("socialSecurityNumber", customer01.getSocialSecurityNumber())
                    .executeUpdate()
                    .getKey();

            System.out.println("persisted customer 01 with ID: " + insertedId);

        } finally {
            connection.close();
        }
    }
}
