/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.entercode.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author entercode
 */
public class WaveLoader {
	
	File file;
	HashMap<String, String> header = new HashMap<>();
	int bitrate = 0;
	int channel = 0;
	long samplerate = 0;
	
	
	public WaveLoader(String fileName) {
		file = new File("/Users/entercode/" + fileName);
		
		if(file.exists()) {
			System.out.println("File: " + fileName + " found!");
		} else {
			System.err.println("File: " + fileName + " not found!");
		}
	}
	
	public boolean load() {
		
		//char[] cbuf = new char[10000];
		byte[] bbuf = new byte[3000];
		
		if(file.canRead()) {
			
			
			try {
				FileInputStream fis = new FileInputStream(file);
				//FileReader fr = new FileReader(file);
				//fr.read(cbuf, 0, 9800);
				fis.read(bbuf, 0, 3000);
			} catch (IOException ex) {
				Logger.getLogger(WaveLoader.class.getName()).log(Level.SEVERE, null, ex);
			}
			
		}
		
		System.out.println("=== Load Format ===");
		int bcnt = 0;	// byte count
		
		// RIFF header
		header.put("Riff", String.valueOf(readWithChar(bbuf, bcnt, 4)));
		bcnt += 4;
		
		// File size - 8byte
		header.put("FileSize", String.valueOf(readWithLong(bbuf, bcnt, 4)));
		bcnt += 4;
		
		// WAVE header
		header.put("Wave", String.valueOf(readWithChar(bbuf, bcnt, 4)));
		bcnt += 4;
		
		// fmt chunk
		header.put("Fmt", String.valueOf(readWithChar(bbuf, bcnt, 4)));
		bcnt += 4;
		
		// bytes of fmt chunks
		header.put("FmtSize", String.valueOf(readWithLong(bbuf, bcnt, 4)));
		bcnt += 4;
		
		// format ID
		header.put("FormatID", String.valueOf(readWithLong(bbuf, bcnt, 2)));
		bcnt += 2;
		
		// Channel
		header.put("Channel", String.valueOf(readWithLong(bbuf, bcnt, 2)));
		bcnt += 2;
		
		// Sample Rate
		header.put("SampleRate", String.valueOf(readWithLong(bbuf, bcnt, 4)));
		bcnt += 4;
		
		// Data Speed (Byte/sec.)
		header.put("DataSpeed", String.valueOf(readWithLong(bbuf, bcnt, 4)));
		bcnt += 4;
		
		// Block Size ((Byte/Sample)*Channel)
		header.put("BlockSize", String.valueOf(readWithLong(bbuf, bcnt, 2)));
		bcnt += 2;
		
		// Bit Rate (Bit/Sample)
		header.put("BitRate", String.valueOf(readWithLong(bbuf, bcnt, 2)));
		bcnt += 2;
		
		// Extended block size (not used in liner PCM)
		header.put("ExtendedBlockSize", String.valueOf(readWithLong(bbuf, bcnt, 0)));
		bcnt += 0;
		
		// Extended block (not used in liner PCM)
		header.put("ExtendedBlock", String.valueOf(readWithLong(bbuf, bcnt, 0)));
		bcnt += 0;
		
		// Data chunk
		header.put("Data", String.valueOf(readWithChar(bbuf, bcnt, 4)));
		bcnt += 4;
		
		// Byte size of Data chunk
		header.put("DataChunkSize", String.valueOf(readWithLong(bbuf, bcnt, 4)));
		bcnt += 4;
		
		System.out.println(header.toString());
		
		return true;
	}
	
	// read char[] from byte[]
	private char[] readWithChar(byte[] bbuf, int off, int len) {
		char[] cbuf = new char[len];
		for(int i = 0; i < len; i++) {
			//bbuf[i + off];
			cbuf[i] = (char)bbuf[i + off];
		}
		return cbuf;
	}
	
	// read long from byte[]
	private long readWithLong(byte[] bbuf, int off, int len) {
		long ibuf = 0;
		
		for (int i = 0; i < len; i++)
		{
		   //ibuf = (ibuf << 8) + (bbuf[i + off] & 0xff);
		   ibuf += ((long) bbuf[i + off] & 0xffL) << (8 * i);
		}
		return ibuf;
	}
	
	
	/*
	 * Accesser
	 */
	
	public HashMap<String, String> getHeader() {
		return header;
	}
	public int getBitRate() {
		return 3;
	}
	
}
