package uai.crud;

import org.sql2o.Connection;
import uai.model.Customer;

import java.util.List;

public class Read extends AbstractCrud{
    private final static String SQL_FIND_BY_ID = "select * from `CRUD`.`customer` WHERE id = :id";
    private final static String SQL_FIND_ALL = "select * from `CRUD`.`customer`";

    public static void main(String[] args) {
        Connection connection = getOpenedConnection();

        try{
            List<Customer> customerList = connection.createQuery(SQL_FIND_ALL)
                                                    .addColumnMapping("social_security_number", "socialSecurityNumber")
                                                    .executeAndFetch(Customer.class);
            for (Customer customer : customerList) {
                System.out.println(customer);
            }

            Customer foundCustomer = connection.createQuery(SQL_FIND_BY_ID )
                                               .addColumnMapping("social_security_number", "socialSecurityNumber")
                                               .addParameter("id", 3)
                                               .executeAndFetchFirst(Customer.class);

            System.out.println(foundCustomer);
        } finally {
            connection.close();
        }
    }
}
