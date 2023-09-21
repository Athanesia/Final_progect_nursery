import java.util.ArrayList;
import java.util.List;

public class Pet {
    private String name;
    private int age;
    private List<String> commands;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
        this.commands = new ArrayList<>();
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public List<String> getCommands() {
        return commands;
    }

    public void showCommands() {
        System.out.println("Commands for " + name + ":");
        for (String command : commands) {
            System.out.println("- " + command);
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}