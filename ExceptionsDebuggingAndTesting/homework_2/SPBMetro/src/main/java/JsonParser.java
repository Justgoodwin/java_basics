import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class JsonParser {
    private String absolutePath; // путь к сайту

    public JsonParser(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public void htmlCodeReader() {
        try {
            Document doc = Jsoup.connect(absolutePath).maxBodySize(0).get();

            Elements lineElements = doc.select("span.js-metro-line.t-metrostation-list-header");
            Elements stationElements = doc.select("div.js-metro-stations.t-metrostation-list-table");
            Elements connectionsElements = doc.select("div.js-metro-stations.t-metrostation-list-table");

            JSONObject objectForJson = new JSONObject();

            BufferedWriter writer = Files.newBufferedWriter
                    (Paths.get("data/metro.json"));

            objectForJson.put("stations", getObjectStation(stationElements));
            objectForJson.put("connections", getArrayConnections(connectionsElements));
            objectForJson.put("lines", getArrayLine(lineElements));

            writer.write(objectForJson.toJSONString());
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JSONObject getObjectStation(Elements stationElements) {
        ArrayList<DownloadStation> stList = new ArrayList<>();

        for (Element element : stationElements) {
            String numberLine = element.attr("data-line");
            Elements nameStationElement = element.select("span.name");
            for (Element elementStation : nameStationElement) {
                String nameStation = elementStation.text();
                stList.add(new DownloadStation(nameStation, numberLine));
            }
        }

        HashMap<String, List<String>> stationMap = stList.stream()
                .collect(Collectors.groupingBy(DownloadStation::getLine
                        , LinkedHashMap::new
                        , Collectors.mapping(
                                DownloadStation::getStation,
                                Collectors.toList())));

        return new JSONObject(stationMap);
    }

    private JSONArray getArrayLine(Elements lineElements) {
        JSONArray lines = new JSONArray();
        ArrayList<DownloadLines> linesList = new ArrayList<>();

        for (Element elementLine : lineElements) {
            String nameLine = elementLine.text();
            String numberLine = elementLine.attr("data-line");
            linesList.add(new DownloadLines(numberLine, nameLine));
        }

        for (DownloadLines h : linesList) {
            JSONObject lines1 = new JSONObject();
            lines1.put("number", h.getNumber());
            lines1.put("name", h.getName());
            lines.add(lines1);
        }
        return lines;
    }

    private JSONArray getArrayConnections(Elements connectionsElements) {

        ArrayList<DownloadConnection> cList = new ArrayList<>();

        for (Element element : connectionsElements) {
            String strLineIn = element.attr("data-line");
            Elements cElements1 = element.select("a:has(span.t-icon-metroln)");
            for (Element element1 : cElements1) {
                String strNameInBeforeFormated = element1.text();
                String strNameIn = strNameInBeforeFormated.replaceAll("\\d+\\.\\s", "");
                Elements cElements2 = element1.select("a:has(span.t-icon-metroln) > span.t-icon-metroln");
                for (Element element2 : cElements2) {
                    String strLineToBeforeFormated = element2.attr("class");
                    String strLineTo = strLineToBeforeFormated.replaceAll(".+\\-", "")
                            .replaceAll(".{4}", "");

                    String strNameToBeforeFormated = element2.attr("title");
                    String strNameTo = strNameToBeforeFormated.replaceAll("(.+\\«)(.+)(\\».+)", "$2");
                    cList.add(new DownloadConnection(strLineIn, strNameIn, strLineTo, strNameTo));
                }
            }
        }
        TreeSet<String> connectionSet = new TreeSet<>();

        cList.stream()
                .forEach(d -> connectionSet.add(d.getNameIn() + "*" + d.getLineIn() + "*"
                        + d.getNameTo() + "*" + d.getLineTo()));

        TreeMap<Integer, String> connectionMap = new TreeMap<>();

        for (String f : connectionSet) {
            int sum = 0;
            for (char ch : f.toCharArray()) {
                sum += 1 + ch;
            }
            connectionMap.put(sum, f);
        }


        JSONArray connections = new JSONArray();

        for (Map.Entry entry : connectionMap.entrySet()) {
            JSONObject connectionObject1 = new JSONObject();
            JSONObject connectionObject2 = new JSONObject();
            JSONObject connectionObject3 = new JSONObject();
            JSONArray cArray = new JSONArray();
            String str = String.valueOf(entry.getValue());
            String strLineIn = str.replaceAll("(\\W+)(\\w+)(\\W+)(\\w+)"
                    , "$2");
            String strNameIn = str.replaceAll("(\\W+)(\\w+)(\\W+)(\\w+)"
                    , "$1").replaceAll("\\*", "");
            String strLineTo = str.replaceAll("(\\W+)(\\w+)(\\W+)(\\w+)"
                    , "$4");
            String strNameTo = str.replaceAll("(\\W+)(\\w+)(\\W+)(\\w+)"
                    , "$3").replaceAll("\\*", "");

            connectionObject1.put("line", strLineIn);
            connectionObject1.put("station", strNameIn);
            connectionObject2.put("line", strLineTo);
            connectionObject2.put("station", strNameTo);
            cArray.add(connectionObject1);
            cArray.add(connectionObject2);
            connections.add(cArray);
        }
        return connections;
    }

}