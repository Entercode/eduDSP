/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.entercode.edudsp;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;

/**
 *
 * @author entercode
 */
public class PlayBack extends Thread {
	
	private static final int BITS = 16;
    private static final int HZ = 44100;
    private static final int MONO = 2;
	
	private SourceDataLine source;
	private TargetDataLine target;
    private AudioInputStream stream;
	private byte[] voice = new byte[ HZ * BITS / 8 * MONO ];
			
	public PlayBack() {
		try {
			// オーディオフォーマットの指定
			AudioFormat linear = new AudioFormat( HZ, BITS, MONO, true, false );
			
			// Player
			// ソースデータラインを取得
			DataLine.Info sinfo = new DataLine.Info( SourceDataLine.class, linear );
			source = (SourceDataLine)AudioSystem.getLine( sinfo );
			
			// ソースデータラインを開く
			source.open( linear );
			
			// スピーカー出力開始
			source.start();
			
			// Recorder
            // ターゲットデータラインを取得
			DataLine.Info tinfo = new DataLine.Info( TargetDataLine.class, linear );
            target = (TargetDataLine)AudioSystem.getLine( tinfo );
            
            // ターゲットデータラインを開く
            target.open( linear );
            
            // マイク入力開始
            target.start();
            
            // 入力ストリームを取得
            //stream = new AudioInputStream( target );
			
		} catch (LineUnavailableException ex) {
			Logger.getLogger(PlayBack.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public synchronized void start() {
		super.start(); //To change body of generated methods, choose Tools | Templates.
		
		Thread stopper = new Thread(new Runnable() {

			public void run() {
				try {
					Thread.sleep(10000);
					
				} catch (InterruptedException ex) {
					Logger.getLogger(PlayBack.class.getName()).log(Level.SEVERE, null, ex);
				}
				System.exit(0);
			}
		});
		
		int cnt = 0;
		
		while(true) {
			
			source.write(voice, 0, target.read(voice, 0, voice.length));
		}
	}
	
	
	
}
