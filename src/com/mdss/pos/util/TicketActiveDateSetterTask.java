package com.mdss.pos.util;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import com.mdss.pos.main.Application;
import com.mdss.pos.main.PosWindow;
import com.mdss.pos.model.Ticket;
import com.mdss.pos.model.dao.TicketDAO;
import com.mdss.pos.swing.GlassPane;
import com.mdss.pos.ui.dialog.POSMessageDialog;

public class TicketActiveDateSetterTask extends TimerTask {
	TicketDAO ticketDAO = new TicketDAO();
	
	@Override
	public void run() {
		PosWindow posWindow = Application.getPosWindow();
		GlassPane glassPane = (GlassPane) posWindow.getGlassPane();
		try {
			glassPane.setMessage("Updating system, please wait...");
			glassPane.setVisible(true);
			
			Calendar currentTime = Calendar.getInstance();
			int currentDay = currentTime.get(Calendar.DAY_OF_MONTH);

			List<Ticket> openTickets = ticketDAO.findOpenTickets();
			for (Ticket ticket : openTickets) {
				Date activeDate = ticket.getActiveDate();
				if(activeDate == null) {
					activeDate = ticket.getCreateDate();
				}
				currentTime.setTime(activeDate);
				int activeDay = currentTime.get(Calendar.DAY_OF_MONTH);
				if (currentDay > activeDay) {
					currentTime.set(Calendar.DAY_OF_MONTH, currentDay);
					ticket.setActiveDate(currentTime.getTime());

					ticketDAO.update(ticket);
				}
			}
		} catch (Exception e) {
			POSMessageDialog.showError(posWindow, "Error while updating ticket active date", e);
		} finally {
			glassPane.setVisible(false);
		}
	}

}
