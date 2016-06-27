package com.matt.utils;

import java.util.HashMap;
import java.util.Map;

public class Euler21Utils {
	private static Map<Integer,Integer> divisorCache;
	
	public static boolean isAmicibleNumber(int number){
		int possibleAmicibleNum = sumOfDivisors(number);
		if(possibleAmicibleNum != number && sumOfDivisors(possibleAmicibleNum) == number){
			return true;
		}else{
			return false;
		}
	}
	
	public static int sumOfDivisors(int num){
		
		if(numIsInCache(num)){
			return divisorCache.get(num);
		}
	
		int divisorSum = 1;
		
		for (int i = 2; i < integerSqrt(num); i++) {
			if (num % i == 0) {
				divisorSum += i;
				if (num / i != i) { //don't forget the number on the other side of the sqrt!
					divisorSum += (num / i);
				}
			}
		}
		
		//make sure to add the result to the cache!
		divisorCache.put(num, divisorSum);
		
		return divisorSum;
	}
	
	public static void flushCache(){
		divisorCache = null;
	}
	
	/**
	 * Initializes the divisorCache if it needs to, and returns true
	 * iff the passed number is in the cache. false if it is not 
	 * present`
	 * 
	 * @param num
	 * @return
	 */
	private static boolean numIsInCache(int num){
		if(divisorCache == null){
			divisorCache = new HashMap<Integer,Integer>();
		}
		
		return divisorCache.containsKey(num);
	}
	
	/**
	 * Returns the integer square root
	 * 
	 * Avoids a confusing jumble of casting
	 * 
	 * @param num
	 * @return
	 */
	private static int integerSqrt(int num){
		return (int) Math.sqrt((double)num);
	}
}
