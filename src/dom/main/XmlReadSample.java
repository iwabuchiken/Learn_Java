/*********************************
 * 20130214_140339
 * REF=> http://axbeak.blog60.fc2.com/blog-entry-287.html
 *********************************/
package dom.main;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlReadSample {
	 
		public static void main(String[] args) {
			
//				String filename = "dat/sample.xml";
				String filename = "dat/furigana.xml";
				
				try {
				    new XmlReader(filename).showXml();
				} catch (SAXException e) {
				    e.printStackTrace();
				} catch (IOException e) {
				    e.printStackTrace();
				} catch (ParserConfigurationException e) {
				    e.printStackTrace();
				}
		}
 
		static class XmlReader {
 
				private final String filename;
 
				/**
				 * �R���X�g���N�^
				 * @param filename �Ǎ��t�@�C���p�X
				 */
				public XmlReader(String filename) {
				    this.filename = filename;
				}
 
				/**
				 * XML�t�@�C���̓��e��\������
				 * @throws SAXException
				 * @throws IOException
				 * @throws ParserConfigurationException
				 */
				public void showXml() throws SAXException, IOException,
				        ParserConfigurationException {
				    Document doc = DocumentBuilderFactory.newInstance()
				            .newDocumentBuilder().parse(new File(filename));
				    showChildNodes(doc.getChildNodes(), 0);
				}
 
				/**
				 * XML�̗v�f�����o���\������
				 * @param nodeList
				 * @param level
				 */
				private void showChildNodes(NodeList nodeList, int level) {
				    if (nodeList == null) {
				        return;
				    }
 
				    for (int i = 0; i < nodeList.getLength(); i++) {
				        Node node = nodeList.item(i);
				        if (node.getNodeType() == Node.TEXT_NODE) {
				            String text = node.getNodeValue().trim();
				            if (!text.isEmpty()) {
				                System.out.println(String.format("%sText:%s",
				                        indent(level), text));
				            }
				            continue;
				        }
				        if (!(node instanceof Element)) {
				            continue;
				        }
 
				        Element element = (Element) node;
				        String tagName = element.getTagName();
				        String attributes = getAttributeStrings(element.getAttributes());
				        System.out.println(String.format(
				                "%sTagName:%s, Attributes:[%s]", indent(level), tagName,
				                attributes));
 
				        showChildNodes(element.getChildNodes(), level + 1);
				    }
				}
 
				/**
				 * Attributes�̓��e�𕶎���Ŏ擾
				 * @param attributes
				 * @return Attributes�̕�����
				 */
				private String getAttributeStrings(NamedNodeMap attributes) {
				    if (attributes == null) {
				        return "";
				    }
 
				    StringBuffer sb = new StringBuffer();
				    for (int i = 0; i < attributes.getLength(); i++) {
				        Node node = attributes.item(i);
				        String nodeName = node.getNodeName();
				        String nodeValue = node.getNodeValue();
				        sb.append(nodeName).append("=").append(nodeValue);
 
				        if (i < attributes.getLength() - 1) {
				            sb.append(", ");
				        }
				    }
 
				    return sb.toString();
				}
		}
 
		/**
		 * �C���f���g�쐬
		 * @param level
		 * @return �C���f���g������
		 */
		public static String indent(int level) {
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < level; i++) {
				    sb.append('\t');
				}
				return sb.toString();
		}
}