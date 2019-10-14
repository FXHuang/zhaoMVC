package xml;

import java.util.Scanner;

import com.spdb.entity.User;
import com.spdb.utill.CatchHelper;

public class Testxml {
	
	
	public static CatchHelper helper;   //这里的hepler也要bean容器托管
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // 从键盘接收数据
		// 判断是否还有输入
		if (scan.hasNextLine()) {
			String strcmd = scan.nextLine();
			helper = new CatchHelper();
			helper.parsePath(strcmd);
		}
		scan.close();
		
	}

}
