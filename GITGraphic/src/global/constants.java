package global;

import Shape.Rectangle;
import Shape.Rectangle1;
import Shape.Rectangle2;
import Shape.Polygon;
import Shape.Shape;
public class constants {

	public enum EToolBar{
		//select("선택", new Select()),
		rectangle("네모", new Rectangle()),
		rectangle1("네모", new Rectangle1()),
		rectangle2("네모", new Rectangle2()),
		Polygon("폴리건", new Polygon()),
		//ellipse("동그라미", new Ellipse()),
		//line("선", new Line()),
		;
		// 셀렉트 하자마자 오브잭트가 텍스트에 선택 쉐이프에 네모가 들어간다
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
		//EToolBar select = new EToolBar("선택", new Select()), 원래는 필드에 오브젝트 바로 저장안했으면 이런식으로 객체를 만들수있다
		
	}
	public enum EMainFrame {//리소스 이메뉴랑 이메인프레임. 두개 분리하는게 좋다
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
