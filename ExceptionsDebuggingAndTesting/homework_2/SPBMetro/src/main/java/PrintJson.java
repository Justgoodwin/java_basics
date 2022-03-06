import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class PrintJson {
    private String pathToJsonFile;
    StringBuilder builder = new StringBuilder();

    public PrintJson(String pathToJsonFile) {
        this.pathToJsonFile = pathToJsonFile;
    }

    public void printJsonFile() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(pathToJsonFile));
            lines.forEach(builder::append);

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(builder.toString());
            JSONObject stationObject = (JSONObject) jsonObject.get("stations");

            stationObject.keySet().stream().sorted(Comparator.comparingInt(s -> Integer.parseInt(((String) s)
                    .replaceAll("[^\\d]","")))).forEach(lineNumberObject -> {
                        JSONArray stationArray = (JSONArray) stationObject.get(lineNumberObject);
                        int stationCount = stationArray.size();
                        System.out.println("Номер линиии " + lineNumberObject +
                                " - колличество станций : " + stationCount);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

