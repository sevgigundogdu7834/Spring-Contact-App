package service;

import domain.Contact;
import java.util.List;

public interface ContactService {

    public void save(Contact contact);
    public void update(Contact contact);
    public void delete(int contactId);
    public void delete(Integer[] contactIds);

    public List<Contact> findUserContact(int userId);
    public List<Contact> findUserContact(int userId,String txt);

}
