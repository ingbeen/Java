import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EventActionListener implements ActionListener {
    JTable table;
    JTextField txtCode, txtIrum, txtSu, txtDanga, txtPrice;
    
    EventActionListener() {
    }
    //����
    EventActionListener(JTable table) {
    	this.table = table;
    }
    //�߰�, ����
    EventActionListener(JTable table, JTextField txtCode, JTextField txtIrum,
    		JTextField txtSu, JTextField txtDanga) {
        this.table = table;
        this.txtCode = txtCode;
        this.txtIrum = txtIrum;
        this.txtSu = txtSu;
        this.txtDanga = txtDanga;
    }
    
    public void actionPerformed(ActionEvent e) {
	    if (e.getActionCommand().equals("�߰�"))
	    {
	    	insert();
	    }
	    else if (e.getActionCommand().equals("����"))
	    {
	    	delete();
	    }
	    else
	    {
	    	update();
	    }
    }
    
    void insert()
    {
    	Sangpum obj = new Sangpum();
    	int i, rowNum, flag=0;
    	
    	DefaultTableModel model = (DefaultTableModel) table.getModel();
    	
    	obj.code = txtCode.getText().trim();
    	
    	rowNum = model.getRowCount();
        for (i=0; i<rowNum; i++)
        {
        	 String table_code = model.getValueAt(i, 0).toString().trim();
             if (table_code.equals(obj.code))
             {
                  flag=1;
                  break;
             }
        }
        
        if (flag == 0)
        {
        	obj.irum = txtIrum.getText().trim();
	        obj.su = Integer.parseInt(txtSu.getText().trim());
	        obj.dan = Integer.parseInt(txtDanga.getText().trim());
	        obj.process();
	     
	        Object arr[] = new Object[5];
	        arr[0] = obj.code;
	        arr[1] = obj.irum;
	        arr[2] = obj.su;
	        arr[3] = obj.dan;
	        arr[4] = obj.price;

	        model.addRow(arr);
	        System.out.println("��ǰ�ڵ� " + obj.code + " �߰� ����!");
        }
        else
        	System.out.println("��ǰ�ڵ� " + obj.code + " �ߺ������� �߰� ����!");
        
        txtCode.setText("");
        txtIrum.setText("");
        txtSu.setText("");
        txtDanga.setText("");
    }
    
    void delete()
    {
    	int row = table.getSelectedRow();
        if (row == -1)
            return;
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String code = model.getValueAt(row, 0).toString().trim();
        model.removeRow(row);
        System.out.println("��ǰ�ڵ� " + code + " ���� ����!");
    }
    
    void update()
    {
    	int i, rowNum, flag=0;
    	String table_hakbun = null;
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Sangpum obj = new Sangpum();
     
        obj.code = txtCode.getText().trim();
        
        rowNum = model.getRowCount();
        for (i=0; i<rowNum; i++)
        {
        	table_hakbun = model.getValueAt(i, 0).toString().trim();
             if (table_hakbun.equals(obj.code))
             {
            	  obj.su = Integer.parseInt(txtSu.getText().trim());
                  obj.dan = Integer.parseInt(txtDanga.getText().trim());
                  obj.process();
                  model.setValueAt(obj.su, i, 2);
                  model.setValueAt(obj.dan, i, 3);
                  model.setValueAt(obj.price, i, 4);
                  
                  flag=1;
                  break;
             }
        }
        if (flag == 0)
        	System.out.println("��ǰ�ڵ� " + obj.code + " ���� ����!");
        else
        	System.out.println("��ǰ�ڵ� " + obj.code + " ���� ����!");
        	
        txtCode.setText("");
        txtIrum.setText("");
        txtSu.setText("");
        txtDanga.setText("");

    }
}
