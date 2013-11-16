package il.ac.technion.cs.ssdl.cs234311.yp09.controller;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Will be used to extract the contents of the states from XML files
 * 
 * @date 11/16/2013
 * @email owais.musa@gmail.com
 * @author Owais Musa
 * 
 */
public class XMLScreenContentParser {

  /**
   * Extract the contents from the XML file and return it as arrays to strings
   * 
   * @param in_contentFile
   *          the XML file
   * @param out_shortPress
   * @param out_longPress
   */
  public static void parseScreenContent(final String in_contentFile,
      final String[] out_shortPress, final String[] out_longPress) {

    try {
      final File xmlFile = new File(in_contentFile);
      final DocumentBuilderFactory dbFactory = DocumentBuilderFactory
          .newInstance();
      final DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      final Document doc = dBuilder.parse(xmlFile);
      doc.getDocumentElement().normalize();

      // Extract long presses' contents
      for (int i = 0; i < 4; i++) {
        NodeList nodes = doc.getElementsByTagName("longPress" + i);
        assert nodes.getLength() == 1;

        Node node = nodes.item(0);
        assert node.getNodeType() == Node.ELEMENT_NODE;

        nodes = node.getChildNodes();
        node = nodes.item(0);

        out_longPress[i] = node.getNodeValue();
      }

      // Extract short presses' contents
      for (int i = 0; i < 4; i++) {
        NodeList nodes = doc.getElementsByTagName("shortPress" + i);
        assert nodes.getLength() == 1;

        Node node = nodes.item(0);
        assert node.getNodeType() == Node.ELEMENT_NODE;

        nodes = node.getChildNodes();
        node = nodes.item(0);

        out_shortPress[i] = node.getNodeValue();
      }
    } catch (final Exception ex) {
      ex.printStackTrace();
    }

  }
}
