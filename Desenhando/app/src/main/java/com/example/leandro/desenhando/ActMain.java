package com.example.leandro.desenhando;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Leandro on 21/03/16.
 */
public class ActMain extends Activity{
    int tabuleiro [][]= {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    Tela t;
    float lado = 50;
    float h = (float)(lado/2 * Math.sqrt(3));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main_act);
        t = new Tela(this);
        setContentView(t);
    }
    class Tela extends View{
        Tela(Context c){
            super(c);}

        @Override
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            Paint p = new Paint();
            p.setStyle(Paint.Style.STROKE);
            p.setColor(new Color().rgb(30, 30, 30));
            canvas.drawLine(100, 0, 100, 300, p);
            canvas.drawLine(200, 0, 200, 300, p);
            canvas.drawLine(0,100,300,100, p);
            canvas.drawLine(0,200,300,200, p);


            canvas.drawLine(0, h, lado / 2 , 0, p);
            canvas.drawLine(lado / 2, 0 , 3 * lado / 2 , 0, p);
            canvas.drawLine(3 * lado / 2, 0, 2 * lado, h, p);
            canvas.drawLine(2 * lado, h, 3 * lado / 2, 2 * h , p);
            canvas.drawLine(3 * lado / 2, 2 * h, lado / 2, 2 * h, p);
            canvas.drawLine(lado / 2, 2 * h, 0, h, p);


        }

    }
}
