package pl.niewiel;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        MatrixFiller m=new MatrixFiller();
        ArrayList<Future<FillInfo>> listaWynikow = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i=0;i<100;i++) {
            listaWynikow.add(executorService.submit(m));
        }
        executorService.shutdown();
//
        try {
            if (executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                for (Future<FillInfo> info : listaWynikow) {
                    System.out.println(info.get().getE());
                }
            } else {
                System.out.println("Nie udało się wykonać");
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        int tab[]=m.getTab();

        for (int aTab : tab) {
            System.out.println(aTab);
        }
    }
}
