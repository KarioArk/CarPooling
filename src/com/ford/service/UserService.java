package com.ford.service;

import java.util.ArrayList;
import java.util.List;

import com.ford.core.MongoDBSingleton;
import com.ford.domain.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class UserService {

    public List<User> getDefaultUser() {
        List<User> userList = new ArrayList<User>();
        MongoDBSingleton dbSingleton = MongoDBSingleton.getInstance();
		DB db = dbSingleton.getTestdb();
        DBCollection coll = db.getCollection("UserDetails");
        
        //Retrieve Code from DB
		DBCursor cursor = coll.find();
		while(cursor.hasNext()) {
			User user = new User();
			BasicDBObject obj = (BasicDBObject) cursor.next();
			System.out.println("CDSID->"+ obj.getString("CDSID"));
			System.out.println("Mobile Number->"+ obj.getString("MobileNumber"));
			System.out.println("Gender->"+ obj.getString("Gender"));
			user.setCdsid(obj.getString("CDSID"));
	        user.setMobileNumber(obj.getString("MobileNumber"));
	        user.setGender(obj.getString("Gender"));
	        userList.add(user);
		}

        return userList;
    }

	public void addUser(User user) {
		MongoDBSingleton dbSingleton = MongoDBSingleton.getInstance();
		DB db = dbSingleton.getTestdb();
        DBCollection coll = db.getCollection("UserDetails");
		//Insert code to DB
        BasicDBObject doc = new BasicDBObject("CDSID", user.getCdsid()).append("MobileNumber", user.getMobileNumber()).append("Gender",user.getGender());
		coll.insert(doc);
		DBObject myDoc = coll.findOne();
		System.out.println(myDoc);
				
	}
}