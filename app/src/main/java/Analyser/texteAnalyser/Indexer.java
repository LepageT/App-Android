package Analyser.texteAnalyser;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class Indexer {

    /** Creates a new instance of Indexer */
    public Indexer() {
    }

    private IndexWriter indexWriter = null;

    public IndexWriter getIndexWriter(boolean create) throws IOException {
    	
    	File dir = new File("index-directory");
    	
        if (dir.exists()) {
        	for(String s: dir.list())
        	{
        		File current = new File(dir.getPath(), s);
        		current.delete();
        	}
        	dir.delete();
        }
        if (indexWriter == null) {

            File test = new File("index-directory");
            test.mkdir();
            Directory indexDir = FSDirectory.open(new File("index-directory"));
            
            IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_10_2, new StandardAnalyzer());
            indexWriter = new IndexWriter(indexDir, config);
        }
        return indexWriter;
   }

    public void closeIndexWriter() throws IOException {
        if (indexWriter != null) {
            indexWriter.close();
        }
   }

    public void indexHotel(Keyword keyword) throws IOException {

        System.out.println("Indexing Services: " + keyword);
        IndexWriter writer = getIndexWriter(false);
        Document doc = new Document();
        doc.add(new StringField("id", keyword.getId(), Field.Store.YES));
        doc.add(new StringField("name", keyword.getName(), Field.Store.YES));
        doc.add(new StringField("type", keyword.getType(), Field.Store.YES));
        String fullSearchableText = keyword.getName() + " " + keyword.getKeywords();
        doc.add(new TextField("content", fullSearchableText, Field.Store.NO));
        writer.addDocument(doc);
    }

    public void rebuildIndexes() throws IOException {
          //
          // Erase existing index
          //
          getIndexWriter(true);
          //
          // Index all Accommodation entries
          //
          Keyword[] keywords = KeywordDatabase.getKeywords();
          for(Keyword keyword : keywords) {
              indexHotel(keyword);
          }
          //
          // Don't forget to close the index writer when done
          //
          closeIndexWriter();
     }
    
}
