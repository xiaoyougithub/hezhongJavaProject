import java.util.regex.Pattern;

public class SubStringDemo {
	public static void main(String[] args) {
		String pattern=".*nice.*";
		String content="nice to meet you!";
		boolean isMatched=Pattern.matches(pattern, content);
		System.out.println("'nice' is matched ? "+isMatched);
	}
}
