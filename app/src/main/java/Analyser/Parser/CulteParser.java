package Analyser.Parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Analyser.Services.LieuCulte;
import Analyser.Services.Service;

public class CulteParser {

	public List<Service> parseFile()
	{
		String fileName = "src/main/files/LIEU_CULTE.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = "\\|";
		int id = 0;
		
		List<Service> cultes = new ArrayList<Service>();
		try {
			br = new BufferedReader(new FileReader(fileName));
			br.readLine();
			while((line = br.readLine()) != null)
			{
				String[] service = line.split(cvsSplitBy);
				
				LieuCulte c = new LieuCulte();
				c.setId(id);
				c.setType("culte");
				c.setName(service[0]);
				c.setQuartier(service[7]);
				c.setReligion(service[5]);
				c.setLongitude(Float.parseFloat(service[8]));
				c.setLatitude(Float.parseFloat(service[9]));
				
				cultes.add(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return cultes;
	}
}
