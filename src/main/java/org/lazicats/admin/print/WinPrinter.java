package org.lazicats.admin.print;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

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

public class WinPrinter {

	/**
	 * 打印
	 */
	public static void print(){
	     PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
	        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
	        PrintService[] pservices = PrintServiceLookup.lookupPrintServices(flavor, aset);
	        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
	        PrintService service = ServiceUI.printDialog(null, 200, 200, pservices,
	                defaultService, flavor, aset);
	        if (service != null) {
	            try {
	                DocPrintJob pj = service.createPrintJob();
	                aset.add(MediaSizeName.ISO_A4);
	                FileInputStream fis = new FileInputStream("D:\\WinPrinter.txt");
	                DocAttributeSet das = new HashDocAttributeSet();
	                Doc doc = new SimpleDoc(fis, flavor, das);
	                pj.print(doc, aset);
	                Thread.sleep(10 * 1000);
	            } catch (FileNotFoundException fe) {
	                fe.printStackTrace();
	            } catch (PrintException e) {
	                e.printStackTrace();
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        } else {
	            System.out.println("打印失败");
	        }
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		print();
	}

}