package ejercicios;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class E218Sax  extends DefaultHandler {
    private StringBuilder valor;

    public E218Sax() {
        this.valor = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qname, Attributes attributes) throws SAXException {
        this.valor.setLength(0);
        if (qname.equals("alumno")) {
            System.out.println("-----------");
            String numero = attributes.getValue("Numero");
            System.out.println("Numero de alumno "+numero);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        this.valor.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        switch (qName) {
            case "alumno":
                System.out.println("-----------");
                break;
            case "apellido":
                System.out.println("Apellido: " + this.valor.toString());
                break;
            case "edad":
                System.out.println("Edad: " + this.valor.toString());
                break;
            case "nota":
                System.out.println("Nota: " + this.valor.toString());
                break;

        }

    }
}
