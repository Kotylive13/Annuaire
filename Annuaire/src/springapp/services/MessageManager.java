package springapp.services;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean()
@Startup
public class MessageManager implements IMessageManager {

    @PersistenceContext(unitName = "myData")
    EntityManager em;

    public MessageManager() {
    }

    @PostConstruct
    public void init() {
        System.out.println("INIT EJB = " + this);
    }

    @Override
    public void add(String data) {
        Message m = new Message(data);
        em.persist(m);
    }

    @Override
    public int removeAll() {
        return em.createQuery("Delete From Message").executeUpdate();
    }

    @Override
    public Collection<Message> findAll() {
        return em.createQuery("Select m From Message m", Message.class)
                .getResultList();
    }
}