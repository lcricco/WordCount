package edu.sbcc.cs105;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner in = new Scanner(new File("harvsents.txt"));
		
		Map<String, Integer> wordCount = new HashMap<>();
		for(String word = in.next(); in.hasNext(); word = in.next()) {
			word = word.toLowerCase().replaceAll("[!@#$%^&*()\\.,]", "");
			wordCount.put(word, wordCount.containsKey(word) ? wordCount.get(word)+1 : 1);
		}

		wordCount.remove("");
		
		for(String word: new TreeSet<String>(wordCount.keySet())) {
			System.out.printf("'%s': %d\n", word, wordCount.get(word));
		}
		
		in.close();
	}
}
