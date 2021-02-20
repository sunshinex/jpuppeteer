package jpuppeteer.util.mouse;

public class Flow {
    private static final int AVERAGE_BUCKET_VALUE = 100;

    private final double[] buckets;

    public Flow(double[] characteristics) {
        buckets = normalizeBuckets(characteristics);
    }

    private double[] normalizeBuckets(double[] flowCharacteristics) {
        double[] buckets = new double[flowCharacteristics.length];
        long sum = 0;
        for (int i = 0; i < flowCharacteristics.length; i++) {
            if (flowCharacteristics[i] < 0) {
                throw new IllegalArgumentException("Invalid FlowCharacteristics at [" + i + "] : " + flowCharacteristics[i]);
            }
            sum += flowCharacteristics[i];
        }

        if (sum == 0) {
            throw new IllegalArgumentException("Invalid FlowCharacteristics. All array elements can't be 0.");
        }

        double multiplier = (double) AVERAGE_BUCKET_VALUE * buckets.length / sum;
        for (int i = 0; i < flowCharacteristics.length; i++) {
            buckets[i] = flowCharacteristics[i] * multiplier;
        }
        return buckets;
    }

    public double[] getFlowCharacteristics() {
        return buckets;
    }

    public double getStepSize(double distance, int steps, double completion) {
        double completionStep = 1d / steps;
        double bucketFrom = (completion * buckets.length);
        double bucketUntil = ((completion + completionStep) * buckets.length);

        double bucketContents = getBucketsContents(bucketFrom, bucketUntil);
        double distancePerBucketContent = distance / (buckets.length * AVERAGE_BUCKET_VALUE);

        return bucketContents * distancePerBucketContent;
    }

    private double getBucketsContents(double bucketFrom, double bucketUntil) {
        double sum = 0;
        for (int i = (int)bucketFrom; i < bucketUntil; i++) {
            double value = buckets[i];
            double endMultiplier = 1;
            double startMultiplier = 0;
            if (bucketUntil < i+1) {
                endMultiplier = bucketUntil - (int)bucketUntil;
            }
            if ((int)bucketFrom == i) {
                startMultiplier = bucketFrom - (int)bucketFrom;
            }
            value *= endMultiplier - startMultiplier;
            sum += value;
        }

        return sum;
    }
}
