package com.jumia.test.dao;

import com.jumia.test.config.RegexFunction;
import com.jumia.test.dto.SearchCustomerDTO;
import com.jumia.test.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.sqlite.Function;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class CustomCustomerDAOImpl implements CustomCustomerDAO {

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Customer> searchOverCustomer(SearchCustomerDTO searchCustomerDTO) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> customerRoot = cq.from(Customer.class);

        if(searchCustomerDTO.getCountry() != null){
            Predicate phonePredicate ;
            switch (searchCustomerDTO.getCountry()){
                case "Cameroon" :
                    phonePredicate = cb.like(customerRoot.get("phone"), "%(237)%");
                    break ;
                case "Ethiopia" :
                    phonePredicate = cb.like(customerRoot.get("phone"), "%(251)%");
                    break ;
                case "Morocco" :
                    phonePredicate = cb.like(customerRoot.get("phone"), "%(212)%");
                    break;
                case "Mozambique" :
                    phonePredicate = cb.like(customerRoot.get("phone"), "%(258)%");
                    break ;
                case "Uganda" :
                    phonePredicate = cb.like(customerRoot.get("phone"), "%(256)%");
                    break;
                default:
                        throw new RuntimeException("Not a valid country");
            }

            cq.where(phonePredicate);
        }

        TypedQuery<Customer> query = entityManager.createQuery(cq);

        return query.getResultList();
    }

//    public void testRegex (String regex){
//        Connection conn = null;
//        try {
//            String url = "jdbc:sqlite:sample.db";
//            conn = DriverManager.getConnection(url);
//            Function.create(conn,"regexp" , new RegexFunction());
//
//            conn.beginRequest();
//            Statement statement = conn.createStatement();
//          ResultSet resultSet = statement.executeQuery("SELECT * from Customer c where c.phone REGEXP '" + regex+"'");
//
//          while(resultSet.next()){
//              System.out.println(resultSet);
//
//          }
//        }catch (Exception e){
//e.printStackTrace();
//        }
//    }
}
