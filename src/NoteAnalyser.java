public class NoteAnalyser {
    //Low frequency up to B2-50% = 120,01 Hz
    //High frequency from G2-50% = 95,25 HZ
    void getNote(Signal signal){
        FrequencyAnalyser freqAnalyser = new LowFrequencyAnalyser();
        //freqAnalyser.analyse(signal, signal.samplingRate);

    }
}
