package com.albert.bs.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

import com.albert.bs.model.SessionContainer;
import com.opensymphony.xwork2.ActionContext;

/**
 * generate validation code image
 * 
 * @author Albert
 * @version V1.0 2012-03-25
 * @since JDK5.0
 */
public class ValidationCodeAction extends AlbertAction {
	private static final long serialVersionUID = 6029959678426367029L;
	
	private static final int WIDTH = 60;//验证码图片的宽度
	private static final int HEIGHT = 20;	//验证码图片的高度
	private static final int CODE_AMOUNT = 4;//验证码图片的数量
	private static final char[] randomSequence = new char[] {
		'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};
	private byte[] imageBytes;//保存验证码图像数据的字节数组
	
	@Override
	public String execute() throws Exception {
		generateValidationCodeImage();
		return SUCCESS;
	}
	
	//在给定范围内获得随机颜色
	private Color getRangeColor(int fc,int bc) {
		Random random = new Random();
		if(fc>255)
			fc = 200;
		if(bc>255)
			bc = 200;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
	
	//产生验证码图像，将图像数据保存到字节数组�?
	@SuppressWarnings("unchecked")
	private void generateValidationCodeImage() throws IOException {
		int fontHeight;//字体高度
		int rectWidth,rectHeight;//验证码边框宽度�?高度
		int offsetWidth;//验证码偏移量
		int addition;//在图像中写入验证码的额外偏移
		int codeHight;//在图像中写入验证码时指定的高�?
		fontHeight = HEIGHT - 2;
		rectWidth = WIDTH - 1;
		rectHeight = HEIGHT - 1;
		offsetWidth = WIDTH/(CODE_AMOUNT+1);
		addition = offsetWidth/2;
		codeHight = HEIGHT - 4;
		
		BufferedImage buffImg = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();
		Random random = new Random();
		g.setColor(getRangeColor(200, 250));//设定背景�?
		g.fillRect(0, 0, WIDTH, HEIGHT);
		Font font = new Font("Times New Roman", Font.PLAIN, fontHeight);
		g.setFont(font);//设置字体
		//画边�?
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, rectWidth, rectHeight);
		//随机产生160条干扰线
		g.setColor(getRangeColor(160, 200));
		for (int i = 0; i < 160; i++) {
			int x = random.nextInt(WIDTH);
			int y = random.nextInt(HEIGHT);
			int x1 = random.nextInt(12);
			int y1 = random.nextInt(12);
			g.drawLine(x, y, x+x1, y+y1);
		}
		StringBuffer sb = new StringBuffer();//保存验证�?
		int red = 0,green = 0,blue = 0;
		//产生指定位数的验证码
		for (int i = 0; i < CODE_AMOUNT; i++) {
			int index = random.nextInt(35);
			String strRand = String.valueOf(randomSequence[index]);
			sb.append(strRand);
			red = random.nextInt(110);
			green = random.nextInt(50);
			blue = random.nextInt(50);
			
			g.setColor(new Color(20+red, 20+green, 20+blue));
			g.drawString(strRand, offsetWidth*i + addition, codeHight);//将验证码绘制到图像中
		}
		
		Map session = ActionContext.getContext().getSession();
		SessionContainer container = (SessionContainer) session.get("container"); 
		if(container == null) {			
			container = new SessionContainer();
		}
		container.setValidationCode(sb.toString());
		session.put("container", container);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(buffImg, "jpeg", baos); //将验证码图像按照jpeg格式输出到ByteArrayOutputStream�?
		imageBytes = baos.toByteArray();
		baos.close();
	}
	
	public String getContentType() {  //用于向自定义结果返回图像MIME类型
		return "image/jpeg";
	}
	public int getContentLength() {  //用于向自定义结果返回图像数据的长�?
		return imageBytes.length;
	}
	public byte[] getImageInBytes(){ //用于向自定义结果返回图像数据
		return imageBytes;
	}

}
