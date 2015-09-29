package apt.app.giheung;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by jaebeomlee on 2014. 4. 12..
 */

public class haksa extends Activity {

    Date calender = new Date();
    int year;
    int month;
    int date;
    int day;
    int lastday;

    TextView tv;
    TextView tv2;
    Calendar calendar = Calendar.getInstance();
    String tbody;

    MyAdapter adapter;
    ListView list;
    ArrayList<MyData> arrData;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.haksa);
        year = calender.getYear() + 1900;
        month = calender.getMonth() + 1;
        date = calender.getDate();
        day = calender.getDay();




        setData();







        }

    private void setData() {
        arrData = new ArrayList<MyData>();
        Calendar cal = Calendar.getInstance();
        int caldate = cal.getMaximum(Calendar.DAY_OF_MONTH);



        new Thread() {
            @Override
            public void run() {
                Document document;
                try {
                    String url = "http://giheung.hs.kr/?_page=130&"
                            + "yy="
                            + year
                            + "&mm="
                            + month;
                    int datenumber = 0;
                    if (month == 1 || month == 3 || month == 5
                            || month == 7 || month == 8 || month == 10
                            || month == 12) {
                        //마지막 날이 31일인 달
                        datenumber= 31;
                    } else if (month == 4 || month == 6 || month == 9
                            || month == 11) {
                        //마지막 날이 30일인 달
                        datenumber=30;
                    } else if (month == 2) {
                        if (year % 4 == 0) {
                            if (year % 100 == 0) {
                                if (year % 400 == 0) {

                                    //2월의 마지막 날이 29일
                                    datenumber = 29;
                                }
                                //2월의 마지막 날이 28일
                                datenumber = 28;

                            }
                            //2월의 마지막 날이 29일
                            datenumber = 29;
                        } else {
                            //2월의 마지막 날이 28일
                            datenumber = 28;
                        }
                    }

                    document = (Document) Jsoup.connect(url).get();
                    Elements table = document.select("table");


                    tbody = table.toString();
                    tbody = tbody.split("<tbody>")[1];


                    tbody= tbody.split("<span class=\"day2")[24];



                    final int finalDate1 = datenumber;

                    arrData.add(new MyData("A","A"));
                    arrData.add(new MyData("A","A"));
                    arrData.add(new MyData("A","A"));



                    list = (ListView)findViewById(R.id.List);
                    list.setAdapter(adapter);
                    adapter = new MyAdapter(haksa.this, arrData);
                    
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {


                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }

}


