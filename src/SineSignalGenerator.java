public class SineSignalGenerator {
    private double sinFrequency = 164.81; //of signal i [Hz]
    private double samplingRate = 44100;  //[Hz]
    private double signalLength = 0.05; //of signal in [s]
    private double sinOffset = 0;
    private double sinAmplitude = 1;
    private double[] signal;

    public SineSignalGenerator(double sineFrequency){
        sinFrequency = sineFrequency;
        signal = new double[(int)(samplingRate * signalLength)];
        for (int i = 0; i < samplingRate * signalLength ; i++){
            this.signal[i] = sinAmplitude * Math.sin(2 * Math.PI * sinFrequency * ((double) i / 44100) + sinOffset);
        }
    }

    public void printSignal(){
        for (int i = 0 ; i < signal.length; i++){
            System.out.println(signal[i]);
        }
    }

    public int getSignalLength(){
        return signal.length;
    }

    public double[] getSignal(){
        return signal;
    }

    public double getSamplingRate(){
        return samplingRate;
    }

    public void setSinFrequency(double sinFrequency){
        this.sinFrequency = sinFrequency;
        regenerateSignal();
    }
    public void setSamplingRate(double samplingRate){
        this.samplingRate = samplingRate;
        regenerateSignal();
    }

    public void setSignalLength(double signalLength){
        this.signalLength = signalLength;
        regenerateSignal();
    }

    public void setSinOffset(double sinOffset){
        this.sinOffset = sinOffset;
        regenerateSignal();
    }

    public void setSinAmplitude(double sinAmplitude){
        this.sinAmplitude = sinAmplitude;
        regenerateSignal();
    }

    public void regenerateSignal(){
        //this.sinFrequency = sinFrequency;
        double[] signal = new double[(int)(samplingRate * signalLength)];
        for (int i = 0; i < samplingRate * signalLength ; i++){
            signal[i] = sinAmplitude * Math.sin(2 * Math.PI * sinFrequency * ((double) i / 44100) + sinOffset);
        }
    }
}
