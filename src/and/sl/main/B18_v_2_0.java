package and.sl.main;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import dom.main.XmlHandler;

public class B18_v_2_0 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String kw = "ô‘ó–Ôi’†j";
		
		String url = "http://jlp.yahooapis.jp/FuriganaService/V1/furigana" +
				"?appid=dj0zaiZpPTZjQWNRNExhd0thayZkPVlXazlhR2gwTTJGUE56SW1jR285TUEtLSZzPWNvbnN1bWVyc2VjcmV0Jng9Mjc-" +
				"&grade=1" +
				"&sentence=" + kw;

		String filename = "dat/furigana.xml";
		
		XmlHandler xh = new XmlHandler(filename);
		
		Document doc = xh.getDoc(url);

		System.out.println("["
				+ Thread.currentThread().getStackTrace()[1].getLineNumber()
				+ ":"
				+ Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "]"
				+ "doc.getChildNodes().getLength()=" + doc.getChildNodes().getLength());

		String tagName = "Word";
		

		
		NodeList nListWord = doc.getElementsByTagName(tagName);
		
		System.out.println("["
				+ Thread.currentThread().getStackTrace()[1].getLineNumber()
				+ ":"
				+ Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "]"
				+ "nListWord.getLength()=" + nListWord.getLength());
			//=> [41:main]nListWord.getLength()=5
		
		Node nWord = nListWord.item(0);
		
		System.out.println("["
				+ Thread.currentThread().getStackTrace()[1].getLineNumber()
				+ ":"
				+ Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "]"
				+ "nWord.getNodeName()=" + nWord.getNodeName()
				+ "/"
				+ "nWord.getNodeType()=" + nWord.getNodeType()
				+ "/"
				+ "nWord.getNodeValue()=" + nWord.getNodeValue());
			//=> [52:main]nWord.getNodeName()=Word/nWord.getNodeType()=1/nWord.getNodeValue()=null
		
		if (nWord.getNodeType() == Node.ELEMENT_NODE) {
			
			System.out.println("["
					+ Thread.currentThread().getStackTrace()[1].getLineNumber()
					+ ":"
					+ Thread.currentThread().getStackTrace()[1].getMethodName()
					+ "]" + "nWord => Element node");
			
		} else {//if (nWord.getNodeType() =)
			
			System.out.println("["
					+ Thread.currentThread().getStackTrace()[1].getLineNumber()
					+ ":"
					+ Thread.currentThread().getStackTrace()[1].getMethodName()
					+ "]" + "nWord => Not an element node");
			
		}//if (nWord.getNodeType() =)
			//=> [66:main]nWord => Element node
		
		NodeList nL_WordSurface = null;
		
		if (nWord.getNodeType() == Node.ELEMENT_NODE) {
			
			nL_WordSurface = ((Element) nWord).getElementsByTagName("Surface");
			
			System.out.println("["
					+ Thread.currentThread().getStackTrace()[1].getLineNumber()
					+ ":"
					+ Thread.currentThread().getStackTrace()[1].getMethodName()
					+ "]" + "nL_WordSurface => Initialized");
			
		} else {//if (nWord.getNodeType() == Node.ELEMENT_NODE)
			
			System.out.println("["
					+ Thread.currentThread().getStackTrace()[1].getLineNumber()
					+ ":"
					+ Thread.currentThread().getStackTrace()[1].getMethodName()
					+ "]" + "nWord => Not an element node");
			
			return;
			
		}//if (nWord.getNodeType() == Node.ELEMENT_NODE)
			//=> [90:main]nL_WordSurface => Initialized
		
		/*********************************
		 * Surface
		 *********************************/
		System.out.println("["
				+ Thread.currentThread().getStackTrace()[1].getLineNumber()
				+ ":"
				+ Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "]"
				+ "nL_WordSurface.getLength()=" + nL_WordSurface.getLength());
			//=> [111:main]nL_WordSurface.getLength()=1
		
		Node nSurface = nL_WordSurface.item(0);
		
		System.out.println("["
				+ Thread.currentThread().getStackTrace()[1].getLineNumber()
				+ ":"
				+ Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "]"
				+ "nSurface.getNodeName()=" + nSurface.getNodeName()
				+ "/"
				+ "nSurface.getNodeType()=" + nSurface.getNodeType()
				+ "/"
				+ "nSurface.getNodeValue()=" + nSurface.getNodeValue());
			//=> [122:main]nSurface.getNodeName()=Surface/nSurface.getNodeType()=1/nSurface.getNodeValue()=null
		
		/*********************************
		 * Furigana
		 *********************************/
		NodeList nl_WordFurigana = ((Element) nWord).getElementsByTagName("Furigana");
		
		System.out.println("["
				+ Thread.currentThread().getStackTrace()[1].getLineNumber()
				+ ":"
				+ Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "]"
				+ "nL_WordFurigana.getLength()=" + nl_WordFurigana.getLength());
			//=> 
		
		Node nFurigana = nl_WordFurigana.item(0);
		
		System.out.println("["
				+ Thread.currentThread().getStackTrace()[1].getLineNumber()
				+ ":"
				+ Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "]"
				+ "nFurigana.getNodeName()=" + nFurigana.getNodeName()
				+ "/"
				+ "nFurigana.getNodeType()=" + nFurigana.getNodeType()
				+ "/"
				+ "nFurigana.getNodeValue()=" + nFurigana.getNodeValue());
			//=> [151:main]nFurigana.getNodeName()=Furigana/nFurigana.getNodeType()=1/nFurigana.getNodeValue()=null
		
		/*********************************
		 * root
		 *********************************/
		Node nRoot = doc.getDocumentElement();
		
		System.out.println("["
				+ Thread.currentThread().getStackTrace()[1].getLineNumber()
				+ ":"
				+ Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "]"
				+ "nRoot.getNodeName()=" + nRoot.getNodeName()
				+ "/"
				+ "nRoot.getNodeType()=" + nRoot.getNodeType()
				+ "/"
				+ "nRoot.getNodeValue()=" + nRoot.getNodeValue());
		
		//=> [168:main]nRoot.getNodeName()=ResultSet/nRoot.getNodeType()=1/nRoot.getNodeValue()=null
		
		/*********************************
		 * Get node list: Word
		 *********************************/
		NodeList nlWord = null;
		
		if (nRoot.getNodeType() == Node.ELEMENT_NODE) {
			
			nlWord = ((Element) nRoot).getElementsByTagName("Word");
			
			System.out.println("["
					+ Thread.currentThread().getStackTrace()[1].getLineNumber()
					+ ":"
					+ Thread.currentThread().getStackTrace()[1].getMethodName()
					+ "]" + "nlWord => Initialized");
			
		} else {//if (nRoot.getNodeType() == Node.ELEMENT_NODE)
			
			System.out.println("["
					+ Thread.currentThread().getStackTrace()[1].getLineNumber()
					+ ":"
					+ Thread.currentThread().getStackTrace()[1].getMethodName()
					+ "]" + "nRoot => Not an element node");
			
			return;
			
		}//if (nRoot.getNodeType() == Node.ELEMENT_NODE)
			//=> 
		
		/*********************************
		 * Furigana2
		 *********************************/
		Node nWord2 = nlWord.item(0);
		
		NodeList nlWordFurigana = ((Element) nWord2).getElementsByTagName("Furigana");
		
		System.out.println("["
				+ Thread.currentThread().getStackTrace()[1].getLineNumber()
				+ ":"
				+ Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "]"
				+ "nlWordFurigana.getLength()=" + nlWordFurigana.getLength());
			//=> 
		
		Node nFurigana2 = nlWordFurigana.item(0);
		
		System.out.println("["
				+ Thread.currentThread().getStackTrace()[1].getLineNumber()
				+ ":"
				+ Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "]"
				+ "nFurigana2.getNodeName()=" + nFurigana2.getNodeName()
				+ "/"
				+ "nFurigana2.getNodeType()=" + nFurigana2.getNodeType()
				+ "/"
				+ "nFurigana2.getNodeValue()=" + nFurigana2.getNodeValue());
			//=> [226:main]nFurigana2.getNodeName()=Furigana/nFurigana2.getNodeType()=1/nFurigana2.getNodeValue()=null

		/*********************************
		 * Children of Furigana2
		 *********************************/
		NodeList nlFuriChild = nFurigana2.getChildNodes();
		
		Node nlFuriChild_First = nlFuriChild.item(0);
		
		System.out.println("["
				+ Thread.currentThread().getStackTrace()[1].getLineNumber()
				+ ":"
				+ Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "]"
				+ "nlFuriChild.getLength()=" + nlFuriChild.getLength());

			//=> [245:main]nlFuriChild.getLength()=1

		System.out.println("["
				+ Thread.currentThread().getStackTrace()[1].getLineNumber()
				+ ":"
				+ Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "]"
				+ "nlFuriChild_First.getNodeName()=" + nlFuriChild_First.getNodeName()
				+ "/"
				+ "nlFuriChild_First.getNodeType()=" + nlFuriChild_First.getNodeType()
				+ "/"
				+ "nlFuriChild_First.getNodeValue()=" + nlFuriChild_First.getNodeValue());

			//=> [254:main]nlFuriChild_First.getNodeName()=#text/nlFuriChild_First.getNodeType()=3/nlFuriChild_First.getNodeValue()=‚¹‚ñ‚½‚­
		
		System.out.println("["
				+ Thread.currentThread().getStackTrace()[1].getLineNumber()
				+ ":"
				+ Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "]"
				+ "Node.ELEMENT_NODE=" + Node.ELEMENT_NODE
				+ "/"
				+ "Node.ENTITY_NODE=" + Node.ENTITY_NODE
				+ "/"
				+ "Node.TEXT_NODE=" + Node.TEXT_NODE
				+ "/"
				+ "Node.DOCUMENT_NODE=" + Node.DOCUMENT_NODE
				+ "/");
		
			//=> [267:main]Node.ELEMENT_NODE=1/Node.ENTITY_NODE=6/Node.TEXT_NODE=3/Node.DOCUMENT_NODE=9/

		
		
		
		
//		System.out.println("["
//				+ Thread.currentThread().getStackTrace()[0].getLineNumber()
//				+ ":"
//				+ Thread.currentThread().getStackTrace()[0].getMethodName()
//				+ "]"
//				+ "doc.getChildNodes().getLength()=" + doc.getChildNodes().getLength());
//			//=> [-1:getStackTrace]doc.getChildNodes().getLength()=1
		
//		System.out.println("["
//				+ Thread.currentThread().getStackTrace()[2].getLineNumber()
//				+ ":"
//				+ Thread.currentThread().getStackTrace()[2].getMethodName()
//				+ "]"
//				+ "doc.getChildNodes().getLength()=" + doc.getChildNodes().getLength());

//		System.out.println("["
//			+ new Throwable().getStackTrace()[1].getLineNumber()
//			+ ":"
//			+ new Throwable().getStackTrace()[1].getMethodName()
//			+ "]"
//			+ "doc.getChildNodes().getLength()=" + doc.getChildNodes().getLength());

		
	}//public static void main(String[] args)

}//public class B18_v_2_0
