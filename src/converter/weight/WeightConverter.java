package converter.weight;
import java.util.HashMap;
import java.util.Scanner;

public class WeightConverter{

    public void run() {

        Scanner scan = new Scanner(System.in);

        System.out.println("Select conversion type: (input number)\n" +
                "1. metric to metric;\n" +
                "2. metric to imperial;\n" +
                "3. imperial to imperial;\n" +
                "4. imperial to metric.");

        int option = Integer.parseInt(scan.nextLine());

        System.out.println("Input value to convert:");
        float value = Float.parseFloat(scan.nextLine());
        System.out.println("Input unit to convert from:");
        String from = scan.nextLine();
        System.out.println("Input unit to convert to:");
        String to = scan.nextLine();

        switch (option) {
            case 1:
                System.out.printf("Converting value: %.2f\n", value);
                System.out.printf("Converting from: %s\n", from);
                System.out.printf("Converting to: %s\n", to);
                System.out.printf("Result: " + value + " " + metricUnitsFull.get(from)+
                        " is equivalent to %.2f " + metricUnitsFull.get(to) +
                        ".\n", convertMetric(from,to,value));
                break;
            case 2:
                System.out.printf("Converting value: %.2f\n", value);
                System.out.printf("Converting from: %s\n", from);
                System.out.printf("Converting to: %s\n", to);
                System.out.printf("Result: " + value + " " + metricUnitsFull.get(from)+
                        " is equivalent to %.2f " + imperialUnitsFull.get(to) +
                        ".\n", metricToImperial(from,to,value));
                break;

            case 3:
                System.out.printf("Converting value: %.2f\n", value);
                System.out.printf("Converting from: %s\n", from);
                System.out.printf("Converting to: %s\n", to);
                System.out.printf("Result: " + value + " " + imperialUnitsFull.get(from)+
                        " is equivalent to %.2f " + imperialUnitsFull.get(to) +
                        ".\n", convertImperial(from,to,value));
                break;

            case 4:
                System.out.printf("Converting value: %.2f\n", value);
                System.out.printf("Converting from: %s\n", from);
                System.out.printf("Converting to: %s\n", to);
                System.out.printf("Result: " + value + " " + imperialUnitsFull.get(from)+
                        " is equivalent to %.2f " + metricUnitsFull.get(to) +
                        ".\n", imperialToMetric(from,to,value));
                break;

            default:
                System.out.println("Something went wrong");


        }


    }

    static float oz_to_g = 28.349523125F;

    private final float[][] metricConversionTable = {
            {1, 10, 100, 1_000, 10_000, 100_000, 1_000_000, 1_000_000_000},
            {(float) 0.1, 1, 10, 100, 1_000, 10_000, 100_000, 100_000_000},
            {(float) 0.01, (float) 0.1, 1, 10, 100, 1_000, 10_000, 10_000_000},
            {(float) 0.001, (float) 0.01, (float) 0.1, 1, 10, 100, 1_000,
                    1_000_000},
            {(float) 0.0001, (float) 0.001, (float) 0.01, (float) 0.1, 1, 10,
                    100, 100_000},
            {(float) 0.00001, (float) 0.0001, (float) 0.001, (float) 0.01,
                    (float) 0.1, 1, 10, 10_000},
            {(float) 0.000001, (float) 0.00001, (float) 0.0001, (float) 0.001,
                    (float) 0.01,
                    (float) 0.1, 1, 1_000},
            {(float) 0.0000000001, (float) 0.000000001, (float) 0.0000001,
                    (float) 0.000001, (float) 0.00001, (float) 0.0001,
                    (float) 0.001, 1}
    };

    private final  float[][] imperialConversionTable = {
            {1, 16, 1_600, 32_000, 35_840},
            {(float) 0.0625, 1, 100, 2_000, 2_240},
            {(float) 0.000625, (float) 0.01, 1, 20, (float) 22.40},
            {(float) 0.00003125, (float) 0.0005, (float) 0.05, 1, (float) 1.12},
            {(float) 0.00002790178, (float) 0.00044642857, (float) 0.05, (float) 0.89285714285, (float) 1}
    };

    static HashMap<String, Integer> metricUnitsMap = new HashMap<>() {
        {
            put("mg",0);
            put("cg",1);
            put("dg",2);
            put("g",3);
            put("dag", 4);
            put("hg",5);
            put("kg",6);
            put("t", 7);
        }
    };

    static HashMap<String, Integer> imperialUnitsMap = new HashMap<>() {
        {
            put("oz",0);
            put("lb",1);
            put("hdw",2);
            put("st",3);
            put("lt", 4);
        }
    };


    public HashMap<String, String > metricUnitsFull = new HashMap<>() {
        {
            put("mg","milligram(s)");
            put("cg","centigram(s)");
            put("dg","decigram(s)");
            put("g","gram(s)");
            put("dag", "dekagram(s)");
            put("hg","hectogram(s)");
            put("kg","kilogram(s)");
            put("t", "metric ton(s)");
        }
    };

    public HashMap<String, String> imperialUnitsFull = new HashMap<>() {
        {
            put("oz","ounce(s)");
            put("lb","pound(s)");
            put("hdw","hundredweight(s)");
            put("st","imperial short ton(s)");
            put("lt","imperial long ton(s)");
        }
    };

    public double convertMetric(String from, String to, double value) {
        if (metricUnitsMap.containsKey(from) && metricUnitsMap.containsKey(to)){
            return value * metricConversionTable[metricUnitsMap.get(to)][metricUnitsMap.get(from)];
        }
        else{
            return 0;
        }
    }

    public double convertImperial(String from, String to, double value) {
        if (imperialUnitsMap.containsKey(from) && imperialUnitsMap.containsKey(to)){
            return value * imperialConversionTable[imperialUnitsMap.get(to)][imperialUnitsMap.get(from)];
        }
        else{
            return 0;
        }
    }

    public double metricToImperial(String from, String to, double value) {
        return convertImperial("oz", to, gramsToOunces(convertMetric(from,"g", value)));
    }

    public double imperialToMetric(String from, String to, double value) {
        return convertMetric("g", to, ouncesToGrams(convertImperial(from, "oz", value)));
    }

    static double gramsToOunces(double grams) {
        return grams/oz_to_g;
    }

    static double ouncesToGrams(double ounces) {
        return  ounces * oz_to_g;
    }

}
