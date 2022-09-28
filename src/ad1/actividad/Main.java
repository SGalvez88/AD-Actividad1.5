package ad1.actividad;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

    private static final String datosPersonales = "datosPersonales";
    private static final String datosPublicos = "datosPublicos";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

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

                NodeList datosPersonalesYDatosPublicos = nodePersona.getChildNodes();

                for (int j = 0; j < datosPersonalesYDatosPublicos.getLength(); j++) {
                    System.out.println("El nombre del nodo es: " + datosPersonalesYDatosPublicos.item(j).getNodeName());
                    
                    Node nodeDatosPersonalesYDatosPublicos = datosPersonalesYDatosPublicos.item(j);
                    
                    //if (datosPersonalesYDatosPublicos.item(j).getNodeName().equals("datosPersonales")) {
                    if (nodeDatosPersonalesYDatosPublicos.getNodeName().equals("datosPersonales")) {
                        
                        NodeList idApellidoDepSalario = datosPersonalesYDatosPublicos.item(j).getChildNodes(); //obtienes un node y sus hijos

                        for (int k = 0; k < idApellidoDepSalario.getLength(); k++) {
                            
                            System.out.println("El nombre del nodo es: " + idApellidoDepSalario.item(k).getNodeName());

                        }

                    //} else if (datosPersonalesYDatosPublicos.item(j).getNodeName().equals("datosPublicos")) {
                    } else if (nodeDatosPersonalesYDatosPublicos.getNodeName().equals("datosPublicos")) {

                        NodeList idApellidoDepSalario = datosPersonalesYDatosPublicos.item(j).getChildNodes(); //obtienes un node y sus hijos

                        for (int k = 0; k < idApellidoDepSalario.getLength(); k++) {
                           
                            System.out.println("El nombre del nodo es: " + idApellidoDepSalario.item(k).getNodeName());

                        }

                    }

                }

                /*
                if (nodePersona.getNodeType() == Node.ELEMENT_NODE) {

                    Element elementoPersona = (Element) nodePersona;

                    NodeList NodeListPersonasHijos = elementoPersona.getChildNodes();

                    for (int j = 0; j < NodeListPersonasHijos.getLength(); j++) {

                        Node nodePersonasHijos = NodeListPersonasHijos.item(j);

                        if (nodePersonasHijos.getNodeType() == Node.ELEMENT_NODE) {

                            Element elementoHijoPersona = (Element) nodePersonasHijos;

                            NodeList nodeListDatosHijos = elementoHijoPersona.getChildNodes();

                            for (int k = 0; k < nodeListDatosHijos.getLength(); k++) {

                                Node nodeDatosHijos = nodeListDatosHijos.item(k);

                                if (nodeDatosHijos.getNodeType() == Node.ELEMENT_NODE) {
                                    
                                    Element elementoDatosHijos = (Element) nodeDatosHijos;
                                   
                                   
                                        System.out.println(elementoDatosHijos.getElementsByTagName("id").item(0).getTextContent());
                                        System.out.println(elementoDatosHijos.getElementsByTagName("apellido").item(0).getTextContent());
                                                                   
                                        System.out.println(elementoDatosHijos.getElementsByTagName("dep").item(0).getTextContent());
                                        System.out.println(elementoDatosHijos.getElementsByTagName("salario").item(0).getTextContent());
                                    

                                }

                            }

                            /*switch (personasHijos.item(j).getNodeName()) {
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
                 */
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
