package dao;

import domain.Contact;


import java.util.List;

public interface ContactDao {

    public void save(Contact c);
    public void update(Contact c);
    public void delete(Contact c);
    public void delete(int id);
    public Contact findById(int id);
    public List<Contact> userAll();
    public List<Contact> findByProperty(String propName,Object propValue);
}
