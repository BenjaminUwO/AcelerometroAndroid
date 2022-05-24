package com.example.senstenz;

import static com.example.senstenz.AlmacenaValor.cx;
import static com.example.senstenz.AlmacenaValor.cy;
import static com.example.senstenz.AlmacenaValor.vx;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Canvasjiji extends View {


    public Canvasjiji(Context context) {
        super(context);
    }

    public static class XDDD {
        public static float cx = 100;
        public static float cy = 100;

        public static float vx;
        public static float vy;
    }


    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        canvas.drawColor(Color.BLACK);

        Paint pincel = new Paint();
        pincel.setColor(Color.RED);
        pincel.setStrokeWidth(10);



        if ((-XDDD.vx+XDDD.cx) >= 100 && (-XDDD.vx+XDDD.cx) <= (canvas.getWidth()-100)){
            XDDD.cx -= 2*XDDD.vx;
        }
        if ((XDDD.vy+XDDD.cy) >= 100 && (XDDD.vy+XDDD.cy) <= (canvas.getHeight()-100)){
            XDDD.cy += 2*XDDD.vy;
        }
        canvas.drawCircle(XDDD.cx,XDDD.cy,100,pincel);



    }

}
