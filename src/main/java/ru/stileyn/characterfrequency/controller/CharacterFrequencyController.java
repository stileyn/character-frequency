package ru.stileyn.characterfrequency.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

@RestController
public class CharacterFrequencyController {

    @GetMapping("/character-frequency")
    public Map<Character, Integer> getCharacterFrequency(@RequestParam String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Подсчет частоты символов
        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Сортировка по убыванию частоты
        frequencyMap = sortByValueDescending(frequencyMap);

        return frequencyMap;
    }

    // Метод для сортировки Map по значению (частоте) в убывающем порядке
    private Map<Character, Integer> sortByValueDescending(Map<Character, Integer> unsortedMap) {
        return unsortedMap.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
