package pl.niewiel;

import java.util.Random;
import java.util.concurrent.Callable;

public class MatrixFiller implements Callable<FillInfo> {

    private int[] tab = new int[100];

    public int[] getTab() {
        return tab;
    }

    MatrixFiller() {
        for (int i = 0; i < tab.length; i++) {
            tab[i] = 0;
        }
    }

    @Override
    public FillInfo call() throws Exception {
        Random r = new Random(100);
        int i = r.nextInt();
        while(matrixFilled()){
            for (int e : tab)
            {
                fillElement(i);
                return new FillInfo(e);

            }
        }

        return new FillInfo(1);

    }

    private synchronized void fillElement(int i) {
        while (matrixFilled()) {
            System.out.println("true");
            tab[i] ++;
        }


    }

    private boolean matrixFilled() {
        for (int i = 1; i < tab.length; i++) {
            if (tab[i] == 0) {
                return true;
            }
        }
        System.out.println("false");
        return false;

    }
}
