package kg.itacademy.exam.service;

import kg.itacademy.exam.entity.Customer;
import kg.itacademy.exam.entity.Ticket;
import kg.itacademy.exam.repository.CustomerRepository;
import kg.itacademy.exam.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Customer create(Customer customer) {
        Customer c = new Customer();
        List<Ticket> ticketList = new ArrayList<>();
        for(Ticket t : customer.getTicketList()) {
            if(!t.getIsBought() && t.getSession().getFilm().getAgeLimit() <= customer.getAge()){
                t.setIsBought(true);
                ticketList.add(t);
        }
            else{
                System.out.println(t + " не продается");
            }
        }
        c.setId(customer.getId());
        c.setAge(customer.getAge());
        c.setTicketList(ticketList);
        return customerRepository.save(c);
    }


}
