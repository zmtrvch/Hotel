import java.util.Date;

public class ClientCompanyItem {
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    private String business;
    private String contact;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}
