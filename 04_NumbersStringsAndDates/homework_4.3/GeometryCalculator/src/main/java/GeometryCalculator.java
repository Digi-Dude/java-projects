public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        double circleSquare = Math.PI * Math.pow(radius, 2.0);
        return circleSquare;
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        double sphereVolume  = 4.0 / 3.0 * Math.PI * Math.pow(Math.abs(radius), 3.0);
        return sphereVolume;
    }

    public static boolean isTrianglePossible(double a, double b, double c) {
        if ((a <=0.0 || b <=0.0 || c <=0.0) || (a + b < c || a + c < b || b + c < a))
          {
            return false;
        }
        else return true;
        
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        if (!isTrianglePossible(a, b, c)) {
            return -1.0;
        }
        double halfPerimeter = (a + b + c) / 2;
        double triangleSquare = Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter -c));

        return triangleSquare;
    }
}
