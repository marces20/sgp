package utils;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {
	
	public static <T> boolean contains(final T[] array, final T v) {
	    for (final T e : array)
	        if (e == v || v != null && v.equals(e))
	            return true;

	    return false;
	}
	
	public static List<Integer> convertArrayStringToIntenger(String[] ids) {
		List<Integer> ret = new ArrayList<Integer>();
		if(ids != null){
			for(String x : ids){
				ret.add(Integer.parseInt(x));
			}
		}
		return ret;
	}
}
