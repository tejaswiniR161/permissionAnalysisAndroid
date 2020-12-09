package com.microphone.earspy;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Environment;
import android.os.IBinder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestService extends Service {
    private static final String AUDIO_RECORDER_FOLDER = "EAR SPY";
    private static final String AUDIO_RECORDER_TEMP_FILE = "record_temp.raw";
    private static final int RECORDER_BPP = 16;
    private static final int mFormat = 2;
    private static final int mSampleRate = 44100;
    /* access modifiers changed from: private */
    public String appTag = "microphone activity";
    /* access modifiers changed from: private */
    public boolean mActive = false;
    /* access modifiers changed from: private */
    public AudioRecord mAudioInput = null;
    /* access modifiers changed from: private */
    public AudioTrack mAudioOutput = null;
    /* access modifiers changed from: private */
    public int mInBufferSize = 0;

    public void onCreate() {
        this.mInBufferSize = AudioRecord.getMinBufferSize(mSampleRate, 16, 2);
        int mOutBufferSize = AudioTrack.getMinBufferSize(mSampleRate, 4, 2);
        this.mAudioInput = new AudioRecord(5, mSampleRate, 16, 2, this.mInBufferSize);
        this.mAudioOutput = new AudioTrack(3, mSampleRate, 4, 2, mOutBufferSize, 1);
    }

    public void onDestroy() {
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    public void record() {
        new Thread() {
            public void run() {
                Context applicationContext = TestService.this.getApplicationContext();
                recordLoop();
            }

            /* JADX WARNING: Removed duplicated region for block: B:22:0x005d A[Catch:{ Exception -> 0x015b }] */
            /* JADX WARNING: Removed duplicated region for block: B:55:0x010c A[Catch:{ Exception -> 0x00ec }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private void recordLoop() {
                /*
                    r11 = this;
                    r10 = 1
                    com.microphone.earspy.TestService r9 = com.microphone.earspy.TestService.this
                    android.media.AudioTrack r9 = r9.mAudioOutput
                    int r9 = r9.getState()
                    if (r9 != r10) goto L_0x0019
                    com.microphone.earspy.TestService r9 = com.microphone.earspy.TestService.this
                    android.media.AudioRecord r9 = r9.mAudioInput
                    int r9 = r9.getState()
                    if (r9 == r10) goto L_0x001a
                L_0x0019:
                    return
                L_0x001a:
                    com.microphone.earspy.TestService r9 = com.microphone.earspy.TestService.this     // Catch:{ Exception -> 0x00a3 }
                    android.media.AudioTrack r9 = r9.mAudioOutput     // Catch:{ Exception -> 0x00a3 }
                    r9.play()     // Catch:{ Exception -> 0x00a3 }
                    com.microphone.earspy.TestService r9 = com.microphone.earspy.TestService.this     // Catch:{ Exception -> 0x00bf }
                    android.media.AudioRecord r9 = r9.mAudioInput     // Catch:{ Exception -> 0x00bf }
                    r9.startRecording()     // Catch:{ Exception -> 0x00bf }
                    com.microphone.earspy.TestService r9 = com.microphone.earspy.TestService.this     // Catch:{ Exception -> 0x00b1 }
                    java.lang.String r4 = r9.getTempFilename()     // Catch:{ Exception -> 0x00b1 }
                    r7 = 0
                    java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x00d6 }
                    r8.<init>(r4)     // Catch:{ FileNotFoundException -> 0x00d6 }
                L_0x0038:
                    com.microphone.earspy.TestService r9 = com.microphone.earspy.TestService.this     // Catch:{ Exception -> 0x00ec }
                    int r9 = r9.mInBufferSize     // Catch:{ Exception -> 0x00ec }
                    java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocateDirect(r9)     // Catch:{ Exception -> 0x00ec }
                    com.microphone.earspy.TestService r9 = com.microphone.earspy.TestService.this     // Catch:{ Exception -> 0x00ec }
                    int r9 = r9.mInBufferSize     // Catch:{ Exception -> 0x00ec }
                    byte[] r0 = new byte[r9]     // Catch:{ Exception -> 0x00ec }
                    boolean r9 = com.microphone.earspy.MicrophoneActivity.IsRecording     // Catch:{ Exception -> 0x00ec }
                    if (r9 == 0) goto L_0x0104
                    if (r8 != 0) goto L_0x015d
                    java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x00dd }
                    r7.<init>(r4)     // Catch:{ FileNotFoundException -> 0x00dd }
                L_0x0055:
                    com.microphone.earspy.TestService r9 = com.microphone.earspy.TestService.this     // Catch:{ Exception -> 0x015b }
                    boolean r9 = r9.mActive     // Catch:{ Exception -> 0x015b }
                    if (r9 == 0) goto L_0x014f
                    com.microphone.earspy.TestService r9 = com.microphone.earspy.TestService.this     // Catch:{ Exception -> 0x015b }
                    android.media.AudioRecord r9 = r9.mAudioInput     // Catch:{ Exception -> 0x015b }
                    com.microphone.earspy.TestService r10 = com.microphone.earspy.TestService.this     // Catch:{ Exception -> 0x015b }
                    int r10 = r10.mInBufferSize     // Catch:{ Exception -> 0x015b }
                    int r6 = r9.read(r1, r10)     // Catch:{ Exception -> 0x015b }
                    r1.get(r0)     // Catch:{ Exception -> 0x015b }
                    r1.rewind()     // Catch:{ Exception -> 0x015b }
                    com.microphone.earspy.TestService r9 = com.microphone.earspy.TestService.this     // Catch:{ Exception -> 0x015b }
                    android.media.AudioTrack r9 = r9.mAudioOutput     // Catch:{ Exception -> 0x015b }
                    r10 = 0
                    r9.write(r0, r10, r6)     // Catch:{ Exception -> 0x015b }
                    r9 = 0
                    r7.write(r0, r9, r6)     // Catch:{ Exception -> 0x015b }
                    r5 = 0
                L_0x0082:
                    com.microphone.earspy.TestService r9 = com.microphone.earspy.TestService.this     // Catch:{ Exception -> 0x015b }
                    int r9 = r9.mInBufferSize     // Catch:{ Exception -> 0x015b }
                    int r9 = r9 / 2
                    if (r5 >= r9) goto L_0x0055
                    int r9 = r5 * 2
                    byte r9 = r0[r9]     // Catch:{ Exception -> 0x015b }
                    int r10 = r5 * 2
                    int r10 = r10 + 1
                    byte r10 = r0[r10]     // Catch:{ Exception -> 0x015b }
                    int r10 = r10 << 8
                    r9 = r9 | r10
                    short r2 = (short) r9     // Catch:{ Exception -> 0x015b }
                    short r9 = com.microphone.earspy.MicrophoneActivity.cAmplitude     // Catch:{ Exception -> 0x015b }
                    if (r2 <= r9) goto L_0x00a0
                    com.microphone.earspy.MicrophoneActivity.cAmplitude = r2     // Catch:{ Exception -> 0x015b }
                L_0x00a0:
                    int r5 = r5 + 1
                    goto L_0x0082
                L_0x00a3:
                    r3 = move-exception
                    com.microphone.earspy.TestService r9 = com.microphone.earspy.TestService.this     // Catch:{ Exception -> 0x00b1 }
                    java.lang.String r9 = r9.appTag     // Catch:{ Exception -> 0x00b1 }
                    java.lang.String r10 = "Failed to start playback"
                    android.util.Log.e(r9, r10)     // Catch:{ Exception -> 0x00b1 }
                    goto L_0x0019
                L_0x00b1:
                    r3 = move-exception
                    com.microphone.earspy.TestService r9 = com.microphone.earspy.TestService.this
                    java.lang.String r9 = r9.appTag
                    java.lang.String r10 = "Error somewhere in record loop."
                    android.util.Log.d(r9, r10)
                    goto L_0x0019
                L_0x00bf:
                    r3 = move-exception
                    com.microphone.earspy.TestService r9 = com.microphone.earspy.TestService.this     // Catch:{ Exception -> 0x00b1 }
                    java.lang.String r9 = r9.appTag     // Catch:{ Exception -> 0x00b1 }
                    java.lang.String r10 = "Failed to start recording"
                    android.util.Log.e(r9, r10)     // Catch:{ Exception -> 0x00b1 }
                    com.microphone.earspy.TestService r9 = com.microphone.earspy.TestService.this     // Catch:{ Exception -> 0x00b1 }
                    android.media.AudioTrack r9 = r9.mAudioOutput     // Catch:{ Exception -> 0x00b1 }
                    r9.stop()     // Catch:{ Exception -> 0x00b1 }
                    goto L_0x0019
                L_0x00d6:
                    r3 = move-exception
                    r3.printStackTrace()     // Catch:{ Exception -> 0x00b1 }
                    r8 = r7
                    goto L_0x0038
                L_0x00dd:
                    r3 = move-exception
                    r3.printStackTrace()     // Catch:{ Exception -> 0x00ec }
                    com.microphone.earspy.TestService r9 = com.microphone.earspy.TestService.this     // Catch:{ Exception -> 0x00ec }
                    android.media.AudioRecord r9 = r9.mAudioInput     // Catch:{ Exception -> 0x00ec }
                    r9.stop()     // Catch:{ Exception -> 0x00ec }
                    goto L_0x0019
                L_0x00ec:
                    r3 = move-exception
                    r7 = r8
                L_0x00ee:
                    com.microphone.earspy.TestService r9 = com.microphone.earspy.TestService.this     // Catch:{ Exception -> 0x00b1 }
                    java.lang.String r9 = r9.appTag     // Catch:{ Exception -> 0x00b1 }
                    java.lang.String r10 = "Error while recording, aborting."
                    android.util.Log.d(r9, r10)     // Catch:{ Exception -> 0x00b1 }
                L_0x00f9:
                    r7.close()     // Catch:{ Exception -> 0x00fe }
                    goto L_0x0019
                L_0x00fe:
                    r3 = move-exception
                    r3.printStackTrace()     // Catch:{ Exception -> 0x00b1 }
                    goto L_0x0019
                L_0x0104:
                    com.microphone.earspy.TestService r9 = com.microphone.earspy.TestService.this     // Catch:{ Exception -> 0x00ec }
                    boolean r9 = r9.mActive     // Catch:{ Exception -> 0x00ec }
                    if (r9 == 0) goto L_0x014e
                    com.microphone.earspy.TestService r9 = com.microphone.earspy.TestService.this     // Catch:{ Exception -> 0x00ec }
                    android.media.AudioRecord r9 = r9.mAudioInput     // Catch:{ Exception -> 0x00ec }
                    com.microphone.earspy.TestService r10 = com.microphone.earspy.TestService.this     // Catch:{ Exception -> 0x00ec }
                    int r10 = r10.mInBufferSize     // Catch:{ Exception -> 0x00ec }
                    int r6 = r9.read(r1, r10)     // Catch:{ Exception -> 0x00ec }
                    r1.get(r0)     // Catch:{ Exception -> 0x00ec }
                    r1.rewind()     // Catch:{ Exception -> 0x00ec }
                    com.microphone.earspy.TestService r9 = com.microphone.earspy.TestService.this     // Catch:{ Exception -> 0x00ec }
                    android.media.AudioTrack r9 = r9.mAudioOutput     // Catch:{ Exception -> 0x00ec }
                    r10 = 0
                    r9.write(r0, r10, r6)     // Catch:{ Exception -> 0x00ec }
                    r5 = 0
                L_0x012d:
                    com.microphone.earspy.TestService r9 = com.microphone.earspy.TestService.this     // Catch:{ Exception -> 0x00ec }
                    int r9 = r9.mInBufferSize     // Catch:{ Exception -> 0x00ec }
                    int r9 = r9 / 2
                    if (r5 >= r9) goto L_0x0104
                    int r9 = r5 * 2
                    byte r9 = r0[r9]     // Catch:{ Exception -> 0x00ec }
                    int r10 = r5 * 2
                    int r10 = r10 + 1
                    byte r10 = r0[r10]     // Catch:{ Exception -> 0x00ec }
                    int r10 = r10 << 8
                    r9 = r9 | r10
                    short r2 = (short) r9     // Catch:{ Exception -> 0x00ec }
                    short r9 = com.microphone.earspy.MicrophoneActivity.cAmplitude     // Catch:{ Exception -> 0x00ec }
                    if (r2 <= r9) goto L_0x014b
                    com.microphone.earspy.MicrophoneActivity.cAmplitude = r2     // Catch:{ Exception -> 0x00ec }
                L_0x014b:
                    int r5 = r5 + 1
                    goto L_0x012d
                L_0x014e:
                    r7 = r8
                L_0x014f:
                    com.microphone.earspy.TestService r9 = com.microphone.earspy.TestService.this     // Catch:{ Exception -> 0x015b }
                    java.lang.String r9 = r9.appTag     // Catch:{ Exception -> 0x015b }
                    java.lang.String r10 = "Finished recording"
                    android.util.Log.d(r9, r10)     // Catch:{ Exception -> 0x015b }
                    goto L_0x00f9
                L_0x015b:
                    r3 = move-exception
                    goto L_0x00ee
                L_0x015d:
                    r7 = r8
                    goto L_0x0055
                */
                throw new UnsupportedOperationException("Method not decompiled: com.microphone.earspy.TestService.C12221.recordLoop():void");
            }
        }.start();
    }

    private void deleteTempFile() {
        new File(getTempFilename()).delete();
    }

    /* access modifiers changed from: private */
    public String getTempFilename() {
        String filepath = Environment.getExternalStorageDirectory().getPath();
        File file = new File(filepath, "EAR SPY");
        if (!file.exists()) {
            file.mkdirs();
        }
        File tempFile = new File(filepath, AUDIO_RECORDER_TEMP_FILE);
        if (tempFile.exists()) {
            tempFile.delete();
        }
        return file.getAbsolutePath() + "/" + AUDIO_RECORDER_TEMP_FILE;
    }

    private void copyWaveFile(String inFilename, String outFilename) {
        long j = 0 + 44;
        long byteRate = (long) 176400;
        byte[] data = new byte[this.mInBufferSize];
        try {
            FileInputStream fileInputStream = new FileInputStream(inFilename);
            FileOutputStream out = new FileOutputStream(outFilename);
            long totalAudioLen = fileInputStream.getChannel().size();
            long totalDataLen = totalAudioLen + 44;
            if (totalDataLen < 100) {
                File file = new File(outFilename);
                if (file.exists()) {
                    file.delete();
                }
            }
            WriteWaveFileHeader(out, totalAudioLen, totalDataLen, 44100, 2, byteRate);
            while (fileInputStream.read(data) != -1) {
                out.write(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        MicrophoneActivity.wavFileName = outFilename;
    }

    private void WriteWaveFileHeader(FileOutputStream out, long totalAudioLen, long totalDataLen, long longSampleRate, int channels, long byteRate) throws IOException {
        out.write(new byte[]{82, 73, 70, 70, (byte) ((int) (255 & totalDataLen)), (byte) ((int) ((totalDataLen >> 8) & 255)), (byte) ((int) ((totalDataLen >> 16) & 255)), (byte) ((int) ((totalDataLen >> 24) & 255)), 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, (byte) channels, 0, (byte) ((int) (255 & longSampleRate)), (byte) ((int) ((longSampleRate >> 8) & 255)), (byte) ((int) ((longSampleRate >> 16) & 255)), (byte) ((int) ((longSampleRate >> 24) & 255)), (byte) ((int) (255 & byteRate)), (byte) ((int) ((byteRate >> 8) & 255)), (byte) ((int) ((byteRate >> 16) & 255)), (byte) ((int) ((byteRate >> 24) & 255)), 4, 0, 16, 0, 100, 97, 116, 97, (byte) ((int) (255 & totalAudioLen)), (byte) ((int) ((totalAudioLen >> 8) & 255)), (byte) ((int) ((totalAudioLen >> 16) & 255)), (byte) ((int) ((totalAudioLen >> 24) & 255))}, 0, 44);
    }
}
