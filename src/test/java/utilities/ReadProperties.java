package utilities;

import java.io.*;
import java.util.Properties;

public class ReadProperties {

	public static void main(String[] args) throws IOException {
		FileReader fr=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configFiles\\config.properties");
		Properties p=new Properties();
		p.load(fr);
		System.out.println(p.getProperty("browser"));

	}

}
