package day6;

import java.io.FileReader;
import java.util.List;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;

public class CSVExample {
	@Test
	public void ReadingCSVFile() throws Exception {
		// Connect with CSV File
		CSVReader cs = new CSVReader(new FileReader("C:\\Users\\sonali\\Desktop\\Selenium\\Data.csv"));

		List<String[]> allData = cs.readAll(); // Read all Data from CSV file

		for (int i = 0; i < allData.size(); i++) {
			String[] row = allData.get(i); // It will give particular row's Data

			String user = row[0];
			String pwd = row[1];
			System.out.println(user + " ");
			System.out.println(pwd);
		}

	}
}
