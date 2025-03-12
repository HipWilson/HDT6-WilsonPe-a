import java.util.*;

// Definición de la clase Pokemon
public record Pokemon(String name, String type1, String ability) {}

// Factory con programación funcional
class MapFactory {
    public static Map<String, Pokemon> getMap(int choice) {
        return switch (choice) {
            case 1 -> new HashMap<>();
            case 2 -> new TreeMap<>();
            case 3 -> new LinkedHashMap<>();
            default -> throw new IllegalArgumentException("Opción inválida");
        };
    }
}
