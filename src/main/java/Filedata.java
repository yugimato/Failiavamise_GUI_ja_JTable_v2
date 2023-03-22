//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.time.LocalDate;

public class Filedata {
    private String firstname;
    private String lastname;
    private String gender;
    private LocalDate birth;
    private LocalDate death;
    private String place;
    private String type;
    private String county;
    private String[] colums;

    public Filedata(String firstname, String lastname, String gender, LocalDate birth, LocalDate death, String place, String type, String county) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.birth = birth;
        this.death = death;
        this.place = place;
        this.type = type;
        this.county = county;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getGender() {
        return this.gender;
    }

    public LocalDate getBirth() {
        return this.birth;
    }

    public LocalDate getDeath() {
        return this.death;
    }

    public String getPlace() {
        return this.place;
    }

    public String getType() {
        return this.type;
    }

    public String getCounty() {
        return this.county;
    }

    public int getColumnCount() {
        return this.colums == null ? 0 : this.colums.length;
    }
}
