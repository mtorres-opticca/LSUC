package ca.on.lsuc.csv.reader;

public class CSVReaderTest {

	public static void main(String[] args) {

		CSVReader reader = new CSVReader();
		try {
			reader.readCSV2();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
