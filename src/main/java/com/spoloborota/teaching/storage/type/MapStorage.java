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
	public boolean remove(String[] keyValue) {
		if (hashMap.containsKey(keyValue[0])){
			hashMap.remove(keyValue[0]);
			return true;
		}
		else {
			return false;
		}
	}
	public boolean list(String[] keyValue) {
		Iterator<HashMap.Entry<String, String>> iterator = hashMap.entrySet().iterator();
		System.out.print(name + ":  ");
		
		while (iterator.hasNext())
		{
			//получение «пары» элементов
			HashMap.Entry<String, String> pair = iterator.next();
			String key = pair.getKey();            //ключ
			String value = pair.getValue();        //значение
			System.out.print(key + " = " + value + "   ");
		}
		System.out.println();
		
		return true;
	}
}
