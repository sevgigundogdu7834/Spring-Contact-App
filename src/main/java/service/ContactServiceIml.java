package service;

import dao.BaseDao;
import dao.ContactDao;
import dao.ContactDaoIml;
import domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rm.ContactRowMapper;
import util.StringContactUtility;

import java.util.List;

@Service
public class ContactServiceIml extends BaseDao implements ContactService {

    @Autowired
    private ContactDaoIml contactDao;

    public void save(Contact contact) {

        contactDao.save(contact);
    }

    public void update(Contact contact) {

        contactDao.update(contact);
    }

    public void delete(int contactId) {

        contactDao.delete(contactId);
    }

    public void delete(Integer[] contactIds) {


        String _contactId=StringContactUtility.toCommaSeperatedString(contactIds);
        String sql="DELETE FROM contact WHERE contactId IN("+_contactId+")";
        getJdbcTemplate().update(sql);


    }

    public List<Contact> findUserContact(int userId) {

        return contactDao.findByProperty("userId",userId);

    }

    public List<Contact> findUserContact(int userId, String txt) {

        String sql="SELECT contactId,name,phone,email,adress,remark FROM contact WHERE userId=? AND (name LIKE('%"+txt+"%') OR phone LIKE('%"+txt+"%') OR email LIKE('%"+txt+"%') OR adress LIKE('%"+txt+"%') OR remark LIKE('%"+txt+"%')";
        List<Contact> contactList=getJdbcTemplate().query(sql,new ContactRowMapper(),userId);
        return contactList;
    }
}
