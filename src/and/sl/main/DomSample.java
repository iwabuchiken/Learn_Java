/*********************************
 * REF=> http://www.fireproject.jp/feature/xml/programing/java-dom.html
 *********************************/
package and.sl.main;

import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomSample {

    protected Document doc;
    protected int tab;

    public DomSample(String filename){
	try{
	    DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
	    DocumentBuilder db=dbf.newDocumentBuilder();
	    /* XML文書を読み込む.*/
	    doc=db.parse(new FileInputStream(filename));
	}catch(Exception e){
	    e.printStackTrace();
	}
	tab=0;
    }

    public void getNodeInfo(Node node){
		tabbing();
		/* ノードの種類を出力 */
		System.out.println("Node type= "+node.getNodeType());
		tabbing();
		/* ノード名を出力 */
		System.out.println("Node name= "+node.getNodeName());
		tabbing();
		/* ノードの値を出力 */
	       	System.out.println("Node value= "+node.getNodeValue());
    }//public void getNodeInfo(Node node)

    /* 全ノードを探索 */
    public void walkThrough(){
	Node root=doc.getDocumentElement();
	recursiveWalk(root);
    }

    private void recursiveWalk(Node node){
		/*
		これは,XML文書のインデントなどの空白のノードを読み飛ばすための処理.
		Node.TEXT_NODE ノードがテキストで,ノードの値の空白を除いた文字列の長さが0の場合は読み飛ばす.
		*/
		   
		if(node.getNodeType()==Node.TEXT_NODE && node.getNodeValue().trim().length()==0){
		    return;
		}
		getNodeInfo(node);
		tab++;
		/* node.getFirstChild : nodeの最初の子を得る */
		/* child.getNextSibling : childの兄弟ノードを得る */
		for(Node child=node.getFirstChild();child!=null;child=child.getNextSibling()){
		    recursiveWalk(child);
		}
		
		tab--;
		
    }//private void recursiveWalk(Node node)

    protected void tabbing(){
	for(int i=0;i<tab;i++){
	    System.out.print("\t");
	}
    }

    public static void main(String args[]){
//		DomSample ds=new DomSample("sample.xml");
//    	DomSample ds=new DomSample("dat/sample.xml");
    	DomSample ds=new DomSample("dat/furigana.xml");
		ds.walkThrough();
    }
}

//Node type= 1
//Node name= ResultSet
//Node value= null
//	Node type= 1
//	Node name= Result
//	Node value= null
//		Node type= 1
//		Node name= WordList
//		Node value= null
//			Node type= 1
//			Node name= Word
//			Node value= null
//				Node type= 1
//				Node name= Surface
//				Node value= null
//					Node type= 3
//					Node name= #text
//					Node value= 洗濯
//				Node type= 1
//				Node name= Furigana
//				Node value= null
//					Node type= 3
//					Node name= #text
//					Node value= せんたく
//				Node type= 1
//				Node name= Roman
//				Node value= null
//					Node type= 3
//					Node name= #text
//					Node value= sentaku
//			Node type= 1
//			Node name= Word
//			Node value= null
//				Node type= 1
//				Node name= Surface
//				Node value= null
//					Node type= 3
//					Node name= #text
//					Node value= 網
//				Node type= 1
//				Node name= Furigana
//				Node value= null
//					Node type= 3
//					Node name= #text
//					Node value= もう
//				Node type= 1
//				Node name= Roman
//				Node value= null
//					Node type= 3
//					Node name= #text
//					Node value= mou
//			Node type= 1
//			Node name= Word
//			Node value= null
//				Node type= 1
//				Node name= Surface
//				Node value= null
//					Node type= 3
//					Node name= #text
//					Node value= （
//			Node type= 1
//			Node name= Word
//			Node value= null
//				Node type= 1
//				Node name= Surface
//				Node value= null
//					Node type= 3
//					Node name= #text
//					Node value= 中
//				Node type= 1
//				Node name= Furigana
//				Node value= null
//					Node type= 3
//					Node name= #text
//					Node value= なか
//				Node type= 1
//				Node name= Roman
//				Node value= null
//					Node type= 3
//					Node name= #text
//					Node value= naka
//			Node type= 1
//			Node name= Word
//			Node value= null
//				Node type= 1
//				Node name= Surface
//				Node value= null
//					Node type= 3
//					Node name= #text
//					Node value= ）
