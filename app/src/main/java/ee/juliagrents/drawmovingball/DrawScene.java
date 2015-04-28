package ee.juliagrents.drawmovingball;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.view.View;

/**
 * Created by Julia@Igor on 28.04.2015.
 */
public class DrawScene extends View {

    private Paint canvasPaint;
/**private Paint circlePaint;*/
    private Paint rectPaint;
    private Paint imgPaint;
    private Bitmap mBitmap;

    private int x=50;
    private int y=50;
    /**private int circleRadius=50;*/

    private int dx=5;
    private int dy=5;

    private final int FRAME_RATE = 1;

    private Handler h;


    public int getCurrentX() {
        return x;
    }


    public int getCurrentY() {
        return y;
    }

    public DrawScene(Context context, int start_x, int start_y) {

        super(context);

        x=start_x;
        y=start_y;

        h = new Handler();
        canvasPaint = new Paint();
        /**circlePaint = new Paint();*/
        rectPaint = new Paint();
        imgPaint = new Paint();
        Resources res = this.getResources();
        mBitmap = BitmapFactory.decodeResource(res, R.drawable.tennisball);

        canvasPaint.setStyle(Paint.Style.FILL);
        canvasPaint.setColor(Color.YELLOW);

        /** circlePaint.setColor(Color.GREEN);*/
    }

    private  Runnable r = new Runnable() {
        @Override
        public void run() {
            invalidate();
        }
    };


    @Override

    protected void onDraw(Canvas sceneCanvas) {

        super.onDraw(sceneCanvas);

        sceneCanvas.drawPaint(canvasPaint);
        sceneCanvas.drawRect(33,66,750,750, rectPaint );
        sceneCanvas.drawBitmap(mBitmap, 50,50, imgPaint);
        /** sceneCanvas.drawCircle(x,y,circleRadius, circlePaint);*/
        x=x+dx;
        y+=dy;
        /**
        if (x>this.getWidth() || x<circleRadius) {
            dx=dx*-1;
        }
        if (y>this.getHeight() || y<circleRadius) {
            dy=dy*-1;
        }
         */
        h.postDelayed(r, FRAME_RATE);


    }
}