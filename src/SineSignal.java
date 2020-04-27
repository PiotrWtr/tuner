public class SineSignal extends  Signal{
    double sinFrequency = 164.81; //of signal i [Hz]
    double samplingRate = 44100;  //[Hz]
    double signalLength = 1; //of signal in [s]
    double sinOffset = 0;
    double sinAmplitude = 1;
    double[] signal;

    public SineSignal() {
        System.out.println("konstruktor SineSignal");
        signal = new double[(int)(samplingRate * signalLength)];
        for (int i = 0; i < samplingRate * signalLength ; i++){
            signal[i] = sinAmplitude * Math.sin(2 * Math.PI * sinFrequency * ((double) i / 44100) + sinOffset);
        }
    }
    public SineSignal(double frequency) {
        System.out.println("konstruktor SineSignal");
        sinFrequency = frequency;
        signal = new double[(int) (samplingRate * signalLength)];
        for (int i = 0; i < samplingRate * signalLength; i++) {
            signal[i] = sinAmplitude * Math.sin(2 * Math.PI * sinFrequency * ((double) i / 44100) + sinOffset);
        }
    }

    /*public void printSignal(){
        for (int i = 0 ; i < signal.length; i++){
            System.out.println(signal[i]);
        }
    }*/
}
