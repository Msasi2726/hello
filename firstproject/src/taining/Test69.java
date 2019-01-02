package taining;

import java.util.Locale;
import java.util.Scanner;

import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

public class Test69 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception
	{
		//Get Data
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Text");
		String x=sc.nextLine();
		//Convert Given text to voice
		System.setProperty("freetts.voices","com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
		Synthesizer s=Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
		s.allocate();
		s.resume();
		s.speakPlainText(x, null);
		s.waitEngineState(Synthesizer.QUEUE_EMPTY);
		s.allocate();
	}

}
