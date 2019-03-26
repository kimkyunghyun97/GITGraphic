package global;

import Shape.Rectangle;
import Shape.Rectangle1;
import Shape.Rectangle2;
import Shape.Polygon;
import Shape.Shape;
public class constants {

	public enum EToolBar{
		//select("����", new Select()),
		rectangle("�׸�", new Rectangle()),
		rectangle1("�׸�", new Rectangle1()),
		rectangle2("�׸�", new Rectangle2()),
		Polygon("������", new Polygon()),
		//ellipse("���׶��", new Ellipse()),
		//line("��", new Line()),
		;
		// ����Ʈ ���ڸ��� ������Ʈ�� �ؽ�Ʈ�� ���� �������� �׸� ����
		private String text;
		private Shape shape;
		private EToolBar(String text, Shape shape){
			this.text =text;
			this.shape =shape;
		}
		public Shape getshape(){
			return this.shape;
		}
		public String getText(){
			return this.text;
		}
		//EToolBar select = new EToolBar("����", new Select()), ������ �ʵ忡 ������Ʈ �ٷ� ����������� �̷������� ��ü�� ������ִ�
		
	}
	public enum EMainFrame {//���ҽ� �̸޴��� �̸���������. �ΰ� �и��ϴ°� ����
		x(200), 
		y(100),
		w(400),
		h(600)
		;
		private int value;
		private EMainFrame(int value){
		this.value= value;
				
		}
		public int getValue(){
		return this.value;
	}
		}
	
	public enum EMenu{
	fileMenu("FILE"),
	editMenu("EDIT"),
	;
	private String text;
	private EMenu(String text){
	this.text= text;
			
	}
	public String getText(){
	return this.text;
}
	}
	public enum EFileMenu{
		newItem("new"),
		openItem("open"),
		;
		private String text;
		private EFileMenu(String text){
		this.text= text;
				
		}
		public String getText(){
		return this.text;
	}

}
	}
