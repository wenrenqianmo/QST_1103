package No1;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex1
 * 1. 在个人分支下，修改Answers.md文件，里面填入当输入为'2016-11-11 11:11:11'时，输出的值是多少
 * 2. 对代码进行注释，说明每行代码的作用，把代码提交到个人分支下
 * 3. 创建pull request，与主仓库的master分支对比
 */
public class TimestampTransfer { 
	@SuppressWarnings("resource") 
	 public static void main(String[] args){ 
	 	Scanner scanner = new Scanner(System.in); //标准输入
	 	SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //输入时间的格式
	 	SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); //输出时间的格式
	 	while (scanner.hasNext()){ 
	 		String line = scanner.nextLine(); //接收输入的字符串
	 		Date lineDate = null; 
	 		long lineTimestamp; 
	 		try { 
	 			lineDate = inputFormat.parse(line); //字符串转换成时间
	 			lineTimestamp = lineDate.getTime(); //时间转换成毫秒long
	 			System.out.println(outputFormat.format(lineDate) + " to " + lineTimestamp); //输出第二种格式的时间和毫秒数long
	 		} catch (ParseException e) { 
	 			e.printStackTrace(); //异常
	 		} 
	 	} 
	 } 
} 
