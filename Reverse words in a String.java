class Solution {
   	public String reverseWords(String s) {
		String trimmed = s.trim().replaceAll("\\s+", " ");
		List<String> words = new ArrayList();
		words.addAll(Arrays.asList(trimmed.split(" ")));
		Collections.reverse(words);
		return String.join(" ", words);
	}

}
