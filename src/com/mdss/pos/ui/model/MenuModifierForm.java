/*
 * ModifierEditor.java
 *
 * Created on August 4, 2006, 12:03 AM
 */

package com.mdss.pos.ui.model;

import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;

import com.mdss.pos.model.MenuModifier;
import com.mdss.pos.model.MenuModifierGroup;
import com.mdss.pos.model.Tax;
import com.mdss.pos.model.dao.ModifierDAO;
import com.mdss.pos.model.dao.ModifierGroupDAO;
import com.mdss.pos.model.dao.TaxDAO;
import com.mdss.pos.swing.ComboBoxModel;
import com.mdss.pos.swing.FixedLengthDocument;
import com.mdss.pos.swing.MessageDialog;
import com.mdss.pos.ui.BeanEditor;
import com.mdss.pos.ui.dialog.BeanEditorDialog;
import com.mdss.pos.util.POSUtil;

/**
 *
 * @author  MShahriar
 */
public class MenuModifierForm extends BeanEditor {

	/** Creates new form ModifierEditor */
	public MenuModifierForm() throws Exception {
		this(new MenuModifier());
	}

	public MenuModifierForm(MenuModifier modifier) throws Exception {
		initComponents();
		
		tfName.setDocument(new FixedLengthDocument(20));
		
		ModifierGroupDAO modifierGroupDAO = new ModifierGroupDAO();
		List<MenuModifierGroup> groups = modifierGroupDAO.findAll();
		cbModifierGroup.setModel(new DefaultComboBoxModel(new Vector<MenuModifierGroup>(groups)));
		
		TaxDAO taxDAO = new TaxDAO();
		List<Tax> taxes = taxDAO.findAll();
		cbTaxes.setModel(new ComboBoxModel(taxes));
		
		setBean(modifier);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new com.mdss.pos.swing.TransparentPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfExtraPrice = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        cbTaxes = new javax.swing.JComboBox();
        tfPrice = new javax.swing.JFormattedTextField();
        btnNewTax = new javax.swing.JButton();
        tfName = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        cbModifierGroup = new javax.swing.JComboBox();
        btnPrintToKitchen = new javax.swing.JCheckBox();

        jLabel2.setText("Price:");

        jLabel1.setText("Name:");

        jLabel3.setText("Extra Price:");

        jLabel5.setText("Tax Rate:");

        tfExtraPrice.setText("0");

        jLabel6.setText("%");

        tfPrice.setText("0");

        btnNewTax.setText("...");
        btnNewTax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewTaxActionPerformed(evt);
            }
        });

        jLabel4.setText("Group:");

        btnPrintToKitchen.setText("Print to kitchen");
        btnPrintToKitchen.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnPrintToKitchen.setMargin(new java.awt.Insets(0, 0, 0, 0));

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel5)
                    .add(jLabel1)
                    .add(jLabel4)
                    .add(jLabel2)
                    .add(jLabel3))
                .add(9, 9, 9)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(btnPrintToKitchen)
                        .addContainerGap())
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                            .add(tfName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                            .addContainerGap())
                        .add(jPanel1Layout.createSequentialGroup()
                            .add(cbModifierGroup, 0, 290, Short.MAX_VALUE)
                            .addContainerGap())
                        .add(jPanel1Layout.createSequentialGroup()
                            .add(cbTaxes, 0, 173, Short.MAX_VALUE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(btnNewTax)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(jLabel6)
                            .add(59, 59, 59))
                        .add(jPanel1Layout.createSequentialGroup()
                            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, tfExtraPrice)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, tfPrice, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                            .addContainerGap()))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(tfName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(cbModifierGroup, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(27, 27, 27)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel3)
                            .add(tfExtraPrice, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jLabel2)
                        .add(tfPrice, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(cbTaxes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnNewTax)
                    .add(jLabel6))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnPrintToKitchen)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("General", jPanel1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 194, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
	private void btnNewTaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewTaxActionPerformed
		try {
			TaxForm editor = new TaxForm();
			BeanEditorDialog dialog = new BeanEditorDialog(editor, getParentFrame(), true);
			dialog.open();
			if (!dialog.isCanceled()) {
				Tax tax = (Tax) editor.getBean();
				ComboBoxModel model = (ComboBoxModel) cbTaxes.getModel();
				model.addElement(tax);
				model.setSelectedItem(tax);
			}
		} catch (Exception x) {
			MessageDialog.showError("An error has occured, please restart the application", x);
		}
	}//GEN-LAST:event_btnNewTaxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewTax;
    private javax.swing.JCheckBox btnPrintToKitchen;
    private javax.swing.JComboBox cbModifierGroup;
    private javax.swing.JComboBox cbTaxes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private com.mdss.pos.swing.TransparentPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JFormattedTextField tfExtraPrice;
    private javax.swing.JFormattedTextField tfName;
    private javax.swing.JFormattedTextField tfPrice;
    // End of variables declaration//GEN-END:variables
	@Override
	public boolean save() {
		try {
			if(!updateModel()) return false;
			
			MenuModifier modifier = (MenuModifier) getBean();
			ModifierDAO dao = new ModifierDAO();
			dao.saveOrUpdate(modifier);
		} catch (Exception e) {
			MessageDialog.showError("An error has occured, could not save", e);
			return false;
		}
		return true;
	}

	@Override
	public void dispose() {
	}

	@Override
	protected void updateView() {
		MenuModifier modifier = (MenuModifier) getBean();
		
		if(modifier == null) {
			tfName.setText("");
			tfPrice.setText("0");
			tfExtraPrice.setText("0");
			return;
		}
		
		tfName.setText(modifier.getName());
		tfPrice.setValue(new Double(modifier.getPrice()));
		tfExtraPrice.setValue(Double.valueOf(modifier.getExtraPrice()));
		cbModifierGroup.setSelectedItem(modifier.getModifierGroup());
		btnPrintToKitchen.setSelected(modifier.isShouldPrintToKitchen());
		if(modifier.getTax() != null) {
			cbTaxes.setSelectedItem(modifier.getTax());
		}
	}

	@Override
	protected boolean updateModel() {
		MenuModifier modifier = (MenuModifier) getBean();

		String name = tfName.getText();
    	if(POSUtil.isBlankOrNull(name)) {
    		MessageDialog.showError("Name is required");
    		return false;
    	}
    	
		modifier.setName(name);
		modifier.setPrice(((Double) tfPrice.getValue()).doubleValue());
		modifier.setExtraPrice(((Double) tfExtraPrice.getValue()).doubleValue());
		modifier.setTax((Tax) cbTaxes.getSelectedItem());
		modifier.setModifierGroup((MenuModifierGroup) cbModifierGroup.getSelectedItem());
		modifier.setShouldPrintToKitchen(Boolean.valueOf(btnPrintToKitchen.isSelected()));
		
		return true;
	}

	public String getDisplayText() {
    	MenuModifier modifier = (MenuModifier) getBean();
    	if(modifier.getId() == null) {
    		return "New menu modifier";
    	}
    	return "Edit menu modifier";
    }
}
