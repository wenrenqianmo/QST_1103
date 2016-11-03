package no3;
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.text.ParseException; 
import java.text.SimpleDateFormat; 
import java.util.Date; 
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern; 


public class FilterByTime {
	public static void main(String[] args) throws ParseException, FileNotFoundException{ 
 		//确定时间范围
		SimpleDateFormat regularFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
 		Date beginDate = regularFormat.parse("2015-12-31 18:00:00"); 
 		Date endDate = regularFormat.parse("2015-12-31 19:00:00"); 
 		//文件获取
 		String filePath = "G:/eclipse/workspace/ex1/access.log"; 
 		FileInputStream inputStream = new FileInputStream(filePath); 
 		Scanner scanner = new Scanner(inputStream, "UTF-8"); 
 		//正则表达式
 		String pattern = "(\\d+.\\d+.\\d+.\\d+) [^ ]+ [^ ]+ \\[([^ ]+)";
 		Pattern r = Pattern.compile(pattern);
 		//提取时间转换格式
 		SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy:HH:mm:ss");
 		
 		while (scanner.hasNext()){ 
 			// 对每行进行处理 
 			String line = scanner.nextLine(); 
 			// 切分获取IP，Time
 			Matcher m = r.matcher(line);
 			if(m.find()){
 				String strIp = m.group(1); 
 	 			String strTime = m.group(2);
 	 			//将String转换转换成时间
 	 			Date lineDate = null; 
 	 			lineDate = inputFormat.parse(strTime.replaceAll("Dec", "12"));
 	 			//将时间转换成毫秒数
 	 			long lineTimestamp;
 	 			long begin;
 	 			long end;
 	 			lineTimestamp = lineDate.getTime();
 	 			begin = beginDate.getTime();
 	 			end = endDate.getTime();
 	 			
 	 			// 比较时间，对在时间区间内的数据进行输出 
 	 			if((lineTimestamp>begin)&&(lineTimestamp<end)){
 	 				System.out.println(strIp + "\t" + strTime); 
 	 			}
 			}
 		} 
 	} 
}
