package ejercicios;

import org.w3c.dom.*;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;


/*Crea una clase llamada EscribirPeliculasXML, que tenga un método main.
Dentro del main, utiliza la clase Transformer para generar un nuevo fichero XML,
llamado copiaPeliculas.xml, que sea una copia del fichero peliculas.xml*/
public class EscribirPeliculasXML {
    public static void main(String[] args) {
        copiarXML("peliculas.xml");
        E216.leerXmL("copiaPeliculas.xml");
    }

    private static void copiarXML(String s) {
        try{
            Document doc = E216.leerXmL(s);
            doc.getDocumentElement().normalize();

            Element rootElement = doc.getDocumentElement();

            //Primer elemento
            Element elemento1 = doc.createElement("pelicula");
            rootElement.appendChild(elemento1);

            //Se agrega un atributo al nodo elemento y su valor
            NodeList nList = doc.getElementsByTagName("pelicula");
            Attr attr = doc.createAttribute("id");
            elemento1.setAttributeNode(attr);

            //se añaden elementos hijos al primer elemento

            Element titulo = doc.createElement("titulo");
            elemento1.appendChild(titulo);

            Element ano = doc.createElement("ano");
            elemento1.appendChild(ano);
            titulo.setTextContent("Contenido del elemento 2");

            Element precio = doc.createElement("precio");
            elemento1.appendChild(precio);
            titulo.setTextContent("Contenido del elemento 2");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    attr.setValue(eElement.getAttribute("id"));
                    titulo.setTextContent(eElement.getElementsByTagName("titulo").item(0).getTextContent());
                    ano.setTextContent(eElement.getElementsByTagName("ano").item(0).getTextContent());
                    precio.setTextContent(eElement.getElementsByTagName("precio").item(0).getTextContent());
                }
            }


            //Se escribe el contenido del XML en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();



            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("copiaPeliculas.xml"));



            transformer.transform(source, result);
            System.out.println("----------------------------");
            System.out.println(" La copia ha finalizado");
            System.out.println("----------------------------");
            System.out.println();


        }catch (TransformerException tfe) {
            tfe.printStackTrace();
        }

    }





}
