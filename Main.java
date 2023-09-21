import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (Counter counter = new Counter();
            Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Меню:");
                System.out.println("1. Добавить нового питомца");
                System.out.println("2. Добавить новое вьючное животное");
                System.out.println("3. Показать команды для питомца");
                System.out.println("4. Показать команды для вьючного животного");
                System.out.println("5. Выход");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Введите вид питомца: ");
                        String petName = scanner.next();
                        System.out.print("Введите возраст питомца: ");
                        int petAge = scanner.nextInt();
                        scanner.nextLine(); // Считываем символ новой строки

                        Pet pet = new Pet(petName, petAge);
                        System.out.print("Введите команду для питомца: ");
                        String petCommand = scanner.nextLine();
                        pet.addCommand(petCommand);
                        counter.add();

                        // Записываем данные о питомце в файл
                        try (FileWriter writer = new FileWriter("pets.txt", true)) {
                            writer.write("Питомец: " + petName + ", Возраст: " + petAge + "\n");
                            writer.write("Команды: " + pet.getCommands() + "\n");
                            writer.write("\n");
                        } catch (IOException e) {
                            System.err.println("Ошибка при записи в файл: " + e.getMessage());
                        }
                        break;
                    case 2:
                        System.out.print("Введите вид вьючного животного: ");
                        String livestockName = scanner.next();
                        System.out.print("Введите возраст вьючного животного: ");
                        int livestockAge = scanner.nextInt();
                        scanner.nextLine(); // Считываем символ новой строки

                        Livestock livestock = new Livestock(livestockName, livestockAge);
                        System.out.print("Введите команду для вьючного животного: ");
                        String livestockCommand = scanner.nextLine();
                        livestock.addCommand(livestockCommand);
                        counter.add();
                        // Записываем данные о скоте в файл
                        try (FileWriter writer = new FileWriter("livestock.txt", true)) {
                            writer.write("Вьючное животное: " + livestockName + ", Возраст: " + livestockAge + "\n");
                            writer.write("Команды: " + livestock.getCommands() + "\n");
                            writer.write("\n");
                        } catch (IOException e) {
                            System.err.println("Ошибка при записи в файл: " + e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.print("Введите вид питомца для показа команд: ");
                        String petNameToShow = scanner.next();
                        // Реализуйте поиск питомца по имени и вывод его команд
                        break;
                    case 4:
                        System.out.print("Введите вид вьючного животного для показа команд: ");
                        String livestockNameToShow = scanner.next();
                        // Реализуйте поиск скота по имени и вывод его команд
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Неверный выбор. Пожалуйста, выберите правильный вариант.");
                        break;
                }
            }
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
    }
}