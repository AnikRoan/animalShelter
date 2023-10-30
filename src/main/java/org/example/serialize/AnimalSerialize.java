package org.example.serialize;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.example.enams.Extensions;
import org.example.model.Animal;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class AnimalSerialize {

    //2. Користувацьке меню:
    //- Додаток повинен відображати меню з наступними опціями:
    //- Додати тварину ( add pet ): Запитуйте користувача про деталі тварини і додавайте її до списку прихистку.
    //- Переглядати тварин ( show all ): Показуйте список усіх тварин, які в даний час є у притулку.
    //- Видалити тварину ( take pet from shelter ): Дозвольте користувачеві вибрати тварину зі списку і видалити її.
    //- Вихід (exit): Закрити додаток.
    //3. Зберігання даних:
    //- При закритті додатка (через опцію "Вихід" або будь-які інші засоби) всі дані про тварин повинні зберігатися у файлі за допомогою бібліотеки Jackson.
    //- При наступному запуску ці дані повинні бути прочитані та завантажені назад до додатка.
    private final ObjectMapper objectMapper = new JsonMapper();
    private final Extensions exception = Extensions.JSON;
    private final String path = "src/main/resources/animal";




    public void serialize(List<Animal> animal) {


        try {
            objectMapper.writeValue(new File(path + exception), animal);
        } catch (IOException e) {
            System.out.println("");
        }
    }

    public Optional<List<Animal>> deSerialize() {
        try {
            List<Animal>l = Optional.of(objectMapper.readValue
                    (new File(path + exception),new TypeReference<List<Animal>>() {});
            return Optional.of(l);


        } catch (IOException e) {
            System.out.println("");
        }
        return Optional.empty();
    }
}
