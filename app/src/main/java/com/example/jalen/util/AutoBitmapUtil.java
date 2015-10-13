package com.example.jalen.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;

public class AutoBitmapUtil {
	/**
	 * 
	 * @param imgpath
	 *            输入图片的路径
	 * @param screenwidth
	 *            输入屏幕分辨率的宽度 getWindowManager().getDefaultDisplay().getWidth();
	 * @param screenheight
	 *            输入屏幕分辨率的高度 getWindowManager().getDefaultDisplay().getHeight();
	 * @return
	 */
	public static Bitmap getAutoBitmap(String imgpath, int screenwidth,
			int screenheight) {
		// 1.得到手机的分辨率

		// 2.得到图片的宽高属性。
		Options opts = new Options();// 解析图片的选项参数
		opts.inJustDecodeBounds = true;// 不真正的解析这个bitmap ，只是获取bitmap的宽高信息
		Bitmap bitmap = BitmapFactory.decodeFile(imgpath, opts);
		int imageHeight = opts.outHeight;
		int imageWidth = opts.outWidth;
		// 3.计算缩放比例。
		int dx = imageWidth / screenwidth;
		int dy = imageHeight / screenheight;

		System.out.println("手机分辨率:" + screenwidth + "x" + screenheight);
		System.out.println("图片分辨率:" + imageWidth + "x" + imageHeight);
		System.out.println("缩放比例：dx=" + dx + "dy=" + dy);
		int scale = 1;
		if (dx >= dy && dy >= 1) {
			scale = dx;
		}
		if (dy >= dx && dx >= 1) {
			scale = dy;
		}
		System.out.println("总体缩放比例：" + scale);

		opts.inJustDecodeBounds = false;// 真正的解析bitmap
		// 4.设置图片的缩放比例
		opts.inSampleSize = scale; // 指定图片缩放比例
		bitmap = BitmapFactory.decodeFile(imgpath, opts);
		return bitmap;
	}
}
