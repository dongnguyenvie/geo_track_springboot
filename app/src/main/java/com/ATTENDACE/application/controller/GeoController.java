package com.ATTENDACE.application.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ATTENDACE.application.entitys.Geo;
import com.ATTENDACE.application.entitys.format.UserJson;
import com.ATTENDACE.application.service.GeoService;
import com.ATTENDACE.application.util.MessageStatus;

@RestController
@CrossOrigin(origins = "*")
//v1.1.2
@RequestMapping("/api/geo")
public class GeoController {
	
	@Autowired
	GeoService geoService;
	
	//NEW RESET
	@PostMapping("")
	public ResponseEntity<?>  ResetAndAddNew(@RequestBody List<Geo> geo, @RequestParam("place_id") int place_id){
		try {
			geoService.CreateGenerateGeo(place_id);
			geoService.UpdateActiveGeo(place_id,false);
			geoService.AddNewListGeo(place_id, geo);
			return new ResponseEntity<>(MessageStatus.dialog(true, "Success"), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(MessageStatus.dialog(false, e.getMessage()), HttpStatus.OK);
		}
	}

	//ADD MORE
	@PutMapping("")
	public ResponseEntity<?> AddGeoMore(@RequestBody List<Geo> geo,@RequestParam("place_id") int place_id){
		try {
			geoService.CreateGenerateGeo(place_id);
			geoService.AddNewListGeo(place_id, geo);
			return new ResponseEntity<>(MessageStatus.dialog(true, "Success"), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(MessageStatus.dialog(false, e.getMessage()), HttpStatus.OK);
		}	
	}
	
	//GET GEO
	@RequestMapping("")
	public ResponseEntity<?> GetGeoPlaceId(@RequestParam("place_id") int place_id){
		try {
			return new ResponseEntity<>(geoService.GetAll(place_id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(MessageStatus.dialog(false, e.getMessage()), HttpStatus.OK);
		}
		
	}

	//DELETE GEO
	@DeleteMapping("")
	public ResponseEntity<?> DeleteAllRelationship(@RequestBody UserJson us){
		try {
			geoService.UpdateActiveGeo(us.getPlace_id(),false);
			return new ResponseEntity<>(MessageStatus.dialog(true, "Success"), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(MessageStatus.dialog(false, e.getMessage()), HttpStatus.OK);
		}
	}
	
	
}
