package Pojo;

public class Jira {
	int Ticketid;
	String Assignee;
	String Reporter;
	String Heading;
	String Notify;
	String Statusto;
	public Jira(int ticketid, String assignee, String reporter, String heading, String notify, String statusto) {
		///super();
		Ticketid = ticketid;
		Assignee = assignee;
		Reporter = reporter;
		Heading = heading;
		Notify = notify;
		Statusto = statusto;
	}
	
	public int getTicketid() {
		return Ticketid;
	}

	public void setTicketid(int ticketid) {
		Ticketid = ticketid;
	}

	public String getAssignee() {
		return Assignee;
	}

	public void setAssignee(String assignee) {
		Assignee = assignee;
	}

	public String getReporter() {
		return Reporter;
	}

	public void setReporter(String reporter) {
		Reporter = reporter;
	}

	public String getHeading() {
		return Heading;
	}

	public void setHeading(String heading) {
		Heading = heading;
	}

	public String getNotify() {
		return Notify;
	}

	public void setNotify(String notify) {
		Notify = notify;
	}

	public String getStatusto() {
		return Statusto;
	}

	public void setStatusto(String statusto) {
		Statusto = statusto;
	}

	public Jira() {
		//super();
	}
	
}
