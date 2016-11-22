package com.spoloborota.teaching.storage.type;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapStorage {

	public String name;
	public HashMap<String, String> hashMap;

	public MapStorage(String name) {
		this.name = name;
		hashMap = new HashMap<>();
	}

	public boolean add(String[] keyValue) {
		hashMap.put(keyValue[0], keyValue[1]);
		return true;
	}

	public String remove(String[] keyValue) {
		return hashMap.remove(keyValue[0]);
	}

	public String list(String[] keyValue) {
		Iterator<HashMap.Entry<String, String>> iterator = hashMap.entrySet().iterator();
		String s1 = "Repository " + name + ": {";

		while (iterator.hasNext())
		{
			HashMap.Entry<String, String> pair = iterator.next();
			String key = pair.getKey();
			String value = pair.getValue();
			s1 = s1 + key + "=" + value + " ";
			
		}
		s1 = s1 + "\b}";
		return s1;
	}
}
