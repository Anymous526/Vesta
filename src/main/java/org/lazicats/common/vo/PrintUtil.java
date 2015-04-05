package org.lazicats.common.vo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSizeName;
import javax.swing.JOptionPane;
/***
 * 打印功能的实现
 */
public class PrintUtil {
	// 文档打印
	public static void printJava() {
		// JFileChooser fileChooser = new JFileChooser(); //创建打印作业
		// int state = fileChooser.showOpenDialog(null);
		// if(state == fileChooser.APPROVE_OPTION){
		// File file = fileChooser.getSelectedFile();
		File file = new File("E:/孙小娇简历.docx"); // 获取选择的文件
		// 构建打印请求属性集
		HashPrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
		// 设置打印格式，因为未确定类型，所以选择autosense
		DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
		// 查找所有的可用的打印服务
		PrintService printService[] = PrintServiceLookup.lookupPrintServices(
				flavor, pras);

		// 定位默认的打印服务
		PrintService defaultService = PrintServiceLookup
				.lookupDefaultPrintService();
		// 显示打印对话框
		PrintService service = ServiceUI.printDialog(null, 200, 200,
				printService, defaultService, flavor, pras);
		if (service != null) {
			try {
				DocPrintJob job = service.createPrintJob(); // 创建打印作业
				FileInputStream fis = new FileInputStream(file); // 构造待打印的文件流
				DocAttributeSet das = new HashDocAttributeSet();
				Doc doc = new SimpleDoc(fis, flavor, das);
				job.print(doc, pras);
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public static boolean printNoDriver(String ip, int port, String str,
			int skip) throws Exception {
		@SuppressWarnings("resource")
		Socket client = new java.net.Socket();

		PrintWriter socketWriter;
		client.connect(new InetSocketAddress(ip, port), 1000); // 创建一个 socket
		socketWriter = new PrintWriter(client.getOutputStream());// 创建输入输出数据流
		/* 纵向放大一倍 */
		socketWriter.write(0x1c);
		socketWriter.write(0x21);
		socketWriter.write(8);
		socketWriter.write(0x1b);
		socketWriter.write(0x21);
		socketWriter.write(8);
		socketWriter.println(str);
		for (int i = 0; i < skip; i++) {
			socketWriter.println("");// 打印完毕自动走纸
		}
		return true;
	}

	// 图片打印
	public static void printImage(String imageurl) {
		FileInputStream textStream = null;
		try {
			textStream = new FileInputStream(imageurl);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		// String printStr = "打印测试内容";// 获取需要打印的目标文本
		if (textStream != null) // 当打印内容不为空时
		{ // 指定打印输出格式
			DocFlavor flavor = DocFlavor.INPUT_STREAM.POSTSCRIPT;// SERVICE_FORMATTED.PRINTABLE
			// 定位默认的打印服务
			PrintService printService = PrintServiceLookup
					.lookupDefaultPrintService();
			// 创建打印作业
			DocFlavor[] d = printService.getSupportedDocFlavors();
			for (DocFlavor df : d) {
				System.out.println(df.getMimeType());
			}
			if (printService.isDocFlavorSupported(flavor)) {
				System.out.println("支持");
			}
			;
			DocPrintJob job = printService.createPrintJob();
			// 设置打印属性
			PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
			// 设置纸张大小,也可以新建MediaSize类来自定义大小
			pras.add(MediaSizeName.ISO_A4);
			DocAttributeSet das = new HashDocAttributeSet();
			// 指定打印内容
			Doc doc = new SimpleDoc(textStream, flavor, das);
			// 不显示打印对话框，直接进行打印工作
			try {
				job.print(doc, pras);// 进行每一页的具体打印操作
				System.out.println("打印成功了");
			} catch (PrintException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			// 如果打印内容为空时，提示用户打印将取消
			JOptionPane.showConfirmDialog(null,
					"Sorry, Printer Job is Empty, Print Cancelled!", "Empty",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
		}
	}
	
	//
	@SuppressWarnings("unused")
	public static void printNoWindow(String imageUrl) {
		FileInputStream textStream = null;
		try {
			textStream = new FileInputStream(imageUrl);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// String printStr = "打印测试内容";// 获取需要打印的目标文本
		if (textStream != null) // 当打印内容不为空时
		{ // 指定打印输出格式
			DocFlavor flavor = DocFlavor.INPUT_STREAM.JPEG;// SERVICE_FORMATTED.PRINTABLE
			// 构建打印请求属性集
			HashPrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
			// 查找所有的可用的打印服务
			PrintService allPrintService[] = PrintServiceLookup
					.lookupPrintServices(flavor, pras);
			// 定位默认的打印服务
			PrintService printService = PrintServiceLookup
					.lookupDefaultPrintService(); // 创建打印作业
			DocFlavor[] d = printService.getSupportedDocFlavors();
			for (DocFlavor df : d) {
				System.out.println(df.getMimeType());
			}
			if (printService.isDocFlavorSupported(flavor)) {
				System.out.println("支持");
			}
			;
			DocPrintJob job = printService.createPrintJob(); // 设置打印属性
			pras.add(MediaSizeName.ISO_A4);
			DocAttributeSet das = new HashDocAttributeSet(); // 指定打印内容
			Doc doc = new SimpleDoc(textStream, flavor, das); // 不显示打印对话框，直接进行打印工作
			try {
				job.print(doc, pras);// 进行每一页的具体打印操作
				System.out.println("打印成功了");
			} catch (PrintException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			// 如果打印内容为空时，提示用户打印将取消
			JOptionPane.showConfirmDialog(null,
					"Sorry, Printer Job is Empty, Print Cancelled!", "Empty",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
		}
	}

}