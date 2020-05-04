public class SineSignal extends Signal{
    double sinFrequency = 164.81; //of signal i [Hz]
    static final double samplingRate = 44100;  //[Hz]
    double signalLength = 1; //of signal in [s]
    double sinOffset = 0;
    double sinAmplitude = 1;

    SineSignal(Double signalFrequency) {
        this(samplingRate, null);
        super.signal = signal(signalFrequency);
        System.out.println("Zadziałał konstruktor SineSignal 1arg");
    }

    SineSignal(double samplingRate, double[] signal) {
        super(samplingRate, signal);
        System.out.println("Zadziałał konstruktor SineSignal 2arg");
    }

    double[] signal(double frequency){
        sinFrequency = frequency;
        signal = new double[(int)(samplingRate * signalLength)];
        for (int i = 0; i < samplingRate * signalLength ; i++){
            signal[i] = sinAmplitude * Math.sin(2 * Math.PI * sinFrequency * ((double) i / 44100) + sinOffset);
        }
        return signal;
    }
}