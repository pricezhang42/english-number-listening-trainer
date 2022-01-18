package util;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import listener.ButtonListener;

public class SpeakUtil {
    private static boolean pausable = false;
    static ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");
    static Dispatch sapo = sap.getObject();

    public static void speak(String[] strings) {

//        synchronized (sap){
//        }

//        ButtonListener.instance.isFinished = false;
        try {

//            sap = new ActiveXComponent("Sapi.SpVoice");
//            sapo = sap.getObject();

            sap.setProperty("Volume", new Variant(100));
            sap.setProperty("Rate", new Variant(0));
            sap.setProperty("SynchronousSpeakTimeout", new Variant(1000000));

//            Dispatch.call(sapo, "Speak", new Variant("<speak version=\"1.0\"\n" +
//                    "xmlns=\"http://www.w3.org/2001/10/synthesis\"\n" +
//                    "xml:lang=\"en-US\">\n" +
//                    "<voice xml:lang=\"en-US\" gender=\"female\">\n" +
//                    string + "</voice>\n" +
//                    "</speak>"));
            int i = 0;
            for (String str : strings) {
                System.out.println("Is canceled?" + ButtonListener.sw.isCancelled());
                if (ButtonListener.sw.isCancelled()) {
                    System.out.println("break");
                    break;
                }
                System.out.println(i);
                Dispatch.call(sapo, "Speak", new Variant("<speak version=\"1.0\"\n" +
                        "xmlns=\"http://www.w3.org/2001/10/synthesis\"\n" +
                        "xml:lang=\"en-US\">\n" +
                        "<voice xml:lang=\"en-US\" gender=\"female\">\n" +
                        str + " </voice>\n" +
                        "</speak>"), new Variant(0));
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            sapo.safeRelease();
//            sap.safeRelease();
        }
    }

    public static void speak(String str) {

        try {

            sap.setProperty("Volume", new Variant(100));
            sap.setProperty("Rate", new Variant(0));
            sap.setProperty("SynchronousSpeakTimeout", new Variant(1000000));

            Dispatch.call(sapo, "Speak", new Variant("<speak version=\"1.0\"\n" +
                    "xmlns=\"http://www.w3.org/2001/10/synthesis\"\n" +
                    "xml:lang=\"en-US\">\n" +
                    "<voice xml:lang=\"en-US\" gender=\"female\">\n" +
                    str + " </voice>\n" +
                    "</speak>"), new Variant(0));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void speak() {
        pausable = true;
        speak(NumberClass.speakNumbers);
    }

    public static void pause() {
        if (pausable || !ButtonListener.isFinished) {
            try {
                Dispatch.call(sapo, "Pause");
                pausable = false;
            } catch (Exception ignored) {
            }
        }
    }

    public static void resume() {
        try {
            pausable = true;
            Dispatch.call(sapo, "Resume");
        } catch (Exception ignored) {
        }
    }

    public static void stop() {
        try {
//            while (true) {
//                Dispatch.call(sapo, "Skip", new Variant("Sentence"), new Variant(Integer.MAX_VALUE));
//            }
            ButtonListener.sw.cancel(true);
            System.out.println(ButtonListener.sw.isCancelled());
            Dispatch.call(sapo, "Skip", new Variant("Sentence"), new Variant(Integer.MAX_VALUE));
//            ButtonListener.sw = null;
//            Dispatch.call(sapo, "Pause");
            pausable = true;
        } catch (Exception ignored) {
        }
    }

    public static void main(String[] args) {
//        NumberClass.generateFixedNums(3, 2);
//        NumberClass.generateRangedNums(1, 3, 1, 3);
        NumberClass.generateDates(2000, 2021);
        for(int i = 0; i < 10; i++) {
            System.out.println(NumberClass.numbers[i]);
        }
        speak();
    }
}
