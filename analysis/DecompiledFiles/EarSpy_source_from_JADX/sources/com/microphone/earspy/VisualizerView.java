package com.microphone.earspy;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import com.facebook.ads.AdError;

public class VisualizerView extends View {
    public static int AMPLITUDE_CIRCLE_FIVE = AdError.SERVER_ERROR_CODE;
    public static int AMPLITUDE_CIRCLE_FOUR = 4000;
    public static int AMPLITUDE_CIRCLE_ONE = 16000;
    public static int AMPLITUDE_CIRCLE_THREE = 7000;
    public static int AMPLITUDE_CIRCLE_TWO = 11000;
    int counter = 0;
    int curCircleNo = 0;
    int[] drawIdsHighlighted = {C1206R.C1207drawable.f2321a1, C1206R.C1207drawable.f2322a2, C1206R.C1207drawable.f2323a3, C1206R.C1207drawable.f2324a4, C1206R.C1207drawable.f2325a5, C1206R.C1207drawable.f2326a6};
    int[] drawIdsNormal = {C1206R.C1207drawable.f2328b1, C1206R.C1207drawable.f2329b2, C1206R.C1207drawable.f2330b3, C1206R.C1207drawable.f2331b4, C1206R.C1207drawable.f2332b5, C1206R.C1207drawable.f2333b6};
    private byte[] mBytes;
    private Paint mForePaint = new Paint();
    private float[] mPoints;
    private Rect mRect = new Rect();
    SharedPreferences mSharedPreferences;
    int preCircleNo = 0;

    public VisualizerView(Context context, SharedPreferences mSharedPreferences2) {
        super(context);
        this.mSharedPreferences = mSharedPreferences2;
        init();
    }

    private void init() {
        this.mBytes = null;
        this.mForePaint.setStrokeWidth(1.0f);
        this.mForePaint.setAntiAlias(true);
        this.mForePaint.setColor(Color.rgb(255, 0, 0));
    }

    public void updateVisualizer(byte[] bytes) {
        this.mBytes = bytes;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mBytes != null) {
            if (this.mPoints == null || this.mPoints.length < this.mBytes.length * 4) {
                this.mPoints = new float[(this.mBytes.length * 4)];
            }
            this.mRect.set(0, 0, getHeight(), getWidth());
            for (int i = 0; i < this.mBytes.length - 1; i++) {
                this.mPoints[i * 4] = (float) ((this.mRect.width() * i) / (this.mBytes.length - 1));
                this.mPoints[(i * 4) + 1] = (float) ((this.mRect.height() / 2) + ((((byte) (this.mBytes[i] + 128)) * (this.mRect.height() / 2)) / 128));
                this.mPoints[(i * 4) + 2] = (float) ((this.mRect.width() * (i + 1)) / (this.mBytes.length - 1));
                this.mPoints[(i * 4) + 3] = (float) ((this.mRect.height() / 2) + ((((byte) (this.mBytes[i + 1] + 128)) * (this.mRect.height() / 2)) / 128));
                float f = this.mPoints[(i * 4) + 1];
                this.mPoints[(i * 4) + 1] = this.mPoints[i * 4];
                this.mPoints[i * 4] = f;
                float f2 = this.mPoints[(i * 4) + 3];
                this.mPoints[(i * 4) + 3] = this.mPoints[(i * 4) + 2];
                this.mPoints[(i * 4) + 2] = f2;
            }
            canvas.drawLines(this.mPoints, this.mForePaint);
            this.curCircleNo = 0;
            if (MicrophoneActivity.cAmplitude > AMPLITUDE_CIRCLE_ONE) {
                this.curCircleNo = 1;
            } else if (MicrophoneActivity.cAmplitude > AMPLITUDE_CIRCLE_TWO) {
                this.curCircleNo = 2;
            } else if (MicrophoneActivity.cAmplitude > AMPLITUDE_CIRCLE_THREE) {
                this.curCircleNo = 3;
            } else if (MicrophoneActivity.cAmplitude > AMPLITUDE_CIRCLE_FOUR) {
                this.curCircleNo = 4;
            } else if (MicrophoneActivity.cAmplitude > AMPLITUDE_CIRCLE_FIVE) {
                this.curCircleNo = 5;
            } else {
                this.curCircleNo = 6;
            }
            MicrophoneActivity.cAmplitude = 0;
            if (MicrophoneActivity.IsActive) {
                if (this.preCircleNo != this.curCircleNo) {
                    MicrophoneActivity.recordButton[this.curCircleNo - 1].setBackgroundResource(this.drawIdsHighlighted[this.curCircleNo - 1]);
                    if (this.preCircleNo > 0) {
                        MicrophoneActivity.recordButton[this.preCircleNo - 1].setBackgroundResource(this.drawIdsNormal[this.preCircleNo - 1]);
                    }
                }
                this.preCircleNo = this.curCircleNo;
            }
        }
    }
}
