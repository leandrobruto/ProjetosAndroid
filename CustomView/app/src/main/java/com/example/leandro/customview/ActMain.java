package com.example.leandro.customview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;


/**
 * Created by Leandro on 22/03/16.
 */
public class ActMain extends Activity {
    private Tela tela;
    int line[] = {0, 0, 0, 0};
    private Path drawPolygon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.act_main);
        tela = new Tela(this);
        setContentView(tela);
    }
    class Tela extends View {
        private Paint paint = new Paint();

        Tela(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {

            if(event.getAction() == MotionEvent.ACTION_UP){
                float x = event.getX();
                float y  = event.getY();

                for(int m = 0; m < 4; m++){

                }

                for(int m = 0; m < 4; m++) {

                    //if( x > (m + 1) * 55 && x < (m * 100) + 145 && y > 55 && y < 145)
                        line[m] = 1;
                    tela.invalidate();
                }
            }
            return true;
        }


        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            //paint.setColor(Color.rgb(30, 30, 30));
            for (int m = 0; m < 4; m++) {
                canvas.drawPath(drawPolygon((m + 1) * 55 + 100, 200, 30, 6), paint);
            }
            for (int m = 0; m < 5; m++) {
                canvas.drawPath(drawPolygon((m + 1) * 55 + 75, 250, 30, 6), paint);
            }
            for (int m = 0; m < 6; m++) {
                canvas.drawPath(drawPolygon((m + 1) * 55 + 50, 300, 30, 6), paint);
            }
            for (int m = 0; m < 7; m++) {
                canvas.drawPath(drawPolygon((m + 1) * 55 + 25, 350, 30, 6), paint);
            }
            for (int m = 0; m < 6; m++) {
                canvas.drawPath(drawPolygon((m + 1) * 55 + 50, 400, 30, 6), paint);
            }
            for (int m = 0; m < 5; m++) {
                canvas.drawPath(drawPolygon((m + 1) * 55 + 75, 450, 30, 6), paint);
            }
            for (int m = 0; m < 4; m++) {
                canvas.drawPath(drawPolygon((m + 1) * 55 + 100, 500, 30, 6), paint);
            }

            for (int m = 0; m < 4; m++) {
                if (line[m] == 1) {
                    paint.setColor(Color.rgb(150, 150, 150));
                    canvas.drawPath(drawPolygon((m + 1) * 100, 100, 45, 6), paint);
                    paint.setColor(Color.rgb(30,30,30));
                    canvas.drawText("hum",100,100,paint);
                }

            }
        }

        Path drawPolygon(int centerY, int centerX, int raio, int nlados) {
            Path polygon = new Path();
            double ang = Math.PI * 2 / nlados;
            polygon.moveTo((float) (centerY + raio * Math.sin(0)), (float) (centerX + raio * Math.cos(0)));
            for (int i = 1; i < nlados; i++)
                polygon.lineTo((float) (centerY + raio * Math.sin(ang * i)), (float) (centerX + raio * Math.cos(ang * i)));
            polygon.close();

            return polygon;
        }
    }
}
