package org.lazicats.admin.print;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.lazicats.admin.vo.Account;
import org.lazicats.website.vo.GoodsVo;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
/**
 * 打印
 * @author Amos
 *
 */

@SuppressWarnings("restriction")
public class Print {
	public static BufferedImage image;

	public static String createImage(String fileLocation) {
		try {
			FileOutputStream fos = new FileOutputStream(fileLocation);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
			encoder.encode(image);
			bos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileLocation;
	}
	/**
	 * 58打印机   结账图片打印
	 * @param goodsVoList
	 * @param account
	 * @return
	 */
	public static String graphicsGeneration(List<GoodsVo> goodsVoList,Account account) {
		createDir("D://print//account//image");
		int imageWidth = 400;// 图片的宽度
		int imageHeight = 400 + goodsVoList.size() * 100;// 图片的高度
		image = new BufferedImage(imageWidth, imageHeight,
				BufferedImage.TYPE_INT_RGB);
		//时间设置
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, imageWidth, imageHeight);
		graphics.setColor(Color.BLACK);
		Font fontTitle = new Font("楷体", Font.BOLD, 35);
		graphics.setFont(fontTitle);
		graphics.drawString("下酒菜", 120, 50);
		Font fontTitle1 = new Font("楷体", Font.BOLD, 25);
		graphics.setFont(fontTitle1);
		graphics.drawString("桌号: " + account.getOrderTable().getDeskNo()+"号桌", 50,85);
		graphics.drawString("订单编号: " + account.getMyOrder().getId(), 50, 110);
		graphics.drawString("时间: "+time , 50, 135);//DateUtil.formatDate(account.getMyOrder().getCreateDate(), "yyyy-MM-dd HH:mm:ss") 
		graphics.drawString("收银: 张海波", 50, 170);
		Font fontLine = new Font("楷体", Font.BOLD, 45);
		graphics.setFont(fontLine);
		graphics.drawLine(20, 195, 390, 195);
		graphics.setFont(fontTitle1);
		graphics.drawString("菜名        数量   单价", 50, 230);//8,4空格
		Font font = new Font("宋体", Font.PLAIN, 25);
		graphics.setFont(font);
		Integer y = 240;
		Integer x=30;
		double totalPrice=0.00;
		for (GoodsVo gv : goodsVoList) {
			totalPrice=totalPrice+gv.getQty()*gv.getPrice();
			x=30;
			y = y + 25;
			graphics.drawString(gv.getName(), x, y);
			int n=6;
//			for(int i=0;i<gv.getName().length();i++){
//				n++;
//			}
			x = x + 25*n;
			x=x+25*2;
			graphics.drawString(""+gv.getQty()+"份", x, y);
			x = x + 25*3;
			graphics.drawString(gv.getPrice()+"元", x, y);
			//x = x + 25;
		}
		int k=goodsVoList.size();
		graphics.setFont(fontLine);
		if(k>2){
			graphics.drawLine(20, x+25*k, y+k*25, x+25*k);//x+25*k			
		}else{
			graphics.drawLine(20, x, y+k*25, x);//x+25*k	
		}
		
		graphics.setFont(font);
		graphics.drawString("美食数量:"+account.getMyOrder().getGoodsNum()+"份", 170,  y+k*25+25);
		graphics.drawString("总价格:"+totalPrice+"元", 170,  y+k*25+50);
		graphics.drawString("消费合计:"+totalPrice+"元", 170,  y+k*25+75);
		graphics.drawString("付款金额:"+totalPrice+"元", 170,  y+k*25+100);
		
		/**
			//graphics.drawString("备注: " + gv.getId(), 50, y);
			//y = y + 25;
		// ImageIcon imageIcon = new ImageIcon(imgurl);
		// graphics.drawImage(imageIcon.getImage(), 230, 0, null);
		// 改成这样:
		*/
		BufferedImage bimg = null;
		try {
			bimg = javax.imageio.ImageIO.read(new java.io.File(
					"D://print//account//image"+account.getMyOrder().getId()+ ".jpg"));
		} catch (Exception e) {
		}
		if (bimg != null)
			graphics.drawImage(bimg, 100, 0, null);
		graphics.dispose();
		String imageUrl = createImage("D://print//account//image//"
				+ account.getMyOrder().getId() + ".jpg");
		return imageUrl;
	}
	
	
	
