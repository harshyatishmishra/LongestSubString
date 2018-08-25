

import java.util.ArrayList;
import java.util.List;

public class LongestSubString {

	public static void main(String[] args) {

		List<Character> list = new ArrayList<>();
		int maxSize = 0;
		String longest = "";
		String str = "abba";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (!list.contains(ch)) {
				list.add(ch);
			} else {
				LongestSubString.print(list);
				if (maxSize < list.size()) {
					maxSize = list.size();
					longest = list.toString();
				}
				int indexOf = list.indexOf(ch);
				int diff = list.size() - indexOf;
				System.out.println("Index of : " + indexOf + "		list size :" + list.size());
				System.out.println("Difference between of " + ch + " :" + diff);

				if (diff == list.size()) {
					list.remove(0);
					System.out.println("Removed :" + ch);
					list.add(ch);
				} else {
					list = list.subList(indexOf + 1, list.size());
					list.add(ch);
					print(list);
				}
			}
		}
		print(list);
		if (maxSize < list.size()) {
			maxSize = list.size();
			longest = list.toString();
		}
		System.out.println(longest + " " + maxSize);
	}

	public static void print(List<Character> list) {
		for (char str : list) {
			System.out.print(str);
		}
		System.out.println();
	}
}
