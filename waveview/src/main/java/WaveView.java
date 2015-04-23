
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;
import javax.swing.JFrame;

public class WaveView extends JFrame {
	
	
	int frameWidth = 200;
	int frameHeight = 200;
	int currentHeight = 0;
	static byte[] b = new byte[48000];
	
	
    /**
     * @param args the command line arguments
     */
	
	// record duration, in milliseconds
    static final long RECORD_TIME = 6000;  // 1 minute
 
    // path of the wav file
    File wavFile = new File("/Users/entercode/Desktop/Test/test.wav");
 
    // format of audio file
    AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
 
    // the line from which audio data is captured
    TargetDataLine line;
 
    /**
     * Defines an audio format
     */
    AudioFormat getAudioFormat() {
        float sampleRate = 48000;
        int sampleSizeInBits = 8;
        int channels = 1;
        boolean signed = true;
        boolean bigEndian = true;
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits,
                                             channels, signed, bigEndian);
        return format;
    }
 
    /**
     * Captures the sound and record into a WAV file
     */
    void start() {
		try {
			AudioFormat format = getAudioFormat();
			DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
			
			// checks if system supports the data line
			if (!AudioSystem.isLineSupported(info)) {
				System.out.println("Line not supported");
				System.exit(0);
			}
			line = (TargetDataLine) AudioSystem.getLine(info);
			line.open(format);
			line.start();   // start capturing
			
			System.out.println("Start capturing...");
			
			AudioInputStream ais = new AudioInputStream(line);
			currentHeight = ais.read(b);
			System.out.println(currentHeight);
			
			System.out.println("Start recording...");
			
			// start recording
			AudioSystem.write(ais, fileType, wavFile);
		} catch (LineUnavailableException ex) {
			Logger.getLogger(WaveView.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(WaveView.class.getName()).log(Level.SEVERE, null, ex);
		}
    }
 
    /**
     * Closes the target data line to finish capturing and recording
     */
    void finish() {
        line.stop();
        line.close();
        System.out.println("Finished");
    }
	
    public static void main(String[] args) {
		
		try {

			JFrame frame = new JFrame("Waveform Display Simulator"); 
			frame.setBounds(200,200, 500, 350);

			File file = new File(args[0]); 
			AudioInputStream audioInputStream 
				= AudioSystem.getAudioInputStream(file);
        
			WaveformPanelContainer container = new WaveformPanelContainer(); 
			container.setAudioToDisplay(audioInputStream);
       
			frame.getContentPane().setLayout(new BorderLayout());		
			frame.getContentPane().add(container, BorderLayout.CENTER);
		
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
			frame.show();
			frame.validate();
			frame.repaint();

		} catch (Exception e){
			e.printStackTrace();
		}
		
		/*final WaveView recorder = new WaveView();
 
        // creates a new thread that waits for a specified
        // of time before stopping
        Thread stopper = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(RECORD_TIME);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                recorder.finish();
				
				printValues();
            }
        });
 
        stopper.start();
 
        // start recording
        recorder.start();*/
		//AudioInputButton myButton = new AudioInputButton(2);
		//myButton.startListening();
	}
	
	static void printValues() {
		for(int i = 0; i < 48000; i++) {
			System.out.println(b[i]);
		}
	}
	
}
