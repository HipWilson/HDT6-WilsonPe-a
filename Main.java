import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de Mapa: 1) HashMap 2) TreeMap 3) LinkedHashMap");
        int choice = scanner.nextInt();
        scanner.nextLine();

        PokemonStreamManager manager = new PokemonStreamManager(choice);
        manager.loadPokemons("pokemons.csv");

        boolean running = true;
        while (running) {
            System.out.println("\n1) Agregar Pokémon\n2) Mostrar colección ordenada\n3) Mostrar todos ordenados\n4) Buscar por habilidad\n5) Salir");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> {
                    System.out.println("Ingrese el nombre del Pokémon:");
                    manager.addPokemonToUser(scanner.nextLine());
                }
                case 2 -> manager.showUserCollectionByType();
                case 3 -> manager.showAllPokemonsByType();
                case 4 -> {
                    System.out.println("Ingrese la habilidad:");
                    manager.showPokemonByAbility(scanner.nextLine());
                }
                case 5 -> running = false;
                default -> System.out.println("Opción inválida");
            }
        }
        scanner.close();
    }
}

