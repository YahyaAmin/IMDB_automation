package hooks;

import java.io.File;

public class RunnerForGoodWindows {

    public static void mvnCommandRunner(){
        String [] arr = new String[2];
        String projectpath = System.getProperty("user.dir");
        System.out.println(projectpath);
        arr [0] = "cd C:\\Users\\abc\\Desktop\\IMDB Automation";
        arr [1] = "mvn verify -DskipTests";

        File dir = new File ("C:\\Users\\abc\\Documents\\GitHub\\Kamelpay_Final_Automation");
        GoodWindowsExec.main(new String[] {"mvn verify -DskipTests"}, dir );

    }

    public static void notepadrun(){

        File dir = new File ("C:\\Users\\abc\\");
        GoodWindowsExec.main(new String[] {"notepad.exe"}, dir );

    }

    public static void mvnCleanVerify(){
        File dir = new File ("C:\\Users\\abc\\Documents\\GitHub\\Kamelpay_Final_Automation");
        GoodWindowsExec.main(new String[] {"mvn clean verify"}, dir );
    }

    public static void testingCLI(){
        File dirtest = new File ("C:\\Users\\abc\\Desktop\\Jmeter\\apache-jmeter-5.4.3\\bin");
        GoodWindowsExec.main(new String[] {"jmeter.bat"}, dirtest );
    }


    public static void main(String[] args) {
        mvnCommandRunner();
    }



}
