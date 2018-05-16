package com.example.com.EncryptPDF;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		PdfReader reader = null;
		try {
			reader = new PdfReader("mypdf.pdf");
		} catch (IOException e) {
			e.printStackTrace();
		}
		PdfStamper stamper = null;
		try {
			stamper = new PdfStamper(reader, new FileOutputStream("mypdf_secure.pdf"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			stamper.setEncryption("userpassword123".getBytes(), "ownerpassword123".getBytes(), PdfWriter.ALLOW_COPY,
					PdfWriter.ENCRYPTION_AES_256);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		try {
			stamper.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		reader.close();
		System.out.println("Encryption Complete");
	}
}
