import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupDemo {

	public static void main(String[] args) {
		//������ʵ��
		/*��������Ǵ����ܶ�����鲢����Щ���鵱��һ������λ�����ַ���
		*/
		String patternString="(\\d+)(\\D*)(\\d+)(.*)";
		String content="2018 nice to meet you 2019!";
		
		//����pattern����
		Pattern pattern=Pattern.compile(patternString);
		//����Matcher����
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
