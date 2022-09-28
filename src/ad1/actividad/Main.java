package ad1.actividad;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {
    
    private static final String caseDatosPersonales = "datosPersonales";
    private static final String caseDatosPublicos = "datosPublicos";

    public static void main(String[] args) {

        File file = new File("src\\resources\\Personas.xml");

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            

            Document document = documentBuilder.parse(file);

            document.getDocumentElement().normalize();

            NodeList personas = document.getElementsByTagName("persona");

            System.out.println("Nodos personas a recorrer: " + personas.getLength());

            for (int i = 0; i < personas.getLength(); i++) {

                Node nodePersona = personas.item(i);
                if (nodePersona.getNodeType() == Node.ELEMENT_NODE) {

                    Element elementoPersona = (Element) nodePersona;

                    NodeList personasHijos = elementoPersona.getChildNodes();

                    for (int j = 0; j < personasHijos.getLength(); j++) {

                        Node nodePersonasHijos = personasHijos.item(j);//cambiar nombre

                        if (nodePersonasHijos.getNodeType() == Node.ELEMENT_NODE) {

                            Element elementoHijoPersona = (Element) nodePersonasHijos;

                            switch (personasHijos.item(j).getNodeName()) {
                                case caseDatosPersonales:
                                    System.out.println("Id: " + elementoHijoPersona.getElementsByTagName("id").item(0).getTextContent());
                                    System.out.println("Apellido: "
                                            + elementoHijoPersona.getElementsByTagName("apellido").item(0).getTextContent());
                                    break;
                                case caseDatosPublicos:
                                    System.out.println("Departamento: "
                                            + elementoHijoPersona.getElementsByTagName("dep").item(0).getTextContent());
                                    System.out.println("Salario: "
                                            + elementoHijoPersona.getElementsByTagName("salario").item(0).getTextContent());
                                    break;
                            }
                        }
                    }
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }

}
