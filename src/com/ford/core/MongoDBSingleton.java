package com.ford.core;

import com.mongodb.DB;
import com.mongodb.MongoClient;

/**
 * Java + MongoDB Hello world Example
 *
 */
public class MongoDBSingleton {

	private static MongoDBSingleton mDbSingleton;

	private static MongoClient mongoClient;

	private static DB db;

	private MongoDBSingleton(){};
	
	public static MongoDBSingleton getInstance() {
		if (mDbSingleton == null) {
			mDbSingleton = new MongoDBSingleton();
		}
		return mDbSingleton;
	}

	public DB getTestdb() {
		if (mongoClient == null) {
			mongoClient = new MongoClient("localhost", 27017);
		}
		if (db == null)
			db = mongoClient.getDB("Karthick");
		/*if (!db.isAuthenticated()) {
			boolean auth = db.authenticate(dbUser, dbPassword.toCharArray());
		}*/
		return db;
	}
	/*
	 * public static void main(String[] args) {
	 * 
	 * System.out.println("Hello");
	 * 
	 * @SuppressWarnings("resource") MongoClient mongo = new
	 * MongoClient("localhost", 27017);
	 * 
	 * @SuppressWarnings("deprecation") DB db = mongo.getDB("Karthick");
	 * 
	 * @SuppressWarnings("deprecation") List<String> dbs =
	 * mongo.getDatabaseNames(); for (String database : dbs) {
	 * System.out.println(database); } // DBCollection table =
	 * db.getCollection("movie"); }
	 */}