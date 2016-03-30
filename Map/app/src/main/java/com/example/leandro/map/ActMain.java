package com.example.leandro.map;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import java.util.Random;

/**
 * Created by Leandro on 23/03/16.
 */
public class ActMain extends Activity {
    private Tela tela;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.act_main);
        tela = new Tela(this);
        setContentView(tela);
    }
    class Tela extends View{
        private Paint paint = new Paint();
        private Random rnd = new Random();
        private final int wArea = 200;
        private final int hArea = 200;
        Tela(Context context){
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            for(int i = 0;i<2000;i++){
                int pX = rnd.nextInt(wArea);
                int pY = rnd.nextInt(hArea);
                paint.setColor(Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
                canvas.drawPoint(pX,pY,paint);
            }

            for(int i = 0;i<500;i++){
                int p1X = rnd.nextInt(wArea) + 250;
                int p1Y = rnd.nextInt(hArea);
                int p2X = rnd.nextInt(hArea) + 250;
                int p2Y = rnd.nextInt(wArea);
                paint.setColor(Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
                canvas.drawLine(p1X, p1Y, p2X, p2Y, paint);
            }

            for(int i = 0;i<100;i++){
                int p1X = rnd.nextInt(wArea);
                int p1Y = rnd.nextInt(hArea) + 250;
                int p2X = rnd.nextInt(hArea);
                int p2Y = rnd.nextInt(wArea) + 250;
                paint.setColor(Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
                canvas.drawRect(p1X, p1Y, p2X, p2Y, paint);
            }

            for(int i = 0;i<100;i++){
                int pX = rnd.nextInt(wArea) + 250;
                int pY = rnd.nextInt(hArea) + 250;
                int raio = rnd.nextInt(20) + 10;
                paint.setColor(Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
                canvas.drawCircle(pX, pY,raio, paint);
            }

            paint.setColor(Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
            canvas.drawPath(drawPolygon(60, 550, 50, 3), paint);
            invalidate();

            paint.setColor(Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
            canvas.drawPath(drawPolygon(180, 550, 50, 6), paint);

            paint.setColor(Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
            canvas.drawPath(drawPolygon(300, 550, 50, 8), paint);

            paint.setColor(Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
            canvas.drawPath(drawPolygon(420, 550, 50, 12), paint);

            invalidate();
        }

            Path drawPolygon(int centerX, int centerY, int raio, int nlados) {
                Path polygon = new Path();

                double ang = Math.PI * 2 / nlados;
                polygon.moveTo((float) (centerX + raio * Math.cos(0)), (float) (centerY + raio * Math.sin(0)));
                for(int i = 1;i<nlados;i++)
                    polygon.lineTo((float)(centerX + raio * Math.cos(ang * i)), (float)(centerY + raio * Math.sin(ang * i)));
                    polygon.close();
                    return polygon;
        }
    }

}
