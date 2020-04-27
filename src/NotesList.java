import java.util.TreeMap;
import java.util.Map;

public class NotesList {
    Double a4Frequency = 440.0;
    Double C0Frequency = a4Frequency / (Math.pow(2, 4) * Math.pow((Math.pow(2, (double)1/12)), 9));
    Map<Double, String> sounds = new TreeMap<>();
    String[] noteNames = new String[]{"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    public NotesList(){
        this.countNotes();
    }

    public NotesList(double freq){
        a4Frequency = freq;
        countNotes();
    }
    
    public void countNotes(){
        for(int octave = 0 ; octave <= 8 ; octave++){
            for (int i = 0; i < 12; i++) {
                Double freq = C0Frequency * Math.pow((Math.pow(2, (double)1/12)), i) * (Math.pow(2, octave ));
                sounds.put(freq, noteNames[i] + octave);
            }
        }
    }
    
    public void printNotes(){
        for (Map.Entry<Double, String> entry : sounds.entrySet()){
            System.out.print( entry.getValue() + " ");
            System.out.format("%.2f%n",(Double) entry.getKey());
        }
    }
}