	/**
	 * 58打印机   后厨图片打印
	 * @param goodsVoList
	 * @param account
	 * @return
	 */
	

		public static String orderPic(List<GoodsVo> goodsVoList,Account account) {
			createDir("D://print//order//image");
			int imageWidth = 400;// 图片的宽度
			int imageHeight = 400 + goodsVoList.size() * 100;// 图片的高度
			image = new BufferedImage(imageWidth, imageHeight,
					BufferedImage.TYPE_INT_RGB);
			Graphics graphics = image.getGraphics();
			graphics.setColor(Color.WHITE);
			graphics.fillRect(0, 0, imageWidth, imageHeight);
			graphics.setColor(Color.BLACK);
			Font fontTitle = new Font("楷体", Font.BOLD, 35);
			graphics.setFont(fontTitle);
			graphics.drawString("下酒菜", 120, 50);
			Font fontTitle1 = new Font("楷体", Font.BOLD, 25);
			graphics.setFont(fontTitle1);
			graphics.drawString("桌号: " + account.getOrderTable().getDeskNo()+"号桌", 50,85);
			graphics.drawString("订单编号: " + account.getMyOrder().getId(), 50, 110);
			graphics.drawString("时间: " +account.getMyOrder().getCreateDate() , 50, 135);//DateUtil.formatDate(account.getMyOrder().getCreateDate(), "yyyy-MM-dd")
			graphics.drawString("收银: 张海波", 50, 170);
			Font fontLine = new Font("楷体", Font.BOLD, 45);
			graphics.setFont(fontLine);
			graphics.drawLine(20, 195, 390, 195);
			graphics.setFont(fontTitle1);
			graphics.drawString("菜名        数量   味道", 50, 230);//8,4空格
			Font font = new Font("宋体", Font.PLAIN, 25);
			graphics.setFont(font);
			Integer y = 240;
			Integer x=30;
			double totalPrice=0.00;
			for (GoodsVo gv : goodsVoList) {
				totalPrice=totalPrice+gv.getQty()*gv.getPrice();
				x=30;
				y = y + 25;
				graphics.drawString(gv.getName(), x, y);
				int n=6;
//				for(int i=0;i<gv.getName().length();i++){
//					n++;
//				}
				x = x + 25*n;
				x=x+25*2;
				graphics.drawString(""+gv.getQty()+"份", x, y);
				x = x + 25*3;
				graphics.drawString(gv.getTaste(), x, y);
				//x = x + 25;
			}
			
			BufferedImage bimg = null;
			try {
				bimg = javax.imageio.ImageIO.read(new java.io.File(
						"D://print//order//image"+account.getMyOrder().getId()+ ".jpg"));
			} catch (Exception e) {
			}
			if (bimg != null)
				graphics.drawImage(bimg, 100, 0, null);
			graphics.dispose();
			String imageUrl = createImage("D://print//order//image//"
					+ account.getMyOrder().getId() + ".jpg");
			return imageUrl;
		}
	
	
	
	
	
	
	
	
	
	
	
	//创建文件夹
	public static boolean createDir(String destDirName) {
		File dir = new File(destDirName);
		if (dir.exists()) {
			System.out.println("创建目录" + destDirName + "失败，目标目录已存在！");
			return false;
		}
		if (!destDirName.endsWith(File.separator))
			destDirName = destDirName + File.separator;
		// 创建单个目录
		if (dir.mkdirs()) {
			System.out.println("创建目录" + destDirName + "成功！");
			return true;
		} else {
			System.out.println("创建目录" + destDirName + "成功！");
			return false;
		}
	}

}