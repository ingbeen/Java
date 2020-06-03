import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EventActionListener implements ActionListener {
	JTable table;
	JTextField code_field, irum_field, su_field, dan_field;
	
	EventActionListener(JTable table, JTextField code_field, JTextField irum_field, JTextField su_field, JTextField dan_field){
		this.table = table;
		this.code_field = code_field;
		this.irum_field = irum_field;
		this.su_field = su_field;
		this.dan_field = dan_field;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("추가")) {
			insert();
		} else if(e.getActionCommand().equals("삭제")) {
			delete();
		} else {
			update();
		}

	}


	void insert() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Sangpum obj = new Sangpum();
		obj.code = code_field.getText().trim();
		if(obj.code.equals("")) {
			System.out.println("상품코드를 입력해주십시오");
			return;
		}
		boolean check = false;
		for(int i = 0; i < table.getRowCount(); i++) {
			if(obj.code.equals(model.getValueAt(i, 0))) {
				check = true;
				System.out.println("상품코드가 중복입니다");
				break;
			}
		}
		if(check) {
			return;
		}
		obj.irum = irum_field.getText().trim();
		try {
			obj.su = Integer.parseInt(su_field.getText().trim());
			obj.dan = Integer.parseInt(dan_field.getText().trim());
		}catch(NumberFormatException nfe) {
			System.out.println("수량과 단가를 입력해주십시오");
			return;
		}
		obj.price_calc();
		Object[] arr = new Object[5];
		arr[0] = obj.code;
		arr[1] = obj.irum;
		arr[2] = obj.su;
		arr[3] = obj.dan;
		arr[4] = obj.price;
		model.addRow(arr);
		code_field.setText("");
		irum_field.setText("");
		su_field.setText("");
		dan_field.setText("");
		System.out.println("상품정보 입력완료");
	}


	void delete() {
		int row = table.getSelectedRow();
		if(row == -1) {
			return;
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String code = (String) model.getValueAt(row, 0);
		model.removeRow(row);
		System.out.println(code + " 삭제완료");
	}


	void update() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String choice = code_field.getText().trim();
		Sangpum obj = new Sangpum();
		boolean check = false;
		int i;
		for(i = 0; i < table.getRowCount(); i++) {
			if(model.getValueAt(i, 0).equals(choice)) {
				obj.irum = irum_field.getText().trim();
				obj.su = Integer.parseInt(su_field.getText().trim());
				obj.dan = Integer.parseInt(dan_field.getText().trim());
				obj.price_calc();
				check = true;
				break;
			}
		}
		if(!check) {
			System.out.println("존재하지 않은 상품코드입니다");
			return;
		}
		model.setValueAt(obj.irum, i, 1);
		model.setValueAt(obj.su, i, 2);
		model.setValueAt(obj.dan, i, 3);
		model.setValueAt(obj.price, i, 4);
		irum_field.setText("");
		su_field.setText("");
		dan_field.setText("");
		System.out.println("상품정보 수정완료");
	}
}
