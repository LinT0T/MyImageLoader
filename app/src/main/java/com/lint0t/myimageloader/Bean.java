package com.lint0t.myimageloader;

import android.graphics.Bitmap;

public class Bean {
    public  Bitmap bitmap;

    public Bean(Bitmap bitmap){
        this.bitmap = bitmap;
    }

    public  Bitmap getBitmap() {
        return bitmap;
    }

    public  void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
