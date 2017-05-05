package cn.itcast.bos.action;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 二维码生成控制器
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月14日 上午9:20:15
 * @version 1.0
 */
public class BarcodeAction extends ActionSupport {

	private static final long serialVersionUID = -7746136646824334829L;
	/** 定义存放在二维码图片中的内容 */
	private String url;
	/** 定义生成二维码图片的宽度 */
	private static final int WIDTH = 200;
	/** 定义生成二维码图片的高度 */
	private static final int HEIGHT = 200;
	/** 定义公司logo的宽度 */
	private static final int LOGO_WIDTH = 50;
	/** 定义公司logo的高度 */
	private static final int LOGO_HEIGHT = 50;
	
	@Override
	public String execute() throws Exception {
		
		/** 判断url */
		if (url == null || "".equals(url)){
			url = "http://www.bos.com/login.jspx";
		}
		
		/** 获取响应对象 */
		HttpServletResponse response = ServletActionContext.getResponse();
		/** 告诉浏览器响应的内容类型是图片 */
		response.setContentType("images/png");
		
		/** 定义生成二维码需要的全局配置信息*/
		Map<EncodeHintType, Object> hints = new HashMap<>();
		/** 设置二维码图片中内容编码 */
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		/** 设置二维码图片上下左右的边距 */
		hints.put(EncodeHintType.MARGIN, 0);
		/** 设置二维码图片的纠错级别 */
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		
		/** 
		 * 生成二维码字节转化对象
		 * 第一个参数：二维码图片中的内容
		 * 第二个参数：生成二维码的格式器
		 * 第三个参数：生成二维码图片的宽度
		 * 第四个参数：生成二维码图片的高度
		 */
		BitMatrix matrix = new MultiFormatWriter().encode(url,
					BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
		/** 获取二维码图片实际的宽度 */
		int matrix_width = matrix.getWidth();
		/** 获取二维码图片实际的高度 */
		int matrix_height = matrix.getHeight();
		
		/** 定义一张空白缓冲流图片 */
		BufferedImage image = new BufferedImage(matrix_width, matrix_height, 
						BufferedImage.TYPE_INT_RGB);
		
		/** 循环二维码字节转化对象中所有点 */
		for (int x = 0; x < matrix_width; x++){
			for (int y = 0; y < matrix_height; y++){
				/** 获取其中一点，判断它是黑色还是白色   true:黑色   false:白色 */
				int rgb = matrix.get(x, y) ? 0x4B0082 : 0xffffff;
				/** 在空白图片绘制一点 */
				image.setRGB(x, y, rgb);
			}
		}
		/** 获取图片对应的画笔 */
		Graphics2D g = (Graphics2D)image.getGraphics();
		/** 获取公司的logo，得到输入流 */
		InputStream inputStream = ServletActionContext.getServletContext()
					.getResourceAsStream("/images/girl1.jpg");
		/** 把输入流转化成缓冲流图片 */
		BufferedImage logo = ImageIO.read(inputStream);
		/** 绘制图片 */
		g.drawImage(logo, 
					(matrix_width - LOGO_WIDTH) / 2, 
					(matrix_height - LOGO_HEIGHT) / 2, 
					LOGO_WIDTH, LOGO_HEIGHT, null);
		/** 设置画笔颜色 */
		g.setColor(Color.WHITE);
		/** 设置画笔的粗细 */
		g.setStroke(new BasicStroke(5.0f));
		/** 设置消除锯齿 */
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		/** 绘制圆角矩形 */
		g.drawRoundRect((matrix_width - LOGO_WIDTH) / 2, 
						(matrix_height - LOGO_HEIGHT) / 2, 
						  LOGO_WIDTH, LOGO_HEIGHT, 15, 15);
		
		/** 
		 * 向浏览器输出二维码
		 * 第一个参数：二维码字节转化对象
		 * 第二个参数：图片格化
		 * 第三个参数：输出流
		 */
		//MatrixToImageWriter.writeToStream(matrix, "png", response.getOutputStream());
		ImageIO.write(image, "png", response.getOutputStream());
		return NONE;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}