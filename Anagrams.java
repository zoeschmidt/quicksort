/**
 * @author Zoe Schmidt
 * CS 2420 - Fall 2019
 * Problem 33 from Chapter 8
 */

public class Anagrams {

	
	public static boolean areTheyAnagrams(char[] w1, char[] w2) {
		
		if(w1.length != w2.length) {
			return false;
		}
		
		quickSort(w1, 0, w1.length-1);
		quickSort(w2, 0, w2.length-1);
		
		for(int i = 0; i < w1.length; i++) {
			if(w1[i] != w2[i]) {
				return false;
			}
		}
		
		return true;
		
	}
	
	public static void quickSort(char[] word, int left, int right) {
		
		if(left < right) {
			 int pivot = findPivot(word, left, right);
			quickSort(word, left, pivot-1);
			quickSort(word, pivot+1, right);
			
		}
	}
	
	public static int findPivot(char[] word, int left, int right) {	
		int p = word[right];
		int l = left;
		
		for(int i = left; i < right; i++) {
			if(word[i] <= p) {
				char t = word[l];
				word[l] = word[i];
				word[i] = t;
				l++;
			}
		}
		char t = word[l];
		word[l] = word[right];
		word[right] = t;
		
		return l;
			
	}
		
	
	public static void main(String[] ags) {
		char[] stale = {'s', 't', 'a', 'l', 'e'};
		char[] least = {'l', 'e', 'a', 's', 't'};
		char[] listen = {'l', 'i', 's', 't', 'e', 'n'};
		char[] silent = {'s', 'i', 'l', 'e', 'n', 't'};
		char[]  stressed = {'s', 't', 'r', 'e', 's', 's', 'e', 'd'};
		char[] desserts = {'d', 'e', 's', 's', 'e', 'r', 't', 's'};
		char[]  dormitory = {'d', 'o', 'r', 'm', 'i', 't', 'o', 'r', 'y'};
		char[] dirtyRoom = {'d', 'i', 'r', 't', 'y', 'r', 'o', 'o', 'm'};
		
		
		System.out.println("1. Testing stale and least: " + areTheyAnagrams(stale, least)); 
		System.out.println();
		System.out.println("2. Testing listen and silent: " + areTheyAnagrams(silent, listen));
		System.out.println();
		System.out.println("3. Testing stressed and desserts: " + areTheyAnagrams(stressed, desserts));
		System.out.println();
		System.out.println("4. Testing dormitory and dirtyroom: " + areTheyAnagrams(dormitory, dirtyRoom));
		System.out.println();
		System.out.println("5. Testing stale and silent: " + areTheyAnagrams(stale, listen)); 		//False
		System.out.println();
		System.out.println("6. Testing listen and dormitory: " + areTheyAnagrams(listen, dormitory)); //False
	}
}
