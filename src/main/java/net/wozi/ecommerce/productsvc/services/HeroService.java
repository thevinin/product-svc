package net.wozi.ecommerce.productsvc.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class HeroService {
    static Map<Integer, String> HEROES = new HashMap<>();

    static {
        HEROES.put(11, "name: Dr Nice, message: Likes to lick dicks");
        HEROES.put(12, "name: Narco, message: Likes to take it in the ass");
        HEROES.put(13, "name: Bombasto, message: Likes little boys");
        HEROES.put(14, "name: Celeritas, message: fucks sheeps and dogs");
        HEROES.put(15, "name: Magneta, message: likes to shit on other people - i.e. Cleveland Steamer");
        HEROES.put(16, "name: RubberMan, message: Likes to be wrapped up in rubber and whipped");
        HEROES.put(17, "name: Dynama, message: Do me you big-dicked queer!");
        HEROES.put(18, "name: Dr IQ, message: I like to fuck girls in the ass");
        HEROES.put(19, "name: Magma, message: Give me a big titted bitch and let me pee on her");
        HEROES.put(543, "name: Chaos Monkey, message: I do monkey sex");
    };

    public String getHeroes(){
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(HEROES);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

    public String getAHeroByID(int id){
        return HEROES.get(id);
    }

    public static void main(String[] args){
        HeroService app = new HeroService();
        System.out.println("Heroes[JSON]: " + app.getHeroes());

        // or with Java 8 stream
        String json2 = "{"+HEROES.entrySet().stream()
                .map(e -> "\""+ e.getKey() + "\"" + ":\"" + String.valueOf(e.getValue()) + "\"")
                .collect(Collectors.joining(", "))+"}";

        System.out.println("Heroes[JSON]: " + json2);
    }
}
