package com.albert.bs.util;

import java.io.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.Graphics;
import java.awt.color.ColorSpace;
import javax.imageio.ImageIO;

/**
 * 图片缩放
 * @author Albert
 *
 */
public class ImageCut {
	
//	public static void main(String args[]) {
//		int width = 450;
//		int height = 550;
//		File file = new File("D:\\1.png");
//		File file2 = new File("D:\\2.png");
//		
//		ImageCut.scale(file.getAbsolutePath(), file2.getAbsolutePath(), width,
//				height);
//	}

	public static void scale(String srcImageFile, String result, float scale,
			boolean flag) {
		try {
			java.io.File f = new java.io.File(result);

			f.getParentFile().mkdirs();
			BufferedImage src = ImageIO.read(new File(srcImageFile)); // 读入文件
			int width = src.getWidth(); // 得到源图宽
			int height = src.getHeight(); // 得到源图长
			if (flag) {
				// 放大
				width = (int) (width * scale);
				height = (int) (height * scale);
			} else {
				// 缩小
				width = (int) (width / scale);
				height = (int) (height / scale);
			}
			Image image = src.getScaledInstance(width, height,
					Image.SCALE_DEFAULT);
			BufferedImage tag = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			ImageIO.write(tag, "JPEG", new File(result));// 输出到文件流
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void scale(String srcImageFile, String result, int twidth,
			int theight) {
		try {
			java.io.File f = new java.io.File(result);
			f.getParentFile().mkdirs();
			BufferedImage src = ImageIO.read(new File(srcImageFile)); // 读入文件
			int width = twidth; // 得到源图宽
			int height = theight; // 得到源图长

			Image image = src.getScaledInstance(width, height,
					Image.SCALE_DEFAULT);
			BufferedImage tag = new BufferedImage(width, height,
					BufferedImage.TYPE_USHORT_565_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			ImageIO.write(tag, "GIF", new File(result));// 输出到文件流
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void cut(String srcImageFile, String descDir, int destWidth,
			int destHeight) {
		try {
			Image img;
			ImageFilter cropFilter;
			// 读取源图像
			BufferedImage bi = ImageIO.read(new File(srcImageFile));
			int srcWidth = bi.getHeight(); // 源图宽度
			int srcHeight = bi.getWidth(); // 源图高度
			if (srcWidth > destWidth && srcHeight > destHeight) {
				Image image = bi.getScaledInstance(srcWidth, srcHeight,
						Image.SCALE_DEFAULT);
				destWidth = 200; // 切片宽度
				destHeight = 150; // 切片高度
				int cols = 0; // 切片横向数量
				int rows = 0; // 切片纵向数量
				// 计算切片的横向和纵向数量
				if (srcWidth % destWidth == 0) {
					cols = srcWidth / destWidth;
				} else {
					cols = (int) Math.floor(srcWidth / destWidth) + 1;
				}
				if (srcHeight % destHeight == 0) {
					rows = srcHeight / destHeight;
				} else {
					rows = (int) Math.floor(srcHeight / destHeight) + 1;
				}
				// 循环建立切片
				// 改进的想法:是否可用多线程加快切割速度
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < cols; j++) {
						// 四个参数分别为图像起点坐标和宽高
						// 即: CropImageFilter(int x,int y,int width,int height)
						cropFilter = new CropImageFilter(j * 200, i * 150,
								destWidth, destHeight);
						img = Toolkit.getDefaultToolkit().createImage(
								new FilteredImageSource(image.getSource(),
										cropFilter));
						BufferedImage tag = new BufferedImage(destWidth,
								destHeight, BufferedImage.TYPE_INT_RGB);
						Graphics g = tag.getGraphics();
						g.drawImage(img, 0, 0, null); // 绘制缩小后的图
						g.dispose();
						// 输出为文件
						ImageIO.write(tag, "GIF", new File(descDir));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 图像类型转换 GIF->JPG GIF->PNG PNG->JPG PNG->GIF(X)
	 */
	public static void convert(String source, String result) {
		try {
			File f = new File(source);
			f.canRead();
			f.canWrite();
			BufferedImage src = ImageIO.read(f);
			ImageIO.write(src, "JPG", new File(result));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 彩色转为黑白
	 * 
	 * @param source
	 * @param result
	 */
	public static void gray(String source, String result) {
		try {
			BufferedImage src = ImageIO.read(new File(source));
			ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
			ColorConvertOp op = new ColorConvertOp(cs, null);
			src = op.filter(src, null);
			ImageIO.write(src, "GIF", new File(result));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	// public static void main(String[] args) {
	// scale("D:/workDir/2009_0619/EP2010/node_43.jpg",
	// "D:/workDir/2009_0619/EP2010/node_43.gif", 1.05f, false);
	// }
}
