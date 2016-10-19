package random.com.fortest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/10/18.
 */
public class TestPaint extends View {


    private int width, height;

    private Paint mPaint = new Paint();

    public int[] data = new int[]{60,40,50,130,80};
    private int[] colors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};

    int currentAngle = -90;


    private void initPaint() {
        mPaint.setColor(Color.GRAY);
        mPaint.setStyle(Paint.Style.FILL);  //设置画笔模式为填充
        mPaint.setStrokeWidth(10f);         //设置画笔宽度为10px

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w ;
        height = h ;
    }

    public TestPaint(Context context) {
        super(context);

    }

    public TestPaint(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    public TestPaint(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(width/2,height/2);



        float r = (float) ((Math.min(width,height)/2)*0.8);
        RectF rectF = new RectF(-r, -r, r, r);


        for (int k=0;k<data.length;k++){
            mPaint.setColor(colors[k% colors.length]);

            int angle =data[k];

            // 绘制圆弧

            canvas.drawArc(rectF, currentAngle,angle , true, mPaint);
           currentAngle +=angle;
        }


    }
}
