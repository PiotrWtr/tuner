public class Signal {
    double samplingRate;
    double[] signal;

    public Signal(double samplingRate, double[] signal){
        this.samplingRate = samplingRate;
        this.signal = signal;
    }

    public double getSamplingRate(){
        return samplingRate;
    }

    public void printSignal(){
        for (int i = 0 ; i < signal.length; i++){
            System.out.println(signal[i]);
        }
    }
}
/*public class Signal {
    double samplingRate;
    double[] signal = {0};

    public Signal(double samplingRate, double[] signal){
        System.out.println("konstruktor Signal");
        //signal = new double[]{0};
        this.samplingRate = samplingRate;
        this.signal = signal;
    }
}
*/