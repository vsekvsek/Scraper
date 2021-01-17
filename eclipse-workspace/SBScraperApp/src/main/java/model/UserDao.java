package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

;
public class UserDao {
	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  
	 
	public void saveUser(User e){  
	    template.save(e);  
	}  
	//method to update employee  
	public void updateUser(User e){  
	     template.update(e);  
	}  
	//method to delete employee  
	public void deleteEmployee(User e){  
	     template.delete(e);  
	}  
	//method to return one employee of given id  
	public User getById(int id){  
	    User e=(User)template.get(User.class,id);  
	    return e;  
	}  
	//method to return all employees  
	public List<User> getUsers(){  
	    List<User> list=new ArrayList<User>();  
	    list=template.loadAll(User.class);  
	    return list;  
	}  
}
