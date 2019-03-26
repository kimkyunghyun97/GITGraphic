package Toolbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JToolBar;

import DrawingPanel.Drawingpanel;
import global.constants.EToolBar;

public class ToolBar extends JToolBar {
	private static long serialversionUID = 1L;
	//레이아웃 사이즈 주기 현재 코드는 툴바가 깔려 안보인다 . 
	
	private Vector<JButton> buttons;
//이것은 assocatetion 이다 메인프레임이 연결해준것이다 . 상속이아니다
	private Drawingpanel drawingpanel;
	
	public void associate(Drawingpanel drawingpanel) {
		// TODO Auto-generated method stub
		this.drawingpanel = drawingpanel;
	}
	public ToolBar(){
		ActionHandler actionHandler = new ActionHandler();
		this.buttons = new Vector<JButton>();
		for(EToolBar eToolBar: EToolBar.values()){
			JButton button = new JButton(eToolBar.getText());
			button.setActionCommand(eToolBar.name());//컨스탄트에 스트링 이름 저장
			button.addActionListener(actionHandler);
			this.buttons.add(button);
			this.add(button);
		}
	//각툴바에 택스트를 집어넣다 몇번제 이너미 네이셔닝ㄴ지 꺼내온다
	}
	
	public class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			drawingpanel.setCurrentTool(EToolBar.valueOf(event.getActionCommand()));		
			}
}
}
