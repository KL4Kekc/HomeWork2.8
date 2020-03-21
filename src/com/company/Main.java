package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<String, String[]> dictionary = new HashMap<String, String[]>();
        dictionary.put("красивый", new String[]{"симпотичный", "румяный", "привлекательный", "прекрасный"});
        dictionary.put("человек", new String[]{"существо", "личность", "персона", "индивидум"});
        dictionary.put("дом", new String[]{"жилище", "помещение", "логово", "кров"});
        dictionary.put("большой", new String[]{"огромный", "массивный", "крупный", "громадный"});

        HashMap<String, String[]> bigDictionary = new HashMap<String, String[]>(dictionary);

        Set<String> stringSet = dictionary.keySet();
        Iterator<String> iterator = stringSet.iterator();

        while (iterator.hasNext()) {
            try {
                String key = iterator.next();
                String[] array = bigDictionary.get(key);
                bigDictionary.put(key, array);

                for (String string : array) {
                    ArrayList<String> arrayList = new ArrayList<String>(array.length);
                    arrayList.addAll(Arrays.asList(array));
                    arrayList.add(key);
                    arrayList.remove(string);
                    String[] array1 = new String[arrayList.size()];
                    array1 = arrayList.toArray(array1);
                    bigDictionary.put(string, array1);
                    System.out.println("Слова в Большом словаре" + " - " + string + " - " + Arrays.toString(array1));
                }
            } catch (Exception ex) {
            }
        }

        while (true) {
            System.out.println("Введите слово: ");
            Scanner scanner = new Scanner(System.in);
            String sentences = scanner.nextLine();
            String[] words = sentences.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (bigDictionary.get(words[i]) == null) {
                    System.out.println("Такого слова нет");
                } else {
                    String[] synonims = bigDictionary.get(words[i]);
                    Random random = new Random();
                    int randomIndex = random.nextInt(synonims.length);
                    System.out.println(synonims[randomIndex] + " ");
                }
            }
        }
    }
}
