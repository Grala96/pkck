package app;

import data.Database;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class FileController {

    public Database loadXML(File file) {

        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Database.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Database database = (Database) jaxbUnmarshaller.unmarshal(file);
            return database;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void saveXML(File file, Database database) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Database.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.marshal(database, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
