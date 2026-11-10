package com.common.NetBug;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class VerifiedCode {
	public static String getVerifiedCode(File VerifiedImage) {
		Tesseract tess = new Tesseract();
		try {
			return tess.doOCR(VerifiedImage).trim();
		} catch (TesseractException e) {
			return null;
		}
	}
}
