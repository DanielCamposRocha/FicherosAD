package ejercicios;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

public class E215 {
    public static void main(String[] args) {
        leerXmL("peliculas.xml");

    }

    public static Document leerXmL(String s) {
        try{
            File inputFile = new File(s);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();
            System.out.println("Elemento Raiz del XML :" +
                    doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("pelicula");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                //System.out.println("\nElemento :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("Película #"+ eElement.getAttribute("id")+":");
                    System.out.println("Título : "+ eElement.getElementsByTagName("titulo").item(0).getTextContent());
                    System.out.println("Año :"+ eElement.getElementsByTagName("ano").item(0).getTextContent());
                    System.out.println("Precio : "+ eElement.getElementsByTagName("precio").item(0).getTextContent());
                }
            }
            return doc;
        }catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
