package live.hmj.util;

import java.util.Date;

public class PresentTime {
	public static String getPresentTime() {
		String time="";
		Date date=new Date();
		time=(1900+date.getYear())+"-"+(1+date.getMonth())+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
		return time;
	}

}
