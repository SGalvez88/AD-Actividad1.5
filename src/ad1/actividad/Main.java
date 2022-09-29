package ad1.actividad;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

    public static void main(String[] args) throws SAXException, IOException {
        
        File file = new File("src\\resources\\Personas.xml");
        
        try {
            
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder =  documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            
            NodeList listaPersonas = document.getElementsByTagName("persona");
           
            for (int i = 0; i < listaPersonas.getLength(); i++) {
               
                NodeList listaDatosPersonalesPublicos = listaPersonas.item(i).getChildNodes();
               
                for (int j = 0; j < listaDatosPersonalesPublicos.getLength(); j++) {
                    
                    if(listaDatosPersonalesPublicos.item(j).getNodeName().equals("datosPersonales")){
                        
                        NodeList listaDatosPersonales = listaDatosPersonalesPublicos.item(j).getChildNodes();
                        
                        for (int k = 0; k < listaDatosPersonales.getLength(); k++) {
                            
                        }
                    }
                    
                    if(listaDatosPersonalesPublicos.item(j).getNodeName().equals("datosPublicos")){
                        
                        NodeList listaDatosPublicos = listaDatosPersonalesPublicos.item(j).getChildNodes();
                        
                        for (int k = 0; k < listaDatosPublicos.getLength(); k++) {
                        
                        }
                    }
                    
                }
                
            }
         
        } catch (ParserConfigurationException exception) {
            exception.getMessage();
        }
        
        
    }
}
