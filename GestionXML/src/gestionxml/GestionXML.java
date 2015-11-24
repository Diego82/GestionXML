package gestionxml;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class GestionXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if (args.length != 1) {
			System.out.println();
		} else {
			XMLOutputFactory factory = XMLOutputFactory.newFactory();
			try (FileOutputStream fos = new FileOutputStream(args[0])) {
				XMLStreamWriter writer = factory.createXMLStreamWriter(fos, "UTF-8");
				writer.writeStartDocument();
				writer.writeCharacters("\n");
				writer.writeStartElement("clientes");
				writer.writeCharacters("\n");

				Cliente c1 = new Cliente("Diego", "Torres", "andalucia", "diego@gmail.com", "333333333", 12341234);
				Cliente c2 = new Cliente("Pedro", "Martinez", "calle martos", "pedro@gmail.com", "333332233", 53441234);

				List<Cliente> listaClientes = new ArrayList<>();
				listaClientes.add(c1);
				listaClientes.add(c2);

				for (Cliente cliente : listaClientes) {
					writer.writeStartElement("cliente");
					writer.writeAttribute("dni", cliente.getNombre());
					writer.writeStartElement("nombre");
					writer.writeCharacters(cliente.getNombre());
					writer.writeEndElement();
					writer.writeStartElement("apellidos");
					writer.writeCharacters(cliente.getApellidos());
					writer.writeEndElement();
					writer.writeStartElement("direccion");
					writer.writeCharacters(cliente.getDireccion());
					writer.writeEndElement();
					writer.writeStartElement("email");
					writer.writeCharacters(cliente.getEmail());
					writer.writeEndElement();
					writer.writeStartElement("telefono");
					writer.writeCharacters(cliente.getTelefono());
					writer.writeEndElement();
					
				}

				writer.writeEndElement();
				writer.writeEndDocument();
				writer.close();
			} catch (IOException | XMLStreamException e) {
				// TODO Auto-generated catch block
				Logger.getLogger(GestionXML.class.getName()).log(Level.SEVERE, null, e);

			}
		}

	}
}
