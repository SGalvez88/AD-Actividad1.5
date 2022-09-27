package ad1.actividad;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {

    public static void main(String[] args) {
        
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            
            File file = new File("src\\resources\\Personas.xml");
            
            Document document = documentBuilder.parse(file);
            
            document.getDocumentElement().normalize();
            
            NodeList personas = document.getElementsByTagName("persona");
            
            System.out.println("Nodos personas a recorrer: " + personas.getLength());
            
            for (int i = 0; i < personas.getLength(); i++) {
                    
                Node nodePersona = personas.item(i);
                    
                    if (nodePersona.getNodeType() == Node.ELEMENT_NODE) {
                        
                        Element elementoPersona = (Element)nodePersona;
                        
                        System.out.println(elementoPersona.getChildNodes());
                    }
               
            }
               
            
        } catch (Exception e) {
        }
    }
    
}
