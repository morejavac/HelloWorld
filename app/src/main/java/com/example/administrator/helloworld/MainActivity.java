package com.example.administrator.helloworld;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //定义视图控件的引用（private）
    private TextView mTxtSjSj;
    private TextView mTxtTzSj ;
    private Button mBtnZ ;
    private Button mBtnZC ;
    private Button mBtnXW ;
    private Button mBtnW ;
    private Button mBtnTbSj ;
    private DatePicker mDatePikRq;

    //定义其他类引用

    //定义本活动成员(private)
    private Calendar calendar;
    private int year;
    private int monthOfYear;
    private int dayOfMonth;
    private int hh;
    private int mm;
    private int ss;

    //定义本活动私有方法
    private void showDateTime(){
        Toast.makeText(MainActivity.this,
                OpUtils.DATEPIC_TZ_MSG+year+
                        OpUtils.DATEPIC_YEAR_MSG+(monthOfYear+1)+
                        OpUtils.DATEPIC_MONTH_MSG+dayOfMonth+
                        OpUtils.DATEPIC_DAYOFMONTH_MSG+hh+
                        OpUtils.DATEPIC_TZ_HH+mm+
                        OpUtils.DATEPIC_TZ_MM+ss+
                        OpUtils.DATEPIC_TZ_SS,Toast.LENGTH_SHORT).show();
        this.istbsj=false;

    }
    private static final int msgKey1 = 1;
    private boolean stopthread=false;
    private boolean istbsj=false;
    public class TimeThread extends  Thread{
        @Override
        public void run() {
            super.run();
            do{
                try {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    msg.what = msgKey1;
                    mHandler.sendMessage(msg);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }while (!stopthread);
        }
    }
    private TimeThread mythread;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case msgKey1:
                    mTxtSjSj.setText(DateUtils.getTimeShort());;
                    break;
                default:
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //活动的视图布局
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //视图控件的引用获取
        mTxtSjSj=(TextView) findViewById(R.id.txtview_sjsj_show );
        mTxtTzSj=(TextView) findViewById(R.id.txtview_tzsj );
        mBtnZ=(Button) findViewById(R.id.btn_z);
        mBtnZC=(Button) findViewById(R.id.btn_zc);
        mBtnXW=(Button) findViewById(R.id.btn_xw);
        mBtnW=(Button) findViewById(R.id.btn_w);
        mBtnTbSj=(Button) findViewById(R.id.btn_tbsj);
        mDatePikRq=(DatePicker) findViewById(R.id.datpk_rq);

        //其他类引用获取

        //日历事件
        calendar = Calendar.getInstance();
        MainActivity.this.year=calendar.get(Calendar.YEAR);
        MainActivity.this.monthOfYear=calendar.get(Calendar.MONTH);
        MainActivity.this.dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);
        MainActivity.this.hh=calendar.get(Calendar.HOUR_OF_DAY);
        MainActivity.this.mm= calendar.get(Calendar.MINUTE);
        MainActivity.this.ss= calendar.get(Calendar.SECOND);
        mDatePikRq.init(year,monthOfYear,dayOfMonth,new  DatePicker.OnDateChangedListener(){
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear,int dayOfMonth){
                MainActivity.this.year=year;
                MainActivity.this.monthOfYear=monthOfYear;
                MainActivity.this.dayOfMonth=dayOfMonth;

                if (!MainActivity.this.istbsj) {
                    Toast.makeText(MainActivity.this,
                            OpUtils.DATEPIC_MSG + year +
                                    OpUtils.DATEPIC_YEAR_MSG + (monthOfYear+1) +
                                    OpUtils.DATEPIC_MONTH_MSG + dayOfMonth +
                                    OpUtils.DATEPIC_DAYOFMONTH_MSG, Toast.LENGTH_SHORT).show();
                }
            }
        });

        //初始化显示手机时间
        mTxtSjSj.setText(DateUtils.getTimeShort());

        //按钮早事件
        mBtnZ.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                String tmp;
                mTxtSjSj.setText(DateUtils.getTimeShort());
                tmp=OpUtils.getTzSjZ();
                mTxtTzSj.setText(tmp);
                MainActivity.this.hh=Integer.valueOf(tmp.substring(0,2));
                MainActivity.this.mm=Integer.valueOf(tmp.substring(3,5));
                MainActivity.this.ss=Integer.valueOf(tmp.substring(6,8));
                istbsj=false;
                showDateTime();
        }
        });

        //按钮中餐事件
        mBtnZC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                String tmp;
                mTxtSjSj.setText(DateUtils.getTimeShort());
                tmp=OpUtils.getTzSjZC();
                mTxtTzSj.setText(tmp);
                MainActivity.this.hh=Integer.valueOf(tmp.substring(0,2));
                MainActivity.this.mm=Integer.valueOf(tmp.substring(3,5));
                MainActivity.this.ss=Integer.valueOf(tmp.substring(6,8));
                istbsj=false;
                showDateTime();
            }
        });

        //按钮下午事件
        mBtnXW.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                String tmp;
                mTxtSjSj.setText(DateUtils.getTimeShort());
                tmp=OpUtils.getTzSjXW();
                mTxtTzSj.setText(tmp);
                MainActivity.this.hh=Integer.valueOf(tmp.substring(0,2));
                MainActivity.this.mm=Integer.valueOf(tmp.substring(3,5));
                MainActivity.this.ss=Integer.valueOf(tmp.substring(6,8));
                istbsj=false;
                showDateTime();
            }
        });
        //按钮晚事件
        mBtnW.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                String tmp;
                mTxtSjSj.setText(DateUtils.getTimeShort());
                tmp=OpUtils.getTzSjW();
                mTxtTzSj.setText(tmp);
                MainActivity.this.hh=Integer.valueOf(tmp.substring(0,2));
                MainActivity.this.mm=Integer.valueOf(tmp.substring(3,5));
                MainActivity.this.ss=Integer.valueOf(tmp.substring(6,8));
                istbsj=false;
                showDateTime();

            }
        });

        //按钮同步时间
        mBtnTbSj.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                calendar = Calendar.getInstance();
                MainActivity.this.year=calendar.get(Calendar.YEAR);
                MainActivity.this.monthOfYear=calendar.get(Calendar.MONTH);
                MainActivity.this.dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);
                MainActivity.this.hh=calendar.get(Calendar.HOUR_OF_DAY);
                MainActivity.this.mm= calendar.get(Calendar.MINUTE);
                MainActivity.this.ss= calendar.get(Calendar.SECOND);
                istbsj=true;
                mDatePikRq.updateDate(MainActivity.this.year,MainActivity.this.monthOfYear,MainActivity.this.dayOfMonth);
                showDateTime();
            }
        });
        mythread = new TimeThread();
        mythread.start();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if ( mythread.isAlive()) {stopthread=true;}
    }
}
