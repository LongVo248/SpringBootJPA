package App.Controller;

import java.util.List;

import App.Controller.CustomerDAO;
import App.Controller.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    public Customer findById(final int id) {
        return customerDAO.findById(id);
    }

    public void save(final Customer customer) {
        // check if exist -> throw exception
        customerDAO.persist(customer);
    }

    public void update(final Customer customer) {
        // check if not exist -> throw excpetion
        Customer customerDb = customerDAO.findById(customer.getId());
        customerDb.setName(customer.getName());
        customerDb.setAddress(customer.getAddress());
        customerDAO.persist(customerDb);
    }

    public void delete(final int id) {
        Customer customer = customerDAO.findById(id);
        if (customer != null) {
            customerDAO.delete(customer);
        }
    }
}
