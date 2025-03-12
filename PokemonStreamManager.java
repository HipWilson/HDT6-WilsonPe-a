import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class PokemonStreamManager {
    private final Map<String, Pokemon> pokemonMap;
    private final Set<Pokemon> userCollection;

    public PokemonStreamManager(int mapChoice) {
        this.pokemonMap = MapFactory.getMap(mapChoice);
        this.userCollection = new HashSet<>();
    }

    public void loadPokemons(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.lines().skip(1).map(line -> line.split(","))
              .filter(data -> data.length >= 3)
              .forEach(data -> pokemonMap.put(data[0], new Pokemon(data[0], data[1], data[2])));
        }
    }

    public void addPokemonToUser(String name) {
        Optional.ofNullable(pokemonMap.get(name))
                .ifPresentOrElse(p -> {
                    if (!userCollection.add(p)) {
                        System.out.println("Ya tienes este Pokémon.");
                    } else {
                        System.out.println(name + " agregado.");
                    }
                }, () -> System.out.println("Pokémon no encontrado."));
    }

    public void showUserCollectionByType() {
        userCollection.stream().sorted(Comparator.comparing(Pokemon::type1)).forEach(System.out::println);
    }

    public void showAllPokemonsByType() {
        pokemonMap.values().stream().sorted(Comparator.comparing(Pokemon::type1)).forEach(System.out::println);
    }

    public void showPokemonByAbility(String ability) {
        pokemonMap.values().stream()
                  .filter(p -> p.ability().equalsIgnoreCase(ability))
                  .forEach(System.out::println);
    }
}
