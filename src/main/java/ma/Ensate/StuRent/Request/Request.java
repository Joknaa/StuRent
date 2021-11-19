package ma.ensate.sturent.Request;

import javax.persistence.*;

@Entity(name = "request") // This tells Hibernate to make a table out of this class
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Request_ID;
    private int Post_ID;
    private int Requester_ID;
    private String Status;

    public Request() { }
    public Request(int Post_ID, int Requester_ID) {
        setRequestID(0);
        setPostID(Post_ID);
        setRequesterID(Requester_ID);
        setStatus(RequestStatus.Waiting.toString());
    }
    public Request(int Request_ID, int Post_ID, int Requester_ID) {
        setRequestID(Request_ID);
        setPostID(Post_ID);
        setRequesterID(Requester_ID);
        setStatus(RequestStatus.Waiting.toString());
    }
    public Request(int Request_ID, int Post_ID, int Requester_ID, String Status) {
        setRequestID(Request_ID);
        setPostID(Post_ID);
        setRequesterID(Requester_ID);
        setStatus(Status);
    }

    public int getRequestID(){return this.Request_ID;}
    public int getPostID(){return this.Post_ID;}
    public int getRequesterID(){return this.Requester_ID;}
    public String getStatus(){return this.Status;}

    public void setRequestID(int ID){this.Request_ID = ID;}
    public void setPostID(int ID){this.Post_ID = ID;}
    public void setRequesterID(int ID){this.Requester_ID = ID;}
    public void setStatus(String status){this.Status = status;}
}
