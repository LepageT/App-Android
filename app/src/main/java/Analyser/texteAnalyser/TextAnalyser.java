package Analyser.texteAnalyser;

import org.apache.lucene.document.Document;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

public class TextAnalyser {

	private SearchEngine se;

	public TextAnalyser() {
		try {

			System.out.println("rebuildIndexes");
			Indexer indexer = new Indexer();
			indexer.rebuildIndexes();
			System.out.println("rebuildIndexes done");

			System.out.println("performSearch");
			this.se = new SearchEngine();

		} catch (Exception e) {
            e.printStackTrace();
			System.out.println("Exception caught.\n");
		}
	}

	public UserRequest analyseText(String textToAnalyse) {
		UserRequest request = new UserRequest();
		
		try {
			TopDocs topDocs = se.performSearch(textToAnalyse, 10);

			System.out.println("Results found: " + topDocs.totalHits);
			ScoreDoc[] hits = topDocs.scoreDocs;

			for (int i = 0; i < hits.length; i++) {
				Document doc = se.getDocument(hits[i].doc);

				switch (doc.get("type")) {
				case "Proximite":
					if (doc.get("name") == "Loin")
						request.setNear(false);
					else
						request.setNear(true);
					break;
				case "Service":
					request.setService(doc.get("name"));
				default:
					break;
				}
			}

			/*
			 * Document doc = se.getDocument(hits[0].doc);
			 * 
			 * ArrayList<Service> service = null; switch (doc.get("name")) {
			 * case "Toilette": service = (ArrayList<Service>) (new
			 * ToiletteParser()).parseFile(); break; case "Lieu de culte":
			 * service = (ArrayList<Service>) (new CulteParser()).parseFile();
			 * break; }
			 * 
			 * for ( Service s: service) { //System.out.println(s.getInfo());
			 * 
			 * }
			 */

			System.out.println("performSearch done");
		} catch (Exception e) {
			System.out.println("Exception caught.\n");
		}
		
		if(request.isRequestComplete())
		{
			return request;
		}
		
		return null;
		
	}
}
