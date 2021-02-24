package JavaRush.JavaRush_Projects.hhBot;

public class Data {
    private String hhtoken;
    private String hhuid;
    private String referrer_id;
    private String idResume;

    public Data(String hhtoken, String hhuid, String referrer_id,String idResume) {
        this.hhtoken = hhtoken;
        this.hhuid = hhuid;
        this.referrer_id = referrer_id;
        this.idResume = idResume;
    }

    public String getHhtoken() {
        return hhtoken;
    }

    public String getHhuid() {
        return hhuid;
    }

    public String getReferrer_id() {
        return referrer_id;
    }

    public String getIdResume() {
        return idResume;
    }

    public void setHhtoken(String hhtoken) {
        this.hhtoken = hhtoken;
    }

    public void setHhuid(String hhuid) {
        this.hhuid = hhuid;
    }

    public void setReferrer_id(String referrer_id) {
        this.referrer_id = referrer_id;
    }

    public void setIdResume(String idResume) {
        this.idResume = idResume;
    }
}
