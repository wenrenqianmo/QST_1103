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
		// 使用Scanner从System.in这个流中读取数据
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 输出的格式，用于解析输入数据
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // 输出的格式，用于转换为输出的数据
		while (scanner.hasNext()){
			// 一行一行处理
			String line = scanner.nextLine();
			Date lineDate = null;
			long lineTimestamp; // Time Stamp一般是32位整数，用long可以存储
			try {
				lineDate = inputFormat.parse(line); // 按照格式解析，格式不对会抛出异常
				lineTimestamp = lineDate.getTime(); // 转化为time stamp
				System.out.println(outputFormat.format(lineDate) + " to " + lineTimestamp);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
