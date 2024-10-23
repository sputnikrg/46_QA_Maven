package demoqa.utils;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class DataProviders {
    @DataProvider
    public Iterator<Object[]> addNewUserFormFromCSVFile() throws IOException {
        //массив хранит данные которые будут использоваться в нашем тесте
        List<Object[]> list = new ArrayList<>();
//классом FileReader считываем данные из файла
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/user.csv"));
        String line = reader.readLine();
//цикл который сканирует строку пока она не закончится, данные разделены запятой
        while (line != null) {
            list.add(line.split(","));//то что разделено запятыми будет добавлено в массив List<Object[]> list
            //приступили к счтению новой строки
            line = reader.readLine();
        }
        reader.close();
//итератор передвигаясь по массиву будет считывать данные с файла и возвращать в наш метод
        return list.iterator();

    }
}
