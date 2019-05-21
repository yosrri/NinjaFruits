package ControlTheGame;

 import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class SaveGame {
	int lives = 16; 
	int score=79;
    public SaveGame(int lives, int score){
    	
    	this.lives = lives;
    	this.score = score;
            //constructor for highscore and lives and the path of the file
    }

    public void saveProgress(){


        try {


            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();


            // root element
            Element root = document.createElement("ninja");
            document.appendChild(root);





//            Element player = document.createElement("ninja");
//            root.appendChild(player);

            Element HighScore = document.createElement("HighScore");
            //where you need to write the no of lives in the file
            HighScore.appendChild(document.createTextNode(String.valueOf(score)));
            root.appendChild(HighScore);

            Element Lives = document.createElement("Lives");
            Lives.appendChild(document.createTextNode(String.valueOf(lives)));
            root.appendChild(Lives);





            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("C:/Users/OMAR/Desktop/Images/PriorityQueue.txt"));

            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging

            transformer.transform(domSource, streamResult);

            System.out.println("Done creating XML File");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();

        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}

