package com.yanbin.lednumberlearning;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

/**
 * Created by hungyanbin on 2015/5/14.
 */
public class LEDView extends TextView {

    public LEDView(Context context) {
        super(context);
    }

    public LEDView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LEDView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    final int LED_COUNT = 36;

    public void setNumber(List<Float> LEDFlags){
        if(LEDFlags.size() != LED_COUNT)
            throw new IllegalArgumentException("wrong LED number : " + LEDFlags.size());

        Iterator<Float> iterator = LEDFlags.iterator();

        StringBuilder number = new StringBuilder();
        for(int row=0;row<9;row++) {
            for (int column = 0; column < 4; column++) {
                Float flag = iterator.next();
                if (flag > 0f)
                    number.append("0");
                else
                    number.append("  ");
                if(column < 3)
                    number.append("\t  ");
            }
            if(row < 8)
                number.append("\n");
        }

        setText(number.toString());
    }
}
