public class LowFrequencyAnalyser extends FrequencyAnalyser {
    private double frequency = 0;

    public double analyse(double[] signal, double samplingRate) {
        int firstZero = 0;
        int secondZero = 0;

        for (int i = 0; i < signal.length; i++) {
            for (int j = 0; j < signal.length - 1; j++) {
                if (signal[j] <= 0 && signal[j + 1] > 0) {
                    firstZero = j;
                    //System.out.println("First zero " + firstZero);
                }

                if (signal[j] >= 0 && signal[j + 1] < 0) {
                    secondZero = j;
                    //System.out.println("Second zero " + secondZero);
                }

                if (firstZero != secondZero) {
                    int halfWaveSamples = secondZero - firstZero;
                    //System.out.println("difference " + halfWaveSamples);
                    //System.out.println("sampling rate " + samplingRate);
                    double halfWaveTime = halfWaveSamples / samplingRate;
                    frequency = 1 / (2 * halfWaveTime);
                    //System.out.print((100 - Math.abs((signal.sinFrequency - frequency)/ frequency)*100) + " ");//"Accuracy of low freq analyser :" +
                    return frequency;
                }
            }
        }
        return 0;
    }
}
