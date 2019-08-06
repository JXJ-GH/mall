package storePlatform.sj;

public class SJ {
    private Integer id;

    private String sjname;

    private String sjpassword;

    private String frname;

    private Integer frage;

    private String frbirnum;

    private String sjphone;

    private String sjdz;

    private int state;

    public SJ() {
    }

    public SJ(Integer id, String sjname, String sjpassword, String frname, Integer frage, String frbirnum, String sjphone, String sjdz, int state) {
        this.id = id;
        this.sjname = sjname;
        this.sjpassword = sjpassword;
        this.frname = frname;
        this.frage = frage;
        this.frbirnum = frbirnum;
        this.sjphone = sjphone;
        this.sjdz = sjdz;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSjname() {
        return sjname;
    }

    public void setSjname(String sjname) {
        this.sjname = sjname;
    }

    public String getSjpassword() {
        return sjpassword;
    }

    public void setSjpassword(String sjpassword) {
        this.sjpassword = sjpassword;
    }

    public String getFrname() {
        return frname;
    }

    public void setFrname(String frname) {
        this.frname = frname;
    }

    public Integer getFrage() {
        return frage;
    }

    public void setFrage(Integer frage) {
        this.frage = frage;
    }

    public String getFrbirnum() {
        return frbirnum;
    }

    public void setFrbirnum(String frbirnum) {
        this.frbirnum = frbirnum;
    }

    public String getSjphone() {
        return sjphone;
    }

    public void setSjphone(String sjphone) {
        this.sjphone = sjphone;
    }

    public String getSjdz() {
        return sjdz;
    }

    public void setSjdz(String sjdz) {
        this.sjdz = sjdz;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "SJ{" +
                "id=" + id +
                ", sjname='" + sjname + '\'' +
                ", sjpassword='" + sjpassword + '\'' +
                ", frname='" + frname + '\'' +
                ", frage=" + frage +
                ", frbirnum='" + frbirnum + '\'' +
                ", sjphone='" + sjphone + '\'' +
                ", sjdz='" + sjdz + '\'' +
                ", state=" + state +
                '}';
    }
}
