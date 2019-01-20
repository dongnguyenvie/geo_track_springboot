package com.ATTENDACE.application.service;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.naming.spi.DirStateFactory.Result;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import java.sql.ResultSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ATTENDACE.application.entitys.Track;
import com.ATTENDACE.application.entitys.format.UserJson;
import com.ATTENDACE.application.mappedVariable.FinalVariableTracking;

@Service
@Transactional
public class TrackService implements Serializable{
	

	
	@PersistenceContext EntityManager em;
	@Autowired FinalVariableTracking DBcolumns;
	
	
	//ADD LIST TRACK
	public void AddNewListTrack(int idTable,List<Track> lstTrack) {
		for(Track track : lstTrack) {
			CreateGenerateTrack(idTable,new Date(track.getPost_date().getTime()));
			insertNew(idTable, track);
			
		}
	}
	
	//GET ALL TRACK USING
	public List<Track> GetAll(int table){
		return em.createNativeQuery(MessageFormat.format("SELECT * FROM track{0} ORDER BY post_time ASC", table), Track.class).getResultList();
	}
	
	//DELETE TRACKING USING DATE AND US_ID
	public void DeleteTrackUsingDate(int table) {
		em.createNativeQuery(MessageFormat.format("DELETE FROM track{0} ", table)).executeUpdate();
	}

	
	//GET TRACK USING US_ID, DATE
	public List<Track> GetTrackUsingUsDate(int us_id,Date date){
		Query query = em.createNativeQuery("SELECT * FROM get_track(?1,?2) ORDER BY post_time ASC ", Track.class);
		query.setParameter(1,us_id);
		query.setParameter(2, date);
		return query.getResultList();
	}

	//GET TRACK USING US_ID, DATE, TIME FROM, TIME TO
	public List<Track> GetTrackUsingUsDateTime(int us_id,Date date,Time timeFrom, Time timeTo){//
		Query query = em.createNativeQuery("SELECT * FROM get_track(?1,?2) WHERE (post_time BETWEEN ?3 AND ?4) ORDER BY post_time ASC ", Track.class);
		query.setParameter(1,us_id);
		query.setParameter(2, date);
		query.setParameter(3, timeFrom);
		query.setParameter(4, timeTo);
		return query.getResultList();
	}
	
	//CREATE GENERATE TABLE TRACK
	public Object CreateGenerateTrack(int table, Date date) {
		Query query = em.createNativeQuery("select * from create_track(?1,?2)");
		query.setParameter(1, table);
		query.setParameter(2, date);
		return query.getSingleResult();
	}
	
	
	
	
	//INSERT TRACK
	public void insertNew(int table,Track track) {
		Query query =  em.createNativeQuery( renderInsertSQL(table, track) );
		query.executeUpdate();
	}
	
	public String renderInsertSQL(int table, Track t) {
		
		String blue = coverJsonArrToString(t.getBluetooth());
		String cell = coverJsonObjToString(t.getCellular());
		String location = coverJsonObjToString(t.getLocations());
		String sat = coverJsonArrToString(t.getSatellite());
		//String sensor = coverJsonObjToString(t.getSensor());
		String sensor = null;
		String wifi = coverJsonArrToString(t.getWifi());
		
		
		MessageFormat messageFormat = new MessageFormat("INSERT INTO track{0}({1},{2},{3},{4},{5},{6},{7},{8}) VALUES("
				+ " ''{9}'',''{10}'' ,''{11}'', ''{12}'' ,''{13}'', ''{14}'', ''{15}'',''{16}'' )");
		Object[] args = {table, DBcolumns.Tr_1,DBcolumns.Tr_2,DBcolumns.Tr_3,DBcolumns.Tr_4,DBcolumns.Tr_5,DBcolumns.Tr_6, DBcolumns.Tr_7,DBcolumns.Tr_8,
				blue,cell,location,sat,sensor,wifi,t.getPost_date(), t.getPost_time().toString() };
		return messageFormat.format(args);
	}
	//cover jsonObj -> String
	private String coverJsonObjToString(Object json) {
		return new JSONObject(json).toString();
	}
	//cover jsonArr -> String
	private <T> String coverJsonArrToString(List list) {
		return new JSONArray(list).toString();
	}

	
}
