package datamanagement;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.*;
 

/**
 * 
 * @author 11594210
 *
 */

public class CheckGradeUI extends  JFrame implements IUnitLister,IStudentLister {
	
	// private variable 
	private CheckGradeController ctl_;
	private  DefaultComboBoxModel uM_;
	private DefaultComboBoxModel rM_;
	
	float f1;
	float f2;
	float f3;
	Integer sid;

	public CheckGradeUI(CheckGradeController ctl) {
		this.ctl_ = ctl;
		uM_ = new DefaultComboBoxModel(new String[0]);
		rM_ = new DefaultComboBoxModel(new String[0]);
		initComponents();
		jComboBox1.setModel(uM_);
		jComboBox2.setModel(rM_);
		jlabel6.setText("");
	}

  
	
	private void initComponents() {

		jLabel1 = new  JLabel();
		jPanel1 = new  JPanel();
		jComboBox1 = new  JComboBox();
		jPanel2 = new  JPanel();
		jComboBox2 = new  JComboBox();
		jPanel3 = new  JPanel();
		jLabel2 = new  JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jTextField1 = new JTextField();
		jTextField2 = new JTextField();
		jTextField3 = new JTextField();
		jButton1 = new  JButton();
		jPanel4 = new  JPanel();
		jLabel5 = new  JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("KODEPACK SOLUTIONS");

		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		jLabel1.setText("Check Grade UI");

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unit"));

		jComboBox1.setModel(uM_);
		jComboBox1.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jComboBox1ItemStateChanged(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jComboBox1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 185,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout
						.createSequentialGroup()
						.addComponent(jComboBox1,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		jPanel2.setBorder(javax.swing.BorderFactory
				.createTitledBorder("Student"));

		jComboBox2.setModel(rM_);
		jComboBox2.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jComboBox2ItemStateChanged(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel2Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jComboBox2,
								javax.swing.GroupLayout.PREFERRED_SIZE, 185,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel2Layout
						.createSequentialGroup()
						.addComponent(jComboBox2,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Marks"));

		jLabel2.setText("Asg1:");

		jLabel3.setText("Asg2:");

		jLabel4.setText("Exam:");

		jTextField1.setEditable(false);
		jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				jTextFieldKeyTyped(evt);
			}
		});

		jTextField2.setEditable(false);
		jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				jTextFieldKeyTyped(evt);
			}
		});

		jTextField3.setEditable(false);
		jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				jTextFieldKeyTyped(evt);
			}
		});

		jButton1.setText("Change");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jButton2 = new javax.swing.JButton();
		
				jButton2.setText("Check Grade");
				jButton2.setActionCommand("checkGrade");
				jButton2.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						jButton3ActionPerformed(evt);
					}
				});

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3Layout.setHorizontalGroup(
			jPanel3Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
					.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel3Layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(jLabel2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(jLabel3))
						.addGroup(jPanel3Layout.createSequentialGroup()
							.addGap(85)
							.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(jPanel3Layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(jPanel3Layout.createSequentialGroup()
							.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(jLabel4))
						.addComponent(jButton2))
					.addGap(18)
					.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(15))
		);
		jPanel3Layout.setVerticalGroup(
			jPanel3Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel2)
						.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel3)
						.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel4)
						.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jButton1)
						.addComponent(jButton2))
					.addContainerGap())
		);
		jPanel3.setLayout(jPanel3Layout);

		jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Grade"));

		jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		jLabel5.setForeground(new java.awt.Color(255, 0, 0));
		jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel5.setText("grade");

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
				jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLabel5, javax.swing.GroupLayout.Alignment.TRAILING,
				javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel4Layout.createSequentialGroup().addGap(34, 34, 34)
						.addComponent(jLabel5)
						.addContainerGap(43, Short.MAX_VALUE)));
		
		jlabel6 = new JLabel();
		jlabel6.setText("Error message");
		jlabel6.setForeground(Color.RED);
		jlabel6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jButton3 = new javax.swing.JButton();
		
				jButton3.setText("Save");
				jButton3.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						jButton2ActionPerformed(evt);
					}
				});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(jlabel6, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
									.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(layout.createSequentialGroup()
							.addGap(157)
							.addComponent(jLabel1))
						.addGroup(layout.createSequentialGroup()
							.addGap(165)
							.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabel1)
					.addGap(13)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jButton3)
					.addGap(11)
					.addComponent(jlabel6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_jComboBox1ItemStateChanged
		String cU = (String) jComboBox1.getSelectedItem();
		Refresh3();
		clearStudents();
		if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
			if (cU.equals((String) jComboBox1.getItemAt(0))) {
				cU = "NONE";
			}
			ctl_.unitSelected(cU);
		}
	}// GEN-LAST:event_jComboBox1ItemStateChanged

	private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_jComboBox2ItemStateChanged
		Refresh3();
		String cS = (String) jComboBox2.getSelectedItem();
		if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
			if (cS.equals((String) jComboBox2.getItemAt(0))) {
				sid = new Integer(0);
				ctl_.studentSelected(sid);
			} else {
				sid = new Integer(cS.split("\\s")[0]);
			}
			ctl_.studentSelected(sid);
		}
	}// GEN-LAST:event_jComboBox2ItemStateChanged

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
		f1 = new Float(jTextField1.getText()).floatValue();
		f2 = new Float(jTextField2.getText()).floatValue();
		f3 = new Float(jTextField3.getText()).floatValue();
		//lblErrMsg.setText("");
		try {
			String s = ctl_.checkGrade(f1, f2, f3);
			jLabel5.setText(s);
		}
		catch (RuntimeException re) {
			jlabel6.setText(re.getMessage());
		}
	}// GEN-LAST:event_jButton3ActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		ctl_.enableChangeMarks();
		jLabel5.setText("");
		//lblErrMsg.setText("");
	}// GEN-LAST:event_jButton1ActionPerformed

	private void jTextFieldKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTextField1KeyTyped
		jLabel5.setText("");
		jlabel6.setText("");
	}// GEN-LAST:event_jTextField1KeyTyped

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		float asg1 = new Float(jTextField1.getText()).floatValue();
		float asg2 = new Float(jTextField2.getText()).floatValue();
		float exam = new Float(jTextField3.getText()).floatValue();
		jlabel6.setText("");
		try {
			ctl_.saveGrade(asg1, asg2, exam);
			//jButton3ActionPerformed(null);
		}
		catch (RuntimeException re) {
			jlabel6.setText(re.getMessage());
		}
	}// GEN-LAST:event_jButton2ActionPerformed

	public void clearUnits() {
		uM_.removeAllElements();
		uM_.addElement("<none selected>");
		clearStudents();
	}

	public void addUnit(IUnit u) {
		uM_.addElement(u.getUnitCode());
	}

	public void setState1(boolean b) {
		jComboBox1.setEnabled(b);
		jlabel6.setText("");
	}

	public void clearStudents() {
		rM_.removeAllElements();
		rM_.addElement("<none selected>");
	}

	public void addStudent(IStudent student) {
		rM_.addElement(student.getId().toString() + " : "
				+ student.getFirstName() + " " + student.getLastName());
	}

	public void setState2(boolean b) {
		jComboBox2.setEnabled(b);
		jlabel6.setText("");
	}

	public void setRecord(IStudentUnitRecord record) {
		jTextField1.setText(new Float(record.getAssignment1Marks()).toString());
		jTextField2.setText(new Float(record.getAssignment2Marks()).toString());
		jTextField3.setText(new Float(record.getExamMarks()).toString());
		jLabel5.setText("");
	}

	public void Refresh3() {
		jTextField1.setText("");
		jTextField2.setText("");
		jTextField3.setText("");
		jLabel5.setText("");
		jlabel6.setText("");
		jTextField1.setEditable(false);
		jTextField2.setEditable(false);
		jTextField3.setEditable(false);
	}

	public void setState3(boolean b) {
		jButton2.setEnabled(b);
	}

	public void setState4(boolean b) {
		jButton1.setEnabled(b);
		// gradeLB.setText("");
	}

	public void setState5(boolean b) {
		jTextField1.setEditable(b);
		jTextField2.setEditable(b);
		jTextField3.setEditable(b);
	}

	public void setState6(boolean b) {
		jButton3.setEnabled(b);
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JComboBox jComboBox2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jlabel6;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
}
