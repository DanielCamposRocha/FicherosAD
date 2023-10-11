package ejercicios;

import com.sun.org.apache.xml.internal.serializer.OutputPropertiesFactory;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import utilidades.Utilidades;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

/*
* Dado el archivo binario alumnos.dat que tiene el siguiente contenido:

Apellido "FERNANDEZ","LOPEZ","GOMEZ","CHEN","SERRANO","CASILLAS", "ALONSO"
Edad 17, 20, 18, 17, 19, 21, 20
Nota 7.5, 4.2, 6.5, 8.0, 3.2, 9.2, 9.9
* Desarrolla un programa Java que permita:

    Convertir el archivo binario a un archivo XML llamado alumnos.xml utilizando DOM.
    Visualizar el archivo alumnos.xml utilizando DOM.
    Visualizar el archivo alumnos.xml utilizando SAX.
    * <Alumnos>
    *   <Alumno>
            <apellido></apellido>
            <edad></edad>
            <nota></nota>
        </Alumno>
      </Alumnos>
*/
public class E218 {
    static String[] apellidos= {"FERNANDEZ","LOPEZ","GOMEZ","CHEN","SERRANO","CASILLAS", "ALONSO"};
    static int [] anhos={17, 20, 18, 17, 19, 21, 20};
    static double[] notas={7.5, 4.2, 6.5, 8.0, 3.2, 9.2, 9.9};


    private static void escribir() {
        File f= new File("alumnos.dat");
        try (DataOutputStream dos = new DataOutputStream(Files.newOutputStream(f.toPath()))){
            StringBuilder sb=new StringBuilder();
            for (int i=0;i< apellidos.length;i++){
                sb.append(apellidos[i]);
                sb.append(",");
                sb.append(anhos[i]);
                sb.append(",");
                sb.append(notas[i]);
                sb.append(";");
            }
            dos.writeUTF(sb.toString());
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String leer() {
        File f= new File("alumnos.dat");
        String lectura="";
        try (DataInputStream dis=new DataInputStream(Files.newInputStream(f.toPath()))){
                lectura=dis.readUTF();
                return lectura;
        }catch (IOException ex) {
            System.out.println("Error con el fichero");
        }
        return lectura;
    }

    public static void main(String[] args) {
        escribir();
        int a=Utilidades.pedirInt("Si desdea convertir a formato XML pulse 1, visualizar con Dom pulse 2, visualizar con sax pulse3");
        if(a==1)convertirDOM();
        if(a==2)visualizarDOM("alumnos.xml");
        if(a==3)visualizarSAX("alumnos.xml");
    }

    private static void visualizarSAX(String s) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();

            SAXParser parser = factory.newSAXParser();

            E218Sax lector = new E218Sax();
            parser.parse(s, lector);

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void visualizarDOM(String s) {
        try{
            File inputFile = new File(s);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();
            System.out.println("Elemento Raiz del XML :" +
                    doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("alumno");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                //System.out.println("\nElemento :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("Alumno :"+ eElement.getAttribute("Numero"));
                    System.out.println("Apellido : "+ eElement.getElementsByTagName("apellido").item(0).getTextContent());
                    System.out.println("Edad :"+ eElement.getElementsByTagName("edad").item(0).getTextContent());
                    System.out.println("Nota : "+ eElement.getElementsByTagName("nota").item(0).getTextContent());
                }
            }

        }catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

    private static void convertirDOM() {
        ArrayList<String[]>persona =new ArrayList<>();
        String lectura=leer();
        String[] alumnos=lectura.split(";");
        for (String otro:alumnos) {
            persona.add(otro.split(","));
        }

        try {
            DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder db= dbFactory.newDocumentBuilder();
            Document doc= db.newDocument();


            Element rootElement = doc.createElement("Alumnos");
            doc.appendChild(rootElement);

            for (int temp = 0; temp < alumnos.length; temp++) {
                String[] elementoNode = persona.get(temp);

                Element alumno = doc.createElement("alumno");
                rootElement.appendChild(alumno);
                alumno.setAttribute("Numero",String.valueOf(temp+1));

                Element apellido = doc.createElement("apellido");
                alumno.appendChild(apellido);
                Text apelido = doc.createTextNode(elementoNode[0]);
                apellido.appendChild(apelido);

                Element edad = doc.createElement("edad");
                alumno.appendChild(edad);
                Text idade = doc.createTextNode(elementoNode[1]);
                edad.appendChild(idade);

                Element notas = doc.createElement("nota");
                alumno.appendChild(notas);
                Text nota = doc.createTextNode(elementoNode[2]);
                notas.appendChild(nota);
            }

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                //Insertar saltos de línea al final de cada línea
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                //Añadir 3 espacios delante, en función del nivel de cada nodo
                transformer.setOutputProperty(OutputPropertiesFactory.S_KEY_INDENT_AMOUNT, "3");

                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("alumnos.xml"));
                transformer.transform(source, result);

                System.out.println("----------------------------");
                System.out.println(" La copia ha finalizado");
                System.out.println("----------------------------");
                System.out.println();



        } catch (ParserConfigurationException | TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }


}
