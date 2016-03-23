package com.example.rr.myapplication;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Field;

/**
 * Created by 若冰RR on 2016/3/21.
 */
public class ThreeActivity extends AppCompatActivity {
    private TextView mtextView;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.avtivity_three);
        mtextView= (TextView) findViewById(R.id.textView);
        mtextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //文本带颜色等。。。。
//           String html="<font color='#ff0000'>红</font><font color='#00ff00'>绿</font><font color='#000ff0'>蓝</font>";
//                Spanned spannde= Html.fromHtml(html);
//                mtextView.setText(spannde);
                //如何在文本中添加图片
                String html2="你好<img src='ac'></img>,有图有真相<img src='acc'></img>是的";
                Spanned spannde1= Html.fromHtml(html2, new Html.ImageGetter() {
                    @Override
                    public Drawable getDrawable(String source) {
                      Drawable drawable=  getResources().getDrawable(R.mipmap.ac);
                        Class clazz=R.mipmap.class;
                        try {
                            Field field=clazz.getDeclaredField(source);
                           int id=field.getInt(null);//使用反射得到ac的值
                            drawable=getResources().getDrawable(id);//使用id得到图片
                            //设置图片的宽和高
                            drawable.setBounds(0,0,drawable.getMinimumHeight(),drawable.getIntrinsicWidth());
                        } catch (NoSuchFieldException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                        return drawable;

                    }
                },null);
                mtextView.setText(spannde1);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
