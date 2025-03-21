package com.utils;

import com.model.Pelouse;
import com.model.Tondeuse;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileParser {
    public static Map<String, Object> parseInputFile(MultipartFile file) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        String line;

        line = reader.readLine();
        String[] lawnDimensions = line.split(" ");
        Pelouse pelouse = new Pelouse(Integer.parseInt(lawnDimensions[0]), Integer.parseInt(lawnDimensions[1]));

        List<Tondeuse> tondeuses = new ArrayList<>();
        List<String> commands = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            String[] tondeuseData = line.split(" ");
            Tondeuse tondeuse = new Tondeuse(
                    Integer.parseInt(tondeuseData[0]),
                    Integer.parseInt(tondeuseData[1]),
                    tondeuseData[2].charAt(0)
            );
            tondeuses.add(tondeuse);

            line = reader.readLine();
            commands.add(line);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("pelouse", pelouse);
        result.put("tondeuses", tondeuses);
        result.put("commands", commands);

        return result;
    }
}
