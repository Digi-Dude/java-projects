public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {

        //TODO: напишите метод генерации массива температур пациентов

        float[] patientsTemperatures = new float[patientsCount];
        for(int i = 0; i <= patientsCount - 1; i++) {
            patientsTemperatures[i] = (float)(32.0 + Math.random() * 8.0);

        }

        return patientsTemperatures;

        //TODO: напишите метод генерации массива температур пациентов

    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */
        final double MAX_HEALTHY_TEMPERATURE = 37.0;
        final double MIN_HEALTHY_TEMPERATURE = 36.2;
        StringBuilder allPatientsTemperatures = new StringBuilder("");
        String middleTemperature = "";
        int healthyPatient = 0;
        float sumTemperatures = 0;
        for (float temp : temperatureData) {
            allPatientsTemperatures.append(String.format("%.1f",temp) + " ");
            if(MAX_HEALTHY_TEMPERATURE > temp && temp >= MIN_HEALTHY_TEMPERATURE) {
                healthyPatient++;
            }
            sumTemperatures += temp;
        }
        middleTemperature = String.format("%.2f",(sumTemperatures / temperatureData.length));

        String report =
                "Температуры пациентов: " + allPatientsTemperatures.toString().trim() +
                        "\nСредняя температура: " + middleTemperature +
                        "\nКоличество здоровых: " + healthyPatient;



        return report;
    }
}
