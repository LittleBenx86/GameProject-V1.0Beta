package com.unicorn.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CodeServlet
 */
@WebServlet("/CodeServlet")
public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CodeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");

		//告诉客户端response传输过去的文件格式是jpg图片
		response.setHeader("Content-Type", "image/jpeg");

		//在内存中创建一幅图片
		BufferedImage img = new BufferedImage(110, 30, BufferedImage.TYPE_INT_BGR);

		//得到这幅图片,赋予作图功能
		Graphics g = img.getGraphics();

		// 设置图片的背景颜色
		g.setColor(Color.white);
		g.fillRect(0, 0, 110, 30);

		String checkcode = "";

		//开始在图片上画字符串
		for (int i = 0; i < 5; i++) {
			g.setColor(generateColor());
			g.setFont(generateFont());
			String str = generateStr();
			checkcode += str;
			g.drawString(str, 20 * i, 30);
		}

		//画点
		for (int i = 0; i < 100; i++) {
			Random rand = new Random();
			int x = rand.nextInt(110);
			int y = rand.nextInt(30);
			g.setColor(generateColor());
			g.fillOval(x, y, 2, 2);
		}

		//画线
		for (int i = 0; i < 5; i++) {
			Random rand = new Random();
			int x1 = rand.nextInt(110);
			int y1 = rand.nextInt(30);
			int x2 = rand.nextInt(110);
			int y2 = rand.nextInt(30);
			g.setColor(generateColor());
			g.drawLine(x1, y1, x2, y2);
		}

		//把字符信息放到session里存储
		request.getSession().setAttribute("checkcode", checkcode.toLowerCase());

		//发送图片
		ImageIO.write(img, "jpg", response.getOutputStream());
	}

	/**
	 * 随机字符串
	 * 
	 * @return
	 */
	private String generateStr() {
		String[] nums = new String[62];

		//0-9
		for (int i = 0; i < 10; i++)
			nums[i] = String.valueOf(i);

		//A-Z
		for (int i = 65; i < 91; i++)
			nums[i - 55] = Character.toString((char) i);

		//a-z
		for (int i = 97; i < 123; i++)
			nums[i - 61] = Character.toString((char) i);

		//随机选取
		Random rand = new Random();
		int index = rand.nextInt(62);
		return nums[index];

	}

	private Font generateFont() {
		// TODO Auto-generated method stub
		String[] fontNames = new String[] { "Broadway", "幼圆", "Footlight MT Light", "Sitka Text", "方正舒体", "方正姚体",
				"Colonna MT" };
		int[] fontStyles = new int[] { Font.BOLD, Font.ITALIC, Font.BOLD | Font.ITALIC };

		Random rand = new Random();
		int nameIndex = rand.nextInt(fontNames.length);
		int styleIndex = rand.nextInt(fontStyles.length);

		return new Font(fontNames[nameIndex], fontStyles[styleIndex], 28);
	}

	private Color generateColor() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
	}

}
