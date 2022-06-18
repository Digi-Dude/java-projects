import java.util.Scanner;

import net.sf.saxon.expr.PJConverter.StringValueToString;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();

        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - "\t"

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */

        final double MAX_CONTAINER_VOLUME = 12.0;
        final double MAX_BOXES_VOLUME = 27.0;

        
        int allBoxes = Integer.parseInt(boxes);
        int currentBox = 1;

        int necessaryContainers = (int)Math.ceil(allBoxes / MAX_BOXES_VOLUME);
        int currentConteiners = 1;

        int cargoCars = (int) Math.ceil(necessaryContainers / MAX_CONTAINER_VOLUME);
        

        for (int i = 1; i <= cargoCars; i++)
        {
            System.out.println("Грузовик: " + i);

            for( int c = 1; c <= (int)MAX_CONTAINER_VOLUME; c++) 
            {
                if(currentConteiners > necessaryContainers) {
                    break;
                }

                System.out.println("\t" + "Контейнер: " + currentConteiners);

                for( int b = 1; b <= MAX_BOXES_VOLUME; b++)
                {
                    if(currentBox > allBoxes) 
                    {
                        break;
                    }
                    System.out.println("\t" + "\t" + "Ящик: " + currentBox);
                    currentBox++;
                }
                
                currentConteiners++;

            }

        }

        System.out.println("Необходимо:");
        System.out.println("грузовиков - " + cargoCars + " шт.");
        System.out.println("контейнеров - " + necessaryContainers + " шт.");

    }

}
