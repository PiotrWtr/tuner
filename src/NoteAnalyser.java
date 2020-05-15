import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class NoteAnalyser {
    //Low frequency up to B2-50% = 120,01 Hz
    //High frequency from G2-50% = 95,25 HZ
    private NotesList notesList;
    private FrequencyAnalyser freqAnalyser;

    public NoteAnalyser(){
        notesList = new NotesList();
        freqAnalyser = new LowFrequencyAnalyser();
    }

    private Double getCents(double frequency, double nearestNoteFrequency){
        Double cents = 0.0;
        double freqAndNoteDifference = frequency - nearestNoteFrequency;
        //System.out.println();
        //System.out.println("Cent test:");
        //System.out.println("Test freq: " + frequency );
        //System.out.println("Nearest note frequency: " + nearestNoteFrequency);
        //System.out.println("freqAndNoteDifference: " + freqAndNoteDifference);
        if (freqAndNoteDifference < 0){
            double toPreviousNoteDistance = nearestNoteFrequency - nearestNoteFrequency / (Math.pow(2, (double)1/12));
            cents = Math.round((Double)(freqAndNoteDifference / toPreviousNoteDistance * 100 * 10))/10.0;
            //cents = "-" + ((Double)(freqAndNoteDifference / toPreviousNoteDistance * 100 * 10)).toString();

            //System.out.println("<0 toPreviousNoteDistance " + toPreviousNoteDistance );
        }
        if (freqAndNoteDifference > 0){
            double toNextNoteDistance = nearestNoteFrequency * (Math.pow(2, (double)1/12)) - nearestNoteFrequency;
            cents = Math.round((Double)(freqAndNoteDifference / toNextNoteDistance * 100 * 10))/10.0;
            //cents = "+" + ((Double)(freqAndNoteDifference / toNextNoteDistance * 100)).toString();
            //System.out.println(">0 toNextNoteDistance " + toNextNoteDistance );
        }
        return cents;
    }

    String getNote(Signal signal){
        String note = "X";
        double frequency = freqAnalyser.analyse(signal.signal, signal.samplingRate);
        if (frequency >= 120.01 && freqAnalyser.getClass().equals("LowFrequencyAnalyser")){
            freqAnalyser = new HighFrequencyAnalyser();
            frequency = freqAnalyser.analyse(signal.signal, signal.samplingRate);
        }
        if (frequency <= 95.25 && freqAnalyser.getClass().equals("HighFrequencyAnalyser")){
            freqAnalyser = new HighFrequencyAnalyser();
            frequency = freqAnalyser.analyse(signal.signal, signal.samplingRate);
        }
        double nearestNoteFrequency = 0;
        double ratio = 1;
        Iterator<Map.Entry<Double, String>> entries = notesList.sounds.entrySet().iterator();
        while (entries.hasNext()){
            Map.Entry<Double, String> entry = entries.next();
            double innerRatio = Math.abs(1-(entry.getKey()/frequency));
            if ( innerRatio < ratio ){
                nearestNoteFrequency = entry.getKey();
                //System.out.println(nearestNoteFrequency);
                note = entry.getValue();
            }
            if ( innerRatio > ratio ){
                double cents = getCents(frequency, nearestNoteFrequency);
                if (cents <0) {
                    note += " " + getCents(frequency, nearestNoteFrequency);
                }
                else{
                    note += " +" + getCents(frequency, nearestNoteFrequency);
                }
                break;
            }
            ratio = innerRatio;
        }
        return note;
    }
}
