package apt.app.giheung;

public class MyData{
    private String Date;
    private String DateText;

    public MyData(String Date, String DateText) {
        this.Date = Date;
        this.DateText = DateText;
    }

    public String Date(){
        return Date;
    }

    public String DateText(){
        return DateText;
    }
}
