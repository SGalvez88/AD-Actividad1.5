package ad1.actividad;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

    private static final String RUTA_LECTURA = "src\\resources\\Personas.xml";

    private static HashMap<Persona, Integer> personas;
    private static File file;

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {

        personas = new HashMap<>();

        try {

            recorrerFicheroXML(iniciarLecturaXML());
            mostrarPersona();

        } catch (ParserConfigurationException exception) {
            exception.getMessage();
        }
    }

    public static NodeList iniciarLecturaXML() throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File(RUTA_LECTURA));

        NodeList listaPersonas = document.getElementsByTagName("persona");

        return listaPersonas;
    }

    public static void recorrerFicheroXML(NodeList listaPersonas) {
        
        NodeList listaDatosPersonales = null;
        NodeList listaDatosPublicos = null;
                
        for (int i = 0; i < listaPersonas.getLength(); i++) {

            NodeList listaDatosPersonalesPublicos = listaPersonas.item(i).getChildNodes();

            for (int j = 0; j < listaDatosPersonalesPublicos.getLength(); j++) {

                if (listaDatosPersonalesPublicos.item(j).getNodeName().equals("datosPersonales")) {

                    listaDatosPersonales = listaDatosPersonalesPublicos.item(j).getChildNodes();

                }

                if (listaDatosPersonalesPublicos.item(j).getNodeName().equals("datosPublicos")) {

                    listaDatosPublicos = listaDatosPersonalesPublicos.item(j).getChildNodes();

                }
            }
            crearPersona(listaDatosPersonales, listaDatosPublicos);
        }
    }

    public static void crearPersona(NodeList listaDatosPersonales, NodeList listaDatosPublicos) {

        int id = 0;
        String apellido = null;
        String departamento = null;
        float salario = 0;

        for (int k = 0; k < listaDatosPersonales.getLength(); k++) {
            if (listaDatosPersonales.item(k).getNodeName().equals("id")) {
                id = Integer.parseInt(listaDatosPersonales.item(k).getTextContent());
            } else if (listaDatosPersonales.item(k).getNodeName().equals("apellido")) {
                apellido = listaDatosPersonales.item(k).getTextContent();
            }
        }

        for (int k = 0; k < listaDatosPublicos.getLength(); k++) {

            if (listaDatosPublicos.item(k).getNodeName().equals("dep")) {
                departamento = listaDatosPublicos.item(k).getTextContent();

            } else if (listaDatosPublicos.item(k).getNodeName().equals("salario")) {
                salario = Float.parseFloat(listaDatosPublicos.item(k).getTextContent());

            }
        }
        
        addPerson(new Persona(id, apellido, departamento, salario));
    }
    
    public static void addPerson(Persona persona){
        personas.put(persona, persona.getId());
    }

    public static void mostrarPersona() {

        for (Persona personaLista : personas.keySet()) {
            System.out.println(personaLista.toString());

        }
    }

}
