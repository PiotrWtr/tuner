public class ContinuousNoteAnalyser extends NoteAnalyser {
    private NotesList notesList;
    private FrequencyAnalyser freqAnalyser;
    private double[] signal;
    private double samplingRate;

    public ContinuousNoteAnalyser(Signal signal){
        notesList = new NotesList();
        freqAnalyser = new LowFrequencyAnalyser();
        this.signal = signal.signal.clone();
        this.samplingRate = signal.samplingRate;
    }

    public void analyse(){
        int bufferSize = (int) (signal.length * 0.05); //20Hz wave time length
        for (int i = 0 ; i <= signal.length ; i += bufferSize ){
            double[] buffer = new double[bufferSize];
            for (int j = 0; j <= buffer.length ; j++){
                buffer[j] = signal[i+j];

        }
    }
}
