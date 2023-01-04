package com.te.simplebookingsystem.availablesdates;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Map.Entry;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.te.simplebookingsystem.entity.Dates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
public class CollectionOfAvailabes {

	
	public static /*List<LocalDate>*/ void getDatesBetweenUsingJava8(
			  LocalDate startDate, LocalDate endDate) { 
			
			    long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
			    LocalDate trailDate=startDate;
			    for(long i=0 ;i<=numOfDaysBetween;i++) {
			    	trailDate=startDate.plusDays(i);
			    	System.out.println(trailDate);
			    }
//			    return IntStream.iterate(0, i -> i + 1)
//			      .limit(numOfDaysBetween)
//			      .mapToObj(i -> startDate.plusDays(i))
//			      .collect(Collectors.toList()); 
			}

	 public  List<LocalDate> getDatesBetweenUsingJava9(
			  LocalDate startDate, LocalDate endDate) { 
			    long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
			    List<LocalDate> dates =Lists.newArrayList();
			    for(long i=0 ;i<=numOfDaysBetween;i++) {
//			    	Dates date = new Dates();
			    	startDate=startDate.plusDays(i);
			    		dates.add(startDate);
			    		}
			    return dates;
			}

	
	
	public String getAccess(String string) {
		String value;
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("Cricket", "120");
		hashMap.put("football", "200");
		hashMap.put("hockey", "80");
		for(Map.Entry<String, String> entry: hashMap.entrySet()) {
			 value = entry.getKey();
			 if(string.equalsIgnoreCase(value) ) {
			 return value;
		}
		}
		return null;
	}
	
	private Collection<String> getAll(String game){
		String value;
	Multimap<String, String> multimap = ArrayListMultimap.create();
	multimap.put("Cricket", "100rs");
	multimap.put("Cricket", "11 players");
	
	multimap.put("hockey", "80rs");
	multimap.put("hockey", "11 players");
	
	multimap.put("football", "180rs");
	multimap.put("football", "11 players");
	Collection<String> collection = multimap.get(game);
	
	
	
	if(multimap.containsKey(game)) {
		 Collection<String> values = multimap.values();
		 
		return collection;
	}
//	working for only one value;
	
//	for(Entry<String, String> multi : multimap.entries()) {
//		value = multi.getKey();
//		if(game.equalsIgnoreCase(value)) {
//			String string = multi.getValue();
//			return string;
//			
//		}
//		
//	}
	return null;
	}
	
	public static void main(String[] args) {
		CollectionOfAvailabes availabes = new CollectionOfAvailabes();
		LocalDate dts = LocalDate.parse("2022-11-01");
		LocalDate dt = LocalDate.parse("2022-12-01");
		availabes.getDatesBetweenUsingJava8(dts, dt);
		System.out.println(availabes.getDatesBetweenUsingJava9(dts, dt));
	
//		System.out.println(availabes.getAccess("Cricket")); 
//		System.out.println(availabes.getAll("Cricket"));
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//		@Override
//		public Collection<String> values() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//		
//		@Override
//		public int size() {
//			// TODO Auto-generated method stub
//			return 0;
//		}
//		
//		@Override
//		public Collection<String> replaceValues(String key, Iterable<? extends String> values) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//		
//		@Override
//		public Collection<String> removeAll(Object key) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//		
//		@Override
//		public boolean remove(Object key, Object value) {
//			// TODO Auto-generated method stub
//			return false;
//		}
//		
//		@Override
//		public boolean putAll(String key, Iterable<? extends String> values) {
//			// TODO Auto-generated method stub
//			return false;
//		}
//		
//		@Override
//		public boolean putAll(Multimap<? extends String, ? extends String> multimap) {
//			// TODO Auto-generated method stub
//			return false;
//		}
//		
//		@Override
//		public boolean put(String key, String value) {
//			// TODO Auto-generated method stub
//			return false;
//		}
//		
//		@Override
//		public Multiset<String> keys() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//		
//		@Override
//		public Set<String> keySet() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//		
//		@Override
//		public boolean isEmpty() {
//			// TODO Auto-generated method stub
//			return false;
//		}
//		
//		@Override
//		public Collection<String> get(String key) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//		
//		@Override
//		public Collection<Entry<String, String>> entries() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//		
//		@Override
//		public boolean containsValue(Object value) {
//			// TODO Auto-generated method stub
//			return false;
//		}
//		
//		@Override
//		public boolean containsKey(Object key) {
//			// TODO Auto-generated method stub
//			return false;
//		}
//		
//		@Override
//		public boolean containsEntry(Object key, Object value) {
//			// TODO Auto-generated method stub
//			return false;
//		}
//		
//		@Override
//		public void clear() {
//			// TODO Auto-generated method stub
//			
//		}
//		
//		@Override
//		public Map<String, Collection<String>> asMap() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//	};
//	
	
	/*
	 * public static void frequencyHashMap(int[] a)
	{
		HashMap<Integer,Integer> hm=new HashMap<>();
		for(int i=0;i<a.length;i++)
		{
			if(hm.containsKey(a[i]))
			{
				hm.put(a[i], hm.get(a[i]+1));
			}
			else
			{
				hm.put(a[i], 1);
			}
		}
		for(Map.Entry<Integer, Integer> entry:hm.entrySet())
		{
			System.out.println(entry.getKey()+"----"+entry.getValue());
		}

	}
	 */
	
	
	
}
