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
	    /* XML������ǂݍ���.*/
	    doc=db.parse(new FileInputStream(filename));
	}catch(Exception e){
	    e.printStackTrace();
	}
	tab=0;
    }

    public void getNodeInfo(Node node){
		tabbing();
		/* �m�[�h�̎�ނ��o�� */
		System.out.println("Node type= "+node.getNodeType());
		tabbing();
		/* �m�[�h�����o�� */
		System.out.println("Node name= "+node.getNodeName());
		tabbing();
		/* �m�[�h�̒l���o�� */
	       	System.out.println("Node value= "+node.getNodeValue());
    }//public void getNodeInfo(Node node)

    /* �S�m�[�h��T�� */
    public void walkThrough(){
	Node root=doc.getDocumentElement();
	recursiveWalk(root);
    }

    private void recursiveWalk(Node node){
		/*
		�����,XML�����̃C���f���g�Ȃǂ̋󔒂̃m�[�h��ǂݔ�΂����߂̏���.
		Node.TEXT_NODE �m�[�h���e�L�X�g��,�m�[�h�̒l�̋󔒂�������������̒�����0�̏ꍇ�͓ǂݔ�΂�.
		*/
		   
		if(node.getNodeType()==Node.TEXT_NODE && node.getNodeValue().trim().length()==0){
		    return;
		}
		getNodeInfo(node);
		tab++;
		/* node.getFirstChild : node�̍ŏ��̎q�𓾂� */
		/* child.getNextSibling : child�̌Z��m�[�h�𓾂� */
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
//					Node value= ����
//				Node type= 1
//				Node name= Furigana
//				Node value= null
//					Node type= 3
//					Node name= #text
//					Node value= ���񂽂�
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
//					Node value= ��
//				Node type= 1
//				Node name= Furigana
//				Node value= null
//					Node type= 3
//					Node name= #text
//					Node value= ����
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
//					Node value= �i
//			Node type= 1
//			Node name= Word
//			Node value= null
//				Node type= 1
//				Node name= Surface
//				Node value= null
//					Node type= 3
//					Node name= #text
//					Node value= ��
//				Node type= 1
//				Node name= Furigana
//				Node value= null
//					Node type= 3
//					Node name= #text
//					Node value= �Ȃ�
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
//					Node value= �j
