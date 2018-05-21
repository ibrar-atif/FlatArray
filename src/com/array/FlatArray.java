package com.array;

import java.nio.channels.GatheringByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author ibrara
 *
 */
public class FlatArray {
	
	
	public static void main(String a[]) throws Exception{
		
		Integer[] i = getFlatArray(new Object[]{1,new Object[]{1,3,4,new Integer[]{5,6},8},99,new Integer[]{33,46}});
		for(Integer k:i){
		System.out.println(k);	
		}
	}

	public static Integer[] getFlatArray(Object[] input) throws Exception{
		if(input==null){
			throw new Exception("invalid input");
		}
		List<Integer> tempList = new ArrayList<>();
		for(Object o:input){
			if(o instanceof Integer){
				tempList.add((Integer) o);
			}else if(o instanceof Object[]){
				tempList.addAll(Arrays.asList(getFlatArray((Object[]) o)));
			}else{
				throw new Exception("invalid input");
			}
		}
		return tempList.toArray(new Integer[tempList.size()]);
	}
}
