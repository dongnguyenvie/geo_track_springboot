package com.ATTENDACE.application.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ATTENDACE.application.entitys.Track;
import com.ATTENDACE.application.entitys.format.UserJson;
import com.ATTENDACE.application.service.TrackService;
import com.ATTENDACE.application.util.MessageStatus;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/track")
public class TrackController {
	
	@Autowired TrackService trackService;
	
	//GET ALL TRACK USING US_ID
	@RequestMapping(value="/all/{id}")
	public ResponseEntity<?> GetAll(@PathVariable("id") int id){
		try {
			return new ResponseEntity<>(trackService.GetAll(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(MessageStatus.dialog(false, e.getMessage()), HttpStatus.OK);
		}
	}
	
	//GET TRACK USING US_ID, DATE OR DATE AND TIME
	@RequestMapping(value="")
	public ResponseEntity<?> GetTrackUsingDate(@RequestParam("us_id") int us_id,@RequestParam("date") Date date, @RequestParam(value="timefrom",required=false) Time timeFrom, @RequestParam(value="timeto", required=false) Time timeTo){

		try {
			//GET TRACK BY TIME
			if(timeFrom !=null & timeTo !=null) {
				return new ResponseEntity<>(trackService.GetTrackUsingUsDateTime(us_id, date,timeFrom,timeTo), HttpStatus.OK);
			}
			//GET TRACK BY DATE
			return new ResponseEntity<>(trackService.GetTrackUsingUsDate(us_id, date), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(MessageStatus.dialog(false, e.getMessage()), HttpStatus.OK);
		}
	}
	
	//INSERT TRACK
	@PostMapping(value="")
	public ResponseEntity<?> AddTrack(@RequestBody List<Track> lstTrack, @RequestParam("us_id") int id){
		try {
		//	Object idTrack = trackService.CreateGenerateTrack(id);
			trackService.AddNewListTrack(id, lstTrack);
			return new ResponseEntity<>(MessageStatus.dialog(true,"Success"), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(MessageStatus.dialog(false, e.getMessage()), HttpStatus.OK);
		}
	}
	
	//DELETE TRACK USING US_ID
	@DeleteMapping(value="")
	public ResponseEntity<?> DeleteTrackUsingDate(@RequestParam("us_id") int us_id){
		try {
			trackService.DeleteTrackUsingDate(us_id);
			return new ResponseEntity<>(MessageStatus.dialog(true, "Success"), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(MessageStatus.dialog(false, e.getMessage()), HttpStatus.OK);
		}
	}
	

	

	
}
