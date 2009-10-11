/*
 * GroupView.java
 *
 * Created on August 5, 2006, 9:29 PM
 */

package com.mdss.pos.ui.views.order;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import com.mdss.pos.model.MenuCategory;
import com.mdss.pos.model.MenuGroup;
import com.mdss.pos.model.dao.MenuGroupDAO;
import com.mdss.pos.swing.MessageDialog;
import com.mdss.pos.swing.PosButton;
import com.mdss.pos.ui.views.order.actions.GroupSelectionListener;

/**
 *
 * @author  MShahriar
 */
public class GroupView extends SelectionView {
	private Vector<GroupSelectionListener> listenerList = new Vector<GroupSelectionListener>();
    
	private MenuCategory menuCategory;
    
    public static final String VIEW_NAME = "GROUP_VIEW";
    
    /** Creates new form GroupView */
    public GroupView() {
        super("GROUPS");
        
        setBackEnable(false);
    }

	public MenuCategory getMenuCategory() {
		return menuCategory;
	}

	public void setMenuCategory(MenuCategory foodCategory) {
		this.menuCategory = foodCategory;

		reset();
		
		if (foodCategory == null) {
			return;
		}
		
		try {
			MenuGroupDAO dao = new MenuGroupDAO();
			List<MenuGroup> groups = dao.findEnabledByParent(foodCategory);
	        
	        for (int i = 0; i < groups.size(); i++) {
				MenuGroup foodGroup = groups.get(i);
				GroupButton button = new GroupButton(foodGroup);
				addButton(button);
			}
	        revalidate();
	        repaint();
		} catch (Exception e) {
			MessageDialog.showError(e);
		}
	}
	
	public void addGroupSelectionListener(GroupSelectionListener listener) {
		listenerList.add(listener);
	}
	
	public void removeGroupSelectionListener(GroupSelectionListener listener) {
		listenerList.remove(listener);
	}
	
	private void fireGroupSelected(MenuGroup foodGroup) {
		for (GroupSelectionListener listener : listenerList) {
			listener.groupSelected(foodGroup);
		}
	}
	
	
	private class GroupButton extends PosButton implements ActionListener {
		MenuGroup foodGroup;
		
		GroupButton(MenuGroup foodGroup) {
			this.foodGroup = foodGroup;
			
			setText(foodGroup.getName());
			addActionListener(this);
		}

		public void actionPerformed(ActionEvent e) {
			fireGroupSelected(foodGroup);
		}
	}

	@Override
	public void doGoBack() {
	}
}
