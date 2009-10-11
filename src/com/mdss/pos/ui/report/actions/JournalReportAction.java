package com.mdss.pos.ui.report.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JTabbedPane;

import com.mdss.pos.bo.ui.BackOfficeWindow;
import com.mdss.pos.main.Application;
import com.mdss.pos.ui.report.JournalReportView;

public class JournalReportAction extends AbstractAction {

	public JournalReportAction() {
		super("Journal Report");
	}

	public JournalReportAction(String name) {
		super(name);
	}

	public JournalReportAction(String name, Icon icon) {
		super(name, icon);
	}

	public void actionPerformed(ActionEvent e) {
		BackOfficeWindow window = Application.getInstance().getBackOfficeWindow();
		JTabbedPane tabbedPane = window.getTabbedPane();
		
		JournalReportView reportView = null;
		int index = tabbedPane.indexOfTab("Journal Report");
		if (index == -1) {
			reportView = new JournalReportView();
			tabbedPane.addTab("Journal Report", reportView);
		}
		else {
			reportView = (JournalReportView) tabbedPane.getComponentAt(index);
		}
		tabbedPane.setSelectedComponent(reportView);
	}

}
