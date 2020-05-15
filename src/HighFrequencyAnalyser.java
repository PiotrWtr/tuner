public class HighFrequencyAnalyser extends FrequencyAnalyser {
    double frequency = 0;

    double analyse(double[] signal, double samplingRate){
        int zeros = 0;
        for (int i = 0; i < signal.length - 1; i++) {
            if (signal[i] <= 0 && signal[i + 1] > 0) {
                zeros++;
            }
            if (signal[i] >= 0 && signal[i + 1] < 0) {
                zeros++;
            }
        }
        double signalLength = signal.length / samplingRate; //in [s]
        frequency = ((zeros)/2) / signalLength;
        //System.out.println("Zeros: " + zeros);
        //System.out.print((100 - Math.abs((signal.sinFrequency - frequency)/ frequency)*100) + " ");//"Accuracy of high freq analyser:" +
        return frequency;
    }
}
