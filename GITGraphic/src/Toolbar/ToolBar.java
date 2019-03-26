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
	//���̾ƿ� ������ �ֱ� ���� �ڵ�� ���ٰ� ��� �Ⱥ��δ� . 
	
	private Vector<JButton> buttons;
//�̰��� assocatetion �̴� ������������ �������ذ��̴� . ����̾ƴϴ�
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
			button.setActionCommand(eToolBar.name());//����źƮ�� ��Ʈ�� �̸� ����
			button.addActionListener(actionHandler);
			this.buttons.add(button);
			this.add(button);
		}
	//�����ٿ� �ý�Ʈ�� ����ִ� ����� �̳ʹ� ���̼Ŵפ��� �����´�
	}
	
	public class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			drawingpanel.setCurrentTool(EToolBar.valueOf(event.getActionCommand()));		
			}
}
}
