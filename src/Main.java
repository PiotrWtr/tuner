import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        //Gui gui = new Gui();
        //gui.startGui();

        //NotesList notesList = new NotesList();
        //notesList.printNotes();

        double testFrequency = 82.6;
        SineSignal testSignal = new SineSignal(testFrequency);
        //testSignal.printSignal();
        //System.out.println(testSignal.signal.length);
        System.out.println("Test freq: " + testFrequency);

        FrequencyAnalyser lowFreqAalyser = new LowFrequencyAnalyser();
        FrequencyAnalyser highFreqAalyser = new HighFrequencyAnalyser();
        System.out.println("Freq from low freq analyser :" + lowFreqAalyser.analyse(testSignal, testSignal.samplingRate));
        System.out.println("Freq from high freq analyser :" + highFreqAalyser.analyse(testSignal, testSignal.samplingRate));
        System.out.println(" ");
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
