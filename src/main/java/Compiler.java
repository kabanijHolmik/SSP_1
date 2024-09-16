import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Compiler {
    public static void main(String[] args) {
        try {
            // Компиляция файла CurrentDateTime.java
            Process compileProcess = Runtime.getRuntime().exec("javac C:\\Users\\kosen\\IdeaProjects\\SSP_1\\src\\main\\java\\Main.java");

            // Ожидание завершения компиляции
            compileProcess.waitFor();

            // Проверка на успешную компиляцию
            if (compileProcess.exitValue() == 0) {
                System.out.println("Компиляция прошла успешно.");

                // Запуск скомпилированного файла
                Process runProcess = Runtime.getRuntime().exec("java C:\\Users\\kosen\\IdeaProjects\\SSP_1\\src\\main\\java\\Main.java");

                // Чтение и вывод результата выполнения
                BufferedReader input = new BufferedReader(new InputStreamReader(runProcess.getInputStream()));
                String line;
                while ((line = input.readLine()) != null) {
                    System.out.println(line);
                }
                input.close();

                // Ожидание завершения выполнения
                runProcess.waitFor();
            } else {
                System.out.println("Ошибка компиляции.");

                // Вывод ошибок компиляции
                BufferedReader error = new BufferedReader(new InputStreamReader(compileProcess.getErrorStream()));
                String line;
                while ((line = error.readLine()) != null) {
                    System.out.println(line);
                }
                error.close();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
