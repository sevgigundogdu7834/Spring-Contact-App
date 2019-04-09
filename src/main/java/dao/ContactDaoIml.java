package dao;

import domain.Contact;
import domain.User;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import rm.ContactRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ContactDaoIml extends BaseDao implements ContactDao{


    public void save(Contact c) {

        String sql="insert into contact(userId,name,phone,email,adress,remark) values(?,?,?,?,?,?)";
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("userId",c.getUserId());
        map.put("name",c.getName());
        map.put("phone",c.getPhone());
        map.put("email",c.getEmail());
        map.put("adress",c.getAdress());
        map.put("remark",c.getRemark());

        SqlParameterSource sqlParameterSource=new MapSqlParameterSource(map);
        KeyHolder keyHolder=new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(sql,sqlParameterSource,keyHolder);
        c.setContactId(keyHolder.getKey().intValue());
    }

    public void update(Contact c) {

        String sql="update contact set userId=:userId,name=:name,phone=:phone,email=:email,adress=:adress,remark=:remark";
        Map<String,Object> mapList=new HashMap<String, Object>();
        mapList.put("userId",c.getUserId());
        mapList.put("name",c.getName());
        mapList.put("phone",c.getPhone());
        mapList.put("email",c.getEmail());
        mapList.put("adress",c.getAdress());
        mapList.put("remark",c.getRemark());

        getNamedParameterJdbcTemplate().update(sql,mapList);

    }

    public void delete(Contact c) {

    this.delete(c.getContactId());

    }

    public void delete(int id) {

        String sql="delete from contact where contactId=:id";
        getJdbcTemplate().update(sql,id);

    }

    public Contact findById(int id) {

        String sql="select * from contact where contactId=?";
        Contact contact=getJdbcTemplate().queryForObject(sql,new ContactRowMapper(),id);
        return contact;
    }

    public List<Contact> userAll() {

        String sql="select * from contact";
        List<Contact> contactList=getJdbcTemplate().query(sql,new ContactRowMapper());
        return contactList;

    }

    public List<Contact> findByProperty(String propName, Object propValue) {

        String sql="select * from contact where "+propName+"=?";
        List<Contact> contactList=getJdbcTemplate().query(sql,new ContactRowMapper(),propValue);
        return contactList;


    }
}
