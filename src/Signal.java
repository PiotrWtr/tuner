public class Signal {
    double samplingRate;
    double[] signal = {0};

    public Signal(){
        System.out.println("konstruktor Signal");
        //signal = new double[]{0};
    }

    public void printSignal(){
        for (int i = 0 ; i < signal.length; i++){
            System.out.println(signal[i]);
        }
    }

    public void printSignalLength(){
        System.out.println(signal.length);
    }
}
