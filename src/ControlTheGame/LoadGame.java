package ControlTheGame;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.List;


public class LoadGame {
	GameMode game;
	
public 	LoadGame(GameMode game) {

	this.game = game;

}


    public void loadProgress() {
        try {
            File inputFile = new File("C:/Users/OMAR/Desktop/Images/PriorityQueue.txt");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList bList = doc.getElementsByTagName("ninja");
            NodeList nSList = doc.getElementsByTagName("HighScore");
            NodeList bPList = doc.getElementsByTagName("Lives");
            System.out.println("----------------------------");




            Node bNode = bList.item(0);

            for (int temp = 0; temp < bPList.getLength(); temp++) {
                Element eElement = (Element) bNode;
                eElement.getElementsByTagName("HighScore").item(0).getTextContent();
                
                game.setScore(Integer.parseInt(eElement.getElementsByTagName("HighScore").item(0).getTextContent()));
//                boat.setNoSails(Integer.valueOf(eElement.getElementsByTagName("HighScore").item(0).getTextContent()));
                eElement.getElementsByTagName("Lives").item(0).getTextContent();
                game.setGameVariable(Integer.parseInt(eElement.getElementsByTagName("Lives").item(0).getTextContent()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}