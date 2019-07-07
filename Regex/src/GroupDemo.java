import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupDemo {

	public static void main(String[] args) {
		//捕获组实例
		/*捕获组就是创建很多个分组并把这些分组当作一个处理单位来对字符串
		*/
		String patternString="(\\d+)(\\D*)(\\d+)(.*)";
		String content="2018 nice to meet you 2019!";
		
		//创建pattern对象
		Pattern pattern=Pattern.compile(patternString);
		//创建Matcher对象
		Matcher matcher=pattern.matcher(content);
		if(matcher.find()) {
			System.out.println("found value:"+matcher.group(0));
			System.out.println("found value:"+matcher.group(1));
			System.out.println("found value:"+matcher.group(2));
			System.out.println("found value:"+matcher.group(3));
			System.out.println("found value:"+matcher.group(4));
		}
	}
}
