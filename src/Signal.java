public class Signal {
    double samplingRate;
    double[] signal;
    public void printSignal(){
        for (int i = 0; i < signal.length; i++) {
            System.out.println(signal[i]);
        }
    }
}
