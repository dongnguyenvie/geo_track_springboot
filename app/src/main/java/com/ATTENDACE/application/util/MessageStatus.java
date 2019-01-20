package com.ATTENDACE.application.util;

import java.util.HashMap;
import java.util.Map;

public class MessageStatus {
	private static Map<String, Object> status;
	//message
	public static Map<String, Object> dialog(Boolean flag, Object message){
		status = new HashMap<>();
		if(flag) {
			status.put("code", 1);
			status.put("message", message);
			return status;
		}else {
			status.put("code", 0);
			status.put("message", message);
			return status;
		}
	}
}
