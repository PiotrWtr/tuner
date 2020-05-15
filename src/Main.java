import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class Main {
    public static void main(String[] args) {
        Gui gui = new Gui();
        gui.startGui();

        //notesList.printNotes();

        double testFrequency = 98;
        SineSignalGenerator sineGenerator = new SineSignalGenerator(testFrequency);
        // System.out.println(sineGenerator.getSignalLength());
        Signal testSignal = new Signal(sineGenerator.getSamplingRate(), sineGenerator.getSignal());
        //Signal testSignal = new SineSignal(testFrequency);
        //System.out.println(testSignal.signal.length);

        System.out.println("Test freq: " + testFrequency);
        //System.out.println("Test sampling rate: " + testSignal.getSamplingRate());

        NoteAnalyser noteAnalyser = new NoteAnalyser();
        //System.out.println(noteAnalyser.getNote(testSignal));

        //noteAnalyser.notesList.printNotes();

        /*
        FrequencyAnalyser freqAnalyser = new LowFrequencyAnalyser();

        System.out.println("Freq from low freq analyser :" + freqAnalyser.analyse(testSignal, testSignal.getSamplingRate()));
        freqAnalyser = new HighFrequencyAnalyser();
        System.out.println("Freq from high freq analyser :" + freqAnalyser.analyse(testSignal, testSignal.getSamplingRate()));
        */
        /*
        PrintWriter zapis = null;
        try {
            zapis = new PrintWriter("frequencies from sine, lowfreq highfreq.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 100; i <= 13190 ; i++){
            double frequency = i / 100;
            testSignal = new SineSignal((double) i / 10);
            zapis.print( ((double) i / 10) + " " + lowFreqAalyser.analyse(testSignal, testSignal.samplingRate) + " ");
            zapis.println(highFreqAalyser.analyse(testSignal, testSignal.samplingRate));
        }
        System.out.println("ended analysis");
        zapis.close();
        */
    }
}
