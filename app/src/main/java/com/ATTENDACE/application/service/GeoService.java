package com.ATTENDACE.application.service;

import java.text.MessageFormat;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ATTENDACE.application.entitys.Geo;
import com.ATTENDACE.application.mappedVariable.FinalVariableTracking;



@Service
@Transactional
public class GeoService {
	@PersistenceContext EntityManager em;
	@Autowired FinalVariableTracking DBcolumns;
	
	//GET ALL GEO
	public List<Geo> GetAll(int table){
		return em.createNativeQuery(MessageFormat.format("SELECT * FROM geo{0} WHERE active=true ", table), Geo.class).getResultList();
	}
	
	//ADD MEW LIST GEO
	public void AddNewListGeo(int table,List<Geo> lstGeo) {
		for(Geo geo: lstGeo) {
			insertNew(table,geo);
		}
	}
	
	//DELETE GEO
	public void DeleteGeoByPlaceID(int id) {
		em.createNativeQuery(MessageFormat.format("DELETE FROM geo{0}", id)).executeUpdate();
	}
	
	//ACTIVE GEO
	public void UpdateActiveGeo(int id,Boolean flag) {
		em.createNativeQuery(MessageFormat.format("UPDATE geo{0} SET active={1}", id , flag)).executeUpdate();
	}
	
	//GENERATE CREATE GEO
	public Object CreateGenerateGeo(int table) {
		Query query = em.createNativeQuery("select * from create_geo(?1)");
		query.setParameter(1, table);
		return query.getSingleResult();
	}
	

	
	
	
	//INSERT NEW GEO
	public void insertNew(int table,Geo geo) {
		Query query =  em.createNativeQuery( renderInsertSQL(table, geo) );
		query.executeUpdate();
	}	
	
	
	//RENDER STRING SQL 
	public String renderInsertSQL(int table, Geo g) {
		
		String blue = coverJsonArrToString(g.getBluetooth());
		String cell = coverJsonObjToString(g.getCellular());
		String location = coverJsonObjToString(g.getLocations());
		String sat = coverJsonArrToString(g.getSatellite());
		//String sensor = coverJsonObjToString(g.getSensor());
		String sensor = null;
		String wifi = coverJsonArrToString(g.getWifi());
		
		MessageFormat messageFormat = new MessageFormat("INSERT INTO geo{0}({1},{2},{3},{4},{5},{6},{7},{8}) VALUES("
				+ " ''{9}'',''{10}'' ,''{11}'', ''{12}'' ,''{13}'', ''{14}'', ''{15}'',''{16}''  )") ;
		Object[] args = {table, DBcolumns.geo_1,DBcolumns.geo_2,DBcolumns.geo_3,DBcolumns.geo_4,DBcolumns.geo_5,DBcolumns.geo_6,DBcolumns.geo_7,DBcolumns.geo_8,
				blue,cell,location,sat,sensor,wifi, g.getPost_date(),g.getPost_time().toString()};
		
		
		return messageFormat.format(args);
	}
	//COVER jsonObj -> String
	private String coverJsonObjToString(Object json) {
		return new JSONObject(json).toString();
	}
	//COVER jsonArr -> String
	private <T> String coverJsonArrToString(List list) {
		return new JSONArray(list).toString();
	}
	
	
}
