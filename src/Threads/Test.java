package Threads;

public class Test {
    public static void main(String[] args) {
        System.out.println("Debut pp");

        Traitement ta = new Traitement("A");
        Traitement tb = new Traitement("B");
        // run : te5dem el prog principale

        // annoncement de thread
        ta.start();
        tb.start();
        if(ta.isAlive()){
            try {
                ta.join();
                tb.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }



        // join : attendre le processus jusqua la mort d'un autre


        System.out.println("Fin pp");
    }
}
