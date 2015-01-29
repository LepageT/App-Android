package Analyser.Parser;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.Resources;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import Analyser.Services.Service;
import Analyser.Services.Toilette;

public class ToiletteParser {

	
	private List<Service> services;
	
	public List<Service> parseFile() {


        InputStream fileStream = getClass().getClassLoader().getResourceAsStream("files/TOILETTES.CSV");
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = "\\|";
        int id = 0;

        this.services = new ArrayList<Service>();
        try {
            br = new BufferedReader(new InputStreamReader(fileStream));
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] service = line.split(cvsSplitBy);

                Toilette t = new Toilette();
                t.setId(id);
                t.setType("toilette");
                t.setName(service[0]);
                t.setAdresse(service[2] + " " + service[3]);
                t.setQuartier(service[4]);

                this.services.add(t);
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

        return this.services;
    }
}
