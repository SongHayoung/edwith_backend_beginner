package Domain;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class NameCard {
    String name;
    String phone;
    String company;
    String date;

    public NameCard() {}

    public NameCard(String name, String phone, String company) {
        this.name = name;
        this.phone = phone;
        this.company = company;
        this.date = new SimpleDateFormat("EEE MMM dd HH.mm.ss z yyyy", Locale.ENGLISH).format(new java.util.Date());
    }

    public void setName(String name) { this.name = name; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setCompany(String company) { this.company = company; }
    public void setDate(String date) { this.date = date; }

    public String getName() { return this.name; }
    public String getPhone() { return this.phone; }
    public String getCompany() { return this.company; }
    public String getDate() { return this.date; }
}
