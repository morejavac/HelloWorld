package com.example.administrator.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.administrator.helloworld.DateUtils;


public class MainActivity extends AppCompatActivity {
    //定义视图控件的引用（private）
    private TextView mTxtSjSj;
    private TextView mTxtTzSj ;
    private Button mBtnZ ;
    private Button mBtnZC ;
    private Button mBtnXW ;
    private Button mBtnW ;
    private Button mBtnTbSj ;

    //定义其他类引用


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

        //其他类引用获取


        //按钮早事件
        mBtnZ.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                mTxtSjSj.setText(DateUtils.getTimeShort());
                mTxtTzSj.setText(OpUtils.getTzSjZ());
            }
        });

        //按钮中餐事件
        mBtnZC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                mTxtSjSj.setText(DateUtils.getTimeShort());
                mTxtTzSj.setText(OpUtils.getTzSjZC());
            }
        });

        //按钮下午事件
        mBtnXW.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                mTxtSjSj.setText(DateUtils.getTimeShort());
                mTxtTzSj.setText(OpUtils.getTzSjXW());
            }
        });
        //按钮晚事件
        mBtnW.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                mTxtSjSj.setText(DateUtils.getTimeShort());
                mTxtTzSj.setText(OpUtils.getTzSjW());
            }
        });
    }

}
